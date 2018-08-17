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
public class ExportFileDirector {
    
    private ExportFileBuilder exportFileBuilder;

    public void setExportFileBuilder(String fileExtension) {

        if (fileExtension.equalsIgnoreCase("txt")) {
            exportFileBuilder = new ExportTxtBuilder();
        } else if (fileExtension.equalsIgnoreCase("csv")) {
            exportFileBuilder = new ExportCsvBuilder();
        } else if (fileExtension.equalsIgnoreCase("html")) {
            exportFileBuilder = new ExportHtmlBuilder();
        } else if (fileExtension.equalsIgnoreCase("excelSaga")) {
            exportFileBuilder = new ExportObjectBuilder();
        }
        else {
            throw new IllegalArgumentException("Invalid File Extension");
        }
    }
    
    public ExportFileBuilder getExportFileBuilder() {
        return exportFileBuilder;
    }
    
    public void constructFileToExport(File f) throws Exception {
        exportFileBuilder.createNewFileToExport(f);
        exportFileBuilder.exportTableToFile();
    }
}
