/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.DataAccessObjects;

import DataAccessLayer.DatabaseConnection.DatabaseConnImpl;
import DataAccessLayer.Models.User;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hdlucas
 */
public class FilesDaoImpl implements FilesDao {

    @Override
    public void saveFile(File file, User loggedInUser) throws Exception {
        try (PreparedStatement statement = DatabaseConnImpl.getInstance()
                .getConnection().prepareStatement("INSERT INTO FILE (PATH,ID_USER) VALUES (?,?)")) {
            statement.setString(1, file.getAbsolutePath());
            statement.setInt(2, loggedInUser.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public List<String> getRecentFiles(User loggedInUser) throws Exception {
        List<String> recentFiles = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnImpl.getInstance()
                .getConnection().prepareStatement("SELECT * FROM  FILE WHERE ID_USER = ? ORDER BY ID DESC LIMIT 5")) {
            statement.setInt(1, loggedInUser.getId());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                if (!rs.getString("PATH").equals("")) {
                    recentFiles.add(rs.getString("PATH"));
                }
            }
        }
        return recentFiles;
    }
}
