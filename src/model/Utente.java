package model;

import java.util.ArrayList;

public class Utente {
	
	private int ID;
	private String email;
	private String name;
	private String password;
	private String qualification;
	private String profession;
	private int role;
	private int canDownload;
	private int requestTrascriber;
	
	
	public Utente(int ID, String email, String pass, String qualif, String prof, int role, int canDownload, int reqTrascriber) {
		this.ID = ID;
		this.email = email;
		this.password = pass;
		this.qualification = qualif;
		this.profession = prof;
		this.role = role;
		this.canDownload = canDownload;
		this.requestTrascriber = reqTrascriber;
	}
	
	public Utente() {
		
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public int getCanDownload() {
		return canDownload;
	}


	public void setCanDownload(int canDownload) {
		this.canDownload = canDownload;
	}


	public int getRequestTrascriber() {
		return requestTrascriber;
	}


	public void setRequestTrascriber(int requestTrascriber) {
		this.requestTrascriber = requestTrascriber;
	}
	
	
	
	public static void main(String[] args) {
		
		Pagina p = new Pagina();
		p.setAccettato(1);
		p.setID(4);
		p.setNumero(4);
		p.setScanpath("something");
		p.setTrascrizione("trascript");
		p.setManoscritto("ghj");
		
		
		
		Pagina ps = new Pagina();
		ps.setAccettato(1);
		ps.setID(74);
		ps.setNumero(4);
		ps.setScanpath("something");
		ps.setTrascrizione("trascript");
		ps.setManoscritto("ghj");
		
	
		
		
		Manoscritto m = new Manoscritto();
		m.setAnno(100);
		m.setAutore("Ciao");
		m.setGenere("ciao");
		m.setID(4);
		m.setPubblicazione(1);
		m.setTitolo("Ciao");
		m.setSecolo(1454);
		
		m.setListaPagine(ps);
		m.setListaPagine(p);
		
		Manoscritto b = new Manoscritto();
		b.setAnno(1780);
		b.setAutore("Ciao");
		b.setGenere("ciao");
		b.setID(4);
		b.setPubblicazione(1);
		b.setTitolo("pirla");
		b.setSecolo(1454);
		
		b.setListaPagine(p);
		
		
		
		
		for (Pagina v:b.getListaPagine()) {
			System.out.println(v.getID());
		}
		
	
	}
	
}

   