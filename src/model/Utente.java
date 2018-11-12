package model;

public class Utente {
	private static int ID;
	private static String email;
	private static String name;
	private static String password;
	private static String qualification;
	private static String profession;
	private static int role;
	private static int candownload;
	private static int requesttranscriber;
	private static int lvltranscriber;
	
	public Utente() {
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public  String getEmail() {
		return email;
	}
	public  void setEmail(String email) {
		Utente.email = email;
	}
	public  String getName() {
		return name;
	}
	public void setName(String name) {
		Utente.name = name;
	}
	public  String getPassword() {
		return password;
	}
	public  void setPassword(String password) {
		Utente.password = password;
	}
	public String getQualification() {
		return qualification;
	}
	public  void setQualification(String qualification) {
		Utente.qualification = qualification;
	}
	public  String getProfession() {
		return profession;
	}
	public  void setProfession(String profession) {
		Utente.profession = profession;
	}
	public  int getRole() {
		return role;
	}
	public  void setRole(int i) {
		Utente.role = i;
	}
	public  int getCandownload() {
		return candownload;
	}
	public void setCandownload(int candownload) {
		Utente.candownload = candownload;
	}
	public int getRequesttranscriber() {
		return requesttranscriber;
	}
	public  void setRequesttranscriber(int requesttranscriber) {
		Utente.requesttranscriber = requesttranscriber;
	}
	public int getLvltranscriber() {
		return lvltranscriber;
	}
	public  void setLvltranscriber(int lvltranscriber) {
		Utente.lvltranscriber = lvltranscriber;
	}
}

   