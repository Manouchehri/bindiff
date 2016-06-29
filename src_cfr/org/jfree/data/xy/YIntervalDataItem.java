/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.xy.YInterval;

public class YIntervalDataItem
extends ComparableObjectItem {
    public YIntervalDataItem(double d2, double d3, double d4, double d5) {
        super(new Double(d2), new YInterval(d3, d4, d5));
    }

    public Double getX() {
        return (Double)this.getComparable();
    }

    public double getYValue() {
        YInterval yInterval = (YInterval)this.getObject();
        if (yInterval == null) return Double.NaN;
        return yInterval.getY();
    }

    public double getYLowValue() {
        YInterval yInterval = (YInterval)this.getObject();
        if (yInterval == null) return Double.NaN;
        return yInterval.getYLow();
    }

    public double getYHighValue() {
        YInterval yInterval = (YInterval)this.getObject();
        if (yInterval == null) return Double.NaN;
        return yInterval.getYHigh();
    }
}

