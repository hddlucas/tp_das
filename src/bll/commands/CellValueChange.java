/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.commands;

import excelsaga.ExcelSagaTableModel;
import java.util.Vector;

/**
 *
 * @author hdlucas
 */
public class CellValueChange implements Command{
    protected Vector current;
    protected Vector previous;
    protected Vector dataVector;

    public CellValueChange(Vector data){
        dataVector = data;
    }
    
    @Override
    public void execute(ExcelSagaTableModel tm) {
        previous= getCurrent();
        setCurrent(tm.getDataVector());
    }

    @Override
    public void undo(ExcelSagaTableModel tm) {
        setCurrent(previous);
        current = tm.getDataVector();
    }
    
    //Getters and Setters
    public Vector getCurrent() {
        return current;
    }

    public void setCurrent(Vector current) {
        this.current = current;
    }

    public Vector getPrevious() {
        return previous;
    }

    public void setPrevious(Vector previous) {
        this.previous = previous;
    }
    
    
}
