package model;

abstract class Parcel{
	
}

public class Locker {
	private int lockerID;
    public static int counter = 1;
    private Size size;
    private Parcel parcel;
    private int parcelCode;
    
    
	public int getLockerID() {
		return lockerID;
	}
	public void setLockerID() {
		this.lockerID = counter;
		counter++;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Parcel getParcel() {
		return parcel;
	}
	public void setParcel(Parcel parcel) {
		this.parcel = parcel;
	}
	public int getParcelCode() {
		return parcelCode;
	}
	public void setParcelCode(int parcelCode) {
		this.parcelCode = parcelCode;
	}

    
}
