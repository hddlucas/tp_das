/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Models;

import bll.commands.Cell;
import bll.filters.Filter;
import excelsaga.Facade;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author MarcoSequeira-PC
 */
public class FilterListModel extends AbstractListModel<String> {
    ArrayList<Filter> list = new ArrayList<>();
    Cell c;
    Cell auxCell;
    
    public FilterListModel(Cell ce) {
        auxCell = ce;
        Cell aux = ce;
        while( aux instanceof Filter ) {
            list.add((Filter)aux);
            aux = ((Filter)aux).getCell();
        }
        c = aux;
    }
    
    public Filter getFilterByIndex (int index) {
        return list.get(index);
    }
    
    public void addFilter(String name, String parameter) {
        Cell toFilter;
        if( list.isEmpty() ) {
            toFilter = c;
        } else {
            toFilter = list.get(0);
        }
        
        auxCell.setValue(toFilter.getValue());
        System.out.println("prev = " + auxCell.getValue());
        
        Filter f = Facade.addFilter(name, parameter, toFilter);
        list.add(0,f);
        
        fireIntervalAdded(this, 0, 0);
    }
    
    @Override
    public int getSize() {
        return list.size();
    }
     @Override
    public String getElementAt(int index) {
        return list.get(index).getName();
    }
    
    public void removeFilter(int index) {
        if( list.isEmpty() ) {
            return;
        }
        
        Facade.removeFilter(this.getElementAt(index), this.c, list.get(index));
        list.remove(index);
        fireIntervalRemoved(this, 0, 0);
    }
    
}