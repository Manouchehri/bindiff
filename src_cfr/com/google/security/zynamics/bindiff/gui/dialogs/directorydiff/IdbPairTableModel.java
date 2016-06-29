/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DiffPairTableData;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.comparators.JCheckBoxComparator;
import com.google.security.zynamics.zylib.general.comparators.LexicalComparator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

public class IdbPairTableModel
extends AbstractTableModel {
    public static final int SELECTION = 0;
    public static final int IDB_NAME = 1;
    public static final int IDB_LOCATION = 2;
    public static final int DIFF_DESTINATION_DIR = 3;
    private final String[] COLUMNS = new String[]{"", "IDB Name", "IDB Location", "Diff Destination (Editable)"};
    private final List sorters = new ArrayList();
    private List tableData = new ArrayList();

    public IdbPairTableModel() {
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
    public String getColumnName(int n2) {
        return this.COLUMNS[n2];
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
    public Object getValueAt(int n2, int n3) {
        DiffPairTableData diffPairTableData = (DiffPairTableData)this.tableData.get(n2);
        switch (n3) {
            case 0: {
                return diffPairTableData.getSelectionCheckBox();
            }
            case 1: {
                return diffPairTableData.getIDBName();
            }
            case 2: {
                String string;
                String string2 = String.valueOf(diffPairTableData.getIDBLocation());
                if (string2.length() != 0) {
                    string = ".".concat(string2);
                    return string;
                }
                string = new String(".");
                return string;
            }
            case 3: {
                return diffPairTableData.getDestinationDirectory();
            }
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int n2, int n3) {
        if (n3 == 0) return true;
        if (n3 == 3) return true;
        return false;
    }

    public void setTableData(List list) {
        this.tableData = list;
        this.fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object object, int n2, int n3) {
        if (n3 == 0) {
            boolean bl2 = ((JCheckBox)object).isSelected();
            ((DiffPairTableData)this.tableData.get(n2)).getSelectionCheckBox().setSelected(bl2);
            return;
        }
        if (n3 != 3) return;
        ((DiffPairTableData)this.tableData.get(n2)).setDestinationDirectory((String)object);
    }
}

