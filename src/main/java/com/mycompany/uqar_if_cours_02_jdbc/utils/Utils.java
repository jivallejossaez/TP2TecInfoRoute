/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uqar_if_cours_02_jdbc.utils;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yacin
 */
public class Utils {
    
    private Connection connect;
    private String url;
    private String user;
    private String pass;   
    
    public Connection getConnect(){
        
        /* Mettre ici les informations */
        String db_name = "";
        url = "jdbc:mysql://localhost:3306/" + db_name + "?useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        user = "";
        pass = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connect = DriverManager.getConnection(url, user, pass);
                out.println("Connexion réussie !");
            } catch (SQLException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Connexion échouée !");
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            out.println("Connexion échouée !");
        }  
        
        return connect;
    }
    
    public void closeConnect(){
        try {
            if (!connect.isClosed()){
                connect.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
