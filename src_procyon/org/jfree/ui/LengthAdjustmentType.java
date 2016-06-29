package org.jfree.ui;

import java.io.*;

public final class LengthAdjustmentType implements Serializable
{
    private static final long serialVersionUID = -6097408511380545010L;
    public static final LengthAdjustmentType NO_CHANGE;
    public static final LengthAdjustmentType EXPAND;
    public static final LengthAdjustmentType CONTRACT;
    private String name;
    
    private LengthAdjustmentType(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof LengthAdjustmentType && this.name.equals(((LengthAdjustmentType)o).name));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    private Object readResolve() {
        if (this.equals(LengthAdjustmentType.NO_CHANGE)) {
            return LengthAdjustmentType.NO_CHANGE;
        }
        if (this.equals(LengthAdjustmentType.EXPAND)) {
            return LengthAdjustmentType.EXPAND;
        }
        if (this.equals(LengthAdjustmentType.CONTRACT)) {
            return LengthAdjustmentType.CONTRACT;
        }
        return null;
    }
    
    static {
        NO_CHANGE = new LengthAdjustmentType("NO_CHANGE");
        EXPAND = new LengthAdjustmentType("EXPAND");
        CONTRACT = new LengthAdjustmentType("CONTRACT");
    }
}
