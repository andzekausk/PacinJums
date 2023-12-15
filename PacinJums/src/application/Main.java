package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Driver;
import model.Employee;
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
	}
}
