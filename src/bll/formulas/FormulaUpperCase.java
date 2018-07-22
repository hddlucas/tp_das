/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.formulas;

import static gui.ExcelSaga.excelSagaTableModel;

/**
 *
 * @author hdlucas
 */
public class FormulaUpperCase extends Formula {

    @Override
    public String getFormulaResult(String[] params) {
        try {
            validateNumberOfParams(params);

            columnName = params[0].replaceAll("\\d", "");
            columnIndex= excelSagaTableModel.findColumn(columnName);
            rowIndex = Integer.parseInt( params[0].replaceAll("\\D+",""));

            newCellValue=excelSagaTableModel.getValueAt(rowIndex-1, columnIndex).toString().toUpperCase();
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds Exc. Expected Number of Parameters is 1");
            return invalidFormula;
        } catch (Exception e) {
            return invalidFormula;
        }
        
        return newCellValue;
    }

    @Override
    public void validateNumberOfParams(String[] params) throws ArrayIndexOutOfBoundsException {
        if (params.length != 1) {
            throw new ArrayIndexOutOfBoundsException("Out of Bounds Exc. Size is 1");
        }
    }
}
