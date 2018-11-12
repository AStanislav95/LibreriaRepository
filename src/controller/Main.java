package controller;
import model.*;
import controller.viewer.*;

public class Main {
	
	public static void main(String[] args) {
		Utente utentone=new Utente();
		utentone.setEmail("ohno@gmail.com");
		utentone.setName("Stas");
		utentone.setProfession("Pagliaccio");
		utentone.setQualification("Liceo");
		utentone.setRole(1);
		
		RegistrazioneController.register(utentone);
		
		
	}
	
}

