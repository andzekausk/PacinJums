package model;

public class Person {
	private String name;
	private String surname;
//	private String personCode;
	private String phoneNumber;
	private String emailAdress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name.length() > 2 && name.matches("[A-Z]{1}[a-z]+")) {
			this.name = name;
		} else {
			this.name = "Vards";
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname != null && surname.length() > 2 && surname.matches("[A-Z]{1}[a-z]+")) {
			this.surname = surname;
		} else {
			this.surname = "Uzvards";
		}
	}

//	public String getPersonCode() {
//		return personCode;
//	}
//
//	public void setPersonCode(String personCode) {
//		if (personCode != null && personCode.matches("[0-9]{6}-[0-9]{5}"))
//			this.personCode = personCode;
//		else
//			this.personCode = "123456-12345";
//	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber != null && phoneNumber.matches("^[\\+]?[0-9]{8,15}$"))
			this.phoneNumber = phoneNumber;
		else
			this.phoneNumber = "12345678";
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		if (emailAdress != null && emailAdress.matches("^[\\w.]+@([\\w]+\\.)+[\\w]{2,4}$"))
			this.emailAdress = emailAdress;
		else
			this.emailAdress = "epasts@epasts.lv";
	}

	public Person() {
		setName(null);
		setSurname(null);
//		setPersonCode(null);
		setPhoneNumber(null);
		setEmailAdress(null);
	}

	public Person(String name, String surname, /*String personCode,*/ String phoneNumber, String emailAdress) {
		setName(name);
		setSurname(surname);
//		setPersonCode(personCode);
		setPhoneNumber(phoneNumber);
		setEmailAdress(emailAdress);

	}

	@Override
	public String toString() {
		return "\nVārds: " + name + ",	Uzvārds: " + surname +/* ",	Personas kods: " + personCode
				+*/ ",	Telefona numurs: " + phoneNumber + ",	Epasts: " + emailAdress;
	}

}
