/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time.ohlc;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.ohlc.OHLC;

public class OHLCItem
extends ComparableObjectItem {
    public OHLCItem(RegularTimePeriod regularTimePeriod, double d2, double d3, double d4, double d5) {
        super(regularTimePeriod, new OHLC(d2, d3, d4, d5));
    }

    public RegularTimePeriod getPeriod() {
        return (RegularTimePeriod)this.getComparable();
    }

    public double getYValue() {
        return this.getCloseValue();
    }

    public double getOpenValue() {
        OHLC oHLC = (OHLC)this.getObject();
        if (oHLC == null) return Double.NaN;
        return oHLC.getOpen();
    }

    public double getHighValue() {
        OHLC oHLC = (OHLC)this.getObject();
        if (oHLC == null) return Double.NaN;
        return oHLC.getHigh();
    }

    public double getLowValue() {
        OHLC oHLC = (OHLC)this.getObject();
        if (oHLC == null) return Double.NaN;
        return oHLC.getLow();
    }

    public double getCloseValue() {
        OHLC oHLC = (OHLC)this.getObject();
        if (oHLC == null) return Double.NaN;
        return oHLC.getClose();
    }
}

