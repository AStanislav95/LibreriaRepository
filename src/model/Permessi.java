package model;

public class Permessi {
	
	private int livello;
	private int role;
	private int canDownload;
	private int requestTrascriber;
	
	public Permessi(int livello, int ruolo, int Download, int Candidatura) {
		this.livello=livello;
		this.role=ruolo;
		this.canDownload=Download;
		this.requestTrascriber=Candidatura;
	}
	public Permessi() {
		this.livello=0;
		this.role=1;
		this.canDownload=0;
		this.requestTrascriber=0;
	}
	public int getLivello() {
		return livello;
	}
	public void setLivello(int livello) {
		this.livello = livello;
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
	
	

}
