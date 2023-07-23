package model;

/**
 * Tipos de divisas que se pueden utilizar.
 * 
 * @author Gerardo Santana
 * @version 1.0
 */
public enum Divisas {
	/**
	 * Dolar estadounidense
	 */
	USD("USD", "Dolar estadounidense"),
	/**
	 * Euro
	 */
	EUR("EUR", "Euro"),
	/**
	 * Libra esterlina
	 */
	GBP("GBP", "Libra esterlina"),
	/**
	 * Yen japones
	 */
	JPY("JPY", "Yen japones"),
	/**
	 * Won surcoreano
	 */
	KRW("KRW", "Won surcoreano"),
	/**
	 * Peso mexicano
	 */
	MXN("MXN", "Peso mexicano");
	
	private String code, name;
	
	Divisas(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
}