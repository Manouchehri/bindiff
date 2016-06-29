/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;

class WindDataItem
implements Serializable,
Comparable {
    private Number x;
    private Number windDir;
    private Number windForce;

    public WindDataItem(Number number, Number number2, Number number3) {
        this.x = number;
        this.windDir = number2;
        this.windForce = number3;
    }

    public Number getX() {
        return this.x;
    }

    public Number getWindDirection() {
        return this.windDir;
    }

    public Number getWindForce() {
        return this.windForce;
    }

    public int compareTo(Object object) {
        if (!(object instanceof WindDataItem)) throw new ClassCastException("WindDataItem.compareTo(error)");
        WindDataItem windDataItem = (WindDataItem)object;
        if (this.x.doubleValue() > windDataItem.x.doubleValue()) {
            return 1;
        }
        if (!this.x.equals(windDataItem.x)) return -1;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return false;
        }
        if (!(object instanceof WindDataItem)) {
            return false;
        }
        WindDataItem windDataItem = (WindDataItem)object;
        if (!this.x.equals(windDataItem.x)) {
            return false;
        }
        if (!this.windDir.equals(windDataItem.windDir)) {
            return false;
        }
        if (this.windForce.equals(windDataItem.windForce)) return true;
        return false;
    }
}

