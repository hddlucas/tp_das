/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExcelSaga;

import BusinessLogicLayer.Adapters.ImportFileAdapter;
import BusinessLogicLayer.Builders.ExportFileBuilder;
import BusinessLogicLayer.Commands.Cell;
import BusinessLogicLayer.Commands.CellValueChangeCommand;
import BusinessLogicLayer.Commands.CommandManager;
import BusinessLogicLayer.Commands.MacroCommand;
import BusinessLogicLayer.Filters.Filter;
import BusinessLogicLayer.Filters.FilterFactory;
import BusinessLogicLayer.Formulas.FormulaFactory;
import BusinessLogicLayer.Strategy.ViewStrategy;
import DataAccessLayer.DataAccessObjects.FilesDaoImpl;
import DataAccessLayer.DataAccessObjects.UsersDaoImpl;
import DataAccessLayer.Models.User;
import static GraphicalUserInterface.ExcelSaga.excelSagaTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

/**
 *
 * @author hdlucas
 */
public class Facade {

    private static final UsersDaoImpl users = new UsersDaoImpl();
    private static final FilesDaoImpl files = new FilesDaoImpl();
    private static final User user = new User();
    private static final CommandManager cm = new CommandManager();
    private static final List<MacroCommand> macroList = new ArrayList<>();
    public static MacroCommand macro = null;

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
            if (users.login(name, password) != null) {
                user.setUserLoggedIn(users.login(name, password));
                return true;
            }
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

    public static List<String> getRecentFiles() {
        try {
            if (user != null) {
                return files.getRecentFiles(getUserLoggedIn());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return Collections.emptyList();
    }
    
    public static void saveFile(File file) {
        try {
            if (user != null) {
                files.saveFile(file, getUserLoggedIn());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void execute(Cell cell, Object value) {
        //IF IS RUNNING MACRO
        if (macro != null) {
            //USE THIS CONSTRUCTOR WHEN IS RECORDING MACRO
            CellValueChangeCommand command = new CellValueChangeCommand(cell, value);
            macro.add(command);
        }
        else {
            //USE THIS CONSTRUCTOR WHEN ISN'T RECORDING MACRO
            CellValueChangeCommand command = new CellValueChangeCommand(cell);
            cm.execute(command);
        }
    }

    public static void undo() {
        cm.undo();
    }

    public static void redo() {
        cm.redo();
    }

    public static void importFile(File file, String extension) {
        new ImportFileAdapter(extension).importFile(file);
    }

    public static void exportFile(String type, File file) throws Exception {
        ExportFileBuilder builder = ExportFileBuilder.getBuilder(type).setBuilder(file);
        builder.tableExporter();
    }

    public static String applyFormula(String formulaName, String[] params, boolean rangeInterval) {
        FormulaFactory formulaFactory = new FormulaFactory();
        return formulaFactory.getFormula(formulaName).getFormulaResult(params, rangeInterval);
    }

    public static void setViewMode(ViewStrategy viewStrategy) {
        excelSagaTableModel.setStrategy(viewStrategy);
    }

    public static Filter addFilter(String name, String param, Cell cellFilter) {
        //GET OBJECT FILTER FROM FACTORY
        Filter f = FilterFactory.getFilter(name, cellFilter);

        int column = cellFilter.getColumn();
        int row = cellFilter.getRow();
        Boolean alreadyExist = false;

        if (f != null) {
            //VERIFY IF FILTER ALREADY EXIST TO SELECTED CELL
            for (Iterator<Cell> iter = excelSagaTableModel.getCellList().listIterator(); iter.hasNext();) {
                Cell aux = iter.next();
                if (aux.getColumn() == column && aux.getRow() == row) {
                    if (aux.getClass() == f.getClass()) {
                        alreadyExist = true;
                    }
                }
            }

            if (!alreadyExist) {
                //DEFINE PARAMETER OF FILTER
                f.setParameter(param);

                //CHANGE VALUE OF EXCEL TABLE
                excelSagaTableModel.setValueAtFilter(f);
            } else
                return null;
        }
        return f;
    }

    public static void removeFilter(String name, Cell cellFilter, Filter fi) {
        //GET OBJECT FILTER FROM FACTORY
        Filter f = FilterFactory.getFilter(name, cellFilter);
        if (f != null) {
            int column = cellFilter.getColumn();
            int row = cellFilter.getRow();

            //REMOVE CELL OF THIS FILTER
            for (Iterator<Cell> iter = excelSagaTableModel.getCellList().listIterator(); iter.hasNext(); ) {
                Cell aux = iter.next();
                if (aux.getColumn() == column && aux.getRow() == row) {
                    if(aux.getClass() == fi.getClass()) {
                        iter.remove();
                    }
                }
            }   
                        
            Facade.execute((Cell) f, null);

            //CHANGE VALUE OF CELL ON TABLE TO PREVIOUS VALUE
            excelSagaTableModel.setValueAt(cellFilter.getValue(), cellFilter.getRow(), cellFilter.getColumn(), true);
        }
    }
    public static void editFilter (String name, Cell cellFilter, Filter fi, String parameter) {
        
        excelSagaTableModel.setValueAtFilter(fi);
    }
    
    public static void playMacro(MacroCommand m) {
        m.play(cm);
    }
    
    public static List<MacroCommand> getMacroRecording() {
        return macroList;
    }
    
    public static void startMacroRecording() {
        macro = new MacroCommand();
    }
    
    public static void stopMacroRecording(String name) {
        if (name != null) {
            if( !name.isEmpty() ) {
                macro.setName(name);
            }
            macroList.add(macro);
        }
        //WHEN NULL - NOT MACRO RECORDING
        macro = null;
    }
    
    public static void removeMacro (MacroCommand mc) {
        macroList.remove(mc);
//        macroList.forEach((ml) -> {
//        if(name.equals(ml.getName()))
//            macroList.remove(ml);
//        });
    }
        
    public static MacroCommand getMacro() {
        return macro;
    }
}
