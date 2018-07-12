/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Controllers;

import data.Models.User;
import java.util.List;

/**
 *
 * @author hdlucas
 */
public interface UsersController {
    
    List<User> getUsersList()  throws Exception ;
    boolean checkIfUserExists(String name) throws Exception;
    boolean login(String name,String password) throws Exception;
    void create(String name,String password) throws Exception;
}
