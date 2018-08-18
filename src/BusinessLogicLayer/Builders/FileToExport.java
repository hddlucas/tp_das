/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Builders;

import java.io.File;

/**
 *
 * @author hdlucas
 */
public class FileToExport {

    
    private File file;
    
    public FileToExport(File file) {
        this.file = file;
    }
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
