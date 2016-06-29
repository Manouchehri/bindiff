/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.io.Serializable;

public final class LengthAdjustmentType
implements Serializable {
    private static final long serialVersionUID = -6097408511380545010L;
    public static final LengthAdjustmentType NO_CHANGE = new LengthAdjustmentType("NO_CHANGE");
    public static final LengthAdjustmentType EXPAND = new LengthAdjustmentType("EXPAND");
    public static final LengthAdjustmentType CONTRACT = new LengthAdjustmentType("CONTRACT");
    private String name;

    private LengthAdjustmentType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof LengthAdjustmentType)) {
            return false;
        }
        LengthAdjustmentType lengthAdjustmentType = (LengthAdjustmentType)object;
        if (this.name.equals(lengthAdjustmentType.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(NO_CHANGE)) {
            return NO_CHANGE;
        }
        if (this.equals(EXPAND)) {
            return EXPAND;
        }
        if (!this.equals(CONTRACT)) return null;
        return CONTRACT;
    }
}

