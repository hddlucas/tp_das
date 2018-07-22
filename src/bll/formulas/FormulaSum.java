/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.formulas;

import static gui.ExcelSaga.excelSagaTableModel;
import java.util.Arrays;

/**
 *
 * @author hdlucas
 */
public class FormulaSum extends Formula {

    @Override
    public String getFormulaResult(String[] params, boolean rangeInterval) {
        try {
            validateNumberOfParams(params,rangeInterval);
            double sum = 0;
            if (!rangeInterval) {
                for (int i = 0; i < params.length; i++) {
                    columnName = params[i].replaceAll("\\d", "").toUpperCase();
                    columnIndex = excelSagaTableModel.findColumn(columnName);
                    rowIndex = Integer.parseInt(params[i].replaceAll("\\D+", ""));
                    sum += Double.parseDouble(excelSagaTableModel.getValueAt(rowIndex - 1, columnIndex).toString());
                    System.out.println(sum);
                }
            } else {
                System.out.println("range");
            }
            newCellValue = String.valueOf(sum);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return invalidFormula;
        } catch (Exception e) {
            return invalidFormula;
        }

        return newCellValue;
    }

    @Override
    public void validateNumberOfParams(String[] params, boolean rangeInterval) throws ArrayIndexOutOfBoundsException {
        if (rangeInterval) {
            if (params.length != 2) {
                throw new ArrayIndexOutOfBoundsException("Out of Bounds Exc. Size for range interval is 2");
            }
        } else {
            if (params.length < 2) {
                throw new ArrayIndexOutOfBoundsException("Out of Bounds Exc. Size is greater than 1");
            }
        }
    }

}
