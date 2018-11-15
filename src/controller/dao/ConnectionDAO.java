package controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectionDAO {

  private static String URL = "jdbc:mysql://localhost:3306/libreria?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
  
  private static String username = "root";
  private static String pass = "root";

   
  
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
  
  
  
  public static ResultSet query(String str) {
    try {

        
        Connection con = DriverManager.getConnection(URL,username, pass);
        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery(str);

        return result;

    } catch (Exception e) {

        System.out.println(e.getMessage());
        return null;
    }
   
  }
  
  
}