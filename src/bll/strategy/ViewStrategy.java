/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.strategy;

import bll.commands.Cell;

/**
 *
 * @author hdlucas
 */
public interface ViewStrategy {
    Object getCellValue(int row,int column,Object aValue);
}
