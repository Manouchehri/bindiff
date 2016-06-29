/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;

public class XYInterval
implements Serializable {
    private double xLow;
    private double xHigh;
    private double y;
    private double yLow;
    private double yHigh;

    public XYInterval(double d2, double d3, double d4, double d5, double d6) {
        this.xLow = d2;
        this.xHigh = d3;
        this.y = d4;
        this.yLow = d5;
        this.yHigh = d6;
    }

    public double getXLow() {
        return this.xLow;
    }

    public double getXHigh() {
        return this.xHigh;
    }

    public double getY() {
        return this.y;
    }

    public double getYLow() {
        return this.yLow;
    }

    public double getYHigh() {
        return this.yHigh;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYInterval)) {
            return false;
        }
        XYInterval xYInterval = (XYInterval)object;
        if (this.xLow != xYInterval.xLow) {
            return false;
        }
        if (this.xHigh != xYInterval.xHigh) {
            return false;
        }
        if (this.y != xYInterval.y) {
            return false;
        }
        if (this.yLow != xYInterval.yLow) {
            return false;
        }
        if (this.yHigh == xYInterval.yHigh) return true;
        return false;
    }
}

