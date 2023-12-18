package model;

public class Driver extends Employee{
	
	private Transport transport;
	private WorkingRegion workingRegion;
	
	public void setTransport (Transport inputTransport) {
		if(inputTransport != null) {
			transport = inputTransport;
		}else {
			transport = Transport.TY_9142;
		}
	}
	
	public void setWorkingRegion(WorkingRegion inputWorkingRegion) {
		if(inputWorkingRegion != null) {
			workingRegion = inputWorkingRegion;
		}else {
			workingRegion = WorkingRegion.Kurzeme;
		}
	}
	
	public Driver() {
		super();
		setID();
		setTransport(null);
		setWorkingRegion(null);
	}
	
	public Driver (String name, String surname, String personCode, String phoneNumber, String emailAdress
			,Transport inputTransport, WorkingRegion inputWorkingRegion) {
		super(name, surname, personCode, phoneNumber, emailAdress);
		setID();
		setTransport(inputTransport);
		setWorkingRegion(inputWorkingRegion);
	}

	public String toString () {
		//ID: super() | Transport: , Working Region: .
		String result = super.toString() + "   |   Transports: " + transport + "  |   Apkalpojamais Regions: "
				+ workingRegion;
		return result;
	}
}
