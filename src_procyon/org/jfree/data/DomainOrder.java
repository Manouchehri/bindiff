package org.jfree.data;

import java.io.*;

public final class DomainOrder implements Serializable
{
    private static final long serialVersionUID = 4902774943512072627L;
    public static final DomainOrder NONE;
    public static final DomainOrder ASCENDING;
    public static final DomainOrder DESCENDING;
    private String name;
    
    private DomainOrder(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof DomainOrder && this.name.equals(((DomainOrder)o).toString()));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        if (this.equals(DomainOrder.ASCENDING)) {
            return DomainOrder.ASCENDING;
        }
        if (this.equals(DomainOrder.DESCENDING)) {
            return DomainOrder.DESCENDING;
        }
        if (this.equals(DomainOrder.NONE)) {
            return DomainOrder.NONE;
        }
        return null;
    }
    
    static {
        NONE = new DomainOrder("DomainOrder.NONE");
        ASCENDING = new DomainOrder("DomainOrder.ASCENDING");
        DESCENDING = new DomainOrder("DomainOrder.DESCENDING");
    }
}
