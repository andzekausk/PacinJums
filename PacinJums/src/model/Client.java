package model;

public class Client extends Person{

	private  int senderID ;
	private static int SenderCounter = 1;
	private static String senderAddress;
	private  int recieverID;
	private static int RecieverCounter = 1;
	private static String recieverAddress;
	
	public void setSenderID() {
		senderID = SenderCounter;
		SenderCounter++;

	}
	public int getSenderID() {
		return senderID;
	}
	
	public static void setSenderAddress(String inputSenderAddress) {
		if(senderAddress != null && senderAddress.length() > 3 && senderAddress.matches("^\\s*\\S+(?:\\s+\\S+){2}"))
		senderAddress = inputSenderAddress;
		else {
			senderAddress = "Saņēmēja adrese";
		}
	}
	public static String getSenderAddress() {
		return senderAddress;
	}
	
	public void setRecieverID() {
		recieverID = RecieverCounter;
		RecieverCounter++;
	}
	public int getRecieverID() {
		return recieverID;
		
	}
	
	public static void setRecieverAddress(String inputRecieverAddress) {
		if(recieverAddress != null && recieverAddress.length() > 3 && recieverAddress.matches("^\\s*\\S+(?:\\s+\\S+){2}"))
			recieverAddress = inputRecieverAddress;
		else {
			recieverAddress = "Sutītāja adrese";
		}
		
	}
	public static String getRecieverAddress() {
		return recieverAddress;
	}

	public Client() {
		super();
		setSenderID();
		setSenderAddress(null);
		setRecieverID();
		setRecieverAddress(null);
	}

	public Client (String name, String surname, String personCode, String phoneNumber, String emailAdress,
			 String inputSenderAddress, String inputRecieverAddress) {
		
		super(name, surname, personCode, phoneNumber, emailAdress);
		setSenderID();
		setSenderAddress(inputSenderAddress);
		setRecieverID();
		setRecieverAddress(inputRecieverAddress);
		
	}
	
	public String toString() {
		return super.toString() + "   |   " + "No adreses:" + senderAddress + " (ID:" + senderID +
				") Uz adresi: " + recieverAddress + " (ID:" + recieverID + ")";
	}
}
