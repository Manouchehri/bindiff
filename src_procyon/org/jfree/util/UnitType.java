package org.jfree.util;

import java.io.*;

public final class UnitType implements Serializable
{
    private static final long serialVersionUID = 6531925392288519884L;
    public static final UnitType ABSOLUTE;
    public static final UnitType RELATIVE;
    private String name;
    
    private UnitType(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof UnitType && this.name.equals(((UnitType)o).name));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        if (this.equals(UnitType.ABSOLUTE)) {
            return UnitType.ABSOLUTE;
        }
        if (this.equals(UnitType.RELATIVE)) {
            return UnitType.RELATIVE;
        }
        return null;
    }
    
    static {
        ABSOLUTE = new UnitType("UnitType.ABSOLUTE");
        RELATIVE = new UnitType("UnitType.RELATIVE");
    }
}
