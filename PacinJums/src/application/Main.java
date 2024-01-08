package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Client;
import model.Company;
import model.Driver;
import model.Employee;
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
		Image icon = new Image("/pacinjums1logo.png");
		stage.getIcons().add(icon);
	}
	
	public static void main(String[] args) {
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
