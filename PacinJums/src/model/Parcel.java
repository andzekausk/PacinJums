package model;
import java.time.LocalDate;
import java.util.Random;

public class Parcel {
	private String parcelID;
	public static long counter = 1;
//	private ParcelMachine parcelMachine;
	private Client sender;
	private Client reciever;
//	private Driver driver;
	private Size size;
	private boolean isPaid;
//	private boolean recievedHome;
	private ParcelStatus status;
	private boolean isPlacedBySender;
//	private boolean isReturnable;
	Random mansRandoms = new Random();
	
	//getters
	public String getParcelID() {
		return parcelID;
	}
//	public ParcelMachine getparcelMachine() {
//		return parcelMachine;
//	}
	public Client getsender() {
		return sender;
	}
	public Client getreciever() {
		return reciever;
	}
//	public Driver getdriver() {
//		return driver;
//	}
	public Size getSize() {
		return size;
	}
	public boolean getisPaid() {
		return isPaid;
	}
//	public boolean getrecievedHome() {
//		return recievedHome;
//	}
	public ParcelStatus getStatus() {
		return status;
	}
	public boolean getisPlacedBySender() {
		return isPlacedBySender;
	}
//	public boolean getisReturnable() {
//		return isReturnable;
//	}
//	public String getReturnCode() {
//		return returnCode;
//	}
	
	//setters
	public void setParcelID() { //veido ID kā String
		parcelID = "ID-" + LocalDate.now()+"_"+counter;
		counter++;
	}
//	public void setParcelMachine(ParcelMachine parcelMachine) { //pārbauda tikai vai nav null
//		if(parcelMachine != null) {
//			this.parcelMachine = parcelMachine;
//		}
//		else {
//			this.parcelMachine = new ParcelMachine();
//		}
//	}
	public void setSender(Client sender) { //pārbauda tikai vai nav null
		if(sender !=null) {
			this.sender = sender;
		}
		else {
			this.sender = new Client();
		}
	}
	public void setReciever(Client reciever) { //pārbauda tikai vai nav null
		if(reciever !=null) {
			this.reciever = reciever;			
		}
		else {
			this.reciever = new Client();
		}
	}
//	public void setDriver(Driver driver) { //pārbauda tikai vai nav null
//		if(driver !=null) {
//		this.driver = driver;
//			}
//		else {
//			this.driver = new Driver();
//			}
//		}
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
//	public void setRecievedHome(boolean recievedHome) { //nevajag pārbaudi
//		this.recievedHome = recievedHome;
//	}
	public void setStatus(ParcelStatus status) {
		if(status !=null) {
			this.status = status;
		}
		else {
			this.status = ParcelStatus.Lost;
		}
	}
	public void setPlacedBySender(boolean isPlacedBySender) { //nevajag pārbaudi
		this.isPlacedBySender = isPlacedBySender;
	}
//	public void setReturnable(boolean isReturnable) { //nevajag pārbaudi
//		this.isReturnable = isReturnable;
//	}
//	public void setReturnCode() {
//		boolean isFound = false;
//		do {
//			isFound = false;
//			String returnCode = "" + mansRandoms.nextLong(100000,1000000);
//			for (String tempCode: ActiveReturnCodes) {
//				if(tempCode.equals(returnCode)) {
//					isFound = true;
//				}
//			}
//		} while (isFound == true);
//	}
	
	//konstruktori
	
	public Parcel() {
		setParcelID();
//		setParcelMachine(null);
		setSender(null);
		setReciever(null);
//		setDriver(null);
		setSize(Size.S);
		setIsPaid(false);
//		setRecievedHome(false);
		setStatus(ParcelStatus.Lost);
		setPlacedBySender(false);
//		setReturnable(false);
//		setReturnCode();
	}
	
	public Parcel(/*ParcelMachine parcelMachine,*/ Client sender, Client reciever, /*Driver driver,*/ Size size, boolean isPaid,
			/*boolean recievedHome,*/ ParcelStatus status, boolean isPlacedBySender/*, boolean isReturnable, String returnCode*/) {
		setParcelID();
//		setParcelMachine(parcelMachine);
		setSender(sender);
		setReciever(reciever);
//		setDriver(driver);
		setSize(size);
		setIsPaid(isPaid);
//		setRecievedHome(recievedHome);
		setStatus(status);
		setPlacedBySender(isPlacedBySender);
//		setReturnable(isReturnable);
//		setReturnCode();
	}
	
	//toString
	public String toString() {
		return "\nParcel ID: " + getParcelID() + /*"| parcelMachine ID: " + parcelMachine.getPm_ID() +*/ "| sender ID: " + sender.getClientID() + "| reciever ID"
				+ " " + reciever.getClientID() /*+ "| Driver: " + driver*/ + "| Size: " + getSize() + "| isPaid?: "
	+ getisPaid() + /*"| recievedHome?: " + getrecievedHome() +*/ "| Status: " + getStatus() + "| isPlacedBySender?: " + getisPlacedBySender()/* +
	"| isReturnable?: " + isReturnable + "| ReturnCode: " + returnCode + "|||"*/;
	}
	
}
