package model;

public class Trascrizione {

	private int ID;
	private String testo;
	private String annotazione;
	private int pagina;
	private int accettato;
	private int IDUtente;

	
	public Trascrizione() {
		
	}
	
	public Trascrizione(int ID, String testo, String annotazione, int pagina, int accettato, int IDUtente) {
		this.ID = ID;
		this.testo = testo;
		this.annotazione = annotazione;
		this.pagina = pagina;
		this.accettato = accettato;
		this.IDUtente = IDUtente;
		
	}
	
	public Trascrizione(int id, String testo, int IDUtente) {
		this.ID = id;
		this.testo = testo;
		this.IDUtente = IDUtente;

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
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
	public int getPagina() {
		return this.pagina;
	}
	
}