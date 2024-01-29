package model;

public class Client extends Person{

//	private  int senderID ;
//	private static int SenderCounter = 1;
//	private static String senderAddress;
//	private  int recieverID;
//	private static int RecieverCounter = 1;
//	private static String recieverAddress;
//	
//	public void setSenderID() {
//		senderID = SenderCounter;
//		SenderCounter++;
//
//	}
//	public int getSenderID() {
//		return senderID;
//	}
//	
//	public static void setSenderAddress(String inputSenderAddress) {
//		if(inputSenderAddress != null && inputSenderAddress.length() > 3 && inputSenderAddress.matches("[A-Za-z]{1,20}\s[A-Za-z]{1,20}\s[0-9]{1,4}"))
//		senderAddress = inputSenderAddress;
//		else {
//			senderAddress = "Saņēmēja adrese";
//		}
//	}
//	public static String getSenderAddress() {
//		return senderAddress;
//	}
//	
//	public void setRecieverID() {
//		recieverID = RecieverCounter;
//		RecieverCounter++;
//	}
//	public int getRecieverID() {
//		return recieverID;
//		
//	}
//	
//	public static void setRecieverAddress(String inputRecieverAddress) {
//		if(inputRecieverAddress != null && inputRecieverAddress.length() > 3 && inputRecieverAddress.matches("[A-Za-z]{1,20}\s[A-Za-z]{1,20}\s[0-9]{1,4}"))
//			recieverAddress = inputRecieverAddress;
//		else {
//			recieverAddress = "Sutītāja adrese";
//		}
//		
//	}
//	public static String getRecieverAddress() {
//		return recieverAddress;
//	}
//
//	public Client() {
//		super();
//		setSenderID();
//		setSenderAddress(null);
//		setRecieverID();
//		setRecieverAddress(null);
//	}
//
//	public Client (String name, String surname, String personCode, String phoneNumber, String emailAdress,
//			 String inputSenderAddress, String inputRecieverAddress) {
//		
//		super(name, surname, personCode, phoneNumber, emailAdress);
//		setSenderID();
//		setSenderAddress(inputSenderAddress);
//		setRecieverID();
//		setRecieverAddress(inputRecieverAddress);
//		
//	}
//	
//	public String toString() {
//		return super.toString() + "   |   " + "No adreses:" + senderAddress + " (ID:" + senderID +
//				") Uz adresi: " + recieverAddress + " (ID:" + recieverID + ")";
//	}
	
	private  int clientID ;
	private static int counter = 1;
	private String address;
	
	public void setClientID() {
		clientID = counter;
		counter++;

	}
	public int getClientID() {
		return clientID;
	}
	
	public void setAddress(String inputAddress) {
		if(inputAddress != null && inputAddress.length() > 3 && inputAddress.matches("[A-Za-z]{1,20}\s[A-Za-z]{1,20}\s[0-9]{1,4}"))
		address = inputAddress;
		else {
			address = "Nav adrese";
		}
	}
	
	public String getAddress() {
		return address;
	}
	public Client() {
		super();
		setClientID();
		setAddress(null);
	}

	public Client (String name, String surname, /*String personCode,*/ String phoneNumber, String emailAdress,
			 String inputAddress) {
		
		super(name, surname, /*personCode,*/ phoneNumber, emailAdress);
		setClientID();
		setAddress(inputAddress);		
	}
	
	public String toString() {
		return super.toString() + "   |   " + "Client address:" + address + " (Client ID:" + clientID + ")";
	}
}
