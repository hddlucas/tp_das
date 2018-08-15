/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author hdlucas
 */
public interface DataBaseConn {
    
    Connection getConnection();
    void closeConnection() throws SQLException;
    String getDBScript(String file) throws IOException;
}
