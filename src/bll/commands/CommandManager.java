/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.commands;

import excelsaga.ExcelSagaTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hdlucas
 */
public class CommandManager {
    
    List<Command> undoList = new ArrayList<Command>();
    List<Command> redoList = new ArrayList<Command>();
    ExcelSagaTableModel excelSagaTableModel;
    
    public CommandManager(ExcelSagaTableModel tm) {
        excelSagaTableModel=tm;
    }
    
    public void execute(Command c){
        c.execute(excelSagaTableModel);
        redoList.clear();
        undoList.add(c);
    }
    
    public void undo(){
        if(undoList.isEmpty()) return;
        Command last = undoList.remove(undoList.size()-1);
        last.undo(excelSagaTableModel);
        redoList.add(last);
    }

}
