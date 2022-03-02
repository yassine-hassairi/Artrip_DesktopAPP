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
 * @author Yassine
 */
public class myConnection {
   
    public String url = "jdbc:mysql://localhost:3306/artripme";
    public String user = "root";
    public String pwd = "";

    private Connection cnx;
    public static myConnection ct;

    private myConnection() {
        try {
            cnx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connection etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("ewew");
        }
    }

    public static myConnection getInstance() {
        if (ct == null) {
            ct = new myConnection();
        }
        return ct;
    }

    public Connection getCnx() {
        return cnx;
    }

    public Connection getCon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
