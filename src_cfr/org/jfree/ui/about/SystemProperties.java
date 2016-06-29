/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jfree.ui.SortableTable;
import org.jfree.ui.SortableTableModel;
import org.jfree.ui.about.SystemPropertiesTableModel;

public class SystemProperties {
    private SystemProperties() {
    }

    public static SortableTable createSystemPropertiesTable() {
        SystemPropertiesTableModel systemPropertiesTableModel = new SystemPropertiesTableModel();
        SortableTable sortableTable = new SortableTable(systemPropertiesTableModel);
        TableColumnModel tableColumnModel = sortableTable.getColumnModel();
        TableColumn tableColumn = tableColumnModel.getColumn(0);
        tableColumn.setPreferredWidth(200);
        tableColumn = tableColumnModel.getColumn(1);
        tableColumn.setPreferredWidth(350);
        sortableTable.setAutoResizeMode(2);
        return sortableTable;
    }
}

