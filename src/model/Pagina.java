package model;

public class Pagina {
	
	private int ID;
	private int numero;
	private int manoscritto;
	private int accettato;
	private String scanpath;
	private String trascrizione;
	
	
	public Pagina() {
		
	}
	public Pagina(int numero, int manoscritto, String scanpath ) {
		this.numero = numero;
		this.manoscritto = manoscritto;
		this.scanpath = scanpath;
	}
	public Pagina(int numero, int manoscritto, String scanpath,String trascrizione ) {
		this.numero = numero;
		this.manoscritto = manoscritto;
		this.scanpath = scanpath;
		this.trascrizione = trascrizione;
	}
	
	public Pagina(int id, String scanPath) {
		this.ID = id;
		this.scanpath = scanPath;
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
	public int getManoscritto() {
		return manoscritto;
	}
	public void setManoscritto(int manoscritto) {
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
