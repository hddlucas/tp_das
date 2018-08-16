/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Formulas;

/**
 *
 * @author hdlucas
 */
public class FormulaFactory {

    public Formula getFormula(String formulaName) {
        if (formulaName == null) {
            return null;
        }
        if (formulaName.equalsIgnoreCase("MAIUSCULAS") || formulaName.equalsIgnoreCase("UPPERCASE")) {
            return new FormulaUpperCase();
        }
        if (formulaName.equalsIgnoreCase("MINUSCULAS") || formulaName.equalsIgnoreCase("LOWERCASE")) {
            return new FormulaLowerCase();
        } else if (formulaName.equalsIgnoreCase("SOMA") || formulaName.equalsIgnoreCase("SUM")) {
            return new FormulaSum();
        } else if (formulaName.equalsIgnoreCase("SUB") || formulaName.equalsIgnoreCase("SUBTRACAO") || formulaName.equalsIgnoreCase("SUBTRAÇÃO")) {
            return new FormulaSub();
        } else if (formulaName.equalsIgnoreCase("MUL") || formulaName.equalsIgnoreCase("MULTIPLICACAO") || formulaName.equalsIgnoreCase("MULTIPLICAÇÃO")) {
            return new FormulaMul();
        } else if (formulaName.equalsIgnoreCase("COPIA") || formulaName.equalsIgnoreCase("CÓPIA") || formulaName.equalsIgnoreCase("COPY")) {
            return new FormulaCopy();
        }

        return null;
    }
}
