package model;

import java.util.ArrayList;
import java.util.Random;

public class ParcelMachine {
	private String pm_ID;
	private int sSlotAmount, mSlotAmount, lSlotAmount;
	private static int counter = 1;
	private ParcelMachineLocation parcelMachineLocation;
	private String address;
	private ArrayList<Locker> allLockers = new ArrayList<Locker>();

	// getters
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

	public int getmSlotAmount() {
		return mSlotAmount;
	}

	public int getlSlotAmount() {
		return lSlotAmount;
	}

	// setters
	public void setPm_ID() {
		
		pm_ID = "" + parcelMachineLocation.name().substring(0, 5).toUpperCase() + "_" + String.format("%03d", counter);
		counter++;
	}

	public void setParcelMachineLocation(ParcelMachineLocation parcelMachineLocation) {
		this.parcelMachineLocation = parcelMachineLocation;
	}

	public void setAddress(String address) {
		if (address != null && address.matches("^[ a-zA-Z]+[0-9a-z]{1,5}[- ]{1}[0-9a-zA-Z]{0,5}$")) {
			this.address = address;
		} else {
			this.address = "--- incorrect address ---";
		}
	}

	public void setAllLockers() {
		int counter = 1;
		for (int i = 0; i < this.sSlotAmount; i++) {
			this.allLockers.add(new Locker(counter, Size.S, null, -1));
			counter++;
		}
		for (int i = 0; i < this.mSlotAmount; i++) {
			this.allLockers.add(new Locker(counter, Size.M, null, -1));
			counter++;
		}
		for (int i = 0; i < this.lSlotAmount; i++) {
			this.allLockers.add(new Locker(counter, Size.L, null, -1));
			counter++;
		}
	}

	public void setsSlotAmount(int sSlotAmount) {
		if (sSlotAmount > 0)
			this.sSlotAmount = sSlotAmount;
		else
			this.sSlotAmount = 0;
	}

	public void setmSlotAmount(int mSlotAmount) {
		if (mSlotAmount > 0)
			this.mSlotAmount = mSlotAmount;
		else
			this.mSlotAmount = 0;
	}

	public void setlSlotAmount(int lSlotAmount) {
		if (lSlotAmount > 0)
			this.lSlotAmount = lSlotAmount;
		else
			this.lSlotAmount = 0;
	}

	public ParcelMachine() {
		setParcelMachineLocation(ParcelMachineLocation.Centrs);
		setAddress(null);
		setsSlotAmount(0);
		setmSlotAmount(0);
		setlSlotAmount(0);
		setAllLockers();
		setPm_ID();
	}

	public ParcelMachine(ParcelMachineLocation parcelMachineLocation, String address, int sSlotAmount, int mSlotAmount,
			int lSlotAmount) {
		setParcelMachineLocation(parcelMachineLocation);
		setAddress(address);
		setsSlotAmount(sSlotAmount);
		setmSlotAmount(mSlotAmount);
		setlSlotAmount(lSlotAmount);
		setAllLockers();
		setPm_ID();
	}

	@Override
	public String toString() {
		return "\nParcel Machine ID:" + getPm_ID() + ", Parcel Machine Location: " + getParcelMachineLocation()
				+ ", Address: " + getAddress() + ", s slot amount: " + getsSlotAmount() + ", m slot amount: "
				+ getmSlotAmount() + ", l slot amount: " + getlSlotAmount() + ", All Lockers: " + getAllLockers();
	}

	public long generateUnlockCode() {
		long unlockCode;
		Random rand = new Random();
		boolean repeated;
		do {
			repeated = false;
			unlockCode = rand.nextLong(100000, 1000000);
			for (Locker tempLock : getAllLockers()) {
				if (unlockCode == tempLock.getUnlockCode()) {
					repeated = true;
					break;
				}
			}
		} while (repeated);
		return unlockCode;
	}
	
	public ArrayList<Locker> getEmptyLockers(){
		ArrayList<Locker> emptyLockers = new ArrayList<Locker>();
		for(Locker tempLock : getAllLockers()) {
			if (tempLock.isEmpty()) {
				emptyLockers.add(tempLock);
			}
		}
		return emptyLockers;
	}
	
	public void placeParcel(Parcel parcel) {
		if(getLockersBySize(parcel.getSize(), getEmptyLockers())!=null) {
			//getEmptyLockers().get(0).setUnlockCode(generateUnlockCode());
			//getEmptyLockers().get(0).setParcel(parcel);
			getLockersBySize(parcel.getSize(), getEmptyLockers()).get(0).setUnlockCode(generateUnlockCode());
			getLockersBySize(parcel.getSize(), getEmptyLockers()).get(0).setParcel(parcel);
		}
	}
	public ArrayList<Locker> getLockersBySize(Size size, ArrayList<Locker> lockerList){
		ArrayList<Locker> lockersBySize = new ArrayList<Locker>();
		for(Locker tempLock : lockerList) {
			if(tempLock.getSize()==size) {
				lockersBySize.add(tempLock);
			}
		}
		return lockersBySize;
	}
}
