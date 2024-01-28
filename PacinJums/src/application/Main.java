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
	static String sqlCreateTransport = "CREATE TABLE `TRANSPORT` (\r\n"
			+ "	`idtransport` INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
			+ "	`numberplate` VARCHAR(7) NOT NULL\r\n"
			+ ");";
	static String sqlFillTransport = "INSERT INTO 'TRANSPORT'('numberplate') values ('NG-2955'),('GJ-2324'),('AK-8008'),('AM-1994'),('AL-7684'),('KK-4991'),('TI-9142'),('HM-6078')";
	static String sqlCreateDriver = "CREATE TABLE DRIVER ("
			+"iddriver INTEGER PRIMARY KEY AUTOINCREMENT,"
			+"name TEXT NOT NULL,"
			+"surname TEXT NOT NULL,"
			+"personcode TEXT NOT NULL,"
			+"email TEXT NOT NULL,"
			+"workingregion TEXT NOT NULL,"
			+"idtransport INTEGER,"
			+"FOREIGN KEY(idtransport) REFERENCES TRANSPORT(idtransport)"
			+ ");";
	static String sqlFillDriver = "INSERT INTO DRIVER (name, surname, personcode, email, workingregion, idtransport, phonenumber) values \r\n"
			+"('Eduards','Aivars','010171-11511','Ed.Aivars@gmail.com','Riga',1,'+37121234567'), ('Imants','Auziņš','020298-12345','imantsauzins@inbox.lv','Kurzeme',2,'+37122345678'),\r\n"
			+"('Juris','Alunāns','030386-54321','jurish@oto.lv','Vidzeme',3,'+37127654321'),('Rihards','Bargais','040488-23456','bargais@yahoo.com','Zemgale',4,'+37127126354'), \r\n"
			+"('Pēteris','Draguns','050577-99999','dragon@gmail.com','Latgale',5,'+37128273645'),('Andrejs','Eglītis','060600-11111','andr.egl@inbox.lv','Riga',6, '+37129876543'), \r\n"
			+"('Guntars','Godiņš','070797-22222','gunt.god@gmail.com','Kurzeme',7,'+37128765432'),('Harijs','Heislers','080878-33333','harijsheislers@inbox.lv','Vidzeme',8,'+37129876543');";
	
	static String sqlCreatePakomati = "CREATE TABLE PARCELMACHINE ("
			+ "idparcelmachine INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "address TEXT NOT NULL,"
			+ "workingregion TEXT NOT NULL);";
	
	static String sqlFillPakomati = "INSERT INTO PARCELMACHINE (address, workingregion) values('Baložu iela 69', 'Vidzeme'),('Sanatorijas Iela 7', 'Zemgale'),('Ģenerāļa Bulvāris 70', 'Latgale'), ('Ventspils Iela 45','Riga')";
	
	static String sqlCreateSkapisi = "CREATE TABLE LOCKER ("
			+ "idlocker INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "lockernumber INTEGER NOT NULL,"
			+ "size TEXT NOT NULL,"
			+ "lockercode INTEGER NOT NULL,"
			+ "idparcel INTEGER REFERENCES PARCEL(idparcel),"
			+ "idparcelmachine INTEGER NOT NULL REFERENCES PARCELMACHINE(idparcelmachine),"
			+ "placeddate TEXT"
			+ ");"; // TODO: JAPABEIDZ
	
	static String sqlCreateCompany = "CREATE TABLE COMPANY ("
			+ "idcompany INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "companyname TEXT NOT NULL,"
			+ "pvnnumber TEXT NOT NULL,"
			+ "companyaddress TEXT NOT NULL);";
	
	static String sqlFillCompany = "INSERT INTO COMPANY(companyname, pvnnumber, companyaddress) values"
			+ "('SMS Credit', 'LV00123456543', 'Nabagu Iela 45-3'),"
			+ "('SIA Malmar', 'LV00112255331', 'Kuldigas Iela 128'),"
			+ "('SIA Celtnieks','LV00982374123','Jaunais Bulvaris 40');";

	static String sqlCreateClient = "CREATE TABLE CLIENT ("
			+ "idclient INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "name TEXT NOT NULL,"
			+ "surname TEXT NOT NULL,"
			+ "clienttype TEXT NOT NULL,"
			+ "phonenumber TEXT NOT NULL,"
			+ "email TEXT NOT NULL,"
			+ "address TEXT NOT NULL,"
			+ "idcompany INTEGER,"
			+ "FOREIGN KEY(idcompany) REFERENCES COMPANY(idcompany)"
			+ ");";
	
	static String sqlFillClient = "INSERT INTO CLIENT(name, surname, clienttype, phonenumber, email, address, idcompany) values"
			+ "('Janis','Ozols','sender','+37128282828','J.Ozo@inbox.lv','Pardaugavas Iela 66',1),"
			+ "('Kaspars','Daugavins','reciever','+37121398563','Daugava@gmail.com','Ventspils Iela 3',null),"
			+ "('Kristaps','Laipnais','sender','+37121398563','krishux@gmail.com','Roku Iela 51',2),"
			+ "('Irina','Ivanova','reciever','+37122558899','IRinA@one.lv','Lidotaju Iela 5',null);";
	
	static String sqlCreateParcel = "CREATE TABLE PARCEL ("
			+ "idparcel INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "parcelcode TEXT NOT NULL,"
			+ "size TEXT NOT NULL,"
			+ "ispaid INTEGER NOT NULL,"
			+ "isreturnable INTEGER NOT NULL,"
			+ "idsender INTEGER NOT NULL REFERENCES CLIENT(idclient),"
			+ "idreciever INTEGER NOT NULL REFERENCES CLIENT(idclient),"
			+ "iddriver INTEGER REFERENCES DRIVER(iddriver)  ON DELETE SET NULL,"
			+ "collectiondate TEXT"
			+ ");";
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
//		executeSqlScript(sqlCreateSkapisi);
//		executeSqlScript("DROP TABLE CLIENT");
//		executeSqlScript(sqlCreateClient);
//		executeSqlScript(sqlCreateCompany);
//		executeSqlScript(sqlFillClient);
//		String size = "S";
//		for(int i = 1;i<=5;i++) {
//			for(int j=1;j<=60;j++) {
//				if(j<=30) size = "S";
//				else if(j>=31 && j<=50) size = "M";
//				else if(j>=51 && j<=60) size = "L";
//				executeSqlScript("INSERT INTO LOCKER(lockernumber, size, lockercode, idparcel, idparcelmachine, placeddate) values"
//						+ "("+j+",'"+size+"',-1,null,"+i+",null)"
//						+ ";");
//			}
//		}

		
		ParcelMachine pm1 = new ParcelMachine(ParcelMachineLocation.Bauska, "wassabi iela 12", 60, 20, 10);
		Client sender1 = new Client("Cils", "Veks", /*"301199-11111",*/ "21234567", "hallo@gmail.com", "Lielais prospekts 20");
		Client reciever1 = new Client("Pers", "Ona", /*"301100-22222",*/ "22345678", "ahoy@gmail.com", "mazais prospekts 20");
//		Parcel parcel1 = new Parcel(pm1, sender1, reciever1, Size.S, true, false, ParcelStatus.Pending, true);
		Parcel parcel1 = new Parcel(sender1, reciever1, Size.S , true, ParcelStatus.Pending, false);
//		System.out.println(parcel1);
//		System.out.println(pm1);
		pm1.placeParcel(parcel1);
//		System.out.println(pm1);
//		System.out.println(pm1.getLockersBySize(Size.M, pm1.getAllLockers()));
		
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
			c = DriverManager.getConnection("jdbc:sqlite:pacinjums.db");
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
	
	public static void executeSqlScript(String sql) {
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
		System.out.println("SQL script executed");
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
