/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time.ohlc;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.ComparableObjectSeries;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.ohlc.OHLCItem;

public class OHLCSeries
extends ComparableObjectSeries {
    public OHLCSeries(Comparable comparable) {
        super(comparable, true, false);
    }

    public RegularTimePeriod getPeriod(int n2) {
        OHLCItem oHLCItem = (OHLCItem)this.getDataItem(n2);
        return oHLCItem.getPeriod();
    }

    @Override
    public ComparableObjectItem getDataItem(int n2) {
        return super.getDataItem(n2);
    }

    public void add(RegularTimePeriod regularTimePeriod, double d2, double d3, double d4, double d5) {
        if (this.getItemCount() > 0) {
            OHLCItem oHLCItem = (OHLCItem)this.getDataItem(0);
            if (!regularTimePeriod.getClass().equals(oHLCItem.getPeriod().getClass())) {
                throw new IllegalArgumentException("Can't mix RegularTimePeriod class types.");
            }
        }
        super.add(new OHLCItem(regularTimePeriod, d2, d3, d4, d5), true);
    }
}

