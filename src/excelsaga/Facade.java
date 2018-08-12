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
import bll.commands.MacroCommand;
import bll.filters.Filter;
import bll.filters.FilterFactory;
import bll.formulas.Formula;
import bll.formulas.FormulaFactory;
import bll.strategy.ViewStrategy;
import data.Controllers.FilesController;
import data.Controllers.FilesControllerImpl;
import data.Controllers.UsersController;
import data.Controllers.UsersControllerImpl;
import data.Models.User;
import static gui.ExcelSaga.excelSagaTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hdlucas
 */
public class Facade {

    private static final UsersController users = new UsersControllerImpl();
    private static final FilesController files = new FilesControllerImpl();
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
        ExportFileBuilder builder = ExportFileBuilder.getBuilderByType(type).setFile(file);
        builder.tableExporter();
    }

    public static String applyFormula(String formulaName, String[] params, boolean rangeInterval) {
        FormulaFactory formulaFactory = new FormulaFactory();
        Formula formula = formulaFactory.getFormula(formulaName);
        return formula.getFormulaResult(params, rangeInterval);
    }

    public static void setViewMode(ViewStrategy viewStrategy) {
        excelSagaTableModel.setStrategy(viewStrategy);
    }

    public static Filter addFilter(String name, String param, Cell cellFilter) {
        //GET OBJECT FILTER FROM FACTORY
        Filter f = FilterFactory.getFilter(name, cellFilter);
        if (f != null) {
            //CHANGE VALUE OF EXCEL TABLE
            excelSagaTableModel.setValueAt(f.getChanges(param), cellFilter.getRow(), cellFilter.getColumn(), true);

            //TODO
            //DEFINE PARAMETER OF FILTER
            f.setParameter(param, f.getChanges(cellFilter.getValue().toString()));
            //Facade.execute((Cell) f);
            
            
            
            System.out.println("param : addFilkter = " + param);

        }
        return f;
    }

    public static void removeFilter(String name, Cell cellFilter, Filter fi) {
        //GET OBJECT FILTER FROM FACTORY
        Filter f = FilterFactory.getFilter(name, cellFilter);
        if (f != null) {
            //DEFINE PARAMETER OF FILTER
            //Facade.execute((Cell) f);
            //CHANGE VALUE OF EXCEL TABLE

            String value = fi.getPreviousValue();
            excelSagaTableModel.setValueAt(value, cellFilter.getRow(), cellFilter.getColumn(), true);
        }
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
