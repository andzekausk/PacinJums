package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Sanemsana1Controller {
	@FXML
	private Button poga1, poga2, poga3, poga4, poga5, poga6, poga7, poga8, poga9, poga0, pogaDzest, pogaDzestVisu, pogaTurpinat, pogaAtpakal;
	
	@FXML
	private TextField kodaVieta = new TextField("paciņas koda numurs");
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void uzspiestPogu(ActionEvent event) throws IOException {
		Button poga = (Button) event.getSource();
		kodaVieta.setText(kodaVieta.getText()+poga.getText());
	}
	
	public void dzestVienu(ActionEvent event) throws IOException {
		String apgriezts = kodaVieta.getText().substring(0, kodaVieta.getText().length()-1);
		kodaVieta.setText(apgriezts);
	}
	
	public void dzestVisu (ActionEvent event) throws IOException {
		kodaVieta.setText("");
	}
	
	public void sanemt2(ActionEvent event) throws IOException {
		String pareizais_kods = "0990";
		if (kodaVieta.getText().matches(pareizais_kods)) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sanemsana2.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
		else {
			System.out.println("Kļūda");
		}
	}
}
