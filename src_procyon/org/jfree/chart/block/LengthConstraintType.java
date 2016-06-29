package org.jfree.chart.block;

import java.io.*;

public final class LengthConstraintType implements Serializable
{
    private static final long serialVersionUID = -1156658804028142978L;
    public static final LengthConstraintType NONE;
    public static final LengthConstraintType RANGE;
    public static final LengthConstraintType FIXED;
    private String name;
    
    private LengthConstraintType(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof LengthConstraintType && this.name.equals(((LengthConstraintType)o).toString()));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        if (this.equals(LengthConstraintType.NONE)) {
            return LengthConstraintType.NONE;
        }
        if (this.equals(LengthConstraintType.RANGE)) {
            return LengthConstraintType.RANGE;
        }
        if (this.equals(LengthConstraintType.FIXED)) {
            return LengthConstraintType.FIXED;
        }
        return null;
    }
    
    static {
        NONE = new LengthConstraintType("LengthConstraintType.NONE");
        RANGE = new LengthConstraintType("RectangleConstraintType.RANGE");
        FIXED = new LengthConstraintType("LengthConstraintType.FIXED");
    }
}
