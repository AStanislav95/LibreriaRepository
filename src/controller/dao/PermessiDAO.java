package controller.dao;

import java.beans.Statement;
import java.sql.Connection;

public class PermessiDAO {
	static Connection conn;

	public static boolean setRichiesta(int val, int id) {
		try {
			conn = ConnectionDAO.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			stmt.executeUpdate("update utente set RichiestaTrascrittore= " + val + " where ID= " + id);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public static boolean setRuolo(int id, int ruolo) {
		try {
			conn = ConnectionDAO.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			stmt.executeUpdate("update utente set Ruolo=" + ruolo + " where ID=" + id);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public static boolean aggiungiPermessi(int ruolo, int permesso) {
		try {
			conn = ConnectionDAO.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into consente values (" + ruolo + "," + permesso + ")");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean rimuoviPermessi(int ruolo, int permesso) {
		try {
			conn = ConnectionDAO.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			stmt.executeUpdate("delete from consente where IDRuolo=" + ruolo + " and IDPermessi=" + permesso + ";");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean CambioLivelloTrascrittore(int IDutente, int livello) throws Exception {
		conn = ConnectionDAO.getConnection();
		java.sql.Statement stmt = conn.createStatement();
		stmt.executeUpdate("update utente set LivelloTrascrittore=" + livello + " where IDRuolo=" + IDutente + ";");
		return true;
	}
}