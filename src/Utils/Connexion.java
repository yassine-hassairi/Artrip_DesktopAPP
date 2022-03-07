/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Connexion {
    public final String url="jdbc:mysql://localhost:3306/artrip1";
    public final String login="root";
    public final String pwd="";
    public static Connexion instance=null;
    Connection connexion;
    
    
    private Connexion(){
        try {
            connexion =DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie ...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreur");
            
        }
    }
    
    
    public static Connexion getInstance (){
        if (instance == null)
            instance = new Connexion();
        
        return instance;
    }
    
    public Connection getCnx(){
        return connexion;
    }
       
            
    
    
}
