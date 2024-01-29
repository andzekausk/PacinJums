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
import java.sql.PreparedStatement;
import java.sql.Connection;

public class Sanemsana1Controller extends Controller{
	@FXML
	private Button poga1, poga2, poga3, poga4, poga5, poga6, poga7, poga8, poga9, poga0, pogaDzest, pogaDzestVisu, pogaTurpinat, pogaAtpakal;
	
	@FXML
	private TextField kodaVieta = new TextField("paciņas koda numurs");
	
	@FXML
	private javafx.scene.control.Label label1;
	
	String pareizais_kods;
	
	
	public void izslegtIevadi() throws IOException {
		kodaVieta.setEditable(false);
	}
	
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

	public static String searchLockerByCode(String value) {
		makeConnection();
		try {
		stmt = c.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		//ResultSet rs = null;
		try {
			String query = "SELECT * FROM locker WHERE lockercode = ?";
			//rs = stmt.executeQuery( "SELECT * FROM LOCKER WHERE" + lockerCode + " = ?" );
			try (PreparedStatement statement = c.prepareStatement(query)) {
				statement.setString(1, value);
				try (ResultSet resultset = statement.executeQuery()) {
//					 StringBuilder resultStringBuilder = new StringBuilder();
//					 resultStringBuilder.append(resultset.getString("lockercode"));
//					 return resultStringBuilder.toString();
					return resultset.getString("lockercode");
				}
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

    }
	
//	public static void deleteLockerByCode(String value) {
//	    makeConnection();
//	    try {
//	        String query = "DELETE FROM locker WHERE lockercode = ?";
//	        try (PreparedStatement statement = c.prepareStatement(query)) {
//	            statement.setString(1, value);
//	            statement.executeUpdate();
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	}
	
	public void updateLockerCode(String oldValue, String newValue) {
	    makeConnection();
	    try {
	        String query = "UPDATE locker SET lockercode = ? WHERE lockercode = ?";
	        try (PreparedStatement statement = c.prepareStatement(query)) {
	            statement.setString(1, newValue);
	            statement.setString(2, oldValue);
	            statement.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	}
	
	public void sanemt2(ActionEvent event) throws IOException {
		pareizais_kods = searchLockerByCode(kodaVieta.getText());
		if (pareizais_kods !=null) {
			System.out.println(pareizais_kods);
		changeScene(pogaTurpinat, "/application/Sanemsana2.fxml");
		updateLockerCode(kodaVieta.getText(), "-1");
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
