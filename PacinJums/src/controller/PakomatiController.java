package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Locker;

public class PakomatiController extends Controller {
	@FXML
	private ComboBox<String> parcelMachineSelection;
	@FXML
	private TableView<Locker> parcelMachineContent;
	@FXML
	private TableColumn<Locker, Integer> idlocker;
	@FXML
	private TableColumn<Locker, Integer> lockernumber;
	@FXML
	private TableColumn<Locker, String> size;
	@FXML
	private TableColumn<Locker, Long> unlockCode;
	@FXML
	private TableColumn<Locker, Integer> idparcelmachine;
	@FXML
	private TableColumn<Locker, Integer> idparcel;
	@FXML
	private TableColumn<Locker, String> placeddate;

	@FXML
	private void initialize() {
//		makeConnection();
		parcelMachineSelection.setItems(FXCollections.observableArrayList(getParcelMachineSelection()));
		getParcelMachineContent(-1);
		System.out.println(parcelMachineSelection.getSelectionModel().getSelectedIndex());
//		getParcelMachineContent();
	}
	
	@FXML
	private void parcelMachineSelected(ActionEvent event) {
//		selected
		getParcelMachineContent(1);
	}

	private List<String> getParcelMachineSelection() {
		List<String> selection = new ArrayList<>();
		String str1;
		String SqlSelectMachine = "SELECT * FROM PARCELMACHINE;";
		makeConnection();
		try {
			stmt = c.createStatement();
			ResultSet set = stmt.executeQuery(SqlSelectMachine);
			while (set.next()) {
				str1 = set.getString("address") + ", " + set.getString("workingregion");
				selection.add(str1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endConnection();
		return selection;
	}

	public void getParcelMachineContent(int selectedIndex) {
		makeConnection();
		idlocker.setCellValueFactory(new PropertyValueFactory<>("idlocker"));
		lockernumber.setCellValueFactory(new PropertyValueFactory<>("lockerNumber"));
		size.setCellValueFactory(new PropertyValueFactory<>("size"));
		unlockCode.setCellValueFactory(new PropertyValueFactory<>("lockerCode"));
		idparcelmachine.setCellValueFactory(new PropertyValueFactory<>("idparcelmachine"));
		idparcel.setCellValueFactory(new PropertyValueFactory<>("idparcel"));
		placeddate.setCellValueFactory(new PropertyValueFactory<>("placedDate"));
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		Locker row = new Locker();
		try {
			rs = stmt.executeQuery("SELECT * FROM LOCKER WHERE idparcelmachine="+selectedIndex+";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				row = new Locker(rs.getInt("idlocker"), rs.getInt("lockernumber"), rs.getString("size"),
						rs.getLong("lockercode"), rs.getInt("idparcelmachine"), rs.getInt("idparcel"),
						rs.getString("placeddate"));
				System.out.println(row);
				parcelMachineContent.getItems().add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		endConnection();
	}
	
}
