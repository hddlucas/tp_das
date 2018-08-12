/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.builders;

import static gui.ExcelSaga.excelSagaTableModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;

/**
 *
 * @author MarcoSequeira-PC
 */
public class ExportTxtBuilder extends ExportFileBuilder {

    protected File f = null;
    
    @Override
    public ExportFileBuilder setBuilder(File file) {
        this.f = file;
        return this;
    }

    @Override
    public void tableExporter() throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.f));
       
        Vector<Vector> rowData = excelSagaTableModel.getDataVector();
        String columnName = "";
        String nameColumns = "";
        nameColumns += "Row\\Column|";
        
        for (int cn =0 ;cn < excelSagaTableModel.getColumnCount();cn++){
            columnName = excelSagaTableModel.getColumnName(cn);
            nameColumns += columnName;
            for (int i = 0; i < 9; i++) {
                nameColumns += " ";
            }
            nameColumns += "|";
        }
        
        nameColumns += "\n";
        
        writer.append(nameColumns);

        Integer rowNumber;
        
        if(rowData.size() > 0) {
            for(int c =0; c < rowData.get(0).size();c++){
                writer.append("-----------");
            }
        }
        writer.append("-----------\n");
        
        for (int x =0 ;x<rowData.size();x++){
            
            rowNumber = x+1;
            if(rowNumber < 10)
                writer.append(rowNumber.toString() + "         |");
            else
                writer.append(rowNumber.toString() + "        |");
            for(int k=0;k<rowData.get(x).size();k++){
                String s = (String) rowData.get(x).get(k);
                if(s == null) {
                    s = " ";
                }
                writer.append(s);
                if(s.length() < 10) {
                    for (int i = 0; i < (10-s.length()); i++) {
                        writer.append(" ");
                    }
                }
                
                writer.append("|");
            }
            writer.append("\n");
            if(rowData.size() > 0) {
                for(int c =0; c < rowData.get(0).size();c++){
                    writer.append("-----------");
                }
            }
            writer.append("-----------");

            writer.append("\n");
        }
        writer.close();
    }
    
}
