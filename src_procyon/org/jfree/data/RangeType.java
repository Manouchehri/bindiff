package org.jfree.data;

import java.io.*;

public final class RangeType implements Serializable
{
    private static final long serialVersionUID = -9073319010650549239L;
    public static final RangeType FULL;
    public static final RangeType POSITIVE;
    public static final RangeType NEGATIVE;
    private String name;
    
    private RangeType(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof RangeType && this.name.equals(((RangeType)o).toString()));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        if (this.equals(RangeType.FULL)) {
            return RangeType.FULL;
        }
        if (this.equals(RangeType.POSITIVE)) {
            return RangeType.POSITIVE;
        }
        if (this.equals(RangeType.NEGATIVE)) {
            return RangeType.NEGATIVE;
        }
        return null;
    }
    
    static {
        FULL = new RangeType("RangeType.FULL");
        POSITIVE = new RangeType("RangeType.POSITIVE");
        NEGATIVE = new RangeType("RangeType.NEGATIVE");
    }
}
