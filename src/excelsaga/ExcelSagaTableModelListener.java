/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelsaga;

import bll.commands.Cell;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author hdlucas
 */
public class ExcelSagaTableModelListener implements TableModelListener {

    ExcelSagaTableModel model;

    public ExcelSagaTableModelListener(JTable table) {
        model = (ExcelSagaTableModel) table.getModel();
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        if(row !=-1 && column!=-1){
        
        //String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        
        //execute command
        Cell cell = new Cell(row, column, data);    
        Facade.execute(cell);
        
        System.out.println("Row: " + String.valueOf(row) + " Column: " + String.valueOf(column)+ " Data: " + data);
        }
    }

}
