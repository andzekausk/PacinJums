package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;
//import javafx.scene.Node;

public class MenuController extends Controller{
	@FXML
	private ImageView sanemsanasBilde;
	
	@FXML
	private ImageView sutisanasBilde;
	
	@FXML
	private ImageView atgriesanasBilde;
	
	@FXML
	private Button sanemsanasPoga;
	
	@FXML
	private Button sutisanasPoga;
	
	@FXML
	private Button atgriesanasPoga;
	
//	private Stage stage;
//	private Scene scene;
//	private Parent root;
	
	
	
	public void sanemt1(ActionEvent event) throws IOException {
		changeScene(sanemsanasPoga, "/application/Sanemsana1.fxml");
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sanemsana1.fxml"));
//		root = loader.load();
//		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
	}
//	public void sanemt2(MouseEvent event) throws IOException {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sanemsana1.fxml"));
//		root = loader.load();
//		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//	}
	
	public void sutit1(ActionEvent event) throws IOException {
		changeScene(sutisanasPoga, "/application/Sutisana1.fxml");
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana1.fxml"));
//		root = loader.load();
//		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
	}
	
//	public void sutit2(ActionEvent event) throws IOException {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana1.fxml"));
//		root = loader.load();
//		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//	}
}
