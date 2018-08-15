/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Filters;

import BusinessLogicLayer.Commands.Cell;

/**
 *
 * @author MarcoSequeira-PC
 */
public class UppercaseFilter extends Filter {

    public UppercaseFilter(Cell cell) {
        super(cell);
    }
    
    @Override
    public String getChanges(String param) {
        return cell.getValue().toString().toUpperCase();
    }
     @Override
    public String getName() {
        return "uppercase";
    }
    
}
