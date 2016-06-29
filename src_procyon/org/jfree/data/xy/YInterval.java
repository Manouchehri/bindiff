package org.jfree.data.xy;

import java.io.*;

public class YInterval implements Serializable
{
    private double y;
    private double yLow;
    private double yHigh;
    
    public YInterval(final double y, final double yLow, final double yHigh) {
        this.y = y;
        this.yLow = yLow;
        this.yHigh = yHigh;
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
        if (!(o instanceof YInterval)) {
            return false;
        }
        final YInterval yInterval = (YInterval)o;
        return this.y == yInterval.y && this.yLow == yInterval.yLow && this.yHigh == yInterval.yHigh;
    }
}
