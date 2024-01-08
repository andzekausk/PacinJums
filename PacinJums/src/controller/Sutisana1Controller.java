package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Client;

public class Sutisana1Controller {
	@FXML
	private RadioButton radioButtonS, radioButtonM, radioButtionL;
	
	@FXML
	private TextField nosutVards, nosutMob, nosutEpasts, sanemVards, sanemMob, sanemEpasts;
	
	@FXML
	private Label vietaZinai;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void sutit(ActionEvent event) throws IOException {
		if (nosutVards.getText()== "" || nosutMob.getText()== "" || nosutEpasts.getText()== "") {
			vietaZinai.setText("Aizpildi visus laukumus!");
		}
		else {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana2.fxml"));
			root = loader.load();
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			Client jaunsKlients = new Client(nosutVards.getText(), null, null, nosutMob.getText(), nosutEpasts.getText(), null, null);
			System.out.println(jaunsKlients);
		}
	}
}
