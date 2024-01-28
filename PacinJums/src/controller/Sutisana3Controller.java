package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import model.Client;
import model.Parcel;

public class Sutisana3Controller extends Controller{
	@FXML
	Button pogaTurpinat;
	private Parent root;
	
	//Client jaunsKlients, jaunsKlients2;
	//Parcel jaunsSutijums;
//	public void setJaunsKlients(Client jaunsKlients) throws IOException {
//		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana4.fxml"));
//			
//			root = loader.load();
//	        Sutisana4Controller sutisana4Controller = loader.getController();
//			sutisana4Controller.setJaunsKlients(jaunsKlients);
//}
//	public void setJaunsKlients2(Client jaunsKlients2) throws IOException {
//		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana4.fxml"));
//			
//			root = loader.load();
//	        Sutisana4Controller sutisana4Controller = loader.getController();
//			sutisana4Controller.setJaunsKlients2(jaunsKlients2);
//}
//
	public void paidJaunsPasutijums(Parcel jaunsSutijums) throws IOException {
		jaunsSutijums.setIsPaid(true);
//		
//		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana4.fxml"));
//			
//			root = loader.load();
//	        Sutisana4Controller sutisana4Controller = loader.getController();
//			sutisana4Controller.editJaunsPasutijums(jaunsSutijums);
	}
	
	public void turpinat(ActionEvent event) throws IOException {
		changeScene(pogaTurpinat, "/application/Sutisana4.fxml");
		//FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana4.fxml"));
	
		//root = loader.load();
		//Sutisana4Controller sutisana4Controller = loader.getController();
		//sutisana4Controller.setJaunsKlients(jaunsKlients);
		//sutisana4Controller.setJaunsKlients(jaunsKlients2);
		//sutisana4Controller.editJaunsPasutijums(jaunsSutijums);
	}
}
