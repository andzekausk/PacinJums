package model;

import java.util.ArrayList;

public class ParcelMachine {
	private String pm_ID;
	private static long counter;
	private ParcelMachineLocation parcelMachineLocation;
	private String address;
	private ArrayList<Locker> allLockers = new ArrayList<Locker>();
	private int sSlotAmount, mSlotAmount, lSlotAmount;
	
	//getters
	public String getPm_ID() {
		return pm_ID;
	}
	public ParcelMachineLocation getParcelMachineLocation() {
		return parcelMachineLocation;
	}
	public String getAddress() {
		return address;
	}
	public ArrayList<Locker> getAllLockers() {
		return allLockers;
	}
	

	public int getsSlotAmount() {
		return sSlotAmount;
	}
	public void setsSlotAmount(int sSlotAmount) {
		this.sSlotAmount = sSlotAmount;
	}
	public int getmSlotAmount() {
		return mSlotAmount;
	}
	public void setmSlotAmount(int mSlotAmount) {
		this.mSlotAmount = mSlotAmount;
	}
	public int getlSlotAmount() {
		return lSlotAmount;
	}
	public void setlSlotAmount(int lSlotAmount) {
		this.lSlotAmount = lSlotAmount;
	}
	public void setPm_ID(String pm_ID) {
		this.pm_ID = pm_ID;
	}
	//setters
	public void setParcelMachineLocation(ParcelMachineLocation parcelMachineLocation) {
		this.parcelMachineLocation = parcelMachineLocation;
	}
	public void setPm_ID() {
		pm_ID = ""+  ParcelMachineLocation.class.getName().charAt(0) + ParcelMachineLocation.class.getName().charAt(1) +
				ParcelMachineLocation.class.getName().charAt(3) + "00" + counter;
		counter++;
	}
	public void setAddress(String address) {
		if(address !=null && address.matches("^[ a-zA-Z]+[0-9a-z]{1,5}[- ]{1}[0-9a-zA-Z]{0,5}$")) {
			this.address = address;
		}
		else {
			this.address = "--- incorrect address ---";
		}
	}
	public void setAllLockers(ArrayList<Locker> allLockers) {
		this.allLockers = allLockers;
	}
	
	
}
