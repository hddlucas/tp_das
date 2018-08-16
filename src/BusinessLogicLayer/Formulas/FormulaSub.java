/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Formulas;

import static GraphicalUserInterface.ExcelSaga.excelSagaTableModel;

/**
 *
 * @author hdlucas
 */
public class FormulaSub extends Formula {

    @Override
    public String getFormulaResult(String[] params, boolean rangeInterval) {
        try {
            validateNumberOfParams(params, rangeInterval);
            double sub = 0;
            if (!rangeInterval) {
                for (int i = 0; i < params.length; i++) {
                    columnName = params[i].replaceAll("\\d", "").toUpperCase();
                    columnIndex = excelSagaTableModel.findColumn(columnName);
                    rowIndex = Integer.parseInt(params[i].replaceAll("\\D+", ""));
                    if (i != 0) {
                        sub -= Double.parseDouble(excelSagaTableModel.getValueAt(rowIndex - 1, columnIndex).toString());
                    } else {
                        sub += Double.parseDouble(excelSagaTableModel.getValueAt(rowIndex - 1, columnIndex).toString());
                    }
                }
            } else {
                columnName1 = params[0].replaceAll("\\d", "").toUpperCase();
                columnIndex1 = excelSagaTableModel.findColumn(columnName1);
                rowIndex1 = Integer.parseInt(params[0].replaceAll("\\D+", ""));
                columnName2 = params[1].replaceAll("\\d", "").toUpperCase();
                columnIndex2 = excelSagaTableModel.findColumn(columnName2);
                rowIndex2 = Integer.parseInt(params[1].replaceAll("\\D+", ""));

                if (columnIndex1 == columnIndex2 && rowIndex1 == rowIndex2) {
                    return String.valueOf(0.0);
                } else if (columnIndex1 == columnIndex2) {
                    if (rowIndex1 < rowIndex2) {
                        for (int k = rowIndex1; k <= rowIndex2; k++) {
                            if (k == rowIndex1) {
                                sub += Double.parseDouble(excelSagaTableModel.getValueAt(k - 1, columnIndex1).toString());
                            } else {
                                sub -= Double.parseDouble(excelSagaTableModel.getValueAt(k - 1, columnIndex1).toString());
                            }
                        }
                    } else {
                        for (int k = rowIndex1; k >= rowIndex2; k--) {
                            if (k == rowIndex1) {
                                sub += Double.parseDouble(excelSagaTableModel.getValueAt(k - 1, columnIndex1).toString());
                            } else {
                                sub -= Double.parseDouble(excelSagaTableModel.getValueAt(k - 1, columnIndex1).toString());
                            }
                        }
                    }
                } else if (rowIndex1 == rowIndex2) {
                    if (columnIndex1 < columnIndex2) {
                        for (int k = columnIndex1; k <= columnIndex2; k++) {
                            if (k == columnIndex1) {
                                sub += Double.parseDouble(excelSagaTableModel.getValueAt(rowIndex1 - 1, k).toString());
                            } else {
                                sub -= Double.parseDouble(excelSagaTableModel.getValueAt(rowIndex1 - 1, k).toString());
                            }
                        }
                    } else {
                        for (int k = columnIndex1; k >= columnIndex2; k--) {
                            if (k == columnIndex1) {
                                sub += Double.parseDouble(excelSagaTableModel.getValueAt(rowIndex1 - 1, k).toString());
                            } else {
                                sub -= Double.parseDouble(excelSagaTableModel.getValueAt(rowIndex1 - 1, k).toString());
                            }
                        }
                    }
                } else {
                    //TODO   
                }
            }
            newCellValue = String.valueOf(sub);

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
