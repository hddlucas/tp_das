/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Filters;

import BusinessLogicLayer.Common.Cell;

/**
 *
 * @author MarcoSequeira-PC
 */
public class MinorFilter extends Filter {

    public MinorFilter(Cell c) {
        super(c);
    }
    
    @Override
    public String getChanges(String param) {
        try {
            double currentValue = Double.parseDouble(cell.getValue().toString());
            double p = Double.parseDouble(param);
             if(currentValue >= p)
                return "";
        } catch (NumberFormatException e) {
            return " ";
        }
        return cell.getValue().toString();
    }
    
    @Override
    public String getName() {
        return "minor";
    }
    
}
