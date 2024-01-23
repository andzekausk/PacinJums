package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Client;
import model.Company;
import model.Driver;
import model.Employee;
import model.Parcel;
import model.ParcelMachine;
import model.ParcelMachineLocation;
import model.ParcelStatus;
import model.Size;
import model.Transport;
import model.WorkingRegion;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	static Connection c = null;
	static Statement stmt = null;
	static String sqlCreateCountriesTable = "CREATE TABLE COUNTRIES ( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT NOT NULL, ABBR TEXT NOT NULL, COMMENT varchar(50));";
	static String sqlCreateGamesTable= "CREATE TABLE GAMES ( ID INTEGER PRIMARY KEY AUTOINCREMENT, TEAM1ID INTEGER, TEAM2ID INTEGER, DATETIME VARCHAR(60), SCORE1 INTEGER, SCORE2 INTEGER);";
	static String sqlFillGameTable = "INSERT INTO GAMES (team1ID,team2ID,dateTime,score1,score2) VALUES (3,10,'6 May-Fri 16:15 GMT+3',2,1), (5,1,'6 May-Fri 16:15 GMT+3',1,5), (6,2,'6 May-Fri 20:15 GMT+3',3,0), (4,9,'6 May-Fri 20:15 GMT+3',6,2);";
	static String sqlFillCountriesTable = "INSERT INTO COUNTRIES (NAME, ABBR, COMMENT) VALUES ('Canada', 'CAN', ''), ('Russia', 'RUS', ''), ('Sweden', 'SWE', ''), ('Finland', 'FIN', ''), ('USA', 'USA', ''), ('Czech Republic', 'CZE', ''), ('Switzerland', 'SUI', ''), ('Slovakia', 'SVK', '');";
	
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
		Image icon = new Image("/resources/images/pacinjumslogo.png");
		stage.getIcons().add(icon);
	}
	
	public static void main(String[] args) {
		makeConnection();
//		createTable(sqlCreateCountriesTable);
//		createTable(sqlCreateGamesTable);
//		fillTable(sqlFillCountriesTable);
//		fillTable(sqlFillGameTable);
		getRecordsFromCountries();
		ParcelMachine pm1 = new ParcelMachine(ParcelMachineLocation.Bauska, "wassabi iela 12", 60, 20, 10);
		Client sender1 = new Client("Cils", "Veks", /*"301199-11111",*/ "21234567", "hallo@gmail.com", "Lielais prospekts 20");
		Client reciever1 = new Client("Pers", "Ona", /*"301100-22222",*/ "22345678", "ahoy@gmail.com", "mazais prospekts 20");
//		Parcel parcel1 = new Parcel(pm1, sender1, reciever1, Size.S, true, false, ParcelStatus.Pending, true);
		Parcel parcel1 = new Parcel(sender1, reciever1, Size.S , true, ParcelStatus.Pending, false);
		System.out.println(parcel1);
		System.out.println(pm1);
		pm1.placeParcel(parcel1);
		System.out.println(pm1);
		System.out.println(pm1.getLockersBySize(Size.M, pm1.getAllLockers()));
		
		launch(args);
		endConnection();
	}
	
	public static void makeConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			c = DriverManager.getConnection("jdbc:sqlite:IIHF16.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Opened database successfully");
	}
	
	public static void endConnection() {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Database connection is ended");
	}
	
	public static void createTable(String sql) {
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Table created successfully");
	}
	
	public static void fillTable(String sql) {
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Table filled successfully");
	}
	
	public static void getRecordsFromCountries() {
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// execute select query
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery( "SELECT * FROM COUNTRIES;" );
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
