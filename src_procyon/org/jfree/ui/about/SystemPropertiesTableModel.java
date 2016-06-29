package org.jfree.ui.about;

import org.jfree.ui.*;
import java.util.*;

public class SystemPropertiesTableModel extends SortableTableModel
{
    private List properties;
    private String nameColumnLabel;
    private String valueColumnLabel;
    
    public SystemPropertiesTableModel() {
        this.properties = new ArrayList();
        try {
            for (final String s : ((Hashtable<String, V>)System.getProperties()).keySet()) {
                this.properties.add(new SystemPropertiesTableModel$SystemProperty(s, System.getProperty(s)));
            }
        }
        catch (SecurityException ex) {}
        Collections.sort((List<Object>)this.properties, new SystemPropertiesTableModel$SystemPropertyComparator(true));
        final ResourceBundle bundle = ResourceBundle.getBundle("org.jfree.ui.about.resources.AboutResources");
        this.nameColumnLabel = bundle.getString("system-properties-table.column.name");
        this.valueColumnLabel = bundle.getString("system-properties-table.column.value");
    }
    
    public boolean isSortable(final int n) {
        return n == 0;
    }
    
    public int getRowCount() {
        return this.properties.size();
    }
    
    public int getColumnCount() {
        return 2;
    }
    
    public String getColumnName(final int n) {
        if (n == 0) {
            return this.nameColumnLabel;
        }
        return this.valueColumnLabel;
    }
    
    public Object getValueAt(final int n, final int n2) {
        final SystemPropertiesTableModel$SystemProperty systemPropertiesTableModel$SystemProperty = this.properties.get(n);
        if (n2 == 0) {
            return systemPropertiesTableModel$SystemProperty.getName();
        }
        if (n2 == 1) {
            return systemPropertiesTableModel$SystemProperty.getValue();
        }
        return null;
    }
    
    public void sortByColumn(final int n, final boolean b) {
        if (this.isSortable(n)) {
            super.sortByColumn(n, b);
            Collections.sort((List<Object>)this.properties, new SystemPropertiesTableModel$SystemPropertyComparator(b));
        }
    }
}
