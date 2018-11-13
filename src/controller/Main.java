package controller;
import model.*;
import controller.viewer.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main {
	
	public static void main(String[] args) {
	
		Manoscritto m1=new Manoscritto();
		m1.setAutore("Dante Alighieri");
		m1.setTitolo("Divina Commedia");
		ObjectContenitor.listaManoscritti.add(m1);
		ObservableList<Manoscritto> Result=FXCollections.observableArrayList();
		Result=RicercaMetadatiController.ricercaNome("Divina Commedia");
		//Funzionerà quando nel DAO avremo la funzione che carica i manoscritti.
		
		for (Manoscritto x: Result) {
			System.out.println(x.getAutore());
			System.out.println("okay");
		}
		
	}
	
}
