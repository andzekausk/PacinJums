package model;

public class Locker {
	private int lockerNumber;
    private Size size;
    private Parcel parcel;
    private boolean isEmpty = true;
    private long unlockCode;
    

	public int getLockerNumber() {
		return lockerNumber;
	}
	public void setLockerNumber(int lockerNumber) {
		if(lockerNumber>0)
			this.lockerNumber = lockerNumber;
		else
			this.lockerNumber = -1;
	}
	
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		if(size!=null)
			this.size = size;
	}
	
	public Parcel getParcel() {
		return parcel;
	}
	public void setParcel(Parcel parcel) {
		if(parcel!=null) {
			this.parcel = parcel;
			setEmpty(false);
		}
		else {
			this.parcel = null;
			setEmpty(true);
		}
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	public long getUnlockCode() {
		return unlockCode;
	}
	public void setUnlockCode(long unlockCode) {
		if(unlockCode>99999 && unlockCode<1000000)
			this.unlockCode = unlockCode;
		else
			this.unlockCode = -1;
	}

    public Locker() {
    	setLockerNumber(-1);
    	setSize(Size.S);
    	setParcel(null);
		setUnlockCode(-1);
    }
	public Locker(int lockerNumber, Size size, Parcel parcel, long unlockCode) {
    	setLockerNumber(lockerNumber);
    	setSize(size);
    	setParcel(parcel);
		setUnlockCode(unlockCode);
	}
	@Override
	public String toString() {
		if (getParcel()==null)
			return "\nLocker number: " + getLockerNumber() + ", Size: " + getSize() + ", Parcel ID: "
					+ getParcel() + ", Empty: " + isEmpty() + ", Unlock Code: " + getUnlockCode();
		else
			return "\nLocker number: " + getLockerNumber() + ", Size: " + getSize() + ", Parcel ID: "
			+ getParcel().getParcelID() + ", Empty: " + isEmpty() + ", Unlock Code: " + getUnlockCode();
	}
	
	
    
}
