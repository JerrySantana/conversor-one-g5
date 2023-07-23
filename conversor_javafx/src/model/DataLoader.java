package model;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Esta clase se encarga de obtener el tipo de cambio actual para ciertas monedas.
 * @author Gerardo Santana
 * @version 1.0
 */
public class DataLoader {
	/**
	 * El metodo se encarga de obtener el tipo de cambio actual a partir de la divisa de origen,
	 * del parametro {@code divisa} que se le pasa; hacia una divisa destino.  
	 * @param divisa -> instancia de la clase {@link Divisa}
	 * @return Un valor de tipo {@code Double} con el valor del tipo de cambio, 0.0 en caso de no
	 * encontrarlo o suceda un error de conexión, o 1.0 si el valor de la divisa de origen y destino son el mismo.
	 */
	public static Double obtainExchangeRate(Divisa divisa) {
		int responseCode = 0;
		try {
			URL url = new URL("https://v6.exchangerate-api.com/v6/f239a97b6fb4479a0c36ac82/latest/"
					+ divisa.getDivisaOrigen().getCode());

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			responseCode = connection.getResponseCode();

			if (responseCode != 200) {
				throw new RuntimeException("HTTP Response Code: " + responseCode);
			} else {
				StringBuilder informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()) {
					informationString.append(scanner.nextLine());
				}

				scanner.close();

				JSONParser parser = new JSONParser();
				JSONObject exchangeRate = (JSONObject) parser.parse(String.valueOf(informationString));
				
				JSONObject conversion_rates = (JSONObject) exchangeRate.get("conversion_rates");
				System.out.println(conversion_rates.get(divisa.getDivisaDestino().getCode()));
				return (Double) conversion_rates.get(divisa.getDivisaDestino().getCode());
			}
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		if (responseCode != 200) {
			return 0.0;
		}
		return 1.0;
	}
}
