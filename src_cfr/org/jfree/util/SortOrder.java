/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.Serializable;

public final class SortOrder
implements Serializable {
    private static final long serialVersionUID = -2124469847758108312L;
    public static final SortOrder ASCENDING = new SortOrder("SortOrder.ASCENDING");
    public static final SortOrder DESCENDING = new SortOrder("SortOrder.DESCENDING");
    private String name;

    private SortOrder(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SortOrder)) {
            return false;
        }
        SortOrder sortOrder = (SortOrder)object;
        if (this.name.equals(sortOrder.toString())) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(ASCENDING)) {
            return ASCENDING;
        }
        if (!this.equals(DESCENDING)) return null;
        return DESCENDING;
    }
}

