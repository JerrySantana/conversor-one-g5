package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
	 * @return Un valor de tipo {@code Double} con el valor del tipo de cambio o 0.0 en caso de no
	 * encontrarlo o suceda un error de conexión.
	 */
	public static Double obtainExchangeRate(Divisa divisa) {
		JSONParser parser = new JSONParser();
		try {
			JSONObject conversions = (JSONObject) parser.parse(new FileReader("./exchangeRates.json"));
			JSONObject conversion = (JSONObject) conversions.get(divisa.getDivisaOrigen().getCode());
			
			return (Double) conversion.get(divisa.getDivisaDestino().getCode());
		} catch (IOException | ParseException exception) {
			exception.printStackTrace();
			return 0.0;
		}
	}
	
	public static void obtainExchangeRateData(ArrayList<Divisas> divisas) {
		ArrayList<JSONObject> resultados = new ArrayList<JSONObject>();
		try {
			for (int i = 0; i < divisas.size(); i++) {
				URL url = new URL("https://v6.exchangerate-api.com/v6/f239a97b6fb4479a0c36ac82/latest/" + divisas.get(i).getCode());
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();

				int responseCode = connection.getResponseCode();
				if (responseCode != 200) {
					throw new RuntimeException("HTTP Response Code: " + responseCode);
				}
				StringBuilder informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());
				
				while (scanner.hasNext()) {
					informationString.append(scanner.nextLine());
				}
				
				scanner.close();
				
				JSONParser parser = new JSONParser();
				JSONObject exchangeRates = (JSONObject) parser.parse(String.valueOf(informationString));
				
				resultados.add(exchangeRates);
			}
			if(createJSON(resultados)) {
				System.out.println("Datos obtenidos correctamente.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static boolean createJSON(ArrayList<JSONObject> resultados) {
		FileWriter file = null;
		try {
			System.out.println(resultados);
			JSONObject divisas = new JSONObject();
			file = new FileWriter("./exchangeRates.json");
			for (int i = 0; i < resultados.size(); i++) {
				divisas.put(resultados.get(i).get("base_code"), resultados.get(i).get("conversion_rates"));
			}
			file.write(divisas.toJSONString());
			file.close();
		} catch (NullPointerException | IOException exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}
}
