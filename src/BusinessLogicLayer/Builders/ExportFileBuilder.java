/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Builders;

import java.io.File;


/**
 *
 * @author MarcoSequeira-PC
 */
public abstract class ExportFileBuilder {
    
    protected FileToExport fileToExport;
    
      public FileToExport getFileToExport() {
        return fileToExport;
    }

    public void createNewFileToExport(File f) {
        fileToExport = new FileToExport(f);
    }

    public abstract void exportTableToFile() throws Exception;
}
