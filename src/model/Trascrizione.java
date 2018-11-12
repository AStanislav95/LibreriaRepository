package model;

public class Trascrizione {
	private static int ID;
	private static String testo;
	private static String annotazioni;
	private static int accettato;
	private static int IDutente;
	private static int IDcapotrascrittore;
	
	public static int getID() {
		return ID;
	}
	public static void setID(int iD) {
		ID = iD;
	}
	public static String getTesto() {
		return testo;
	}
	public static void setTesto(String testo) {
		Trascrizione.testo = testo;
	}
	public static String getAnnotazioni() {
		return annotazioni;
	}
	public static void setAnnotazioni(String annotazioni) {
		Trascrizione.annotazioni = annotazioni;
	}

	public static int getAccettato() {
		return accettato;
	}
	public static void setAccettato(int accettato) {
		Trascrizione.accettato = accettato;
	}
	public static int getIDutente() {
		return IDutente;
	}
	public static void setIDutente(int iDutente) {
		IDutente = iDutente;
	}
	public static int getIDcapotrascrittore() {
		return IDcapotrascrittore;
	}
	public static void setIDcapotrascrittore(int iDcapotrascrittore) {
		IDcapotrascrittore = iDcapotrascrittore;
	}

}
