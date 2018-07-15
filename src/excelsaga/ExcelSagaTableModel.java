/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelsaga;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hdlucas
 */
public class ExcelSagaTableModel extends AbstractTableModel{

    public static final int COLS = 26;
    public static final int ROWS = 30;
    private Object[][] objects;


    public ExcelSagaTableModel() {
        objects = new Object[ROWS][COLS];
    }
    
    public int getSize() {
        return ROWS;
    }

    @Override
    public int getRowCount() {
        return ROWS;
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return objects[rowIndex][columnIndex];
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue instanceof Object) {
            Object object = (Object) aValue;
            objects[rowIndex][columnIndex] = object;
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
    
}
