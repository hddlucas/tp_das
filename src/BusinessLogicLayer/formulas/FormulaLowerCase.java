/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.formulas;

import static GraphicalUserInterface.ExcelSaga.excelSagaTableModel;

/**
 *
 * @author hdlucas
 */
public class FormulaLowerCase extends Formula{

    @Override
    public String getFormulaResult(String[] params,boolean rangeInterval) {
        try {
            validateNumberOfParams(params,rangeInterval);

            columnName = params[0].replaceAll("\\d", "").toUpperCase();
            columnIndex= excelSagaTableModel.findColumn(columnName);
            rowIndex = Integer.parseInt( params[0].replaceAll("\\D+",""));

            newCellValue=excelSagaTableModel.getValueAt(rowIndex-1, columnIndex).toString().toLowerCase();
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return invalidFormula;
        } catch (Exception e) {
            return invalidFormula;
        }
        
        return newCellValue;
    }

    @Override
    public void validateNumberOfParams(String[] params,boolean rangeInterval) throws ArrayIndexOutOfBoundsException {
        if (params.length != 1) {
            throw new ArrayIndexOutOfBoundsException("Out of Bounds Exc. Size is 1");
        }
    }
    
}
