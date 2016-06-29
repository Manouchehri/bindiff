/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.axis;

import java.io.Serializable;

public abstract class TickUnit
implements Serializable,
Comparable {
    private static final long serialVersionUID = 510179855057013974L;
    private double size;

    public TickUnit(double d2) {
        this.size = d2;
    }

    public double getSize() {
        return this.size;
    }

    public String valueToString(double d2) {
        return String.valueOf(d2);
    }

    public int compareTo(Object object) {
        if (!(object instanceof TickUnit)) return -1;
        TickUnit tickUnit = (TickUnit)object;
        if (this.size > tickUnit.getSize()) {
            return 1;
        }
        if (this.size >= tickUnit.getSize()) return 0;
        return -1;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof TickUnit)) return false;
        TickUnit tickUnit = (TickUnit)object;
        if (this.size != tickUnit.size) return false;
        return true;
    }

    public int hashCode() {
        long l2 = this.size != 0.0 ? Double.doubleToLongBits(this.size) : 0;
        return (int)(l2 ^ l2 >>> 32);
    }
}

