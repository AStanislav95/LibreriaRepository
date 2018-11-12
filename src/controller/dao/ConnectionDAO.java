package controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectionDAO {
	private static String URL = "jdbc:mysql://localhost/library";
	private static String username = "root";
	private static String pass = "";

   
	
	public static Connection getConnection() throws Exception  {
        Connection conn = null;
        conn = DriverManager.getConnection(URL,username, pass);
             
        return conn;
    }

	public static void closeConnection(ResultSet rs, Connection conn, Statement stat) throws Exception{
		if(rs !=null) {
			rs.close();
		}
		if(conn!=null) {
			conn.close();
		}	
		if(stat!=null) {
			stat.close();
		}
		
	}
}
