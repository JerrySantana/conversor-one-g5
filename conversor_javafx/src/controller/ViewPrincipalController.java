package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewPrincipalController implements Initializable {
	@FXML
	private ComboBox<String> cbConversion;

	@FXML
	private Button btnMainNext;

	@FXML
	private Button btnMainExit;

	@FXML
	private void mainNextButtonAction(ActionEvent event) {
		if(cbConversion.getSelectionModel().getSelectedItem() == "Divisas") {
			try {
			    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ViewDivisas.fxml"));
			    Parent root1 = (Parent) fxmlLoader.load();
			    Stage stage = new Stage();
			    stage.setScene(new Scene(root1));
			    stage.initModality(Modality.WINDOW_MODAL);
			    stage.initOwner(((Node) (event.getSource())).getScene().getWindow());
			    stage.show();
			} catch (Exception ex) {
			    ex.printStackTrace();
			}
		} else {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ViewTemperaturas.fxml"));
				Parent root2 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setScene(new Scene(root2));
				stage.initModality(Modality.WINDOW_MODAL);
				stage.initOwner(((Node) (event.getSource())).getScene().getWindow());
				stage.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	@FXML
	private void mainExitButtonAction(ActionEvent event) {
		Platform.exit();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		ArrayList<String> listaDivisas = new ArrayList<>();
//		Collections.addAll(listaDivisas, new String[]{"Divisas", "Temperatura"});
		cbConversion.getItems().add("Divisas");
		cbConversion.getItems().add("Temperatura");

	}

}
