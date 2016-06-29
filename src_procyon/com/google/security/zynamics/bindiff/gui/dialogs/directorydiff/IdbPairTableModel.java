package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import javax.swing.table.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.general.comparators.*;
import javax.swing.*;

public class IdbPairTableModel extends AbstractTableModel
{
    public static final int SELECTION = 0;
    public static final int IDB_NAME = 1;
    public static final int IDB_LOCATION = 2;
    public static final int DIFF_DESTINATION_DIR = 3;
    private final String[] COLUMNS;
    private final List sorters;
    private List tableData;
    
    public IdbPairTableModel() {
        this.COLUMNS = new String[] { "", "IDB Name", "IDB Location", "Diff Destination (Editable)" };
        this.sorters = new ArrayList();
        this.tableData = new ArrayList();
        this.initSorters();
    }
    
    private void initSorters() {
        this.sorters.add(new Pair(0, new JCheckBoxComparator()));
        this.sorters.add(new Pair(1, new LexicalComparator()));
        this.sorters.add(new Pair(2, new LexicalComparator()));
        this.sorters.add(new Pair(3, new LexicalComparator()));
    }
    
    @Override
    public int getColumnCount() {
        return this.COLUMNS.length;
    }
    
    @Override
    public String getColumnName(final int n) {
        return this.COLUMNS[n];
    }
    
    @Override
    public int getRowCount() {
        return this.tableData.size();
    }
    
    public List getSorters() {
        return this.sorters;
    }
    
    public List getTableData() {
        return this.tableData;
    }
    
    @Override
    public Object getValueAt(final int n, final int n2) {
        final DiffPairTableData diffPairTableData = this.tableData.get(n);
        switch (n2) {
            case 0: {
                return diffPairTableData.getSelectionCheckBox();
            }
            case 1: {
                return diffPairTableData.getIDBName();
            }
            case 2: {
                final String s = ".";
                final String value = String.valueOf(diffPairTableData.getIDBLocation());
                return (value.length() != 0) ? s.concat(value) : new String(s);
            }
            case 3: {
                return diffPairTableData.getDestinationDirectory();
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public boolean isCellEditable(final int n, final int n2) {
        return n2 == 0 || n2 == 3;
    }
    
    public void setTableData(final List tableData) {
        this.tableData = tableData;
        this.fireTableDataChanged();
    }
    
    @Override
    public void setValueAt(final Object o, final int n, final int n2) {
        if (n2 == 0) {
            this.tableData.get(n).getSelectionCheckBox().setSelected(((JCheckBox)o).isSelected());
        }
        else if (n2 == 3) {
            this.tableData.get(n).setDestinationDirectory((String)o);
        }
    }
}
