/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uqar_if_cours_02_jdbc.dao;

import com.mycompany.uqar_if_cours_02_jdbc.dto.UserDTO;
import com.mycompany.uqar_if_cours_02_jdbc.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yacin
 */
public class UserDAO {
    private final String SQL_GetUser = "SELECT * FROM users WHERE username=? AND password=?";  
    private final String SQL_UpdatePassword = "UPDATE users SET password=? WHERE username=?";

    private Connection connect;
    private final Utils db_connect;
    private ResultSet rs;
    private PreparedStatement ps;
    
    public UserDAO(){
        db_connect = new Utils();
        connect = null;
        rs = null;
        ps = null;
    }    
    
    public UserDTO GetUser(String username, String password) throws SQLException{
        try{
            connect = db_connect.getConnect();
            ps = connect.prepareStatement(SQL_GetUser);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
                
            UserDTO userDTO = new UserDTO();
            
            if(rs != null){ 

                while(rs.next()){

                    userDTO.setUsername(rs.getString(2));
                    userDTO.setPassword(rs.getString(3));
                    userDTO.setFullname(rs.getString(4));
                    userDTO.setType(rs.getString(5));
                    
                    return userDTO;  
                }   
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally {
            try {
                rs.close();
                db_connect.closeConnect();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;  
    }
    
    public void UpdatePassword(String username, String new_password) throws SQLException{
        try{
            connect = db_connect.getConnect();
            ps = connect.prepareStatement(SQL_UpdatePassword);
            ps.setString(1, new_password);
            ps.setString(2, username);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally {
            try {
                ps.close();
                db_connect.closeConnect();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
