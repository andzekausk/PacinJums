package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Testa1Controller extends Controller{

	@FXML
	private Button pogaMenu, pogaTestam2;
	
	public void mainMenu(ActionEvent event) throws IOException {
		changeScene(pogaMenu, "/application/MenuScene.fxml");
	}
	
	public void TestaVide2(ActionEvent event) throws IOException {
		changeScene(pogaTestam2, "/application/TestaVide2.fxml");
	}
}
