package model;

import java.time.LocalDate;
import java.util.Random;

public class Parcel {
	private int idparcel;
	private String parcelCode;
	private String size;
	private int isPaid;
	private int isReturnable;
	private int idsender;
	private int idreciever;
	private int iddriver;
	private String collectionDate;
	private String status;

	public int getIdparcel() {
		return idparcel;
	}

	public void setIdparcel(int idparcel) {
		if (idparcel > 0)
			this.idparcel = idparcel;
		else
			this.idparcel = -1;
	}

	public String getParcelCode() {
		return parcelCode;
	}

	public void setParcelCode(String parcelCode) {
		if(parcelCode!=null && parcelCode.matches("[A-Z0-9]{3}-[A-Z0-9]{3}-[A-Z0-9]{3}")) {
			this.parcelCode = parcelCode;	
		}
		else {
			this.parcelCode = "INVALID";
		}
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		if (size != null && (size.matches("S") || size.matches("M") || size.matches("L")))
			this.size = size;
		else
			this.size = "S";
	}

	public int getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(int isPaid) {
		if (isPaid == 1)
			this.isPaid = isPaid;
		else
			this.isPaid = 0;
	}

	public int getIsReturnable() {
		return isReturnable;
	}

	public void setIsReturnable(int isReturnable) {
		if (isReturnable == 1)
			this.isReturnable = isReturnable;
		else
			this.isReturnable = 0;
	}

	public int getIdsender() {
		return idsender;
	}

	public void setIdsender(int idsender) {
		if (idsender > 0)
			this.idsender = idsender;
		else
			this.idsender = -1;
	}

	public int getIdreciever() {
		return idreciever;
	}

	public void setIdreciever(int idreciever) {
		if (idreciever > 0)
			this.idreciever = idreciever;
		else
			this.idreciever = -1;
	}

	public int getIddriver() {
		return iddriver;
	}

	public void setIddriver(int iddriver) {
		if (iddriver > 0)
			this.iddriver = iddriver;
		else
			this.iddriver = -1;
	}

	public String getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(String collectionDate) {
		if (collectionDate != null)
			this.collectionDate = collectionDate;
		else
			this.collectionDate = "0000-00-00";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		if (status != null && (status.matches("pending") || status.matches("delivered") || status.matches("in_transit")
				|| status.matches("pickup_ready") || status.matches("lost")))
			this.status = status;
		else
			this.status = "INVALID";
		
	
	}
	
	public Parcel() {
		setIdparcel(0);
		setParcelCode(null);
		setSize(null);
		setIsPaid(0);
		setIsReturnable(0);
		setIdsender(0);
		setIdreciever(0);
		setIddriver(0);
		setCollectionDate(null);
		setStatus(null);
	}
	public Parcel(int idparcel, String parcelCode, String size, int isPaid, int isReturnable, int idsender,
			int idreciever, int iddriver, String collectionDate, String status) {
		setIdparcel(idparcel);
		setParcelCode(parcelCode);
		setSize(size);
		setIsPaid(isPaid);
		setIsReturnable(isReturnable);
		setIdsender(idsender);
		setIdreciever(idreciever);
		setIddriver(iddriver);
		setCollectionDate(collectionDate);
		setStatus(status);
	}

	@Override
	public String toString() {
		return "Parcel [idparcel=" + idparcel + ", parcelCode=" + parcelCode + ", size=" + size + ", isPaid=" + isPaid
				+ ", isReturnable=" + isReturnable + ", idsender=" + idsender + ", idreciever=" + idreciever
				+ ", iddriver=" + iddriver + ", collectionDate=" + collectionDate + ", status=" + status + "]";
	}
	
	
	
