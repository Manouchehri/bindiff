/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;
import org.jfree.util.ObjectUtilities;

public class XYDataItem
implements Serializable,
Cloneable,
Comparable {
    private static final long serialVersionUID = 2751513470325494890L;
    private Number x;
    private Number y;

    public XYDataItem(Number number, Number number2) {
        if (number == null) {
            throw new IllegalArgumentException("Null 'x' argument.");
        }
        this.x = number;
        this.y = number2;
    }

    public XYDataItem(double d2, double d3) {
        this(new Double(d2), new Double(d3));
    }

    public Number getX() {
        return this.x;
    }

    public Number getY() {
        return this.y;
    }

    public void setY(double d2) {
        this.setY(new Double(d2));
    }

    public void setY(Number number) {
        this.y = number;
    }

    public int compareTo(Object object) {
        if (!(object instanceof XYDataItem)) {
            return 1;
        }
        XYDataItem xYDataItem = (XYDataItem)object;
        double d2 = this.x.doubleValue() - xYDataItem.getX().doubleValue();
        if (d2 > 0.0) {
            return 1;
        }
        if (d2 >= 0.0) return 0;
        return -1;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYDataItem)) {
            return false;
        }
        XYDataItem xYDataItem = (XYDataItem)object;
        if (!this.x.equals(xYDataItem.x)) {
            return false;
        }
        if (ObjectUtilities.equal(this.y, xYDataItem.y)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.x.hashCode();
        return 29 * n2 + (this.y != null ? this.y.hashCode() : 0);
    }
}

