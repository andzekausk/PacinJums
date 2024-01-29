package model;

public class Company extends Client {

	private String companyName;
	private String pvnNumber;
	private String companyAddress;

	public void setCompanyName(String inputCompanyName) {
		if (inputCompanyName != null && inputCompanyName.length() > 2
				&& inputCompanyName.matches("^[a-zA-Z0-9\\s][^|=]*$"))
			companyName = inputCompanyName;
		else {
			companyName = "Incorrect name";
		}
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setPvnNumber(String inputPvnNumber) {
		if (inputPvnNumber != null && inputPvnNumber.length() == 13 && inputPvnNumber.matches("LV[0-9]{11}"))
			pvnNumber = inputPvnNumber;
		else {
			pvnNumber = "Incorrect pvnNumber";
		}
	}

	public String getPvnNumber() {
		return pvnNumber;
	}
	

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		if (companyAddress != null && companyAddress.matches("^[ a-zA-Z]+[0-9a-z]{1,5}[- ]{1}[0-9a-zA-Z]{0,5}$")) {
			this.companyAddress = companyAddress;
		} else {
			this.companyAddress = "incorrect address";
		}
	}

	public Company() {
		super();
		setCompanyName(null);
		setPvnNumber(null);
		setCompanyAddress(null);
	}
	
	public Company(String name, String surname, String phoneNumber, String emailAdress,
			String inputAddress, String inputCompanyName, String inputPvnNumber, String companyAddress) {
		super(name, surname, /*personCode,*/ phoneNumber, emailAdress, inputAddress);
		setCompanyName(inputCompanyName);
		setPvnNumber(inputPvnNumber);
		setCompanyAddress(companyAddress);
	}

	public String toString() {

		return super.toString() + "\nUzņēmuma nosaukums: " + companyName + "\nPVN nummurs: " + pvnNumber;
	}
}
