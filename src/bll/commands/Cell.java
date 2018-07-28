/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.commands;

/**
 *
 * @author hdlucas
 */
public class Cell {

    //Private Fields
    private int row;
    private int column;
    private Object value;
    
    //Constructor
    public Cell(int row, int column, Object value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }
    
    public Cell (Cell c) {
        this.row = c.getRow();
        this.column = c.getColumn();
        this.value = c.getValue();
    }
    
    //Getters and Setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
