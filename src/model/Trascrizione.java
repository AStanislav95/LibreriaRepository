package model;

public class Trascrizione {

	private int ID;
	private String testo;
	private String annotazione;
	private int idPagina;
	private String scanPagina;
	private int accettato;
	private int IDUtente;

	//t.ID,t.testo,t.IDUtente,p.ID,p.scanpath
	
	public Trascrizione(int ID, String text, int IDUtente, int idPagina, String scanPagina) {
		this.ID = ID;
		this.testo = text;
		this.IDUtente = IDUtente;
		this.idPagina = idPagina;
		this.scanPagina = scanPagina;
	}
	
	
	public Trascrizione() {
		
	}
	
	public Trascrizione(int ID, String testo, String annotazione, int pagina, int accettato, int IDUtente) {
		this.ID = ID;
		this.testo = testo;
		this.annotazione = annotazione;
		this.idPagina = pagina;
		this.accettato = accettato;
		this.IDUtente = IDUtente;
		
	}
	
	public Trascrizione(int id, String testo, int IDUtente) {
		this.ID = id;
		this.testo = testo;
		this.IDUtente = IDUtente;

	}
	
	public String getScanPagina() {
		return this.scanPagina;
	}
	
	public void setScanPagina(String scanPagina) {
		this.scanPagina = scanPagina;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getAnnotazione() {
		return annotazione;
	}
	public void setAnnotazione(String annotazione) {
		this.annotazione = annotazione;
	}
	public int getAccettato() {
		return accettato;
	}
	public void setAccettato(int accettato) {
		this.accettato = accettato;
	}
	public int getIDUtente() {
		return IDUtente;
	}
	public void setIDUtente(int iDUtente) {
		IDUtente = iDUtente;
	}
	public void setidPagina(int pagina) {
		this.idPagina = pagina;
	}
	
	public int getidPagina() {
		return this.idPagina;
	}
	
}