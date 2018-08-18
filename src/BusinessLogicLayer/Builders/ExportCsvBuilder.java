/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Builders;

import static GraphicalUserInterface.ExcelSaga.excelSagaTableModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;

/**
 *
 * @author MarcoSequeira-PC
 */
public class ExportCsvBuilder extends ExportFileBuilder {
   
    @Override
    public void exportTableToFile() throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(super.fileToExport.getFile()));
       
        Vector<Vector> rowData = excelSagaTableModel.getDataVector();
              
        for (int x =0 ;x<rowData.size();x++){
            for(int k=0;k<rowData.get(x).size();k++){
               
                String s = (String) rowData.get(x).get(k);
                if(s == null) {
                    s = " ";
                }
                
                writer.append(s);
                if (k != (excelSagaTableModel.getColumnCount() - 1)) {
                    writer.append(",");
                }
            }
            writer.append("\n");
        }
        writer.close();
    }

}
