package controller.manager;

import controller.dao.UtenteDAO;

public class GestioneLivelliTrascrittoriController {
	
	
	public boolean CambiaConNumero(int livello, int IDutente) throws Exception {
		
		return UtenteDAO.CambioLivelloTrascrittore(IDutente, livello);
	}
	public boolean AumentadiUno(int IDutente) throws Exception {
		return UtenteDAO.AumentoLivelloTrascrittore(IDutente) ;
	}
	public boolean DiminuiscidiUno(int IDutente) throws Exception {
		return UtenteDAO.DiminuzioneLivelloTrascrittore(IDutente);
	}
	
	
	
	
}
