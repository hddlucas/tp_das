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

    protected File f;
    
    @Override
    public ExportFileBuilder setBuilder(File file) {
        this.f = file;
        return this;
    }

    @Override
    public void tableExporter() throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.f));
       
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
