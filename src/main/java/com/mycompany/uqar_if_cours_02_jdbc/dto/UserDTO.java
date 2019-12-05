/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.uqar_if_cours_02_jdbc.dto;

/**
 *
 * @author yacin
 */
public class UserDTO {
    private String _username;
    private String _password;
    private String _fullname;
    private String _type;
    
    public UserDTO(){
        
    }
    
    public UserDTO(String username, String password, String fullname, String type){
        this._username = username;
        this._password = password;
        this._fullname = fullname;
        this._type = type;
    }    

    public String getUsername(){
        return this._username;
    }
    
    public void setUsername(String username){
        this._username = username;
    }
    
    public String getPassword(){
        return this._password;
    }
    
    public void setPassword(String password){
        this._password = password;
    }
    
    public String getFullname(){
        return this._fullname;
    }
    
    public void setFullname(String fullname){
        this._fullname = fullname;
    }
 
    public String getType(){
        return this._type;
    }
    
    public void setType(String type){
        this._type = type;
    }    
}
