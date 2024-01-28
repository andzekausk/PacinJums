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
		parcelMachineSelection.setItems(FXCollections.observableArrayList(getParcelMachineSelection()));
	}
	
	private List<String> getParcelMachineSelection(){
		List<String> selection = new ArrayList<>();
		String str1;
		String SqlSelectMachine = "SELECT * FROM PARCELMACHINE;";
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
	
	public void getParcelMachineContent() {
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// execute select query
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery( "SELECT * FROM LOCKER WHERE idparcelmachine=1;" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// iterate through all the returned lines and for each do:
		try {
			while ( rs.next() ) {
			int id = rs.getInt("id"); //parse an integer from field “id”
			String name = rs.getString("name"); //parse string from field “name”
			String abbr = rs.getString("ABBR");
			System.out.println( "ID = " + id +"\t CODE = " + abbr+"\t Country = " +
			name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
