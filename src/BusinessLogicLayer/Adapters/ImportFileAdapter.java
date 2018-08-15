/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Adapters;

import java.io.File;

/**
 *
 * @author hdlucas
 */
public class ImportFileAdapter extends ImportFile{
    
    ImportFile fileReaderDecorated;
    
    public ImportFileAdapter(String fileExtension){
        if(fileExtension.equalsIgnoreCase("csv")){
            fileReaderDecorated = new ImportCsvFile();
        }else if(fileExtension.equalsIgnoreCase("excelSaga")){
            fileReaderDecorated = new ImportObjectFile();
        }
        else if (fileExtension.equalsIgnoreCase("txt")){
            fileReaderDecorated = new ImportTxtFile();
        }
        else if (fileExtension.equalsIgnoreCase("html")){
            fileReaderDecorated = new ImportHtmlFile();
        }
    }

    @Override
    public void importFile(File file) {
        fileReaderDecorated.importFile(file);
    }
}
