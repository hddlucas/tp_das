/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.commands;

import excelsaga.ExcelSagaTableModel;
import static gui.ExcelSaga.excelSagaTableModel;

/**
 *
 * @author hdlucas
 */
public class CellValueChange implements Command{
    protected Cell current;
    protected Cell previous;
    protected Cell cell;

    public CellValueChange(Cell cell){
        current = cell;
    }
    
    @Override
    public void execute(Cell cell) {

    }

    @Override
    public void undo(Cell cell) {
        current = previous;
        excelSagaTableModel.setValueAt(previous.getValue(), previous.getRow(), previous.getColumn());
    }
}
