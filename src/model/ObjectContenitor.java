package model;

import java.util.ArrayList;
import java.util.HashMap;

public class ObjectContenitor {
	public static Utente utenteAttivo = new Utente();
	public static ArrayList<Manoscritto> listaManoscritti = new ArrayList<Manoscritto>();

	
	public void addManoscritto(Manoscritto m) { 
		listaManoscritti.add(m);
	}
	
	
	public ArrayList<Manoscritto> getListaManoscritti(){
		return listaManoscritti;
	}
	
	
	
	
}//end method
