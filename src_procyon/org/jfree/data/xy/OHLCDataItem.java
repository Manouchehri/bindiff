package org.jfree.data.xy;

import java.io.*;
import java.util.*;

public class OHLCDataItem implements Serializable, Comparable
{
    private static final long serialVersionUID = 7753817154401169901L;
    private Date date;
    private Number open;
    private Number high;
    private Number low;
    private Number close;
    private Number volume;
    
    public OHLCDataItem(final Date date, final double n, final double n2, final double n3, final double n4, final double n5) {
        if (date == null) {
            throw new IllegalArgumentException("Null 'date' argument.");
        }
        this.date = date;
        this.open = new Double(n);
        this.high = new Double(n2);
        this.low = new Double(n3);
        this.close = new Double(n4);
        this.volume = new Double(n5);
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public Number getOpen() {
        return this.open;
    }
    
    public Number getHigh() {
        return this.high;
    }
    
    public Number getLow() {
        return this.low;
    }
    
    public Number getClose() {
        return this.close;
    }
    
    public Number getVolume() {
        return this.volume;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OHLCDataItem)) {
            return false;
        }
        final OHLCDataItem ohlcDataItem = (OHLCDataItem)o;
        return this.date.equals(ohlcDataItem.date) && this.high.equals(ohlcDataItem.high) && this.low.equals(ohlcDataItem.low) && this.open.equals(ohlcDataItem.open) && this.close.equals(ohlcDataItem.close);
    }
    
    public int compareTo(final Object o) {
        if (o instanceof OHLCDataItem) {
            return this.date.compareTo(((OHLCDataItem)o).date);
        }
        throw new ClassCastException("OHLCDataItem.compareTo().");
    }
}
