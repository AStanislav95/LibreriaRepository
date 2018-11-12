package model;

import java.util.ArrayList;
import java.util.HashMap;

public class ObjectContenitor {
	public static Utente utenteAttivo = new Utente();
	public static ArrayList<Manoscritto> listaManoscritti = new ArrayList<Manoscritto>();
	public static ArrayList<Pagina> listaPagine;
	
	
	
	public void addManoscritto(Manoscritto m) { 
		listaManoscritti.add(m);
	}
	
	public void addPagina(Pagina p) {
		listaPagine.add(p); 
	}
	
	public ArrayList<Manoscritto> getListaManoscritti(){
		return listaManoscritti;
	}
	
	
	public ArrayList<Pagina> getListaPagine(){
		return listaPagine;
	}
	
	
	
	
	
	
}//end method
