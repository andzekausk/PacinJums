package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Parcel {
	private String parcel_ID;
	public static long counter = 1;
	private ParcelMachine parcelMachine;
	private Client sender;
	private Client reciever;
	private Driver driver;
	private Size size;
	private boolean isPaid;
	private boolean recievedHome;
	private Status status;
	private boolean isPlacedBySender;
	private boolean isReturnable;
	private String returnCode;
	private static ArrayList<String> ActiveReturnCodes = new ArrayList<String>();
	Random mansRandoms = new Random();
	
	//getters
	public String getParcel_ID() {
		return parcel_ID;
	}
	public ParcelMachine getparcelMachine() {
		return parcelMachine;
	}
	public Client getsender() {
		return sender;
	}
	public Client getreciever() {
		return reciever;
	}
	public Driver getdriver() {
		return driver;
	}
	public Size getSize() {
		return size;
	}
	public boolean getisPaid() {
		return isPaid;
	}
	public boolean getrecievedHome() {
		return recievedHome;
	}
	public Status getStatus() {
		return status;
	}
	public String getparcel_ID() {
		return parcel_ID;
	}
	public boolean getisPlacedBySender() {
		return isPlacedBySender;
	}
	public boolean getisReturnable() {
		return isReturnable;
	}
	public String getReturnCode() {
		return returnCode;
	}
	
	//setters
	public void setParcel_ID() { //veido ID kā String
		parcel_ID = "ID-" + LocalDate.now()+"_"+counter;
		counter++;
	}
	public void setParcelMachine(ParcelMachine parcelMachine) { //pārbauda tikai vai nav null
		if(parcelMachine != null) {
			this.parcelMachine = parcelMachine;
		}
		else {
			this.parcelMachine = new ParcelMachine();
		}
	}
	public void setSender(Client sender) { //pārbauda tikai vai nav null
		if(sender !=null) {
			this.sender = sender;
		}
		else {
			this.sender = new Sender();
		}
	}
	public void setReciever(Client reciever) { //pārbauda tikai vai nav null
		if(reciever !=null) {
			this.reciever = reciever;			
		}
		else {
			this.reciever = new Reciever();
		}
	}
	public void setDriver(Driver driver) { //pārbauda tikai vai nav null
		if(driver !=null) {
		this.driver = driver;
			}
		else {
			this.driver = new Driver();
			}
		}
	public void setSize(Size size) {
		if(size !=null) {
			this.size = size;
		}
		else {
			this.size = Size.S;
		}
	}
	public void setIsPaid(boolean isPaid) { //nevajag pārbaudi
		this.isPaid = isPaid;
	}
	public void setRecievedHome(boolean recievedHome) { //nevajag pārbaudi
		this.recievedHome = recievedHome;
	}
	public void setStatus(Status status) {
		if(status !=null) {
			this.status = status;
		}
		else {
			this.status = Status.Lost;
		}
	}
	public void setPlacedBySender(boolean isPlacedBySender) { //nevajag pārbaudi
		this.isPlacedBySender = isPlacedBySender;
	}
	public void setReturnable(boolean isReturnable) { //nevajag pārbaudi
		this.isReturnable = isReturnable;
	}
	public void setReturnCode() {
		boolean isFound = false;
		do {
			isFound = false;
			String returnCode = "" + mansRandoms.nextLong(100000,1000000);
			for (String tempCode: ActiveReturnCodes) {
				if(tempCode.equals(returnCode)) {
					isFound = true;
				}
			}
		} while (isFound == true);
	}
	
	//konstruktori
	
	public Parcel() {
		setParcel_ID();
		setParcelMachine();
		setSender();
		setReciever();
		setDriver();
		setSize(Size.S);
		setIsPaid(false);
		setRecievedHome(false);
		setStatus(Status.Lost);
		setPlacedBySender(false);
		setReturnable(false);
		setReturnCode();
	}
	
	public Parcel(ParcelMachine parcelMachine, Client sender, Client reciever, Driver driver, Size size, boolean isPaid,
			boolean recievedHome, Status status, boolean isPlacedBySender, boolean isReturnable, String returnCode) {
		setParcel_ID();
		setParcelMachine(parcelMachine);
		setSender(sender);
		setReciever(reciever);
		setDriver(driver);
		setSize(size);
		setIsPaid(isPaid);
		setRecievedHome(recievedHome);
		setStatus(status);
		setPlacedBySender(isPlacedBySender);
		setReturnable(isReturnable);
		setReturnCode(returnCode);
	}
	
	//toString
	public String toString() {
		String result = "Parcel ID: " + parcel_ID + "| parcelMachine: " + parcelMachine + "| sender: " + sender + "| reciever"
				+ " " + reciever + "| Driver: " + driver + "| Size: " + size + "| isPaid?: "
	+ isPaid + "| recievedHome?: " + recievedHome + "| Status: " + status + "| isPlacedBySender?: " + isPlacedBySender +
	"| isReturnable?: " + isReturnable + "| ReturnCode: " + returnCode + "|||";
	}
	
}
