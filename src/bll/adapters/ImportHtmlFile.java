/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.adapters;

import static gui.ExcelSaga.excelSagaTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author hdlucas
 */
public class ImportHtmlFile extends ImportFile {

    @Override
    public void importFile(File file) {

        BufferedReader reader = null;
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        Vector<Vector> rowData = new Vector<Vector>();
        int j = 1;
        try {
            reader = new BufferedReader(new FileReader(file));

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            String htmlString = stringBuilder.toString();

            reader.close();

            Document doc = Jsoup.parse(htmlString);
            Element table = doc.select("table").get(0); //select the first table.
            Elements rows = table.select("tr");

            for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                Vector<String> rowVector = new Vector<String>();

                Element row = rows.get(i);
                Elements cols = row.select("td");
                for (j = 1; j < cols.size(); j++) {
                    rowVector.addElement(cols.get(j).text());
                }
                rowData.add(rowVector);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ImportHtmlFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        Vector<String> columnNames = new Vector<String>();
        for (int k = 0; k < j; k++) {
            columnNames.addElement("Column " + j);
        }
        
        excelSagaTableModel.setDataVector(rowData, columnNames);
    }
}
