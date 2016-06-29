/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.xy.YWithXInterval;

public class XIntervalDataItem
extends ComparableObjectItem {
    public XIntervalDataItem(double d2, double d3, double d4, double d5) {
        super(new Double(d2), new YWithXInterval(d5, d3, d4));
    }

    public Number getX() {
        return (Number)((Object)this.getComparable());
    }

    public double getYValue() {
        YWithXInterval yWithXInterval = (YWithXInterval)this.getObject();
        if (yWithXInterval == null) return Double.NaN;
        return yWithXInterval.getY();
    }

    public double getXLowValue() {
        YWithXInterval yWithXInterval = (YWithXInterval)this.getObject();
        if (yWithXInterval == null) return Double.NaN;
        return yWithXInterval.getXLow();
    }

    public double getXHighValue() {
        YWithXInterval yWithXInterval = (YWithXInterval)this.getObject();
        if (yWithXInterval == null) return Double.NaN;
        return yWithXInterval.getXHigh();
    }
}

