package model;
import java.time.LocalDateTime;

public class Parcel {
	private String parcel_ID;
	public static long counter;
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
	public void setParcel_ID() {
		parcel_ID = " " + LocalDateTime.now()+counter;
		counter++;
	}
	public void setParcelMachine(ParcelMachine parcelMachine) {
		if(parcelMachine != null) {
			this.parcelMachine = parcelMachine;
		}
		else {
			this.parcelMachine = new ParcelMachine();
		}
	}
	public void setSender(Client sender) {
		if(sender !=null) {
			this.sender = sender;
		}
		else {
			this.sender = new Sender();
		}
	}
	public void setReciever(Client reciever) {
		if(reciever !=null) {
			this.reciever = reciever;			
		}
		else {
			this.reciever = new Reciever();
		}
	}
	public void setDriver(Driver driver) {
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
	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public void setRecievedHome(boolean recievedHome) {
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
	public void setPlacedBySender(boolean isPlacedBySender) {
		this.isPlacedBySender = isPlacedBySender;
	}
	public void setReturnable(boolean isReturnable) {
		this.isReturnable = isReturnable;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	
	//konstruktori
	
	public Parcel() {
		setParcel_ID();
		setParcelMachine();
		setSender();
		setReciever();
		setDriver();
		setSize();
		setIsPaid(false);
		setRecievedHome(false);
		setStatus();
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
