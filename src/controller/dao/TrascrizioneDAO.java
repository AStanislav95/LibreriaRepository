package controller.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrascrizioneDAO {

	public static ResultSet getTrascrizioni() throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM Trascrizione");
		return rs;
	}

	public static boolean insertTrascrizione(int idPag, String text, int IDUtente) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("INSERT INTO Trascrizione(Pagina, Testo, IDUtente) values (" + idPag + ",'" + text + "',"
				+ IDUtente + ");");
		stm.executeUpdate("delete from Assegnazione where IDPagina="+idPag+" and IDUtente="+IDUtente);
		return true;
	}

	
	public static boolean insertAssegnazione(int IDutente, int IDpagina) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate(
				"INSERT INTO Assegnazione(IDUtente, IDPagina)  values ( " + IDutente + ", " + IDpagina + ");");
		return true;

	}

	public static boolean togliAssegnazione(int IDutente, int IDpagina) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("delete from assegnazione where IDUtente=" + IDutente + " and IDPagina=" + IDpagina + ";");
		con.close();
		return true;
	}

	public static boolean doesitExist(int IDutente, int IDpagina) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		ResultSet rs = stm
				.executeQuery("select * from assegnazione where IDUtente=" + IDutente + " and IDPagina=" + IDpagina);
		if (rs.next()) {
			return true;
		} else
			return false;
	}
	
	//Per il capotrascrittore
	public static boolean accettaTrascrizione(int IDpagina, int IDTrascrizione) throws Exception	{
		Connection con = ConnectionDAO.getConnection();
		Statement stm=con.createStatement();
		stm.executeUpdate("update pagina set trascrizione="+IDTrascrizione+" where id="+IDpagina+" ;");
		stm.executeUpdate("update trascrizione set accettato=1 where id="+IDTrascrizione+";");
		return true;
	}
	
	//Per il capotrascrittore.
	public static ResultSet getTrascrizioniDaRevisionare() {
		try { Connection con = ConnectionDAO.getConnection();
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select t.ID,t.testo,t.IDUtente,p.ID,p.scanpath from pagina p, trascrizione t\r\n" + 
				"where t.pagina=p.ID and t.accettato=0;");
		return rs;
		} catch (Exception e)
		{
			System.out.println(e);
			ResultSet rs=null;
			return rs;
		}
	}
	
	public static int getID(int IDPagina) {
		try{Connection con = ConnectionDAO.getConnection();
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select * from trascrizione where pagina="+IDPagina);
		if(rs.next())
		return rs.getInt(1);
		else
			return -1;
		}
		catch (Exception e) {
			System.out.println(e);
			return -1;
		}
		}
	
	
	public static void mettiAnnotazione(int idtrascrizione, String annotazione) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm=con.createStatement();
		stm.executeUpdate("update trascrizione set annotazione='"+annotazione+"' where id="+idtrascrizione);
	}
	
}
