package model;

public class Person {
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name.length() >= 2 && name.matches("[A-Z]{1}[a-z]+$")) {
			this.name = name;
		} else {
			this.name = "INVALID";
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname != null && surname.length() >= 2 && surname.matches("[A-Z]{1}[a-z]+$")) {
			this.surname = surname;
		} else {
			this.surname = "INVALID";
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber != null && phoneNumber.matches("^[\\+]?[0-9]{8,15}$"))
			this.phoneNumber = phoneNumber;
		else
			this.phoneNumber = "INVALID";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && email.matches("^[\\w.]+@([\\w]+\\.)+[\\w]{2,4}$"))
			this.email = email;
		else
			this.email = "epasts@epasts.lv";
	}

	public Person() {
		setName(null);
		setSurname(null);
		setPhoneNumber(null);
		setEmail(null);
	}

	public Person(String name, String surname, String phoneNumber, String email) {
		setName(name);
		setSurname(surname);
		setPhoneNumber(phoneNumber);
		setEmail(email);

	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ "]";
	}


}
