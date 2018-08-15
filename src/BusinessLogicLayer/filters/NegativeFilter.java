/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.filters;

import BusinessLogicLayer.commands.Cell;

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
            //IF USER PUT PARAMETER - ON THIS FILTER ISN'T NEEDED
            //THIS VERIFICATION ONLY FOR VISUALISATION OF PARAMETER VALUE ON WINDOW
            this.parameterValue = "";
            this.parameter = "";
            
            double currentValue = Double.parseDouble(cell.getValue().toString());
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
