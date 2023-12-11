package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TestSceneController {
	@FXML
	private TextField text_field1;
	@FXML
	private Label title1;
	@FXML
	private Button button1;
	
	public void okClicked(ActionEvent event) {
		Stage mainWindow = (Stage) text_field1.getScene().getWindow();
		String title = text_field1.getText();
		mainWindow.setTitle(title);
		title1.setText(title);
		button1.setText(title);
	}
}
