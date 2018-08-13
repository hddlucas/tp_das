/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.filters;

import bll.commands.Cell;

/**
 *
 * @author hdlucas
 */
public abstract class Filter extends Cell {
    protected Cell cell;
    protected String parameter;
    
     public Filter(Cell c) {
        super(c);
        //this.previousCell = c;
        this.cell = c;         
    }
    
     public Cell getCell() {
        return cell;
    }
    
    public abstract String getChanges(String param);
    
    @Override
    public String getValue () {
        return getChanges(parameter);
    }
    
    public abstract String getName();
    
    public String getParameter () {
        return this.parameter;
    }
    
    public void setParameter(String p){
        this.parameter = p;
    }
}
