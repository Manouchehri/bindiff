package org.jfree.chart.renderer;

import java.io.*;
import org.jfree.util.*;
import java.awt.*;

public class GrayPaintScale implements Serializable, PaintScale, PublicCloneable
{
    private double lowerBound;
    private double upperBound;
    
    public GrayPaintScale() {
        this(0.0, 1.0);
    }
    
    public GrayPaintScale(final double lowerBound, final double upperBound) {
        if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Requires lowerBound < upperBound.");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
    
    public double getLowerBound() {
        return this.lowerBound;
    }
    
    public double getUpperBound() {
        return this.upperBound;
    }
    
    public Paint getPaint(final double n) {
        Math.min(Math.max(n, this.lowerBound), this.upperBound);
        final int n2 = (int)((n - this.lowerBound) / (this.upperBound - this.lowerBound) * 255.0);
        return new Color(n2, n2, n2);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GrayPaintScale)) {
            return false;
        }
        final GrayPaintScale grayPaintScale = (GrayPaintScale)o;
        return this.lowerBound == grayPaintScale.lowerBound && this.upperBound == grayPaintScale.upperBound;
    }
    
    public Object clone() {
        return super.clone();
    }
}
