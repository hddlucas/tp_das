/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
       
    //private fields
    private static User userLoggedIn;
    private String name;
    private String password;

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
    
    public static User getUserLoggedIn() {
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
}
