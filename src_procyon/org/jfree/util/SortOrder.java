package org.jfree.util;

import java.io.*;

public final class SortOrder implements Serializable
{
    private static final long serialVersionUID = -2124469847758108312L;
    public static final SortOrder ASCENDING;
    public static final SortOrder DESCENDING;
    private String name;
    
    private SortOrder(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof SortOrder && this.name.equals(((SortOrder)o).toString()));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        if (this.equals(SortOrder.ASCENDING)) {
            return SortOrder.ASCENDING;
        }
        if (this.equals(SortOrder.DESCENDING)) {
            return SortOrder.DESCENDING;
        }
        return null;
    }
    
    static {
        ASCENDING = new SortOrder("SortOrder.ASCENDING");
        DESCENDING = new SortOrder("SortOrder.DESCENDING");
    }
}
