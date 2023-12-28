package application;
	
import java.io.ObjectInputFilter.Status;

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
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Izvelne.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ParcelMachine pm1 = new ParcelMachine(ParcelMachineLocation.Bauska, "wassabi iela 12", 60, 20, 10);
		Client sender1 = new Client("Cils", "Veks", "301199-11111", "21234567", "hallo@gmail.com", "Lielais prospekts 20");
		Client reciever1 = new Client("Pers", "Ona", "301100-22222", "22345678", "ahoy@gmail.com", "mazais prospekts 20");
		Parcel parcel1 = new Parcel(pm1, sender1, reciever1, Size.S, true, false, ParcelStatus.Pending, true);
		System.out.println(parcel1);
		System.out.println(pm1);
		pm1.placeParcel(parcel1);
		System.out.println(pm1);
		System.out.println(pm1.getLockersBySize(Size.M, pm1.getAllLockers()));
		launch(args);
		
	}
}
