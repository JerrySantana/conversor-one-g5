package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import model.DataLoader;
import model.Divisa;
import model.Divisas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewDivisasController implements Initializable {

	@FXML
	private TextField txtValorDivisa;
	@FXML
	private ComboBox<Divisas> cbDivisaOrigen, cbDivisaDestino;
	@FXML
	private Button btnConvertirDivisas, btnVolverDivisa;
	@FXML
	private Label lblResultadoConversion;

	@FXML
	private void convertirButton(ActionEvent event) {
		Divisa resultadoConversion = null;
		try {
			lblResultadoConversion.setText("");
			double valor = Double.parseDouble(txtValorDivisa.getText());
			resultadoConversion = new Divisa(cbDivisaOrigen.getValue(), cbDivisaDestino.getValue(), valor);
			String resultado = String.format("%.3f %s", resultadoConversion.convertir(), cbDivisaDestino.getValue().getName());
			lblResultadoConversion.setText(resultado);
		} catch (NumberFormatException ex) {
			lblResultadoConversion.setText("Valor inválido.");
			JOptionPane.showMessageDialog(null, "Valor inválido, revisa los datos ingresados.", "Valor inválido.",
					JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException ex) {
			lblResultadoConversion.setText("");
			JOptionPane.showMessageDialog(null, "Hubo un problema, intentlo nuevamente.", "Problema de ejecución.",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			txtValorDivisa.setText("");
		}
	}

	@FXML
	private void volverButton(ActionEvent event) {
		((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<Divisas> divisas = new ArrayList<>();
		Collections.addAll(divisas,
				new Divisas[] { Divisas.USD, Divisas.EUR, Divisas.GBP, Divisas.JPY, Divisas.KRW, Divisas.MXN });
		cbDivisaOrigen.getItems().addAll(divisas);
		cbDivisaDestino.getItems().addAll(divisas);
		DataLoader.obtainExchangeRateData(divisas);
	}

}