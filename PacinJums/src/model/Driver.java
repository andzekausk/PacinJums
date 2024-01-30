package model;

public class Driver extends Person{
	
	private int iddriver;
	private String personCode;
	private int idtransport;
	private String workingRegion;
	
	
	public int getIddriver() {
		return iddriver;
	}

	public void setIddriver(int iddriver) {
		if (iddriver > 0)
			this.iddriver = iddriver;
		else
			this.iddriver = -1;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		if (personCode != null && personCode.matches("[0-9]{6}-[0-9]{5}"))
			this.personCode = personCode;
		else
			this.personCode = "INVALID";
	}

	public int getIdtransport() {
		return idtransport;
	}

	public void setIdtransport(int idtransport) {
		if (idtransport > 0)
			this.idtransport = idtransport;
		else
			this.idtransport = -1;
	}

	public String getWorkingRegion() {
		return workingRegion;
	}

	public void setWorkingRegion(String workingRegion) {
		if (workingRegion != null && (workingRegion.matches("Riga") || workingRegion.matches("Kurzeme")
				|| workingRegion.matches("Vidzeme") || workingRegion.matches("Zemgale") || workingRegion.matches("Latgale")))
			this.workingRegion = workingRegion;
	}
	
	public Driver() {
		super();
		setIddriver(0);
		setPersonCode(null);
		setWorkingRegion(null);
		setIdtransport(0);
		}
	
	public Driver(int iddriver, String name, String surname, String personCode,String phoneNumber, String email, String workingRegion, int idtransport) {
		super(name, surname, phoneNumber, email);
		setIddriver(iddriver);
		setPersonCode(personCode);
		setWorkingRegion(workingRegion);
		setIdtransport(idtransport);
		}

	@Override
	public String toString() {
		return "Driver [iddriver=" + iddriver + ", personCode=" + personCode + ", idtransport=" + idtransport
				+ ", workingRegion=" + workingRegion + "]";
	}

	
}
