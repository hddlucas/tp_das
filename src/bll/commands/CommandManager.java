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

    List<Command> undoList = new ArrayList<>();
    List<Command> redoList = new ArrayList<>();
    Cell cell;

    public CommandManager() {
    }

    public CommandManager(Cell cell) {
        this.cell = cell;
    }

    public void execute(Command c) {
        c.execute(cell);
        redoList.clear();
        undoList.add(c);
    }

    public void undo() {
        if (undoList.isEmpty()) {
            return;
        }
        Command last = undoList.remove(undoList.size() - 1);
        last.undo(cell);
        redoList.add(last);
    }
}
