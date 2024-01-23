package model;

public class Employee extends Person {

	private int ID;
	private static int counter = 1;
	private String personCode;
	
	public int getID() {
		return ID;
	}
	
	public void setID() {
		ID = counter;
		counter++;

	}
	
	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		if (personCode != null && personCode.matches("[0-9]{6}-[0-9]{5}"))
			this.personCode = personCode;
		else
			this.personCode = "123456-12345";
	}
	
	public Employee() {
		
		super();
		setID();
		setPersonCode(null);
	}
	
	public Employee (String name, String surname, String personCode, String phoneNumber, String emailAdress) {
		super(name, surname, /*personCode,*/ phoneNumber, emailAdress);
		setPersonCode(personCode);
		setID();
	}
	public String toString () {
		//ID: super(Person)
		return "ID:" + ID + " " + super.toString() + ",	Personas kods: " + personCode;
	}
}