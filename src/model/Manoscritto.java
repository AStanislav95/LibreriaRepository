package model;

import java.util.ArrayList;

public class Manoscritto {

	private int ID;
	private int pubblicazione;
	private int anno;
	private int secolo;
	private String titolo;
	private String autore;
	private String genere;
	private ArrayList<Pagina> listaPagine = new ArrayList<>();	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPubblicazione() {
		return pubblicazione;
	}
	public void setPubblicazione(int pubblicazione) {
		this.pubblicazione = pubblicazione;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public int getSecolo() {
		return secolo;
	}
	public void setSecolo(int secolo) {
		this.secolo = secolo;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	public ArrayList<Pagina> getListaPagine() {
		return listaPagine;
	}
	public void setListaPagine(Pagina pag) {
		this.listaPagine.add(pag);
	}
	
	
	
	

}
