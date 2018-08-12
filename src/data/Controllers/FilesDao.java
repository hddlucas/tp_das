/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Controllers;

import data.Models.User;
import java.io.File;
import java.util.List;

/**
 *
 * @author hdlucas
 */
public interface FilesDao {
    
    void saveFile(File file,User loggedInUser) throws Exception;
    List<String> getRecentFiles(User loggedInUser) throws Exception;

}
