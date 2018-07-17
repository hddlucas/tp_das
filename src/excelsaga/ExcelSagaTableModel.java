package excelsaga;

import java.io.Serializable;
import java.util.Vector;
import javax.swing.AbstractListModel;
import javax.swing.ListModel;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hdlucas
 */
public class ExcelSagaTableModel extends AbstractTableModel implements Serializable {

    protected Vector dataVector;
    protected Vector columnIdentifiers;
    protected int[] headers;
    public static final int COLS = 5;
    public static final int ROWS = 10;
    
    public ExcelSagaTableModel() {
        this(0, 0);
    }

    private static Vector newVector(int size) {
        Vector v = new Vector(size);
        v.setSize(size);
        return v;
    }

    public ExcelSagaTableModel(int rowCount, int columnCount) {
        this(newVector(columnCount), rowCount);
    }

    public ExcelSagaTableModel(Vector columnNames, int rowCount) {
        setDataVector(newVector(rowCount), columnNames);
    }

    public ExcelSagaTableModel(Object[] columnNames, int rowCount) {
        this(convertToVector(columnNames), rowCount);
    }

    public ExcelSagaTableModel(Vector data, Vector columnNames) {
        setDataVector(data, columnNames);
    }

    public ExcelSagaTableModel(Object[][] data, Object[] columnNames) {
        setDataVector(data, columnNames);
    }

    public Vector getDataVector() {
        return dataVector;
    }

    private static Vector nonNullVector(Vector v) {
        return (v != null) ? v : new Vector();
    }

    public void setDataVector(Vector dataVector, Vector columnIdentifiers) {
        this.dataVector = nonNullVector(dataVector);
        this.columnIdentifiers = nonNullVector(columnIdentifiers);
        justifyRows(0, getRowCount());
        fireTableStructureChanged();
    }

    public void setDataVector(Object[][] dataVector, Object[] columnIdentifiers) {
        setDataVector(convertToVector(dataVector), convertToVector(columnIdentifiers));
    }

    public void newDataAvailable(TableModelEvent event) {
        fireTableChanged(event);
    }

    private void justifyRows(int from, int to) {
        dataVector.setSize(getRowCount());

        for (int i = from; i < to; i++) {
            if (dataVector.elementAt(i) == null) {
                dataVector.setElementAt(new Vector(), i);
            }
            ((Vector) dataVector.elementAt(i)).setSize(getColumnCount());
        }
    }

    public void setNumRows(int rowCount) {
        int old = getRowCount();
        if (old == rowCount) {
            return;
        }
        dataVector.setSize(rowCount);
        if (rowCount <= old) {
            fireTableRowsDeleted(rowCount, old - 1);
        } else {
            justifyRows(old, rowCount);
            fireTableRowsInserted(old, rowCount - 1);
        }
    }

    public void setRowCount(int rowCount) {
        setNumRows(rowCount);
    }

    public void setColumnIdentifiers(Vector columnIdentifiers) {
        setDataVector(dataVector, columnIdentifiers);
    }

    public void setColumnIdentifiers(Object[] newIdentifiers) {
        setColumnIdentifiers(convertToVector(newIdentifiers));
    }

    public void setColumnCount(int columnCount) {
        columnIdentifiers.setSize(columnCount);
        justifyRows(0, getRowCount());
        fireTableStructureChanged();
    }

    @Override
    public int getRowCount() {
        return dataVector.size();
    }

    @Override
    public int getColumnCount() {
        return columnIdentifiers.size();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Vector rowVector = (Vector) dataVector.elementAt(row);
        return rowVector.elementAt(column);
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Vector rowVector = (Vector) dataVector.elementAt(row);
        rowVector.setElementAt(aValue, column);
        fireTableCellUpdated(row, column);
    }

    public ListModel getHeaders() {
        headers = new int[ROWS];
        for (int i = 0; i < headers.length; i++) {
            headers[i] = i + 1;
        }

        ListModel lm = new AbstractListModel() {
            public int getSize() {
                return ROWS;
            }

            public Object getElementAt(int index) {
                return headers[index];
            }
        };

        return lm;
    }

    protected static Vector convertToVector(Object[] anArray) {
        if (anArray == null) {
            return null;
        }
        Vector<Object> v = new Vector<Object>(anArray.length);
        for (Object o : anArray) {
            v.addElement(o);
        }
        return v;
    }

    protected static Vector convertToVector(Object[][] anArray) {
        if (anArray == null) {
            return null;
        }
        Vector<Vector> v = new Vector<Vector>(anArray.length);
        for (Object[] o : anArray) {
            v.addElement(convertToVector(o));
        }
        return v;
    }
}
