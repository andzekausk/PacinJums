package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Client;
import model.Parcel;
import model.ParcelStatus;
import model.Size;


public class Sutisana1Controller  extends Controller{
	@FXML
	private RadioButton radioButtonS, radioButtonM, radioButtonL;
	
	@FXML
	private ToggleGroup pacinasIzmers;
	
	@FXML
	private TextField nosutVards, nosutUzvards, nosutMob, nosutEpasts, sanemVards, sanemUzvards, sanemMob,
	sanemEpasts, sanemAdrese;
	
	@FXML
	private ComboBox<String> parcelMachineSelection;
	
	@FXML
	private Label vietaZinai;
	
	@FXML
	private Button pogaA, pogaB, pogaC, pogaTurpinat;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private String CurrentParcelMachineAddress;
	private Size izmers = Size.S;
  @FXML
	private void initialize() {
		parcelMachineSelection.setItems(FXCollections.observableArrayList(getData()));
		parcelMachineSelection.getSelectionModel().selectFirst();
		CurrentParcelMachineAddress = parcelMachineSelection.getValue();


	}
  
	public void radioPogasIzvele(ActionEvent event) throws IOException {
		if (radioButtonS.isSelected()) {
			izmers = Size.S;
		}
		if (radioButtonM.isSelected()) {
			izmers = Size.M;
		}
		if (radioButtonL.isSelected()) {
			izmers = Size.L;
		}
	}
	
	@FXML
	private void parcelMachineSelected(ActionEvent event) {
		CurrentParcelMachineAddress = parcelMachineSelection.getValue();
		System.out.println(CurrentParcelMachineAddress);
	}
	
	public void sutit(ActionEvent event) throws IOException {
		
		
		if (nosutVards.getText().isEmpty() || nosutUzvards.getText().isEmpty() || nosutMob.getText().isEmpty() || 
				nosutEpasts.getText().isEmpty() || sanemVards.getText().isEmpty() || sanemUzvards.getText().isEmpty() || 
				sanemEpasts.getText().isEmpty() || sanemMob.getText().isEmpty() || sanemAdrese.getText().isEmpty()){
			vietaZinai.setText("Aizpildi visus laukumus!");
		}
		else {
			Client jaunsKlients = new Client(nosutVards.getText(), nosutUzvards.getText(), nosutMob.getText(), nosutEpasts.getText(), parcelMachineSelection.getValue());
			
			Client jaunsKlients2 = new Client(sanemVards.getText(), sanemUzvards.getText(), sanemMob.getText(), sanemEpasts.getText(), sanemAdrese.getText());
			
			Parcel jaunsSutijums = new Parcel(jaunsKlients, jaunsKlients2, izmers , false, ParcelStatus.Pending, true);
			
			
			if (jaunsKlients.getName().matches("INVALID") || 
					jaunsKlients.getSurname().matches("INVALID") ||
					jaunsKlients.getPhoneNumber().matches("INVALID") ||
					jaunsKlients.getEmail().matches("INVALID")||
					jaunsKlients2.getName().matches("INVALID") || 
					jaunsKlients2.getSurname().matches("INVALID") ||
					jaunsKlients2.getPhoneNumber().matches("INVALID") ||
					jaunsKlients2.getEmail().matches("INVALID") ||
					jaunsKlients2.getAddress().matches("INVALID")) {
				vietaZinai.setText("Nekorekta datu ievade");
			}
			else {
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sutisana2.fxml"));
				root = loader.load();
				
				Sutisana2Controller sutisana2Controller = loader.getController();
				sutisana2Controller.setJaunsKlients(jaunsKlients);
				sutisana2Controller.setJaunsKlients2(jaunsKlients2);
				sutisana2Controller.setJaunsPasutijums(jaunsSutijums);
				
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
				System.out.println(jaunsKlients);	
				System.out.println(jaunsSutijums);
				
			}
		}
	}
	public void atpakal(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/MenuScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void uzspiestPogu(ActionEvent event) throws IOException {
		Button poga = (Button) event.getSource();
		//if (nosutVards.isPressed()) {
			nosutVards.setText(nosutVards.getText() + poga.getText()) ;
		//}
	}
	public void uzspiestPogu1(ActionEvent event) throws IOException {
		Button poga = (Button) event.getSource();
		nosutMob.setText(nosutMob.getText()+ poga.getText());
	}
	@FXML
	
	private List<String> getData(){
		List<String> selection = new ArrayList<>();
		String str1;
		String SqlSelectMachine = "SELECT address, workingregion FROM PARCELMACHINE;";
		makeConnection();
		try {
			stmt = c.createStatement();
			ResultSet set = stmt.executeQuery(SqlSelectMachine);
			while(set.next()) {
				str1 = set.getString("address"); // +", "+set.getString("workingregion");
				selection.add(str1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endConnection();
		return selection;
	}
}
