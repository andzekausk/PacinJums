package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Testa2Controller extends Controller{

	@FXML
	private Button pogaMenu, pogaTestam1;
	
	public void mainMenu(ActionEvent event) throws IOException {
		changeScene(pogaMenu, "/application/MenuScene.fxml");
	}
	
	public void TestaVide1(ActionEvent event) throws IOException {
		changeScene(pogaTestam1, "/application/TestaVide1.fxml");
	}
}
