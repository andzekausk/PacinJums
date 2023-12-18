package model;

public class Employee extends Person {

	private int ID;
	private static int counter = 1;

	public int getID() {
		return ID;
	}
	
	public void setID() {
		ID = counter;
		counter++;

	}
	
	public Employee() {
		
		super();
		setID();
	}
	
	public Employee (String name, String surname, String personCode, String phoneNumber, String emailAdress) {
		super(name, surname, personCode, phoneNumber, emailAdress);
		setID();
	}
	public String toString () {
		//ID: super(Person)
		String result = "ID:" + ID + " " + super.toString();
		return result;
	}
}