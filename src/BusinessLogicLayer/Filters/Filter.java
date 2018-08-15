/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Filters;

import BusinessLogicLayer.Commands.Cell;
import ExcelSaga.Facade;

/**
 *
 * @author hdlucas
 */
public abstract class Filter extends Cell {
    protected Cell cell;
    protected String parameter;
    protected String parameterValue;
    
     public Filter(Cell c) {
        super(c);
        this.cell = c;
    }
    
     public Cell getCell() {
        return cell;
    }
    
    public abstract String getChanges(String parameterValue);
    
    @Override
    public String getValue () {
        return getChanges(parameterValue);
    }
    
    public abstract String getName();
    
    public String getParameter () {
        return this.parameter;
    }
    
    public String getParameterValue () {
        return this.parameterValue;
    }
    
    public void setParameter(String p){
        //VERIFY IF PARAMETER IS A FORMULA
        if (p != null && !"".equals(p)) {
            if (p.charAt(0) == '=') {
                try {
                    String[] formula = p.split(" ", 2);
                    //System.out.println(Arrays.toString(formula));
                    String formulaName = formula[0].replace("=", "").toUpperCase();
                    String[]params;
                    if(formula[1].contains(":")){
                        params=formula[1].split(":");
                        this.parameterValue = Facade.applyFormula(formulaName,params,true);
                    }
                    else{
                        params=formula[1].split(" ");
                        this.parameterValue = Facade.applyFormula(formulaName,params,false);
                    }
                } catch (Exception ex) {
                }
            }
            else {
                this.parameterValue = p;
            }
        }
        
        this.parameter = p;
    }
}
