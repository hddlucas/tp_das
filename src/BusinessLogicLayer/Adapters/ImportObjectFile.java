/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Adapters;

import static GraphicalUserInterface.ExcelSaga.excelSagaTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hdlucas
 */
public class ImportObjectFile extends ImportFile {

    @Override
    public void importFile(File file) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fin);
            Vector<Vector> rowData = (Vector<Vector>) ois.readObject();
            Vector<String> columnNames = new Vector<String>();
           
            for (int j = 0; j < rowData.get(0).size(); j++) {
                columnNames.addElement("Column " + j);
            }

            excelSagaTableModel.setDataVector(rowData, columnNames);

        } catch (Exception ex) {
            Logger.getLogger(ImportObjectFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fin.close();
            } catch (IOException ex) {
                Logger.getLogger(ImportObjectFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
