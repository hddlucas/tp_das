/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Adapters;

import static GraphicalUserInterface.ExcelSaga.excelSagaTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author hdlucas
 */
public class ImportCsvFile extends ImportFile {

    @Override
    public void importFile(File file) {
       
        Vector<Vector> rowData = new Vector<Vector>();
        String line = "";
        int i=0;
        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {

            while ((line = br.readLine()) != null) {
             Vector<String> row = new Vector<String>();
                // use comma as separator
                String[] columns = line.split(",",-1);
                
                for(i=0;i<columns.length;i++){
                    row.addElement(columns[i]);
                }
                rowData.add(row);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Vector<String> columnNames = new Vector<String>();
        for(int j=0;j<i;j++){
            columnNames.addElement("Column "+j);
        }
        
        excelSagaTableModel.setDataVector(rowData,columnNames);
    }
}
