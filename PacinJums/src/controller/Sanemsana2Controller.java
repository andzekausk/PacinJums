package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Sanemsana2Controller {
	@FXML
	Button pogaPabeigt;
	
	private Scene scene;
	private Stage stage;
	private Parent root;
	
	public void pabeigt(ActionEvent event) throws IOException {
		//changeScene(pogaPabeigt, "/application/MenuScene.fxml");
		//FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/MenuScene.fxml"));
		//root = loader.load();
		//stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		//scene = new Scene(root);
		//stage.setScene(scene);
		//stage.show();
	}
}
