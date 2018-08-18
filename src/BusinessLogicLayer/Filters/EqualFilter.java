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
public class EqualFilter extends Filter {

    public EqualFilter(Cell cell) {
        super(cell);
    }
    
    @Override
    public String getChanges(String param) {
        //IF IS A NUMBER
        try {
            double currentValue = Double.parseDouble(cell.getValue().toString());
            double parmDouble = Double.parseDouble(param);

            if(parmDouble == currentValue) {
                return Double.toString(currentValue);
            }
        } catch (NumberFormatException ne) {
            //IF IS A STRING
            if(param.equals(cell.getValue().toString())) {
                return cell.getValue().toString();
            }
        }
        
        return "";
    }
    
     @Override
    public String getName() {
        return "equal";
    }
    
}
