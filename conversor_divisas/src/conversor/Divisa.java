package conversor;

import java.util.HashMap;
import java.util.Map;

public class Divisa {
	private Divisas origen;
	private Divisas destino;
	private double valor;

	private static Map<Divisas, Map<Divisas, Double>> conversiones;

	static {
		
		// Inicializamos el mapa de conversiones
		conversiones = new HashMap<>();

		// Agregamos las conversiones de pesos mexicanos a otras divisas
		Map<Divisas, Double> conversionesPesosMexicanos = new HashMap<>();
		conversionesPesosMexicanos.put(Divisas.MXN, 1.0);
		conversionesPesosMexicanos.put(Divisas.DOLAR, 0.0586);
		conversionesPesosMexicanos.put(Divisas.LIBRAS, 0.0461);
		conversionesPesosMexicanos.put(Divisas.EURO, 0.0538);
		conversionesPesosMexicanos.put(Divisas.YEN, 8.4710);
		conversionesPesosMexicanos.put(Divisas.KRW, 76.116);
		conversiones.put(Divisas.MXN, conversionesPesosMexicanos);

		// Agregamos las conversiones de dólares a otras divisas
		Map<Divisas, Double> conversionesDolares = new HashMap<>();
		conversionesDolares.put(Divisas.MXN, 17.0477);
		conversionesDolares.put(Divisas.DOLAR, 1.0);
		conversionesDolares.put(Divisas.LIBRAS, 0.7861);
		conversionesDolares.put(Divisas.EURO, 0.9186);
		conversionesDolares.put(Divisas.YEN, 144.4639);
		conversionesDolares.put(Divisas.KRW, 1298.7071);
		conversiones.put(Divisas.DOLAR, conversionesDolares);

		// Agregamos las conversiones de libras a otras divisas
		Map<Divisas, Double> conversionesLibras = new HashMap<>();
		conversionesLibras.put(Divisas.MXN, 21.6861);
		conversionesLibras.put(Divisas.DOLAR, 1.2718);
		conversionesLibras.put(Divisas.LIBRAS, 1.0);
		conversionesLibras.put(Divisas.EURO, 1.1684);
		conversionesLibras.put(Divisas.YEN, 183.7394);
		conversionesLibras.put(Divisas.KRW, 1651.8422);
		conversiones.put(Divisas.LIBRAS, conversionesLibras);

		// Agregamos las conversiones de euros a otras divisas
		Map<Divisas, Double> conversionesEuros = new HashMap<>();
		conversionesEuros.put(Divisas.MXN, 18.5595);
		conversionesEuros.put(Divisas.DOLAR, 1.0884);
		conversionesEuros.put(Divisas.LIBRAS, 0.8557);
		conversionesEuros.put(Divisas.EURO, 1.0);
		conversionesEuros.put(Divisas.YEN, 157.2467);
		conversionesEuros.put(Divisas.KRW, 1413.7558);
		conversiones.put(Divisas.EURO, conversionesEuros);

		// Agregamos las conversiones de yenes a otras divisas
		Map<Divisas, Double> conversionesYenes = new HashMap<>();
		conversionesYenes.put(Divisas.MXN, 0.1180);
		conversionesYenes.put(Divisas.DOLAR, 0.0069);
		conversionesYenes.put(Divisas.LIBRAS, 0.0054);
		conversionesYenes.put(Divisas.EURO, 0.0063);
		conversionesYenes.put(Divisas.YEN, 1.0);
		conversionesYenes.put(Divisas.KRW, 8.9963);
		conversiones.put(Divisas.YEN, conversionesYenes);

		// Agregamos las conversiones de won surcoreanos a otras divisas
		Map<Divisas, Double> conversionesWonSurcoreanos = new HashMap<>();
		conversionesWonSurcoreanos.put(Divisas.MXN, 0.0131);
		conversionesWonSurcoreanos.put(Divisas.DOLAR, 0.000769);
		conversionesWonSurcoreanos.put(Divisas.LIBRAS, 0.000605);
		conversionesWonSurcoreanos.put(Divisas.EURO, 0.000706);
		conversionesWonSurcoreanos.put(Divisas.YEN, 0.1111);
		conversionesWonSurcoreanos.put(Divisas.KRW, 1.0);
		conversiones.put(Divisas.KRW, conversionesWonSurcoreanos);
	}

	public Divisa(Divisas origen, Divisas destino, double valor) {
		this.origen = origen;
		this.destino = destino;
		this.valor = valor;
	}

	public double convertir() {
		double factorConversion = obtenerFactorConversion();
		return valor * factorConversion;
	}

	private double obtenerFactorConversion() {
		try {
			Map<Divisas, Double> conversionesOrigen = conversiones.get(origen);
			Double factorConversion = conversionesOrigen.get(destino);
			return factorConversion;
		} catch (NullPointerException ex) {
			
		}
		return 0.0;
	}
}
