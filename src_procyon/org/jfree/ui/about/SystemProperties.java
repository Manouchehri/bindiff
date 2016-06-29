package org.jfree.ui.about;

import org.jfree.ui.*;
import javax.swing.table.*;

public class SystemProperties
{
    public static SortableTable createSystemPropertiesTable() {
        final SortableTable sortableTable = new SortableTable(new SystemPropertiesTableModel());
        final TableColumnModel columnModel = sortableTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(350);
        sortableTable.setAutoResizeMode(2);
        return sortableTable;
    }
}
