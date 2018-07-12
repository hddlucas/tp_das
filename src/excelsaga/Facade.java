/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelsaga;

import data.Controllers.UsersController;
import data.Controllers.UsersControllerImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hdlucas
 */
public class Facade {
    
    private static final UsersController users = new UsersControllerImpl();
    
    public static List<String> getUsersList(){
        List<String> usersList= new ArrayList<>();
        try{
            return users.getUsersList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return usersList;
    }
    
     public static boolean login(String name,String password){
        try{
            return users.login(name, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
     
     public static boolean checkIfUserExists(String name){
          try{
            return users.checkIfUserExists(name);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
     }
     public static void create(String name,String password) {
          try{
            users.create(name,password);
        }catch(Exception e){
            e.printStackTrace();
        }
     }
    
}
