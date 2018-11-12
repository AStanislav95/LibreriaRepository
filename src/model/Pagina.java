package model;

public class Pagina {
	private static int ID;
	private static int numero;
	private static String manoscritto;
	private static int accettato;
	private static String scanpath;
	private static Trascrizione trascrizione;
	
	public static int getID() {
		return ID;
	}
	public static void setID(int iD) {
		ID = iD;
	}
	public static int getNumero() {
		return numero;
	}
	public static void setNumero(int numero) {
		Pagina.numero = numero;
	}
	public static String getManoscritto() {
		return manoscritto;
	}
	public static void setManoscritto(String manoscritto) {
		Pagina.manoscritto = manoscritto;
	}
	public static int getAccettato() {
		return accettato;
	}
	public static void setAccettato(int accettato) {
		Pagina.accettato = accettato;
	}
	public static String getScanpath() {
		return scanpath;
	}
	public static void setScanpath(String scanpath) {
		Pagina.scanpath = scanpath;
	}
	public static Trascrizione getTrascrizione() {
		return trascrizione;
	}
	public static void setTrascrizione(Trascrizione trascrizione) {
		Pagina.trascrizione = trascrizione;
	}
	
	

}
