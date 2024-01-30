package model;

public class Transport {
	private int idtransport;
	private String numberPlate;
	
	public int getIdtransport() {
		return idtransport;
	}
	public void setIdtransport(int idtransport) {
		if (idtransport > 0)
			this.idtransport = idtransport;
		else
			this.idtransport = -1;
	}
	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		if(numberPlate!=null &&numberPlate.matches("[A-Z]{1,2}[-][0-9]{1,4}$")) {
			this.numberPlate = numberPlate;
		}
		else {
			this.numberPlate = "INVALID";
		}
	}
	
	public Transport() {
		setIdtransport(0);
		setNumberPlate(null);
	}
	public Transport(int idtransport, String numberPlate) {
		setIdtransport(idtransport);
		setNumberPlate(numberPlate);
	}
	
	@Override
	public String toString() {
		return "Transport [idtransport=" + idtransport + ", numberPlate=" + numberPlate + "]";
	}
	
}
