package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Parcel;

public class Sanemsana2Controller extends Controller {
	@FXML
	Button pogaPabeigt;
	
	@FXML
	Label lockernumber;
	
	private String lockerNr;
	
	@FXML
	private void initialize() {
		lockernumber.setText(lockerNr);
	}
	
	public void setSendLockerNumber(String lockernr) throws IOException {
		lockerNr = ""+lockernr;
		System.out.println(lockerNr);
	}
	
	public void pabeigt(ActionEvent event) throws IOException {
		changeScene(pogaPabeigt, "/application/MenuScene.fxml");

	}
}
