package model;

public class Company extends Client{

	private String companyName;
	private String pvnNumber;
	
	public void setCompanyName(String inputCompanyName) {
		if(inputCompanyName != null && inputCompanyName.length() > 2 && inputCompanyName.matches("^[a-zA-Z0-9\\s][^|=]*$"))
		companyName = inputCompanyName;
		else {
			companyName = "Uzņēmuma nosaukums";
		}
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setPvnNumber(String inputPvnNumber) {
		if(inputPvnNumber != null && inputPvnNumber.length() == 13 && inputPvnNumber.matches("^[A-Z]{2}[0-9]{11}"))
		pvnNumber = inputPvnNumber;
		else {
			pvnNumber = "LV00123456789";
		}
	}
	public String getPvnNumber() {
		return pvnNumber;
	}

	public Company() {
		super();
		setCompanyName(null);
		setPvnNumber(null);
	}

	public Company(String name, String surname, String personCode, String phoneNumber, String emailAdress,
			 String inputSenderAddress, String inputRecieverAddress, String inputCompanyName
			, String inputPvnNumber) {
		super(name, surname, personCode, phoneNumber, emailAdress,inputSenderAddress, inputRecieverAddress);
		setCompanyName(inputCompanyName);
		setPvnNumber(inputPvnNumber);
	}

	public String toString() {
		
		return super.toString() + "\nUzņēmuma nosaukums: " + companyName + "\nPVN nummurs: " + pvnNumber;
	}
}
