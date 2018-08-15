/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Filters;

import BusinessLogicLayer.Commands.Cell;
import BusinessLogicLayer.Filters.Filter;
import ExcelSaga.Facade;
import static GraphicalUserInterface.ExcelSaga.excelSagaTableModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author MarcoSequeira-PC
 */
public class FilterListModel extends AbstractListModel<String> {
    ArrayList<Filter> list = new ArrayList<>();
    Cell c;

    public FilterListModel(Cell ce) {
        if(ce != null) {
            this.c = ce;
            Cell aux = ce;
            ArrayList <Cell> auxList = new ArrayList <>();

            for (Iterator<Cell> iter = excelSagaTableModel.getCellList().listIterator(); iter.hasNext(); ) {
                Cell iterAux = iter.next();
                if (iterAux.getColumn() == aux.getColumn() && iterAux.getRow() == aux.getRow()) {
                    auxList.add(iterAux);
                }
            }

            if(auxList.size() > 0) {
                for ( int i = 0; i < auxList.size(); i++) {
                    if(auxList.get(i) instanceof Filter) {                    
                        list.add((Filter)auxList.get(i));
                    }
                }
            }
        }        
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
                
        Filter f = Facade.addFilter(name, parameter, toFilter);
        
        //VERIFY IF ALREADY EXIST SELECTED FILTER TO SELECTED CELL
        if(f != null) {
            list.add(0,f);
            fireIntervalAdded(this, 0, 0);
        }
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
    
    public void editFilter (int index, String p) {
        if( list.isEmpty() ) {
            return;
        }

        //CHANGE PARAMETER VALUE
        list.get(index).setParameter(p);

        Facade.editFilter(this.getElementAt(index), this.c, list.get(index), p);
    }
    
}