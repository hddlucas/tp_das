/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelsaga;

import bll.adapters.ImportFileAdapter;
import bll.builders.ExportFileBuilder;
import bll.commands.Cell;
import bll.commands.CellValueChangeCommand;
import bll.commands.CommandManager;
import bll.filters.Filter;
import bll.filters.FilterFactory;
import bll.formulas.Formula;
import bll.formulas.FormulaFactory;
import bll.strategy.ViewStrategy;
import data.Controllers.UsersController;
import data.Controllers.UsersControllerImpl;
import data.Models.User;
import static gui.ExcelSaga.excelSagaTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hdlucas
 */
public class Facade {

    private static final UsersController users = new UsersControllerImpl();
    private static final User user = new User();
    private static final CommandManager cm = new CommandManager();

    public static List<User> getUsersList() {
        List<User> usersList = new ArrayList<>();
        try {
            return users.getUsersList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public static boolean login(String name, String password) {
        try {
            return users.login(name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkIfUserExists(String name) {
        try {
            return users.checkIfUserExists(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void create(String name, String password) {
        try {
            users.create(name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUserLoggedIn() {
        try {
            return user.getUserLoggedIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void execute(Cell cell) {
        CellValueChangeCommand command = new CellValueChangeCommand(cell);
        cm.execute(command);
    }

    public static void undo() {
        cm.undo();
    }
    
    public static void redo() {
        cm.redo();
    }
    
    
    public static void importFile(File file,String extension){
        new ImportFileAdapter(extension).importFile(file);
    }
    
    
    public static void exportFile(String type, File file) throws Exception {
        ExportFileBuilder builder = ExportFileBuilder.getBuilderByType(type).setFile(file);
        builder.tableExporter();
    }
    
    public static String applyFormula(String formulaName,String[] params,boolean rangeInterval){
        FormulaFactory formulaFactory = new FormulaFactory();
        Formula formula = formulaFactory.getFormula(formulaName);
        return formula.getFormulaResult(params,rangeInterval);
    }
    
    public static void setViewMode(ViewStrategy viewStrategy){
        excelSagaTableModel.setStrategy(viewStrategy);
    }
    
    public static Filter addFilter(String name, String param, Cell cellFilter) {
        //GET OBJECT FILTER FROM FACTORY
        Filter f = FilterFactory.getFilter(name, cellFilter);
        if(f != null) {
            //CHANGE VALUE OF EXCEL TABLE
            excelSagaTableModel.setValueAt(f.getChanges(param), cellFilter.getRow(), cellFilter.getColumn(), true);
           
            //TODO
            //DEFINE PARAMETER OF FILTER
            //f.setParameter(param, f.getChanges(cellFilter.getValue().toString()));
            //Facade.execute((Cell) f);
            System.out.println("param : addFilkter = " + param);
            
        }
        return f;
    }
    
    public static void removeFilter(String name, String param, Cell cellFilter) {
        //GET OBJECT FILTER FROM FACTORY
        Filter f = FilterFactory.getFilter(name, cellFilter);
        if(f != null) {
            //DEFINE PARAMETER OF FILTER
            //Facade.execute((Cell) f);
            //CHANGE VALUE OF EXCEL TABLE
            excelSagaTableModel.setValueAt(f.getChanges(cellFilter.getValue().toString()), cellFilter.getRow(), cellFilter.getColumn(), true);
        }
    }
}
