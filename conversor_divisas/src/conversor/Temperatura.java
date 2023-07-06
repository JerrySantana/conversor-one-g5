package conversor;

public class Temperatura {
	private Temperaturas temperaturaOrigen;
	private Temperaturas temperaturaDestino;
	private double valorTemperatura;

	public Temperatura(Temperaturas origen, Temperaturas destino, double gradosTemperatura) {
		temperaturaOrigen = origen;
		temperaturaDestino = destino;
		valorTemperatura = gradosTemperatura;
	}

	public double convertir() {
		double temperaturaConvertida = 0;
		switch (temperaturaOrigen) {
		case Celsius:
			temperaturaConvertida = conversionCelsius();
			break;
		case Fahrenheit:
			temperaturaConvertida = conversionFahrenheit();
			break;
		case Kelvin:
			temperaturaConvertida = conversionKelvin();
			break;
		default:
			break;
		}
		return temperaturaConvertida;
	}

	private double conversionCelsius() {
		double temperaturaAuxiliar = 0;
		switch (temperaturaDestino) {
		case Celsius:
			temperaturaAuxiliar = valorTemperatura;
			break;
		case Fahrenheit:
			temperaturaAuxiliar = (valorTemperatura * (9.0 / 5.0)) + 32;
			break;
		case Kelvin:
			temperaturaAuxiliar = valorTemperatura + 273.15;
			break;
		}
		return temperaturaAuxiliar;
	}

	private double conversionFahrenheit() {
		double temperaturaAuxiliar = 0;
		switch (temperaturaDestino) {
		case Celsius:
			temperaturaAuxiliar = (valorTemperatura - 32) * (5.0 / 9.0);
			break;
		case Fahrenheit:
			temperaturaAuxiliar = valorTemperatura;
			break;
		case Kelvin:
			temperaturaAuxiliar = (valorTemperatura - 32) * (5.0 / 9.0) + 273.15;
			break;
		}
		return temperaturaAuxiliar;
	}

	private double conversionKelvin() {
		double temperaturaAuxiliar = 0;
		switch (temperaturaDestino) {
		case Celsius:
			temperaturaAuxiliar = valorTemperatura - 273.15;
			break;
		case Fahrenheit:
			temperaturaAuxiliar = (valorTemperatura - 273.15) * (9.0 / 5.0) + 32;
			break;
		case Kelvin:
			temperaturaAuxiliar = valorTemperatura;
			break;
		}
		return temperaturaAuxiliar;
	}
}
