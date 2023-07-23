package model;

/**
 * Clase que representa un conversor de divisas.
 * 
 * @author Gerardo Santana
 * @version 2.0
 */
public class Divisa {
	private Divisas divisaOrigen;
	private Divisas divisaDestino;
	private double valorDivisa;

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
	 * @return Retorna el valor convertido de la divisa utilizando el factor de
	 *         conversion
	 */
	public double convertir() {
		return valorDivisa * obtenerFactorConversion();
	}
	
	/**
	 * Getter del atributo {@code divisaOrigen}.
	 * @return El valor del atributo {@code divisaOrigen}
	 */
	public Divisas getDivisaOrigen() {
		return divisaOrigen;
	}
	
	/**
	 * Getter del atributo {@code divisaDestino}.
	 * @return El valor del atributo {@code divisaDestino}
	 */
	public Divisas getDivisaDestino() {
		return divisaDestino;
	}

	/**
	 * Metodo para obtener el factor de conversion de la divisa de origen a la
	 * divisa de destino.
	 * 
	 * @return Retorna el factor de conversion obtenido a partir de invocar el método
	 * {@code obtainExchangeRate(Divisa divisa)} de la clase {@link DataLoader}
	 */
	private double obtenerFactorConversion() {
		return DataLoader.obtainExchangeRate(this);
	}
}
