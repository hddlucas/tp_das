/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.commands;

import BusinessLogicLayer.commands.MacroCommand;
import ExcelSaga.Facade;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author MarcoSequeira-PC
 */
public class RecordsListModel extends AbstractListModel<String> {
    ArrayList<MacroCommand> list = new ArrayList<>();
    
    public RecordsListModel() {
        this.list = (ArrayList<MacroCommand>) Facade.getMacroRecording();
        
    }
    
    public MacroCommand getFilterByIndex (int index) {
        return list.get(index);
    }
    
    @Override
    public int getSize() {
        return list.size();
    }
     @Override
    public String getElementAt(int index) {
        return list.get(index).getName();
    }
}
