package org.jfree.data.time.ohlc;

import org.jfree.data.*;
import org.jfree.data.time.*;

public class OHLCItem extends ComparableObjectItem
{
    public OHLCItem(final RegularTimePeriod regularTimePeriod, final double n, final double n2, final double n3, final double n4) {
        super(regularTimePeriod, new OHLC(n, n2, n3, n4));
    }
    
    public RegularTimePeriod getPeriod() {
        return (RegularTimePeriod)this.getComparable();
    }
    
    public double getYValue() {
        return this.getCloseValue();
    }
    
    public double getOpenValue() {
        final OHLC ohlc = (OHLC)this.getObject();
        if (ohlc != null) {
            return ohlc.getOpen();
        }
        return Double.NaN;
    }
    
    public double getHighValue() {
        final OHLC ohlc = (OHLC)this.getObject();
        if (ohlc != null) {
            return ohlc.getHigh();
        }
        return Double.NaN;
    }
    
    public double getLowValue() {
        final OHLC ohlc = (OHLC)this.getObject();
        if (ohlc != null) {
            return ohlc.getLow();
        }
        return Double.NaN;
    }
    
    public double getCloseValue() {
        final OHLC ohlc = (OHLC)this.getObject();
        if (ohlc != null) {
            return ohlc.getClose();
        }
        return Double.NaN;
    }
}
