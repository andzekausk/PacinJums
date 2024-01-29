package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;
//import javafx.scene.Node;

public class Sanemsana1Controller extends Controller{
	@FXML
	private Button poga1, poga2, poga3, poga4, poga5, poga6, poga7, poga8, poga9, poga0, pogaDzest, pogaDzestVisu, pogaTurpinat, pogaAtpakal;
	
	@FXML
	private TextField kodaVieta = new TextField("paciņas koda numurs");
	
	@FXML
	private javafx.scene.control.Label label1;
	
	String pareizais_kods;
	
	public void uzspiestPogu(ActionEvent event) throws IOException {
		Button poga = (Button) event.getSource();
		kodaVieta.setText(kodaVieta.getText()+poga.getText());
	}
	
	public void dzestVienu(ActionEvent event) throws IOException {
		kodaVieta.deleteText(kodaVieta.getLength()-1, kodaVieta.getLength());
	}
	
	public void dzestVisu (ActionEvent event) throws IOException {
		kodaVieta.deleteText(0, kodaVieta.getLength());
	}
	public void getParcelCodes() {
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// execute select query
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery( "SELECT lockercode FROM LOCKER WHERE idparcelmachine=1;" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// iterate through all the returned lines and for each do:
		try {
			while ( rs.next() ) {
				int id = rs.getInt("id"); //parse an integer from field “id”
//				String name = rs.getString("name"); //parse string from field “name”
//				String abbr = rs.getString("ABBR");
//				System.out.println( "ID = " + id +"\t CODE = " + abbr+"\t Country = " +
//						name);
				if (kodaVieta.getText().matches(rs.getString("lockercode"))) {
					pareizais_kods = rs.getString("lockercode");
					System.out.println(pareizais_kods);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sanemt2(ActionEvent event) throws IOException {
		//String pareizais_kods = "0990";
		if (kodaVieta.getText().matches(pareizais_kods)) {
		changeScene(pogaTurpinat, "/application/Sanemsana2.fxml");
		}
		else {
			label1.setText("Kļūda! Ievadi saņemšanas kodu");
			System.out.println("Kļūda");
		}
	}
	
	public void atpakal(MouseEvent event) throws IOException {
		changeScene(poga0, "/application/MenuScene.fxml");
	}
}
