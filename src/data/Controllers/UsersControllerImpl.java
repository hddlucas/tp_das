package data.Controllers;

import data.DatabaseConnection.DatabaseConnImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersControllerImpl implements UsersController{


    //get list of stored users in database
    @Override
    public  List<String> getUsersList() throws Exception {
        List<String> users = new ArrayList<>();

        try(Statement statement = DatabaseConnImpl.getInstance().getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM  USER")) {
            while (rs.next()) {
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        }
        return users;
    }


    //check if user exists on database
    @Override
    public  boolean checkIfUserExists(String name) throws Exception {

        try(PreparedStatement statement = DatabaseConnImpl.getInstance()
                .getConnection().prepareStatement("SELECT ID FROM USER WHERE LOWER(NAME) =?")) {
            statement.setString(1, name.toLowerCase());
            try(ResultSet rs = statement.executeQuery()) {
                if( rs.next() ) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    
    //check if user exists on database
    @Override
    public  boolean login(String name,String password) throws Exception {

        try(PreparedStatement statement = DatabaseConnImpl.getInstance()
                .getConnection().prepareStatement("SELECT NAME FROM USER WHERE LOWER(NAME) =? AND PASSWORD = ?")) {
            statement.setString(1, name.toLowerCase());
            statement.setString(2, password);
            try(ResultSet rs = statement.executeQuery()) {
                if( rs.next() ) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }


    //create new user on database
    @Override
    public  void create(String name,String password) throws Exception {
        try(PreparedStatement statement = DatabaseConnImpl.getInstance()
                .getConnection().prepareStatement("INSERT INTO USER (NAME,PASSWORD) VALUES (?,?)")) {
            statement.setString(1, name);
            statement.setString(2, password);
            statement.executeUpdate();

        }
    }


}
