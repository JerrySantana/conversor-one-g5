package conversor;

public class Divisa {
	private Divisas origen;
	private Divisas destino;
	private double valor;
	
	public Divisa(Divisas origen, Divisas destino, double valor) {
		this.origen = origen;
		this.destino = destino;
		this.valor = valor;
	}
	
	public double convertir() {
		double total = 0;
		switch(origen) {
			case PESOSMEXICANOS:
				total = valor*pesosMexicanos();
				break;
			case DOLAR:
				total = valor*dolares();
				break;
			case LIBRAS:
				total = valor*libras();
				break;
			case EURO:
				total = valor*euros();
				break;
			case YEN:
				total = valor*yenes();
				break;
			case WONCOREANO:
				total = valor*wonCoreanos();
				break;
			default:
				total = 0;
		}
		return total;
	}
	
	private double pesosMexicanos() {
		double conversion;
		switch(destino) {
			case PESOSMEXICANOS:
				conversion = 1;
				break;
			case DOLAR:
				conversion = 0.0586;
				break;
			case LIBRAS:
				conversion = 0.0461;
				break;
			case EURO:
				conversion = 0.0538;
				break;
			case YEN:
				conversion = 8.4710;
				break;
			case WONCOREANO:
				conversion = 76.116;
				break;
			default:
				conversion = 0;
				break;
		}
		return conversion;
	}
	
	private double dolares() {
		double conversion;
		switch(destino) {
			case PESOSMEXICANOS:
				conversion = 17.0477;
				break;
			case DOLAR:
				conversion = 1;
				break;
			case LIBRAS:
				conversion = 0.7861;
				break;
			case EURO:
				conversion = 0.9186;
				break;
			case YEN:
				conversion = 144.4639;
				break;
			case WONCOREANO:
				conversion = 1298.7071;
				break;
			default:
				conversion = 0;
				break;
		}
		return conversion;
	}

	private double libras() {
		double conversion;
		switch(destino) {
			case PESOSMEXICANOS:
				conversion = 21.6861;
				break;
			case DOLAR:
				conversion = 1.2718;
				break;
			case LIBRAS:
				conversion = 1;
				break;
			case EURO:
				conversion = 1.1684;
				break;
			case YEN:
				conversion = 183.7394;
				break;
			case WONCOREANO:
				conversion = 1651.8422;
				break;
			default:
				conversion = 0;
				break;
		}
		return conversion;
	}
	
	private double euros() {
		double conversion;
		switch(destino) {
			case PESOSMEXICANOS:
				conversion = 18.5595;
				break;
			case DOLAR:
				conversion = 1.0884;
				break;
			case LIBRAS:
				conversion = 0.8557;
				break;
			case EURO:
				conversion = 1;
				break;
			case YEN:
				conversion = 157.2467;
				break;
			case WONCOREANO:
				conversion = 1413.7558;
				break;
			default:
				conversion = 0;
				break;
		}
		return conversion;
	}
	
	private double yenes() {
		double conversion;
		switch(destino) {
			case PESOSMEXICANOS:
				conversion = 0.1180;
				break;
			case DOLAR:
				conversion = 0.0069;
				break;
			case LIBRAS:
				conversion = 0.0054;
				break;
			case EURO:
				conversion = 0.0063;
				break;
			case YEN:
				conversion = 1;
				break;
			case WONCOREANO:
				conversion = 8.9963;
				break;
			default:
				conversion = 0;
				break;
		}
		return conversion;
	}
	
	private double wonCoreanos() {
		double conversion;
		switch(destino) {
			case PESOSMEXICANOS:
				conversion = 0.0131;
				break;
			case DOLAR:
				conversion = 0.000769;
				break;
			case LIBRAS:
				conversion = 0.000605;
				break;
			case EURO:
				conversion = 0.000706;
				break;
			case YEN:
				conversion = 0.1111;
				break;
			case WONCOREANO:
				conversion = 1;
				break;
			default:
				conversion = 0;
				break;
		}
		return conversion;
	}
}
