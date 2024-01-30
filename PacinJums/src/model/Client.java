package model;

public class Client extends Person{
	
	private int idclient;
	private String clientType;
	private String address;
	private int idcompany;

	
	
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		if (idclient > 0)
			this.idclient = idclient;
		else
			this.idclient = -1;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		if (clientType != null && (clientType.matches("sender") || clientType.matches("reciever")))
			this.clientType = clientType;
		else
			this.clientType = "INVALID";
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if (address != null && address.matches("^[ a-zA-Z]+[0-9a-z]{1,5}[- ]{1}[0-9a-zA-Z]{0,5}$")) {
			this.address = address;
		} else {
			this.address = "INVALID";
		}
	}
	public int getIdcompany() {
		return idcompany;
	}
	public void setIdcompany(int idcompany) {
		if (idcompany > 0)
			this.idcompany = idcompany;
		else
			this.idcompany = -1;
	}
	
	public Client() {
		super();
		setIdclient(0);
		setClientType(null);
		setAddress(null);
		setIdcompany(0);
	}
	public Client(int idclient, String name, String surname, String clientType, String phoneNumber, String email, String address, int idcompany) {
		super(name, surname, phoneNumber, email);
		setIdclient(idclient);
		setClientType(clientType);
		setAddress(address);
		setIdcompany(idcompany);
	}
	
	@Override
	public String toString() {
		return "Client [idclient=" + idclient + ", clientType=" + clientType + ", address=" + address + ", idcompany="
				+ idcompany + "]";
	}
	
}
