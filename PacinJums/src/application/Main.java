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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
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
		Image icon = new Image("/pacinjumslogo.png");
		stage.getIcons().add(icon);
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

		System.out.println("Parbaudes");
		Employee test1 = new Employee();
		Employee test2 = new Employee("Adolfs", "Sula", "120224-11223","23232323", "epasts@epasts.lv");
		System.out.println(test1);
		System.out.println(test2);
		Driver dr1 = new Driver();
		Driver dr2 = new Driver("Lauris", "Reiniks", "123456-12345", "25814736", "inbox@box.lv",
				Transport.KK_4991, WorkingRegion.Riga);
		System.out.println(dr1);
		System.out.println(dr2);
		Client cl1 = new Client();
		Client cl2 = new Client("Ivans", "Krievs", "123456-12345", "25814736", "inbox@box.lv", "Pils iela 70", "Barona iela 80");
		System.out.println(cl1);
		System.out.println(cl2);
		Company comp1 = new Company();
		Company comp2 = new Company("Ivans", "Krievs", "123456-12345", "25814736", "inbox@box.lv", "Pils iela 70", "Barona iela 80",
				"Amishi", "LV00121231232");
		System.out.println(comp1);
		System.out.println(comp2);
	}
}
