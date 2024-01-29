package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import model.Client;
import model.Parcel;
import model.ParcelMachine;

public class Sutisana4Controller extends Controller{
	@FXML
	Button pogaPabeigt, lockerDoor;
	
	@FXML
	ToggleGroup RegionSelect;
	@FXML
	Label lockerNumber;
	
	Client jaunsKlients = null;
	Client jaunsKlients2 = null;

	public void setJaunsKlients(Client jaunsKlients) {
		this.jaunsKlients = jaunsKlients;
}
	public void setJaunsKlients2(Client jaunsKlients2) {
		this.jaunsKlients2 = jaunsKlients2;
	}
	public void editJaunsPasutijums(Parcel jaunsSutijums) {
		jaunsSutijums.setSender(jaunsKlients);
		jaunsSutijums.setReciever(jaunsKlients2);
		System.out.println(jaunsSutijums);
	}
	

	public void DoorClosed (ActionEvent event) throws IOException {
		lockerNumber.setText("");
	}
	
	public void pabeigt(ActionEvent event) throws IOException {
		changeScene(pogaPabeigt, "/application/MenuScene.fxml");
	}
}
