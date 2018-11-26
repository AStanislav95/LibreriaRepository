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

	public static boolean haTrascrizione(int idpag) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		ResultSet rs=stm.executeQuery("select * from trascrizione where pagina="+idpag);
		return rs.next();
		
	}
	
	
	
	public static boolean insertTrascrizione(int idPag, String text, int IDUtente) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		Statement stm2=con.createStatement();
		Statement stm3=con.createStatement();
		stm.executeUpdate("INSERT INTO Trascrizione(Pagina, Testo, IDUtente) values (" + idPag + ",'" + text + "',"
				+ IDUtente + ");");
		
		stm2.executeUpdate("delete from Assegnazione where IDPagina=" + idPag + " and IDUtente=" + IDUtente);
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

	// Per il capotrascrittore
	public static boolean accettaTrascrizione(int IDpagina, int IDTrascrizione) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("update pagina set trascrizione=" + IDTrascrizione + " where id=" + IDpagina + " ;");
		Statement stm2 = con.createStatement();
		stm2.executeUpdate("update trascrizione set accettato=1 where id=" + IDTrascrizione + ";");
		return true;
	}

	// Per il capotrascrittore.
	public static ResultSet getTrascrizioniDaRevisionare() {
		try {
			Connection con = ConnectionDAO.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm
					.executeQuery("select t.ID,t.testo,t.IDUtente,p.ID,p.scanpath from pagina p, trascrizione t "
							+ "where t.pagina=p.ID and t.accettato=0 and t.annotazioni is null ;");
			return rs;
		} catch (Exception e) {
			System.out.println(e);
			ResultSet rs = null;
			return rs;
		}
	}

	public static int getID(int IDPagina) {
		try {
			Connection con = ConnectionDAO.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from trascrizione where pagina=" + IDPagina);
			if (rs.next())
				return rs.getInt(1);
			else
				return -1;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public static void mettiAnnotazione(int idtrascrizione, String annotazione) throws Exception {
		Connection con = ConnectionDAO.getConnection();
		Statement stm = con.createStatement();
		stm.executeUpdate("update trascrizione set annotazioni='" + annotazione + "' where id=" + idtrascrizione);
	}

	public static ResultSet TrascrizioniAnnotazioniUtente(int idutente) {
		try {
			Connection con = ConnectionDAO.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select t.id, t.testo, t.annotazioni from trascrizione t, utente u\r\n"
					+ "where t.IDUtente=u.ID and u.ID=" + idutente);
			return rs;
		} catch (Exception e) {
			System.out.println(e);
			ResultSet rs = null;
			return rs;
		}
	}

	public static ResultSet infoTrascrizioni(int idutente) {
		try {
			Connection con = ConnectionDAO.getConnection();
			Statement stm = con.createStatement();
			stm.executeUpdate("create or replace view pagineassegnate as "
					+ "select p.id, p.scanpath from pagina p, assegnazione a, utente u " + "where a.idutente="
					+ idutente + " and p.id=a.idpagina and u.id=a.idutente");
			Statement stm2 = con.createStatement();
			stm2.executeUpdate("create or replace view  trascrizioniUtente as "
					+ "select t.testo, t.annotazioni, t.pagina from trascrizione t, utente u "
					+ "where t.IDUtente=u.id and u.id=" + idutente);
			Statement stm3 = con.createStatement();
			stm3.executeUpdate("create or replace view infoTrascrizioni as "
					+ "select pagineassegnate.id, pagineassegnate.scanpath, trascrizioniutente.testo,"
					+ " trascrizioniutente.annotazioni "
					+ "from pagineassegnate LEFT JOIN trascrizioniutente on (pagineassegnate.id=trascrizioniutente.pagina);");
			Statement stm4 = con.createStatement();
			ResultSet rs = stm4.executeQuery("select * from infoTrascrizioni");
			return rs;

		} catch (Exception e) {
			ResultSet rs = null;
			System.out.println(e);
			return rs;
		}

	}
}
