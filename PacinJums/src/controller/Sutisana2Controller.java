package controller;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import model.Client;

public class Sutisana2Controller extends Controller {
	@FXML
	private Label aizpilditsVards, aizpilditsUzvards, aizpilditsMob, aizpilditsEpasts, aizpilditsVards2, aizpilditsUzvards2, aizpilditsMob2, aizpilditsEpasts2;

	 @FXML
	 private RadioButton poga1, poga2, poga3, poga4;
	 
	 @FXML
	 private Button pogaTurpinat;
	 
	 @FXML
	 private Label pazinojums;
	public void setJaunsKlients(Client jaunsKlients) {
        aizpilditsVards.setText(jaunsKlients.getName());
        aizpilditsUzvards.setText(jaunsKlients.getSurname());
        aizpilditsMob.setText(jaunsKlients.getPhoneNumber());
        aizpilditsEpasts.setText(jaunsKlients.getEmailAdress());
        
        
    }
	public void setJaunsKlients2(Client jaunsKlients2) {
        aizpilditsVards2.setText(jaunsKlients2.getName());
        aizpilditsUzvards2.setText(jaunsKlients2.getSurname());
        aizpilditsMob2.setText(jaunsKlients2.getPhoneNumber());
        aizpilditsEpasts2.setText(jaunsKlients2.getEmailAdress());
             
    }
	
	public void dotiesTalak (ActionEvent event) throws IOException {
		if (poga1.isSelected() && (poga3.isSelected() || poga4.isSelected())){
			changeScene(pogaTurpinat, "/application/Sutisana3.fxml");
		}
		else if (poga2.isSelected() && poga3.isSelected() ) {
			changeScene(pogaTurpinat, "/application/Sutisana4.fxml");
		}
		else if (poga2.isSelected() && poga4.isSelected()) {
			pazinojums.setText("Ja saņēmējs maksās par piegādi, atgriešana ir obligāta!");
		}
	}
}
