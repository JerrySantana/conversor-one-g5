package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un conversor de divisas.
 * 
 * @author Gerardo Santana
 * @version 1.0
 */
public class Divisa {
	private Divisas divisaOrigen;
	private Divisas divisaDestino;
	private double valorDivisa;
	private static Map<Divisas, Map<Divisas, Double>> conversiones;

	// Establecemos un mapa de conversion de divisas
	static {
		// Inicializamos el mapa de conversiones
		conversiones = new HashMap<>();

		// Agregamos las conversiones de pesos mexicanos a otras divisas
		Map<Divisas, Double> conversionesPesosMexicanos = new HashMap<>();
//		conversionesPesosMexicanos.put(Divisas.MXN, 1.0);
		conversionesPesosMexicanos.put(Divisas.Dolar, 0.0586);
		conversionesPesosMexicanos.put(Divisas.Libras, 0.0461);
		conversionesPesosMexicanos.put(Divisas.Euro, 0.0538);
		conversionesPesosMexicanos.put(Divisas.Yen, 8.4710);
		conversionesPesosMexicanos.put(Divisas.KRW, 76.116);
		conversiones.put(Divisas.MXN, conversionesPesosMexicanos);

		// Agregamos las conversiones de dólares a otras divisas
		Map<Divisas, Double> conversionesDolares = new HashMap<>();
		conversionesDolares.put(Divisas.MXN, 17.0477);
//		conversionesDolares.put(Divisas.Dolar, 1.0);
		conversionesDolares.put(Divisas.Libras, 0.7861);
		conversionesDolares.put(Divisas.Euro, 0.9186);
		conversionesDolares.put(Divisas.Yen, 144.4639);
		conversionesDolares.put(Divisas.KRW, 1298.7071);
		conversiones.put(Divisas.Dolar, conversionesDolares);

		// Agregamos las conversiones de libras a otras divisas
		Map<Divisas, Double> conversionesLibras = new HashMap<>();
		conversionesLibras.put(Divisas.MXN, 21.6861);
		conversionesLibras.put(Divisas.Dolar, 1.2718);
//		conversionesLibras.put(Divisas.Libras, 1.0);
		conversionesLibras.put(Divisas.Euro, 1.1684);
		conversionesLibras.put(Divisas.Yen, 183.7394);
		conversionesLibras.put(Divisas.KRW, 1651.8422);
		conversiones.put(Divisas.Libras, conversionesLibras);

		// Agregamos las conversiones de euros a otras divisas
		Map<Divisas, Double> conversionesEuros = new HashMap<>();
		conversionesEuros.put(Divisas.MXN, 18.5595);
		conversionesEuros.put(Divisas.Dolar, 1.0884);
		conversionesEuros.put(Divisas.Libras, 0.8557);
//		conversionesEuros.put(Divisas.Euro, 1.0);
		conversionesEuros.put(Divisas.Yen, 157.2467);
		conversionesEuros.put(Divisas.KRW, 1413.7558);
		conversiones.put(Divisas.Euro, conversionesEuros);

		// Agregamos las conversiones de yenes a otras divisas
		Map<Divisas, Double> conversionesYenes = new HashMap<>();
		conversionesYenes.put(Divisas.MXN, 0.1180);
		conversionesYenes.put(Divisas.Dolar, 0.0069);
		conversionesYenes.put(Divisas.Libras, 0.0054);
		conversionesYenes.put(Divisas.Euro, 0.0063);
//		conversionesYenes.put(Divisas.Yen, 1.0);
		conversionesYenes.put(Divisas.KRW, 8.9963);
		conversiones.put(Divisas.Yen, conversionesYenes);

		// Agregamos las conversiones de won surcoreanos a otras divisas
		Map<Divisas, Double> conversionesWonSurcoreanos = new HashMap<>();
		conversionesWonSurcoreanos.put(Divisas.MXN, 0.0131);
		conversionesWonSurcoreanos.put(Divisas.Dolar, 0.000769);
		conversionesWonSurcoreanos.put(Divisas.Libras, 0.000605);
		conversionesWonSurcoreanos.put(Divisas.Euro, 0.000706);
		conversionesWonSurcoreanos.put(Divisas.Yen, 0.1111);
//		conversionesWonSurcoreanos.put(Divisas.KRW, 1.0);
		conversiones.put(Divisas.KRW, conversionesWonSurcoreanos);
	}

	/**
	 * Metodo constructor de la clase.
	 * 
	 * @param origen  -> divisa desde la que se quiere hacer la conversion
	 * @param destino -> divisa para la cual se quiere hacer la conversion
	 * @param valor   -> el valor sobre el cual se va a realizar la conversion
	 */
	public Divisa(Divisas origen, Divisas destino, double valor) {
		divisaOrigen = origen;
		divisaDestino = destino;
		valorDivisa = valor;
	}

	/**
	 * Metodo en el cual se realiza la conversion del valor proporcionado.
	 * 
	 * @return retorna el valor convertido de la divisa utilizando el factor de
	 *         conversion
	 */
	public double convertir() {
//		double factorConversion = obtenerFactorConversion();
//		double valorConvertido = valorDivisa * factorConversion;
		return valorDivisa * obtenerFactorConversion();
	}

	/**
	 * Metodo para obtener el factor de conversion de la divisa de origen a la
	 * divisa de destino. Utiliza la funcion {@code getOrDefault} de la clase
	 * {@link Map} para buscar el factor de conversion.
	 * 
	 * @return retorna el factor de conversion obtenido, o 1.0 si no lo encuentra
	 *         (si la divisa de origen y destino son la misma).
	 */
	private double obtenerFactorConversion() {
		return conversiones.getOrDefault(divisaOrigen, new HashMap<>()).getOrDefault(divisaDestino, 1.0);
	}
}
