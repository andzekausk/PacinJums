package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Client;
import model.Company;
import model.Driver;
import model.Employee;
import model.Parcel;
import model.ParcelMachine;
import model.ParcelMachineLocation;
import model.ParcelStatus;
import model.Size;
import model.Transport;
import model.WorkingRegion;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	static Connection c = null;
	@Override
	public void start(Stage stage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MenuScene.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		stage.setTitle("PacinJums");
		Image icon = new Image("/resources/images/pacinjumslogo.png");
		stage.getIcons().add(icon);
	}
	
	public static void main(String[] args) {
		makeConnection();
		ParcelMachine pm1 = new ParcelMachine(ParcelMachineLocation.Bauska, "wassabi iela 12", 60, 20, 10);
		Client sender1 = new Client("Cils", "Veks", /*"301199-11111",*/ "21234567", "hallo@gmail.com", "Lielais prospekts 20");
		Client reciever1 = new Client("Pers", "Ona", /*"301100-22222",*/ "22345678", "ahoy@gmail.com", "mazais prospekts 20");
//		Parcel parcel1 = new Parcel(pm1, sender1, reciever1, Size.S, true, false, ParcelStatus.Pending, true);
		Parcel parcel1 = new Parcel(sender1, reciever1, Size.S , true, ParcelStatus.Pending, false);
		System.out.println(parcel1);
		System.out.println(pm1);
		pm1.placeParcel(parcel1);
		System.out.println(pm1);
		System.out.println(pm1.getLockersBySize(Size.M, pm1.getAllLockers()));
		
		launch(args);
		endConnection();
	}
	
	public static void makeConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			c = DriverManager.getConnection("jdbc:sqlite:IIHF16.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void endConnection() {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
