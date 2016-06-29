/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.Serializable;

public final class UnitType
implements Serializable {
    private static final long serialVersionUID = 6531925392288519884L;
    public static final UnitType ABSOLUTE = new UnitType("UnitType.ABSOLUTE");
    public static final UnitType RELATIVE = new UnitType("UnitType.RELATIVE");
    private String name;

    private UnitType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof UnitType)) {
            return false;
        }
        UnitType unitType = (UnitType)object;
        if (this.name.equals(unitType.name)) return true;
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    private Object readResolve() {
        if (this.equals(ABSOLUTE)) {
            return ABSOLUTE;
        }
        if (!this.equals(RELATIVE)) return null;
        return RELATIVE;
    }
}

