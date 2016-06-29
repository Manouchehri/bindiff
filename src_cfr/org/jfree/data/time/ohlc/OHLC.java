/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time.ohlc;

import java.io.Serializable;

public class OHLC
implements Serializable {
    private double open;
    private double close;
    private double high;
    private double low;

    public OHLC(double d2, double d3, double d4, double d5) {
        this.open = d2;
        this.close = d5;
        this.high = d3;
        this.low = d4;
    }

    public double getOpen() {
        return this.open;
    }

    public double getClose() {
        return this.close;
    }

    public double getHigh() {
        return this.high;
    }

    public double getLow() {
        return this.low;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof OHLC)) {
            return false;
        }
        OHLC oHLC = (OHLC)object;
        if (this.open != oHLC.open) {
            return false;
        }
        if (this.close != oHLC.close) {
            return false;
        }
        if (this.high != oHLC.high) {
            return false;
        }
        if (this.low == oHLC.low) return true;
        return false;
    }
}

