package controller;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import model.Client;
import model.Parcel;

public class Sutisana2Controller extends Controller {
	@FXML
	private Label aizpilditsVards, aizpilditsUzvards, aizpilditsMob, aizpilditsEpasts, aizpilditsVards2, aizpilditsUzvards2, aizpilditsMob2, aizpilditsEpasts2;

	 @FXML
	 private RadioButton poga1, poga2, poga3, poga4;
	 
	 @FXML
	 private Button pogaTurpinat;
	 
	 @FXML
	 private Label pazinojums;
	 
	 private Parent root;
	 
	
	public void setJaunsKlients(Client jaunsKlients) throws IOException {
        aizpilditsVards.setText(jaunsKlients.getName());
        aizpilditsUzvards.setText(jaunsKlients.getSurname());
        aizpilditsMob.setText(jaunsKlients.getPhoneNumber());
        aizpilditsEpasts.setText(jaunsKlients.getEmailAdress());
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana3.fxml"));
		
		root = loader.load();
        Sutisana3Controller sutisana3Controller = loader.getController();
		sutisana3Controller.setJaunsKlients(jaunsKlients);
        
        
    }
	public void setJaunsKlients2(Client jaunsKlients2) throws IOException {
        aizpilditsVards2.setText(jaunsKlients2.getName());
        aizpilditsUzvards2.setText(jaunsKlients2.getSurname());
        aizpilditsMob2.setText(jaunsKlients2.getPhoneNumber());
        aizpilditsEpasts2.setText(jaunsKlients2.getEmailAdress());
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana3.fxml"));
		
		root = loader.load();
        Sutisana3Controller sutisana3Controller = loader.getController();
		sutisana3Controller.setJaunsKlients2(jaunsKlients2);
             
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
	public void setJaunsPasutijums(Parcel jaunsSutijums) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana3.fxml"));
		
		root = loader.load();
		
		Sutisana3Controller sutisana3Controller = loader.getController();
		sutisana3Controller.paidJaunsPasutijums(jaunsSutijums);
	}
}
