package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Sanemsana2Controller extends Controller {
	@FXML
	Button pogaPabeigt;
	
	
	public void pabeigt(ActionEvent event) throws IOException {
		changeScene(pogaPabeigt, "/application/MenuScene.fxml");

	}
}
