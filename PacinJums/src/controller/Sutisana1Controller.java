package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Client;

public class Sutisana1Controller {
	@FXML
	private RadioButton radioButtonS, radioButtonM, radioButtionL;
	
	@FXML
	private TextField nosutVards, nosutMob, nosutEpasts, sanemVards, sanemMob, sanemEpasts;
	
	@FXML
	private Label vietaZinai;
	
	@FXML
	private Button pogaA, pogaB, pogaC;
	
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
	public void atpakal(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/MenuScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void uzspiestPogu(ActionEvent event) throws IOException {
		Button poga = (Button) event.getSource();
		//if (nosutVards.isPressed()) {
			nosutVards.setText(nosutVards.getText() + poga.getText()) ;
		//}
	}
	public void uzspiestPogu1(ActionEvent event) throws IOException {
		Button poga = (Button) event.getSource();
		nosutMob.setText(nosutMob.getText()+ poga.getText());
	}
}
