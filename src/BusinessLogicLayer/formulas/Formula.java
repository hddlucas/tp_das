/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.formulas;

/**
 *
 * @author hdlucas
 */
public abstract class Formula {
    protected  String newCellValue="";
    protected  String invalidFormula="#REF";
    protected int columnIndex,columnIndex1,columnIndex2;
    protected int rowIndex,rowIndex1,rowIndex2;
    protected String columnName,columnName1,columnName2;
    
    public abstract void validateNumberOfParams(String[] params,boolean rangeInterval);
    public abstract String getFormulaResult(String[] params,boolean rangeInterval);
    
}
