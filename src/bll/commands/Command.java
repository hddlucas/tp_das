/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.commands;

import excelsaga.ExcelSagaTableModel;

/**
 *
 * @author hdlucas
 */
public interface Command {
    
    void execute(Cell cell);
    void undo(Cell cell);
    
}
