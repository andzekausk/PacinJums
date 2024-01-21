package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Client;

public class Sutisana2Controller {
	@FXML
	private Label aizpilditsVards, aizpilditsUzvards, aizpilditsMob, aizpilditsEpasts;

	 
	public void setJaunsKlients(Client jaunsKlients) {
        aizpilditsVards.setText(jaunsKlients.getName());
        aizpilditsUzvards.setText(jaunsKlients.getSurname());
        aizpilditsMob.setText(jaunsKlients.getPhoneNumber());
        aizpilditsEpasts.setText(jaunsKlients.getEmailAdress());
        
        
    }
	
}
