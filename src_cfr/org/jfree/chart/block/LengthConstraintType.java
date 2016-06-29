/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import java.io.Serializable;

public final class LengthConstraintType
implements Serializable {
    private static final long serialVersionUID = -1156658804028142978L;
    public static final LengthConstraintType NONE = new LengthConstraintType("LengthConstraintType.NONE");
    public static final LengthConstraintType RANGE = new LengthConstraintType("RectangleConstraintType.RANGE");
    public static final LengthConstraintType FIXED = new LengthConstraintType("LengthConstraintType.FIXED");
    private String name;

    private LengthConstraintType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LengthConstraintType)) {
            return false;
        }
        LengthConstraintType lengthConstraintType = (LengthConstraintType)object;
        if (this.name.equals(lengthConstraintType.toString())) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(NONE)) {
            return NONE;
        }
        if (this.equals(RANGE)) {
            return RANGE;
        }
        if (!this.equals(FIXED)) return null;
        return FIXED;
    }
}

