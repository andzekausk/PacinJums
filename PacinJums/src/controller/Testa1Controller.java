package controller;

import java.io.IOException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Parcel;
import model.ParcelStatus;

public class Testa1Controller extends Controller{

	@FXML
	private Button pogaMenu, pogaTestam2, pogaIzpilditsPasutijums, pogaGaiduPasutijums, pogaPiegadatsPasutijums,
	pogaPirmsPiegadesPasutijums, pogaIznemumaPasutijums, pogaPazudisPasutijums, pogaAtgrieztsPasutijums, pogaSutijumi;
	
	Random mansRandom = new Random();
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	StringBuilder sb = new StringBuilder();
	int nameLength = 7;
	
//	for (int i = 0; i < nameLength; i++) {
//		int index = mansRandom.nextInt(alphabet.length());
//		char randomChar = alphabet.charAt(index);
//		sb.append(randomChar);
//	}
//	String generatedSender = sb.toString();
	
	public void mainMenu(ActionEvent event) throws IOException {
		changeScene(pogaMenu, "/application/MenuScene.fxml");
	}
	
	public void TestaVide2(ActionEvent event) throws IOException {
		changeScene(pogaTestam2, "/application/TestaVide2.fxml");
	}
	
	public void IzpilditsPasutijums(ActionEvent event) throws IOException {
		boolean isPaidValue = mansRandom.nextBoolean();
		boolean isPlacedBySenderValue = mansRandom.nextBoolean();

		Parcel izpilditsPasutijums = new Parcel(null, null, null, isPaidValue, ParcelStatus.Delivered, isPlacedBySenderValue);
	}
	
	public void GaiduPasutijums(ActionEvent event) throws IOException {
		boolean isPaidValue = mansRandom.nextBoolean();
		boolean isPlacedBySenderValue = mansRandom.nextBoolean();

		Parcel gaiduPasutijums = new Parcel(null, null, null, isPaidValue, ParcelStatus.Pending, isPlacedBySenderValue);
	}
	
	public void PiegadatsPasutijums(ActionEvent event) throws IOException {
		boolean isPaidValue = mansRandom.nextBoolean();
		boolean isPlacedBySenderValue = mansRandom.nextBoolean();

		Parcel piegadatsPasutijums = new Parcel(null, null, null, isPaidValue, ParcelStatus.Pickup_ready, isPlacedBySenderValue);
	}
	
	public void PirmsPiegadesPasutijums(ActionEvent event) throws IOException {
		boolean isPaidValue = mansRandom.nextBoolean();
		boolean isPlacedBySenderValue = mansRandom.nextBoolean();

		Parcel pirmsPiegadesPasutijums = new Parcel(null, null, null, isPaidValue, ParcelStatus.Pre_transit, isPlacedBySenderValue);
	}
	
	public void IznemumaPasutijums(ActionEvent event) throws IOException {
		boolean isPaidValue = mansRandom.nextBoolean();
		boolean isPlacedBySenderValue = mansRandom.nextBoolean();

		Parcel iznemumaPasutijums = new Parcel(null, null, null, isPaidValue, ParcelStatus.Exception, isPlacedBySenderValue);
	}
	
	public void PazudisPasutijums(ActionEvent event) throws IOException {
		boolean isPaidValue = mansRandom.nextBoolean();
		boolean isPlacedBySenderValue = mansRandom.nextBoolean();

		Parcel pazudisPasutijums = new Parcel(null, null, null, isPaidValue, ParcelStatus.Lost, isPlacedBySenderValue);
	}
	
	public void AtgrieztsPasutijums(ActionEvent event) throws IOException {
		boolean isPaidValue = mansRandom.nextBoolean();
		boolean isPlacedBySenderValue = mansRandom.nextBoolean();

		Parcel atgrieztsPasutijums = new Parcel(null, null, null, isPaidValue, ParcelStatus.Returned, isPlacedBySenderValue);
	}
	public void IzprintetSutijumus(ActionEvent event) throws IOException {
		System.out.println();
	}
}
