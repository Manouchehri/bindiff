package org.jfree.data.time.ohlc;

import java.io.*;

public class OHLC implements Serializable
{
    private double open;
    private double close;
    private double high;
    private double low;
    
    public OHLC(final double open, final double high, final double low, final double close) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
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
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OHLC)) {
            return false;
        }
        final OHLC ohlc = (OHLC)o;
        return this.open == ohlc.open && this.close == ohlc.close && this.high == ohlc.high && this.low == ohlc.low;
    }
}
