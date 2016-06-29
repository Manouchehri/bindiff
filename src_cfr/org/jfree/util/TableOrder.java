/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.Serializable;

public final class TableOrder
implements Serializable {
    private static final long serialVersionUID = 525193294068177057L;
    public static final TableOrder BY_ROW = new TableOrder("TableOrder.BY_ROW");
    public static final TableOrder BY_COLUMN = new TableOrder("TableOrder.BY_COLUMN");
    private String name;

    private TableOrder(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TableOrder)) {
            return false;
        }
        TableOrder tableOrder = (TableOrder)object;
        if (this.name.equals(tableOrder.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(BY_ROW)) {
            return BY_ROW;
        }
        if (!this.equals(BY_COLUMN)) return null;
        return BY_COLUMN;
    }
}

