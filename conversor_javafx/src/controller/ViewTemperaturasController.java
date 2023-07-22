package controller;

import java.net.URL;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import model.Temperatura;
import model.Temperaturas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewTemperaturasController implements Initializable {

	@FXML
	private TextField txtValorGrados;
	@FXML
	private ComboBox<Temperaturas> cbTemperaturaOrigen, cbTemperaturaDestino;
	@FXML
	private Button btnConvertirGrados, btnVolverTemperatura;
	@FXML
	private Label lblResultadoConversion;

	@FXML
	private void convertirButton(ActionEvent event) {
		Temperatura resultadoConversion = null;
		try {
			lblResultadoConversion.setText("");
			double valor = Double.parseDouble(txtValorGrados.getText());
			resultadoConversion = new Temperatura(cbTemperaturaOrigen.getValue(), cbTemperaturaDestino.getValue(),
					valor);
			lblResultadoConversion
					.setText(resultadoConversion.convertir() + " " + cbTemperaturaDestino.getValue().name());
		} catch (NumberFormatException ex) {
			lblResultadoConversion.setText("Valor inválido.");
			JOptionPane.showMessageDialog(null, "Valor inválido, revisa los datos ingresados.", "Valor inválido.",
					JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException ex) {
			lblResultadoConversion.setText("");
			JOptionPane.showMessageDialog(null, "Hubo un problema, intentlo nuevamente.", "Problema de ejecución.",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			txtValorGrados.setText("");
		}
	}

	@FXML
	private void volverButton(ActionEvent event) {
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<Temperaturas> temperaturas = new ArrayList<>();
		Collections.addAll(temperaturas,
				new Temperaturas[] { Temperaturas.Celsius, Temperaturas.Fahrenheit, Temperaturas.Kelvin });
		cbTemperaturaOrigen.getItems().addAll(temperaturas);
		cbTemperaturaDestino.getItems().addAll(temperaturas);
	}

}
