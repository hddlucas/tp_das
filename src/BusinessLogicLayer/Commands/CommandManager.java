/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Commands;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hdlucas
 */
public class CommandManager {

    List<Command> undoList = new ArrayList<>();
    List<Command> redoList = new ArrayList<>();

    public CommandManager() {
    }

    public void execute(Command c) {
        c.execute();
        redoList.clear();
        undoList.add(c);
    }

    public void undo() {
        if (undoList.isEmpty()) {
            return;
        }
        Command last = undoList.remove(undoList.size() - 1);
        last.undo();
        redoList.add(last);
    }
    
     public void redo() {
        if (redoList.isEmpty()) {
            return;
        }
        Command next = redoList.remove(redoList.size() - 1);
        next.redo();
        undoList.add(next);
    }
}
