package model;

/**
 * Clase que representa un conversor de temperatura.
 * @author Gerardo Santana
 * @version 1.0
 */
public class Temperatura {
	private Temperaturas temperaturaOrigen;
	private Temperaturas temperaturaDestino;
	private double valorTemperatura;
	
	/**
	 * Metodo constructor de la clase.
	 * @param origen -> tipo de grados de temperatura desde los que se quiere realizar la conversion.
	 * @param destino -> tipo de grados de temperatura a los cuales se quiere realizar la conversion.
	 * @param gradosTemperatura -> valor de los grados de temperatura sobre los cuales se realizara la conversion.
	 */
	public Temperatura(Temperaturas origen, Temperaturas destino, double gradosTemperatura) {
		temperaturaOrigen = origen;
		temperaturaDestino = destino;
		valorTemperatura = gradosTemperatura;
	}
	
	/**
	 * Metodo que devuelve la conversion del valor propocionado.
	 * @return retorna la conversion del valor a los grados de temperatura deseados.
	 */
	public double convertir() {
		switch (temperaturaOrigen) {
		case Celsius:
			return conversionCelsius();
		case Fahrenheit:
			return conversionFahrenheit();
		case Kelvin:
			return conversionKelvin();
		default:
			return 0;
		}
	}
	
	/**
	 * Metodo en donde se obtienen los factores de conversion a partir de grados Celsius, hacia grados Fahrenheit o Kelvin.
	 * @return retorna el valor de la conversion a los grados elegidos o retorna el valor mismo (si los grados origen y destino son ambos Celsius).
	 */
	private double conversionCelsius() {
		switch (temperaturaDestino) {
		case Fahrenheit:
			return (valorTemperatura * (9.0 / 5.0)) + 32;
		case Kelvin:
			return valorTemperatura + 273.15;
		default:
			return valorTemperatura;
		}
	}

	/**
	 * Metodo en donde se obtienen los factores de conversion a partir de grados Fahrenheit, hacia grados Celsius o Kelvin.
	 * @return retorna el valor de la conversion a los grados elegidos o retorna el valor mismo (si los grados origen y destino son ambos Fahrenheit).
	 */
	private double conversionFahrenheit() {
		switch (temperaturaDestino) {
		case Celsius:
			return (valorTemperatura - 32) * (5.0 / 9.0);
		case Kelvin:
			return (valorTemperatura - 32) * (5.0 / 9.0) + 273.15;
		default:
			return valorTemperatura;
		}
	}

	/**
	 * Metodo en donde se obtienen los factores de conversion a partir de grados Celsius, hacia grados Celsius o Fahrenheit.
	 * @return retorna el valor de la conversion a los grados elegidos o retorna el valor mismo (si los grados origen y destino son ambos Kelvin).
	 */
	private double conversionKelvin() {
		switch (temperaturaDestino) {
		case Celsius:
			return valorTemperatura - 273.15;
		case Fahrenheit:
			return (valorTemperatura - 273.15) * (9.0 / 5.0) + 32;
		default:
			return valorTemperatura;
		}
	}
}
