/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.formulas;

/**
 *
 * @author hdlucas
 */
public abstract class Formula {
    protected  String newCellValue="";
    protected  String invalidFormula="#REF";
    protected int columnIndex;
    protected int rowIndex;
    protected String columnName;
    
    public abstract void validateNumberOfParams(String[] params);
    public abstract String getFormulaResult(String[] params);
    
}
