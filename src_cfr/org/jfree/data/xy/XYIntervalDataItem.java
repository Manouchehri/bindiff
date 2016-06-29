/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.xy.XYInterval;

public class XYIntervalDataItem
extends ComparableObjectItem {
    public XYIntervalDataItem(double d2, double d3, double d4, double d5, double d6, double d7) {
        super(new Double(d2), new XYInterval(d3, d4, d5, d6, d7));
    }

    public Double getX() {
        return (Double)this.getComparable();
    }

    public double getYValue() {
        XYInterval xYInterval = (XYInterval)this.getObject();
        if (xYInterval == null) return Double.NaN;
        return xYInterval.getY();
    }

    public double getXLowValue() {
        XYInterval xYInterval = (XYInterval)this.getObject();
        if (xYInterval == null) return Double.NaN;
        return xYInterval.getXLow();
    }

    public double getXHighValue() {
        XYInterval xYInterval = (XYInterval)this.getObject();
        if (xYInterval == null) return Double.NaN;
        return xYInterval.getXHigh();
    }

    public double getYLowValue() {
        XYInterval xYInterval = (XYInterval)this.getObject();
        if (xYInterval == null) return Double.NaN;
        return xYInterval.getYLow();
    }

    public double getYHighValue() {
        XYInterval xYInterval = (XYInterval)this.getObject();
        if (xYInterval == null) return Double.NaN;
        return xYInterval.getYHigh();
    }
}

