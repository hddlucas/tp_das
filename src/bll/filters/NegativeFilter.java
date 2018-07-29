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
public class NegativeFilter extends Filter {

    public NegativeFilter(Cell c) {
        super(c);
    }
    
    @Override
    public String getChanges(String param) {
        try {
            int currentValue = Integer.parseInt(cell.getValue().toString());
             if(currentValue > 0)
                return " ";
        } catch (NumberFormatException e) {
        }
        
        return cell.getValue().toString();
    }
    
    @Override
    public String getName() {
        return "negative";
    }
    
}
