package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Employee;
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
	}
}
