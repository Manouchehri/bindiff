/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;

public class YInterval
implements Serializable {
    private double y;
    private double yLow;
    private double yHigh;

    public YInterval(double d2, double d3, double d4) {
        this.y = d2;
        this.yLow = d3;
        this.yHigh = d4;
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
        if (!(object instanceof YInterval)) {
            return false;
        }
        YInterval yInterval = (YInterval)object;
        if (this.y != yInterval.y) {
            return false;
        }
        if (this.yLow != yInterval.yLow) {
            return false;
        }
        if (this.yHigh == yInterval.yHigh) return true;
        return false;
    }
}

