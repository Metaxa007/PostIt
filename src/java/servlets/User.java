package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Die Klasse User vererbt AbstractUser
 * @author matthiasseeber
 * 
 */
public class User extends AbstractUser {

    /**
     * Konstruktor fuer User
     * @param name
     * @param surname
     * @param email
     * @param password 
     */
    
    private boolean admin=false;
    private boolean scientist=false;
    
    public User(String name, String surname, String email, String password,boolean admin, boolean scientist) {
        super(name, surname, email, password);
        
        this.admin=admin;
        this.scientist=scientist;
        
    }
    
    public boolean getAdmin(){
    
        return this.admin;
        
    }
    
    public boolean getScientist(){
        
        return this.scientist;
        
    }
    
}