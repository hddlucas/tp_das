/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.strategy;

import BusinessLogicLayer.commands.Cell;
import ExcelSaga.Facade;

/**
 *
 * @author hdlucas
 */
public class NormalMode implements ViewStrategy{

    @Override
    public Object getCellValue(int row,int column,Object aValue){
        //formula
        if (aValue != null && !"".equals(aValue.toString())) {
            if (aValue.toString().charAt(0) == '=') {
                try {
                    String[] formula = aValue.toString().split(" ", 2);
                    //System.out.println(Arrays.toString(formula));
                    String formulaName = formula[0].replace("=", "").toUpperCase();
                    String[]params;
                    if(formula[1].contains(":")){
                        params=formula[1].split(":");
                        aValue = Facade.applyFormula(formulaName,params,true);
                    }
                    else{
                        params=formula[1].split(" ");
                        aValue = Facade.applyFormula(formulaName,params,false);
                    }
                    //System.out.println(Arrays.toString(params));
                } catch (Exception ex) {
                }
            }
        }
        
        return aValue;
    }
    
}
