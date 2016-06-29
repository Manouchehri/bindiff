/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.util.Comparator;
import org.jfree.ui.about.SystemPropertiesTableModel$SystemProperty;

public class SystemPropertiesTableModel$SystemPropertyComparator
implements Comparator {
    private boolean ascending;

    public SystemPropertiesTableModel$SystemPropertyComparator(boolean bl2) {
        this.ascending = bl2;
    }

    public int compare(Object object, Object object2) {
        if (!(object instanceof SystemPropertiesTableModel$SystemProperty)) return 0;
        if (!(object2 instanceof SystemPropertiesTableModel$SystemProperty)) return 0;
        SystemPropertiesTableModel$SystemProperty systemPropertiesTableModel$SystemProperty = (SystemPropertiesTableModel$SystemProperty)object;
        SystemPropertiesTableModel$SystemProperty systemPropertiesTableModel$SystemProperty2 = (SystemPropertiesTableModel$SystemProperty)object2;
        if (!this.ascending) return systemPropertiesTableModel$SystemProperty2.getName().compareTo(systemPropertiesTableModel$SystemProperty.getName());
        return systemPropertiesTableModel$SystemProperty.getName().compareTo(systemPropertiesTableModel$SystemProperty2.getName());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SystemPropertiesTableModel$SystemPropertyComparator)) {
            return false;
        }
        SystemPropertiesTableModel$SystemPropertyComparator systemPropertiesTableModel$SystemPropertyComparator = (SystemPropertiesTableModel$SystemPropertyComparator)object;
        if (this.ascending == systemPropertiesTableModel$SystemPropertyComparator.ascending) return true;
        return false;
    }

    public int hashCode() {
        if (!this.ascending) return 0;
        return 1;
    }
}

