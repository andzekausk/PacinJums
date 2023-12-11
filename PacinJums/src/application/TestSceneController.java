package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TestSceneController {
	@FXML
	private TextField textField1;
	@FXML
	private Label label1;
	@FXML
	private Button button1;
	
	public void button1Clicked(ActionEvent event) {
		Stage mainWindow = (Stage) textField1.getScene().getWindow();
		String title = textField1.getText();
		mainWindow.setTitle(title);
		label1.setText(title);
		button1.setText(title);
	}
}
