package org.jfree.data.xy;

import java.io.*;

public class YWithXInterval implements Serializable
{
    private double y;
    private double xLow;
    private double xHigh;
    
    public YWithXInterval(final double y, final double xLow, final double xHigh) {
        this.y = y;
        this.xLow = xLow;
        this.xHigh = xHigh;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getXLow() {
        return this.xLow;
    }
    
    public double getXHigh() {
        return this.xHigh;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof YWithXInterval)) {
            return false;
        }
        final YWithXInterval yWithXInterval = (YWithXInterval)o;
        return this.y == yWithXInterval.y && this.xLow == yWithXInterval.xLow && this.xHigh == yWithXInterval.xHigh;
    }
}
