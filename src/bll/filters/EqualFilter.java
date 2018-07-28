/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.filters;

import bll.commands.Cell;

/**
 *
 * @author MarcoSequeira-PC
 */
public class EqualFilter extends Filter {

    public EqualFilter(Cell cell) {
        super(cell);
    }
    
    @Override
    public String getChanges(String param) {
         String currentValue = cell.getValue().toString();
        
        if(param.equals(currentValue)) {
            return currentValue;
        }
        
        return "";
    }
     @Override
    public String getName() {
        return "equal";
    }
    
}
