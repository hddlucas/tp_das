/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer.Builders;

import static GraphicalUserInterface.ExcelSaga.excelSagaTableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author hdlucas
 */
public class ExportObjectBuilder extends ExportFileBuilder {

    protected File f;

    @Override
    public ExportFileBuilder setBuilder(File file) {
        this.f = file;
        return this;
    }

    @Override
    public void tableExporter() throws Exception {
        try {
            FileOutputStream fos = new FileOutputStream(f.getAbsolutePath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(excelSagaTableModel.getDataVector());
            oos.flush();
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
