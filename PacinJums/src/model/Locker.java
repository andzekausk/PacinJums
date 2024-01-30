package model;

public class Locker {
	private int idlocker;
	private int lockerNumber;
    private String size;
    private long lockerCode;
    private int idparcelmachine;
    private int idparcel;
    private String placedDate;
	

	public int getIdlocker() {
		return idlocker;
	}
	public void setIdlocker(int idlocker) {
		if(idlocker>0)
			this.idlocker = idlocker;
		else
			this.idlocker = -1;
	}
	
	public int getLockerNumber() {
		return lockerNumber;
	}
	public void setLockerNumber(int lockerNumber) {
		if(lockerNumber>0)
			this.lockerNumber = lockerNumber;
		else
			this.lockerNumber = -1;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		if(size!=null &&(size.matches("S") || size.matches("M") || size.matches("L")))
			this.size = size;
		else
			this.size = "S";
	}
	
	public int getIdparcel() {
		return idparcel;
	}
	
	public void setIdparcel(int idparcel) {
		if(idparcel>0)
			this.idparcel = idparcel;
		else
			this.idparcel = -1;
		
	}

	public int getIdparcelmachine() {
		return idparcelmachine;
	}
	public void setIdparcelmachine(int idparcelmachine) {
		if(idparcelmachine>0)
			this.idparcelmachine = idparcelmachine;
		else
			this.idparcelmachine = -1;
	}
	public long getLockerCode() {
		return lockerCode;
	}
	public void setLockerCode(long lockerCode) {
		if(lockerCode>99999 && lockerCode<1000000)
			this.lockerCode = lockerCode;
		else
			this.lockerCode = -1;
	}

	public String getPlacedDate() {
		return placedDate;
	}
	public void setPlacedDate(String placedDate) {
		if(placedDate!=null)
			this.placedDate = placedDate;
		else
			this.placedDate = "0000-00-00";
	}
	public Locker() {
		setIdlocker(0);
		setLockerNumber(0);
		setSize(null);
		setLockerCode(0);
		setIdparcelmachine(0);
		setIdparcel(0);
		setPlacedDate(null);
	}
	
	public Locker(int idlocker, int lockerNumber, String size, long lockerCode, int idparcelmachine, int idparcel, String placedDate) {
		setIdlocker(idlocker);
		setLockerNumber(lockerNumber);
		setSize(size);
		setLockerCode(lockerCode);
		setIdparcelmachine(idparcelmachine);
		setIdparcel(idparcel);
		setPlacedDate(placedDate);
	}
	@Override
	public String toString() {
		return "Locker [idlocker=" + idlocker + ", lockerNumber=" + lockerNumber + ", size=" + size + ", lockerCode="
				+ lockerCode + ", idparcelmachine=" + idparcelmachine + ", idparcel=" + idparcel + ", placedDate="
				+ placedDate + "]";
	}
	

	
	
    
}
