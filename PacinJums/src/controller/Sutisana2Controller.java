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
import javafx.stage.Stage;
import model.Client;
import model.Parcel;

public class Sutisana2Controller extends Controller {
	@FXML
	private Label aizpilditsVards, aizpilditsUzvards, aizpilditsMob, aizpilditsEpasts, aizpilditaAdrese, aizpilditsVards2,
	aizpilditsUzvards2,aizpilditsMob2, aizpilditsEpasts2, aizpilditaAdrese2;

	 @FXML
	 private RadioButton poga1, poga2, poga3, poga4;

	 @FXML
	 private Button pogaTurpinat;

	 @FXML
	 private Label pazinojums;

	 private Parent root;

	Client jaunsKlients, jaunsKlients2;
	Parcel jaunsSutijums;

	private Stage stage;
	private Scene scene;

	public void setJaunsKlients(Client jaunsKlients) throws IOException {
		this.jaunsKlients = jaunsKlients;
        aizpilditsVards.setText(jaunsKlients.getName());
        aizpilditsUzvards.setText(jaunsKlients.getSurname());
        aizpilditsMob.setText(jaunsKlients.getPhoneNumber());
        aizpilditsEpasts.setText(jaunsKlients.getEmailAdress());
        aizpilditaAdrese.setText(jaunsKlients.getAddress());
    }
	public void setJaunsKlients2(Client jaunsKlients2) throws IOException {
		this.jaunsKlients2 = jaunsKlients2;
        aizpilditsVards2.setText(jaunsKlients2.getName());
        aizpilditsUzvards2.setText(jaunsKlients2.getSurname());
        aizpilditsMob2.setText(jaunsKlients2.getPhoneNumber());
        aizpilditsEpasts2.setText(jaunsKlients2.getEmailAdress());
        aizpilditaAdrese2.setText(jaunsKlients2.getAddress());
    }
//	public void setJaunsKlients2(Client jaunsKlients2) {
//        aizpilditsVards2.setText(jaunsKlients2.getName());
//        aizpilditsUzvards2.setText(jaunsKlients2.getSurname());
//        aizpilditsMob2.setText(jaunsKlients2.getPhoneNumber());
//        aizpilditsEpasts2.setText(jaunsKlients2.getEmailAdress());
//
//    }

	public void setJaunsPasutijums(Parcel jaunsSutijums) throws IOException {
		this.jaunsSutijums = jaunsSutijums;
	}
	public void dotiesTalak (ActionEvent event) throws IOException {
		if (poga1.isSelected() && (poga3.isSelected() || poga4.isSelected())){
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana3.fxml"));

			root = loader.load();

			Sutisana3Controller sutisana3Controller = loader.getController();
			sutisana3Controller.paidJaunsPasutijums(jaunsSutijums);
			System.out.println(jaunsSutijums);

			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		}
		else if (poga2.isSelected() && poga3.isSelected() ) {
			changeScene(pogaTurpinat, "/application/Sutisana4.fxml");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana4.fxml"));

			root = loader.load();
	        Sutisana4Controller sutisana4Controller = loader.getController();
	        sutisana4Controller.setJaunsKlients(jaunsKlients);
			sutisana4Controller.setJaunsKlients2(jaunsKlients2);
			sutisana4Controller.editJaunsPasutijums(jaunsSutijums);
		}
		else if (poga2.isSelected() && poga4.isSelected()) {
			pazinojums.setText("Ja saņēmējs maksās par piegādi, atgriešana ir obligāta!");
		}
	}
}
