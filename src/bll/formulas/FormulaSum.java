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
            validateNumberOfParams(params, rangeInterval);
            double sum = 0;
            if (!rangeInterval) {
                for (int i = 0; i < params.length; i++) {
                    columnName = params[i].replaceAll("\\d", "").toUpperCase();
                    columnIndex = excelSagaTableModel.findColumn(columnName);
                    rowIndex = Integer.parseInt(params[i].replaceAll("\\D+", ""));
                    sum += Double.parseDouble(excelSagaTableModel.getValueAt(rowIndex - 1, columnIndex).toString());
                }
            } else {
                String columnName1 = params[0].replaceAll("\\d", "").toUpperCase();
                int columnIndex1 = excelSagaTableModel.findColumn(columnName1);
                int rowIndex1 = Integer.parseInt(params[0].replaceAll("\\D+", ""));
                String columnName2 = params[1].replaceAll("\\d", "").toUpperCase();
                int columnIndex2 = excelSagaTableModel.findColumn(columnName2);
                int rowIndex2 = Integer.parseInt(params[1].replaceAll("\\D+", ""));

                if (columnIndex1 == columnIndex2 && rowIndex1 == rowIndex2) {
                    columnName = params[0].replaceAll("\\d", "").toUpperCase();
                    columnIndex = excelSagaTableModel.findColumn(columnName);
                    rowIndex = Integer.parseInt(params[0].replaceAll("\\D+", ""));
                    return String.valueOf(Double.parseDouble(excelSagaTableModel.getValueAt(rowIndex - 1, columnIndex).toString()));
                } else if (columnIndex1 == columnIndex2) {
                    if (rowIndex1 < rowIndex2) {
                        for (int k = rowIndex1; k <= rowIndex2; k++) {
                            sum += Double.parseDouble(excelSagaTableModel.getValueAt(k - 1, columnIndex1).toString());
                        }
                    } else {
                        for (int k = rowIndex1; k >= rowIndex2; k--) {
                            System.out.println(k);
                            sum += Double.parseDouble(excelSagaTableModel.getValueAt(k - 1, columnIndex1).toString());
                        }
                    }
                } else {
                     //TODO   
                }
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
