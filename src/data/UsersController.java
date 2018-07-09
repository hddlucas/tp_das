package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersController {


    //get list of stored users in database
    public static List<String> getUsersList() throws Exception {
        List<String> users = new ArrayList<>();

        try(Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM  USER")) {
            while (rs.next()) {
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        }
        return users;
    }


    //check if user exists on database
    public static boolean checkIfUserExists(String name) throws Exception {

        try(PreparedStatement statement = DatabaseConnection.getInstance()
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
    public static boolean login(String name,String password) throws Exception {

        try(PreparedStatement statement = DatabaseConnection.getInstance()
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
    public static void create(String name,String password) throws Exception {
        try(PreparedStatement statement = DatabaseConnection.getInstance()
                .getConnection().prepareStatement("INSERT INTO USER (NAME,PASSWORD) VALUES (?,?)")) {
            statement.setString(1, name);
            statement.setString(2, password);
            statement.executeUpdate();

        }
    }


}
