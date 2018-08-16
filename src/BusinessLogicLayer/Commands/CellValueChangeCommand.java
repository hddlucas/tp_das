/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Commands;

import static GraphicalUserInterface.ExcelSaga.excelSagaTableModel;

/**
 *
 * @author hdlucas
 */
public class CellValueChangeCommand implements Command {

    protected Object value, savedValue;
    int row, col;
    protected Cell cell;
    

    public CellValueChangeCommand(Cell cell, Object value) { //CONTRUCTOR USED ON MACRO
        this.cell = cell;
        this.value = value; //FIELD NECESSARY TO MACRO
    }
    
    public CellValueChangeCommand(Cell cell) { // CONSTRUCTOR USED ON UNDO AND REDO
        this.cell = cell;
        this.value = null;
    }

    @Override
    public void execute() {
        this.row = cell.getRow();
        this.col = cell.getColumn();
        
        //IF ISN'T A MACRO GET VALUE FROM THIS WAY
        if(this.value == null)
            this.value = excelSagaTableModel.getValueAt(row, col);
        
        else //IF IS A MACRO PRINT VALUE ON TABLE
            excelSagaTableModel.setValueAt(this.value, row, col,true);
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
