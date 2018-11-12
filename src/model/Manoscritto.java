package model;

public class Manoscritto {
	private static int ID;
	private static int pubblicazione;
	private static int anno;
	private static int secolo;
	private static String titolo;
	private static String autore;
	private static String genere;
	
	
	public static int getID() {
		return ID;
	}
	public static void setID(int iD) {
		ID = iD;
	}
	public static int getPubblicazione() {
		return pubblicazione;
	}
	public static void setPubblicazione(int pubblicazione) {
		Manoscritto.pubblicazione = pubblicazione;
	}
	public static int getAnno() {
		return anno;
	}
	public static void setAnno(int anno) {
		Manoscritto.anno = anno;
	}
	public static int getSecolo() {
		return secolo;
	}
	public static void setSecolo(int secolo) {
		Manoscritto.secolo = secolo;
	}
	public static String getTitolo() {
		return titolo;
	}
	public static void setTitolo(String titolo) {
		Manoscritto.titolo = titolo;
	}
	public static String getAutore() {
		return autore;
	}
	public static void setAutore(String autore) {
		Manoscritto.autore = autore;
	}
	public static String getGenere() {
		return genere;
	}
	public static void setGenere(String genere) {
		Manoscritto.genere = genere;
	}

}
