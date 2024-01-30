package model;

public class Company {

	private int idcompany;
	private String companyName;
	private String pvnNumber;
	private String companyAddress;

	
	public int getIdcompany() {
		return idcompany;
	}

	public void setIdcompany(int idcompany) {
		this.idcompany = idcompany;
	}

	public void setCompanyName(String inputCompanyName) {
		if (inputCompanyName != null && inputCompanyName.length() > 2
				&& inputCompanyName.matches("^[a-zA-Z0-9\\s][^|=]*$"))
			companyName = inputCompanyName;
		else {
			companyName = "INVALID";
		}
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setPvnNumber(String inputPvnNumber) {
		if (inputPvnNumber != null && inputPvnNumber.length() == 13 && inputPvnNumber.matches("LV[0-9]{11}"))
			pvnNumber = inputPvnNumber;
		else {
			pvnNumber = "INVALID";
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
			this.companyAddress = "INVALID";
		}
	}

	public Company() {
		setIdcompany(0);
		setCompanyName(null);
		setPvnNumber(null);
		setCompanyAddress(null);
	}
	
	public Company(int idcompany, String inputCompanyName, String inputPvnNumber, String companyAddress) {
		setIdcompany(idcompany);
		setCompanyName(inputCompanyName);
		setPvnNumber(inputPvnNumber);
		setCompanyAddress(companyAddress);
	}

	
}
