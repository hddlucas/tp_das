package data.DatabaseConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseConnImpl implements DataBaseConn{

    private static DatabaseConnImpl instance;
    protected   Connection connection;
    private String username = "root";
    private String password = "";
    private String url = "jdbc:h2:~/ExcelSaga";

    
    private DatabaseConnImpl()   {

        try {
            String script=this.getDBScript("files/script.sql");
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate(script);

        } catch (ClassNotFoundException  | IOException | SQLException e) {
            Logger.getLogger(DatabaseConnImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }

    public static DatabaseConnImpl getInstance() throws Exception {
        if (instance == null) {
            instance = new DatabaseConnImpl();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnImpl();
        }

        return instance;
    }


    @Override
    public String getDBScript(String file) throws IOException {
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