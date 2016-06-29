/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.ComparableObjectSeries;
import org.jfree.data.xy.YIntervalDataItem;

public class YIntervalSeries
extends ComparableObjectSeries {
    public YIntervalSeries(Comparable comparable) {
        this(comparable, true, true);
    }

    public YIntervalSeries(Comparable comparable, boolean bl2, boolean bl3) {
        super(comparable, bl2, bl3);
    }

    public void add(double d2, double d3, double d4, double d5) {
        super.add(new YIntervalDataItem(d2, d3, d4, d5), true);
    }

    public Number getX(int n2) {
        YIntervalDataItem yIntervalDataItem = (YIntervalDataItem)this.getDataItem(n2);
        return yIntervalDataItem.getX();
    }

    public double getYValue(int n2) {
        YIntervalDataItem yIntervalDataItem = (YIntervalDataItem)this.getDataItem(n2);
        return yIntervalDataItem.getYValue();
    }

    public double getYLowValue(int n2) {
        YIntervalDataItem yIntervalDataItem = (YIntervalDataItem)this.getDataItem(n2);
        return yIntervalDataItem.getYLowValue();
    }

    public double getYHighValue(int n2) {
        YIntervalDataItem yIntervalDataItem = (YIntervalDataItem)this.getDataItem(n2);
        return yIntervalDataItem.getYHighValue();
    }

    @Override
    public ComparableObjectItem getDataItem(int n2) {
        return super.getDataItem(n2);
    }
}

