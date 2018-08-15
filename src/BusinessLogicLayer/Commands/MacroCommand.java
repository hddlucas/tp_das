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
 * @author MarcoSequeira-PC
 */
public class MacroCommand {
    String name;
    List<Command> commandList = new ArrayList<>();
    
    public void add(Command comando) {
        commandList.add(comando);
    }
    
    public void play(CommandManager cm) {
        //EXECUTE COMMANDS FROM MACRO
        commandList.forEach((c) -> {
            cm.execute(c);
        });
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
