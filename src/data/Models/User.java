/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Models;

/**
 *
 * @author hdlucas
 */
public final class User {

    //default constructor
    public User() {
    }

    //constructor
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public User(int id,String name, String password) {
        this.name = name;
        this.password = password;
        this.id=id;
    }
       
    //private fields
    private static User userLoggedIn;
    private String name;
    private String password;
    private int id;

 
    //getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public User getUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(User userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }
    
    public boolean isAdmin() {
        if("admin".equals(userLoggedIn.getName()))
             return true;
        return false;
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
