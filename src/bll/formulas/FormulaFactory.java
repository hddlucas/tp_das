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
public class FormulaFactory {

    public Formula getFormula(String formulaName) {
        if (formulaName == null) {
            return null;
        }
        if (formulaName.equalsIgnoreCase("MAIUSCULAS")) {
            return new FormulaUpperCase();
        }
        if (formulaName.equalsIgnoreCase("MINUSCULAS")) {
            return new FormulaLowerCase();

        } else if (formulaName.equalsIgnoreCase("SOMA")) {
            return new FormulaSum();
            
        } else if (formulaName.equalsIgnoreCase("MUL")) {
            return new FormulaMul();
       
        } else if (formulaName.equalsIgnoreCase("NUMERO")) {
            return new FormulaNumber();
        }
        
        return null;
    }
}
