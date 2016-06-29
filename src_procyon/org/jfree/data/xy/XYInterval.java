package org.jfree.data.xy;

import java.io.*;

public class XYInterval implements Serializable
{
    private double xLow;
    private double xHigh;
    private double y;
    private double yLow;
    private double yHigh;
    
    public XYInterval(final double xLow, final double xHigh, final double y, final double yLow, final double yHigh) {
        this.xLow = xLow;
        this.xHigh = xHigh;
        this.y = y;
        this.yLow = yLow;
        this.yHigh = yHigh;
    }
    
    public double getXLow() {
        return this.xLow;
    }
    
    public double getXHigh() {
        return this.xHigh;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getYLow() {
        return this.yLow;
    }
    
    public double getYHigh() {
        return this.yHigh;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYInterval)) {
            return false;
        }
        final XYInterval xyInterval = (XYInterval)o;
        return this.xLow == xyInterval.xLow && this.xHigh == xyInterval.xHigh && this.y == xyInterval.y && this.yLow == xyInterval.yLow && this.yHigh == xyInterval.yHigh;
    }
}
