package model;

public class Utente {
	
	private int ID;
	private String email;
	private String name;
	private String password;
	private String qualification;
	private String profession;
	private int livello;
	private int role;
	private int canDownload;
	private int requestTrascriber;
	
	
	public Utente(int ID, String email,String nome, String pass, String qualif, String prof, int role, int livello, int canDownload, int reqTrascriber) {
		this.ID = ID;
		this.email = email;
		this.name=nome;
		this.password = pass;
		this.qualification = qualif;
		this.profession = prof;
		this.role = role;
		this.livello=livello;
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
		Manoscritto m = new Manoscritto();
		m.setAnno(100);
		m.setAutore("Ciao");
		m.setGenere("ciao");
		m.setID(4);
		m.setPubblicazione(1);
		m.setTitolo("Ciao");
		m.setSecolo(1454);
		
		Manoscritto b = new Manoscritto();
		b.setAnno(1780);
		b.setAutore("Ciao");
		b.setGenere("ciao");
		b.setID(4);
		b.setPubblicazione(1);
		b.setTitolo("pirla");
		b.setSecolo(1454);
		
		ObjectContenitor.listaManoscritti.add(m);
		ObjectContenitor.listaManoscritti.add(b);
		
		for (Manoscritto x: ObjectContenitor.listaManoscritti) {
			System.out.println(x.getTitolo());
		}
		
	}
	
}
