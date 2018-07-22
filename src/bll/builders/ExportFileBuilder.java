/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.builders;

import java.io.File;

/**
 *
 * @author MarcoSequeira-PC
 */
public abstract class ExportFileBuilder {

    public static ExportFileBuilder getBuilderByType(String t) throws Exception {
        if (t.equalsIgnoreCase("txt")) {
            //return new TextFileBuilder();
        } else if (t.equalsIgnoreCase("csv")) {
            return new ExportCsvBuilder();
        } else if (t.equalsIgnoreCase("html")) {
            return new ExporterHtmlBuilder();
        } else if (t.equalsIgnoreCase("excelSaga")) {
            return new ExportObjectBuilder();
        }
        else {
            throw new IllegalArgumentException("Invalid File Extension");
        }
        return null;
    }

    public abstract ExportFileBuilder setFile(File file);

    public abstract void tableExporter() throws Exception;
}
