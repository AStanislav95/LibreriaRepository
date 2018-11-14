package controller.manager;

import controller.dao.PermessiDAO;


public class GestioneLivelliTrascrittoriController {
	
	
	public boolean CambiaConNumero(int livello, int IDutente) throws Exception {
		
		return PermessiDAO.CambioLivelloTrascrittore(IDutente, livello);
	}
	/*public boolean AumentadiUno(int IDutente) throws Exception {
		return PermessiDAO.AumentoLivelloTrascrittore(IDutente) ;
	}
	public boolean DiminuiscidiUno(int IDutente) throws Exception {
		return PermessiDAO.DiminuzioneLivelloTrascrittore(IDutente);
	}
	*/
	
	
	
}
