/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;
import java.util.Date;

public class OHLCDataItem
implements Serializable,
Comparable {
    private static final long serialVersionUID = 7753817154401169901L;
    private Date date;
    private Number open;
    private Number high;
    private Number low;
    private Number close;
    private Number volume;

    public OHLCDataItem(Date date, double d2, double d3, double d4, double d5, double d6) {
        if (date == null) {
            throw new IllegalArgumentException("Null 'date' argument.");
        }
        this.date = date;
        this.open = new Double(d2);
        this.high = new Double(d3);
        this.low = new Double(d4);
        this.close = new Double(d5);
        this.volume = new Double(d6);
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

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof OHLCDataItem)) {
            return false;
        }
        OHLCDataItem oHLCDataItem = (OHLCDataItem)object;
        if (!this.date.equals(oHLCDataItem.date)) {
            return false;
        }
        if (!this.high.equals(oHLCDataItem.high)) {
            return false;
        }
        if (!this.low.equals(oHLCDataItem.low)) {
            return false;
        }
        if (!this.open.equals(oHLCDataItem.open)) {
            return false;
        }
        if (this.close.equals(oHLCDataItem.close)) return true;
        return false;
    }

    public int compareTo(Object object) {
        if (!(object instanceof OHLCDataItem)) throw new ClassCastException("OHLCDataItem.compareTo().");
        OHLCDataItem oHLCDataItem = (OHLCDataItem)object;
        return this.date.compareTo(oHLCDataItem.date);
    }
}