	// getters
//	public String getParcelID() {
//		return parcelID;
//	}
////	public ParcelMachine getparcelMachine() {
////		return parcelMachine;
////	}
//	public Client getsender() {
//		return sender;
//	}
//	public Client getreciever() {
//		return reciever;
//	}
////	public Driver getdriver() {
////		return driver;
////	}
//	public Size getSize() {
//		return size;
//	}
//	public boolean getisPaid() {
//		return isPaid;
//	}
////	public boolean getrecievedHome() {
////		return recievedHome;
////	}
//	public ParcelStatus getStatus() {
//		return status;
//	}
//	public boolean getisPlacedBySender() {
//		return isPlacedBySender;
//	}
////	public boolean getisReturnable() {
////		return isReturnable;
////	}
////	public String getReturnCode() {
////		return returnCode;
////	}
//	
//	//setters
//	public void setParcelID() { //veido ID kā String
//		parcelID = "ID-" + LocalDate.now()+"_"+counter;
//		counter++;
//	}
////	public void setParcelMachine(ParcelMachine parcelMachine) { //pārbauda tikai vai nav null
////		if(parcelMachine != null) {
////			this.parcelMachine = parcelMachine;
////		}
////		else {
////			this.parcelMachine = new ParcelMachine();
////		}
////	}
//	public void setSender(Client sender) { //pārbauda tikai vai nav null
//		if(sender !=null) {
//			this.sender = sender;
//		}
//		else {
//			this.sender = new Client();
//		}
//	}
//	public void setReciever(Client reciever) { //pārbauda tikai vai nav null
//		if(reciever !=null) {
//			this.reciever = reciever;			
//		}
//		else {
//			this.reciever = new Client();
//		}
//	}
////	public void setDriver(Driver driver) { //pārbauda tikai vai nav null
////		if(driver !=null) {
////		this.driver = driver;
////			}
////		else {
////			this.driver = new Driver();
////			}
////		}
//	public void setSize(Size size) {
//		if(size !=null) {
//			this.size = size;
//		}
//		else {
//			this.size = Size.S;
//		}
//	}
//	public void setIsPaid(boolean isPaid) { //nevajag pārbaudi
//		this.isPaid = isPaid;
//	}
////	public void setRecievedHome(boolean recievedHome) { //nevajag pārbaudi
////		this.recievedHome = recievedHome;
////	}
//	public void setStatus(ParcelStatus status) {
//		if(status !=null) {
//			this.status = status;
//		}
//		else {
//			this.status = ParcelStatus.Lost;
//		}
//	}
//	public void setPlacedBySender(boolean isPlacedBySender) { //nevajag pārbaudi
//		this.isPlacedBySender = isPlacedBySender;
//	}
////	public void setReturnable(boolean isReturnable) { //nevajag pārbaudi
////		this.isReturnable = isReturnable;
////	}
////	public void setReturnCode() {
////		boolean isFound = false;
////		do {
////			isFound = false;
////			String returnCode = "" + mansRandoms.nextLong(100000,1000000);
////			for (String tempCode: ActiveReturnCodes) {
////				if(tempCode.equals(returnCode)) {
////					isFound = true;
////				}
////			}
////		} while (isFound == true);
////	}
//	
//	//konstruktori
//	
//	public Parcel() {
//		setParcelID();
////		setParcelMachine(null);
//		setSender(null);
//		setReciever(null);
////		setDriver(null);
//		setSize(Size.S);
//		setIsPaid(false);
////		setRecievedHome(false);
//		setStatus(ParcelStatus.Lost);
//		setPlacedBySender(false);
////		setReturnable(false);
////		setReturnCode();
//	}
//	
//	public Parcel(/*ParcelMachine parcelMachine,*/ Client sender, Client reciever, /*Driver driver,*/ Size size, boolean isPaid,
//			/*boolean recievedHome,*/ ParcelStatus status, boolean isPlacedBySender/*, boolean isReturnable, String returnCode*/) {
//		setParcelID();
////		setParcelMachine(parcelMachine);
//		setSender(sender);
//		setReciever(reciever);
////		setDriver(driver);
//		setSize(size);
//		setIsPaid(isPaid);
////		setRecievedHome(recievedHome);
//		setStatus(status);
//		setPlacedBySender(isPlacedBySender);
////		setReturnable(isReturnable);
////		setReturnCode();
//	}
//	
//	//toString
//	public String toString() {
//		return "\nParcel ID: " + getParcelID() + /*"| parcelMachine ID: " + parcelMachine.getPm_ID() +*/ "| sender ID: " + sender.getClientID() + "| reciever ID"
//				+ " " + reciever.getClientID() /*+ "| Driver: " + driver*/ + "| Size: " + getSize() + "| isPaid?: "
//	+ getisPaid() + /*"| recievedHome?: " + getrecievedHome() +*/ "| Status: " + getStatus() + "| isPlacedBySender?: " + getisPlacedBySender()/* +
//	"| isReturnable?: " + isReturnable + "| ReturnCode: " + returnCode + "|||"*/;
//	}

}
