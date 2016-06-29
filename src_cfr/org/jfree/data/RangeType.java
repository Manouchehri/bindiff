/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;

public final class RangeType
implements Serializable {
    private static final long serialVersionUID = -9073319010650549239L;
    public static final RangeType FULL = new RangeType("RangeType.FULL");
    public static final RangeType POSITIVE = new RangeType("RangeType.POSITIVE");
    public static final RangeType NEGATIVE = new RangeType("RangeType.NEGATIVE");
    private String name;

    private RangeType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RangeType)) {
            return false;
        }
        RangeType rangeType = (RangeType)object;
        if (this.name.equals(rangeType.toString())) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(FULL)) {
            return FULL;
        }
        if (this.equals(POSITIVE)) {
            return POSITIVE;
        }
        if (!this.equals(NEGATIVE)) return null;
        return NEGATIVE;
    }
}

