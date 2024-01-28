package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TableColumn;

public class PakomatiController extends Controller{
	@FXML
	private ComboBox<String> parcelMachineSelection;
	@FXML
	private TableColumn idlocker;
	@FXML
	private TableColumn lockernumber;
	@FXML
	private TableColumn size;
	@FXML
	private TableColumn unlockCode;
	@FXML
	private TableColumn idparcelmachine;
	@FXML
	private TableColumn idparcel;
	@FXML
	private TableColumn placeddate;

	@FXML
	private void initialize() {
//		makeConnection();
		parcelMachineSelection.setItems(FXCollections.observableArrayList(getData()));
	}
	
	private List<String> getData(){
		List<String> selection = new ArrayList<>();
		String str1;
		String SqlSelectMachine = "SELECT address, workingregion FROM PARCELMACHINE;";
		makeConnection();
		try {
			stmt = c.createStatement();
			ResultSet set = stmt.executeQuery(SqlSelectMachine);
			while(set.next()) {
				str1 = set.getString("address")+", "+set.getString("workingregion");
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
