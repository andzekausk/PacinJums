package model;

public class ParcelMachine {
	private String pm_ID;
	private static long counter;
	private ParcelMachineLocation parcelMachineLocation;
	private String address;
	private static ArrayList<Locker> allSLockers = new ArrayList<Locker>();
	private static ArrayList<Locker> allMLockers = new ArrayList<Locker>();
	private static ArrayList<Locker> allLLockers = new ArrayList<Locker>();
	
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
	public static ArrayList<Locker> getAllSLockers() {
		return allSLockers;
	}
	public static ArrayList<Locker> getAllMLockers() {
		return allMLockers;
	}
	public static ArrayList<Locker> getAllLLockers() {
		return allLLockers;
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
		if(address !=null && address.matches("[a-zA-Z]+\\s*+,\\s*[a-zA-Z]+\\s*+[0-9]{3}-[0-9]{3}")) {
			this.address = address;
		}
		else {
			this.address = "--- incorrect address ---";
		}
	}
	public static void setAllSLockers(ArrayList<Locker> allSLockers) {
		ParcelMachine.allSLockers = allSLockers;
	}
	public static void setAllMLockers(ArrayList<Locker> allMLockers) {
		ParcelMachine.allMLockers = allMLockers;
	}
	public static void setAllLLockers(ArrayList<Locker> allLLockers) {
		ParcelMachine.allLLockers = allLLockers;
	}
	
	
}
