/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;

public final class DomainOrder
implements Serializable {
    private static final long serialVersionUID = 4902774943512072627L;
    public static final DomainOrder NONE = new DomainOrder("DomainOrder.NONE");
    public static final DomainOrder ASCENDING = new DomainOrder("DomainOrder.ASCENDING");
    public static final DomainOrder DESCENDING = new DomainOrder("DomainOrder.DESCENDING");
    private String name;

    private DomainOrder(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DomainOrder)) {
            return false;
        }
        DomainOrder domainOrder = (DomainOrder)object;
        if (this.name.equals(domainOrder.toString())) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(ASCENDING)) {
            return ASCENDING;
        }
        if (this.equals(DESCENDING)) {
            return DESCENDING;
        }
        if (!this.equals(NONE)) return null;
        return NONE;
    }
}

