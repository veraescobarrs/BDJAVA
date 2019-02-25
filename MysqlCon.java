package mysql.con;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author evilnapsis
 */

public class MysqlCon 
{
 
    public static void connect()
    {
    
      String url = "jdbc:mysql://localhost:3306/myjavaapp1";

      String user = "root";
    
      String pass = "";
    System.out.println("Conectando...");
    
      try(Connection connection = DriverManager.getConnection(url, user,pass))
      {
    
        System.out.println("Conectado!!");
    
        // vamos a insertar un registro
    
        System.out.println("Insertando ...");
    
        Statement s = connection.createStatement();
    
        String query1 = "insert into user (username,password,created_at) value (\"user1\",\"mypassword\",NOW())";

        s.executeUpdate(query1);
    
    
       // vamos a recorrer
    
        String query2 = "select * from user";
    
        ResultSet r = s.executeQuery(query2);
    
    
        while(r.next())
        {
        
          System.out.println(r.getObject("id") +" - " +r.getObject("username") + " - " +r.getObject("password"));

        }
    
        
    
      }catch(SQLException e)
       {
        
         System.out.println(e.getMessage());

       }
    
    }

    
    public static void main(String[] args) {
connect();}
    

}
