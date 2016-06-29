/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.ComparableObjectSeries;
import org.jfree.data.xy.XYIntervalDataItem;

public class XYIntervalSeries
extends ComparableObjectSeries {
    public XYIntervalSeries(Comparable comparable) {
        this(comparable, true, true);
    }

    public XYIntervalSeries(Comparable comparable, boolean bl2, boolean bl3) {
        super(comparable, bl2, bl3);
    }

    public void add(double d2, double d3, double d4, double d5, double d6, double d7) {
        super.add(new XYIntervalDataItem(d2, d3, d4, d5, d6, d7), true);
    }

    public Number getX(int n2) {
        XYIntervalDataItem xYIntervalDataItem = (XYIntervalDataItem)this.getDataItem(n2);
        return xYIntervalDataItem.getX();
    }

    public double getXLowValue(int n2) {
        XYIntervalDataItem xYIntervalDataItem = (XYIntervalDataItem)this.getDataItem(n2);
        return xYIntervalDataItem.getXLowValue();
    }

    public double getXHighValue(int n2) {
        XYIntervalDataItem xYIntervalDataItem = (XYIntervalDataItem)this.getDataItem(n2);
        return xYIntervalDataItem.getXHighValue();
    }

    public double getYValue(int n2) {
        XYIntervalDataItem xYIntervalDataItem = (XYIntervalDataItem)this.getDataItem(n2);
        return xYIntervalDataItem.getYValue();
    }

    public double getYLowValue(int n2) {
        XYIntervalDataItem xYIntervalDataItem = (XYIntervalDataItem)this.getDataItem(n2);
        return xYIntervalDataItem.getYLowValue();
    }

    public double getYHighValue(int n2) {
        XYIntervalDataItem xYIntervalDataItem = (XYIntervalDataItem)this.getDataItem(n2);
        return xYIntervalDataItem.getYHighValue();
    }

    @Override
    public ComparableObjectItem getDataItem(int n2) {
        return super.getDataItem(n2);
    }
}

