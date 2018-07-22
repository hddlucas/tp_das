/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.commands;

import static gui.ExcelSaga.excelSagaTableModel;

/**
 *
 * @author hdlucas
 */
public class CellValueChange implements Command {

    protected Object value, savedValue;
    int row, col;
    protected Cell cell;

    public CellValueChange(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void execute() {
        this.row = cell.getRow();
        this.col = cell.getColumn();
        this.value = excelSagaTableModel.getValueAt(row, col);
    }

    @Override
    public void undo() {
        savedValue = excelSagaTableModel.getValueAt(row, col);
        excelSagaTableModel.setValueAt(value, row, col,true);
    }

    @Override
    public void redo() {
        if (savedValue != null) {
            excelSagaTableModel.setValueAt(savedValue, row, col,true);
            savedValue = null;
        }
    }
}
