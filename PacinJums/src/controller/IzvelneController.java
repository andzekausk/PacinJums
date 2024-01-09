package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

public class IzvelneController extends Controller {
	@FXML
	private Button button_sanemt;
	@FXML
	private Button button_nosutit;

//	private Stage stage;
//	private Scene scene;
//	private Parent root;

	// Event Listener on Button[#button_sanemt].onAction
	@FXML
	public void sanemtClicked(ActionEvent event) throws IOException {
		changeScene(button_sanemt, "/application/KautKasUnikals.fxml");
	}

	// Event Listener on Button[#button_nosutit].onAction
//	@FXML
//	public void nosutitClicked(ActionEvent event) throws IOException {
//		root = FXMLLoader.load(getClass().getResource("/application/TestScene.fxml"));
//		//myStage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		stage = (Stage)button_nosutit.getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//	}
	@FXML
	public void nosutitClicked(ActionEvent event) throws IOException {
		changeScene(button_nosutit, "/application/TestScene.fxml");
		
	}
}
