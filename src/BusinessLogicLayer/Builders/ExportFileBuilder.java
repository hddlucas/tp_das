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

    public static ExportFileBuilder getBuilder(String fileExtension) throws Exception {
        if (fileExtension.equalsIgnoreCase("txt")) {
            return new ExportTxtBuilder();
        } else if (fileExtension.equalsIgnoreCase("csv")) {
            return new ExportCsvBuilder();
        } else if (fileExtension.equalsIgnoreCase("html")) {
            return new ExportHtmlBuilder();
        } else if (fileExtension.equalsIgnoreCase("excelSaga")) {
            return new ExportObjectBuilder();
        }
        else {
            throw new IllegalArgumentException("Invalid File Extension");
        }
    }

    public abstract ExportFileBuilder setBuilder(File file);

    public abstract void tableExporter() throws Exception;
}
