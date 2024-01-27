package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import model.Client;
import model.Parcel;

public class Sutisana4Controller extends Controller{
	@FXML
	Button pogaPabeigt;
	Client jaunsKlients;
	Client jaunsKlients2;
	public void setJaunsKlients(Client jaunsKlients) {
		jaunsKlients = this.jaunsKlients;
}
	public void setJaunsKlients2(Client jaunsKlients2) {
		jaunsKlients2 = this.jaunsKlients2;
	}
	public void editJaunsPasutijums(Parcel jaunsSutijums) {
		jaunsSutijums.setSender(jaunsKlients);
		jaunsSutijums.setReciever(jaunsKlients2);
		System.out.println(jaunsSutijums);
	}
	
	public void pabeigt(ActionEvent event) throws IOException {
		changeScene(pogaPabeigt, "/application/MenuScene.fxml");

	}
}
