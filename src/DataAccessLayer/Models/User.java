/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Models;

/**
 *
 * @author hdlucas
 */
public final class User {

    //default constructor
    public User() {
    }

        //private fields
    private static User userLoggedIn;
    private String name;
    private String password;
    private int id;

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
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
