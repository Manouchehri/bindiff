package org.jfree.ui.about;

import java.util.*;

public class SystemPropertiesTableModel$SystemPropertyComparator implements Comparator
{
    private boolean ascending;
    
    public SystemPropertiesTableModel$SystemPropertyComparator(final boolean ascending) {
        this.ascending = ascending;
    }
    
    public int compare(final Object o, final Object o2) {
        if (!(o instanceof SystemPropertiesTableModel$SystemProperty) || !(o2 instanceof SystemPropertiesTableModel$SystemProperty)) {
            return 0;
        }
        final SystemPropertiesTableModel$SystemProperty systemPropertiesTableModel$SystemProperty = (SystemPropertiesTableModel$SystemProperty)o;
        final SystemPropertiesTableModel$SystemProperty systemPropertiesTableModel$SystemProperty2 = (SystemPropertiesTableModel$SystemProperty)o2;
        if (this.ascending) {
            return systemPropertiesTableModel$SystemProperty.getName().compareTo(systemPropertiesTableModel$SystemProperty2.getName());
        }
        return systemPropertiesTableModel$SystemProperty2.getName().compareTo(systemPropertiesTableModel$SystemProperty.getName());
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof SystemPropertiesTableModel$SystemPropertyComparator && this.ascending == ((SystemPropertiesTableModel$SystemPropertyComparator)o).ascending);
    }
    
    public int hashCode() {
        return this.ascending ? 1 : 0;
    }
}
