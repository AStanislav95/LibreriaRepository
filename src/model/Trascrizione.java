package model;

public class Trascrizione {

	private int ID;
	private String testo;
	private String annotazione;
	private int accettato;
	private int IDUtente;
	private int IDCapotrascrittore;
	
	
	public Trascrizione() {
		
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
	public int getIDCapotrascrittore() {
		return IDCapotrascrittore;
	}
	public void setIDCapotrascrittore(int iDCapotrascrittore) {
		IDCapotrascrittore = iDCapotrascrittore;
	}
	
	
}