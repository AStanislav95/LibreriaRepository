package model;

public class Pagina {
	
	private int ID;
	private int numero;
	private String manoscritto;
	private int accettato;
	private String scanpath;
	private String trascrizione;
	
	
	public Pagina() {
		
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getManoscritto() {
		return manoscritto;
	}
	public void setManoscritto(String manoscritto) {
		this.manoscritto = manoscritto;
	}
	public int getAccettato() {
		return accettato;
	}
	public void setAccettato(int accettato) {
		this.accettato = accettato;
	}
	public String getScanpath() {
		return scanpath;
	}
	public void setScanpath(String scanpath) {
		this.scanpath = scanpath;
	}
	public String getTrascrizione() {
		return trascrizione;
	}
	public void setTrascrizione(String trascrizione) {
		this.trascrizione = trascrizione;
	}
	
	

}
