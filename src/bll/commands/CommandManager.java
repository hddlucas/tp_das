/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.commands;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hdlucas
 */
public class CommandManager {
    
    List<Command> undoList = new ArrayList<Command>();
    List<Command> redoList = new ArrayList<Command>();

    
    public CommandManager() {
    }
    
    void apply(Command c){
        //TODO
        //c.do(modelo);
        redoList.clear();
        undoList.clear();
    }
    
    void undo(){
        if(undoList.isEmpty()) return;
        Command last = undoList.remove(undoList.size()-1);
        //TODO
        //last.undo(modelo);
        redoList.add(last);
    }

}
