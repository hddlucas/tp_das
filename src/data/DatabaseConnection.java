package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseConnection {

    private static DatabaseConnection instance;
    protected   Connection connection;
    private String username = "root";
    private String password = "";
    private String url = "jdbc:h2:~/ExcelSaga";

    
    private DatabaseConnection()   {

        try {
            String script=this.getDBScript("files/script.sql");
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate(script);

        } catch (ClassNotFoundException  | IOException | SQLException e) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }

    public static DatabaseConnection getInstance() throws Exception {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }


    private String getDBScript(String file) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();

        BufferedReader reader = new BufferedReader(new FileReader(classLoader.getResource(file).getPath()));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }


}