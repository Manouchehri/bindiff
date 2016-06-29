/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.ComparableObjectSeries;
import org.jfree.data.xy.XIntervalDataItem;

public class XIntervalSeries
extends ComparableObjectSeries {
    public XIntervalSeries(Comparable comparable) {
        this(comparable, true, true);
    }

    public XIntervalSeries(Comparable comparable, boolean bl2, boolean bl3) {
        super(comparable, bl2, bl3);
    }

    public void add(double d2, double d3, double d4, double d5) {
        super.add(new XIntervalDataItem(d2, d3, d4, d5), true);
    }

    public Number getX(int n2) {
        XIntervalDataItem xIntervalDataItem = (XIntervalDataItem)this.getDataItem(n2);
        return xIntervalDataItem.getX();
    }

    public double getYValue(int n2) {
        XIntervalDataItem xIntervalDataItem = (XIntervalDataItem)this.getDataItem(n2);
        return xIntervalDataItem.getYValue();
    }

    @Override
    public ComparableObjectItem getDataItem(int n2) {
        return super.getDataItem(n2);
    }
}

