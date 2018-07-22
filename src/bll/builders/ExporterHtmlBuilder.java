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
public class ExporterHtmlBuilder extends ExportFileBuilder {

    protected File f;
    
    private String cssString = "<style>\n" + 
            "table.blueTable {\n" +
                "  border: 1px solid #1C6EA4;\n" +
                "  background-color: #EEEEEE;\n" +
                "  width: 100%;\n" +
                "  text-align: left;\n" +
                "  border-collapse: collapse;\n" +
                "}\n" +
                "table.blueTable td, table.blueTable th {\n" +
                "  border: 1px solid #AAAAAA;\n" +
                "  padding: 3px 2px;\n" +
                "}\n" +
                "table.blueTable tbody td {\n" +
                "  font-size: 13px;\n" +
                "}\n" +
                "table.blueTable tr:nth-child(even) {\n" +
                "  background: #D0E4F5;\n" +
                "}\n" +
                "table.blueTable thead {\n" +
                "  background: #1C6EA4;\n" +
                "  background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);\n" +
                "  background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);\n" +
                "  background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);\n" +
                "  border-bottom: 2px solid #444444;\n" +
                "}\n" +
                "table.blueTable thead th {\n" +
                "  font-size: 15px;\n" +
                "  font-weight: bold;\n" +
                "  color: #FFFFFF;\n" +
                "  border-left: 2px solid #D0E4F5;\n" +
                "}\n" +
                "table.blueTable thead th:first-child {\n" +
                "  border-left: none;\n" +
                "}\n" +
                "\n" +
                "table.blueTable tfoot {\n" +
                "  font-size: 14px;\n" +
                "  font-weight: bold;\n" +
                "  color: #FFFFFF;\n" +
                "  background: #D0E4F5;\n" +
                "  background: -moz-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);\n" +
                "  background: -webkit-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);\n" +
                "  background: linear-gradient(to bottom, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);\n" +
                "  border-top: 2px solid #444444;\n" +
                "}\n" +
                "table.blueTable tfoot td {\n" +
                "  font-size: 14px;\n" +
                "}\n" +
                "table.blueTable tfoot .links {\n" +
                "  text-align: right;\n" +
                "}\n" +
                "table.blueTable tfoot .links a{\n" +
                "  display: inline-block;\n" +
                "  background: #1C6EA4;\n" +
                "  color: #FFFFFF;\n" +
                "  padding: 2px 8px;\n" +
                "  border-radius: 5px;\n" +
                "}"
            + "</style>\n";
    
    private String fileHeader = "<!DOCTYPE html>\n"
            + "<html>\n"
            + "<head>\n"
            + cssString 
            + "</head>\n"
            + "<body>\n"
            + "\n"
            + "<table class=\"blueTable\">\n";
        
    private String fileFinal = "</table>\n"
            + "\n"
            + "</body>\n"
            + "</html>";
    
    @Override
    public ExportFileBuilder setFile(File file) {
        this.f = file;
        return this;
    }

    @Override
    public void tableExporter() throws Exception {
        
        String toAppend = "";
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.f));
        
        writer.append(fileHeader);
       
        Vector<Vector> rowData = excelSagaTableModel.getDataVector();
              
        for (int x =0 ;x<rowData.size();x++){
            toAppend += "<tr>";
            for(int k=0;k<rowData.get(x).size();k++){
               
                String cellValue = (String) rowData.get(x).get(k);
                if(cellValue == null) {
                    cellValue = " ";
                }
                
                toAppend += "<td>" + cellValue + "</td>";
                //if (k != (excelSagaTableModel.getColumnCount() - 1)) {
                //    writer.append(",");
                //}
            }
            toAppend += "</tr>";
        }
        writer.append(toAppend);
        writer.append(fileFinal);
        writer.close();    
    }
    
}
