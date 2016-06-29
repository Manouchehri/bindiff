/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import org.jfree.ui.SortableTableModel;
import org.jfree.ui.about.SystemPropertiesTableModel$SystemProperty;
import org.jfree.ui.about.SystemPropertiesTableModel$SystemPropertyComparator;

public class SystemPropertiesTableModel
extends SortableTableModel {
    private List properties = new ArrayList();
    private String nameColumnLabel;
    private String valueColumnLabel;

    public SystemPropertiesTableModel() {
        Object object;
        try {
            object = System.getProperties();
            for (String string : object.keySet()) {
                String string2 = System.getProperty(string);
                SystemPropertiesTableModel$SystemProperty systemPropertiesTableModel$SystemProperty = new SystemPropertiesTableModel$SystemProperty(string, string2);
                this.properties.add(systemPropertiesTableModel$SystemProperty);
            }
        }
        catch (SecurityException var1_2) {
            // empty catch block
        }
        Collections.sort(this.properties, new SystemPropertiesTableModel$SystemPropertyComparator(true));
        object = "org.jfree.ui.about.resources.AboutResources";
        ResourceBundle resourceBundle = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        this.nameColumnLabel = resourceBundle.getString("system-properties-table.column.name");
        this.valueColumnLabel = resourceBundle.getString("system-properties-table.column.value");
    }

    @Override
    public boolean isSortable(int n2) {
        if (n2 != 0) return false;
        return true;
    }

    @Override
    public int getRowCount() {
        return this.properties.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int n2) {
        if (n2 != 0) return this.valueColumnLabel;
        return this.nameColumnLabel;
    }

    @Override
    public Object getValueAt(int n2, int n3) {
        SystemPropertiesTableModel$SystemProperty systemPropertiesTableModel$SystemProperty = (SystemPropertiesTableModel$SystemProperty)this.properties.get(n2);
        if (n3 == 0) {
            return systemPropertiesTableModel$SystemProperty.getName();
        }
        if (n3 != 1) return null;
        return systemPropertiesTableModel$SystemProperty.getValue();
    }

    @Override
    public void sortByColumn(int n2, boolean bl2) {
        if (!this.isSortable(n2)) return;
        super.sortByColumn(n2, bl2);
        Collections.sort(this.properties, new SystemPropertiesTableModel$SystemPropertyComparator(bl2));
    }
}

