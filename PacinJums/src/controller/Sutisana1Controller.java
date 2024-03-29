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
	private TextField nosutVards, nosutUzvards, nosutMob, nosutEpasts, sanemVards, sanemUzvards, sanemMob, sanemEpasts;
	
	@FXML
	private Label vietaZinai;
	
	@FXML
	private Button pogaA, pogaB, pogaC;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void sutit(ActionEvent event) throws IOException {
		if (nosutVards.getText().isEmpty() || nosutUzvards.getText().isEmpty() || nosutMob.getText().isEmpty() || nosutEpasts.getText().isEmpty() || sanemVards.getText().isEmpty() || sanemUzvards.getText().isEmpty() || sanemEpasts.getText().isEmpty() || sanemMob.getText().isEmpty()) {
			vietaZinai.setText("Aizpildi visus laukumus!");
		}
		else {
			Client jaunsKlients = new Client(nosutVards.getText(), nosutUzvards.getText(), null, nosutMob.getText(), nosutEpasts.getText(), null);
			
			Client jaunsKlients2 = new Client(sanemVards.getText(), sanemUzvards.getText(), null, sanemMob.getText(), sanemEpasts.getText(), null);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana2.fxml"));
			root = loader.load();
			
			Sutisana2Controller sutisana2Controller = loader.getController();
			sutisana2Controller.setJaunsKlients(jaunsKlients);
			sutisana2Controller.setJaunsKlients2(jaunsKlients2);
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
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
