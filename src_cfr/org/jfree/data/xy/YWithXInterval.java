/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;

public class YWithXInterval
implements Serializable {
    private double y;
    private double xLow;
    private double xHigh;

    public YWithXInterval(double d2, double d3, double d4) {
        this.y = d2;
        this.xLow = d3;
        this.xHigh = d4;
    }

    public double getY() {
        return this.y;
    }

    public double getXLow() {
        return this.xLow;
    }

    public double getXHigh() {
        return this.xHigh;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof YWithXInterval)) {
            return false;
        }
        YWithXInterval yWithXInterval = (YWithXInterval)object;
        if (this.y != yWithXInterval.y) {
            return false;
        }
        if (this.xLow != yWithXInterval.xLow) {
            return false;
        }
        if (this.xHigh == yWithXInterval.xHigh) return true;
        return false;
    }
}

