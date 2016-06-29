package org.jfree.data.statistics;

import java.io.*;

public class HistogramBin implements Serializable, Cloneable
{
    private static final long serialVersionUID = 7614685080015589931L;
    private int count;
    private double startBoundary;
    private double endBoundary;
    
    public HistogramBin(final double startBoundary, final double endBoundary) {
        if (startBoundary > endBoundary) {
            throw new IllegalArgumentException("HistogramBin():  startBoundary > endBoundary.");
        }
        this.count = 0;
        this.startBoundary = startBoundary;
        this.endBoundary = endBoundary;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public void incrementCount() {
        ++this.count;
    }
    
    public double getStartBoundary() {
        return this.startBoundary;
    }
    
    public double getEndBoundary() {
        return this.endBoundary;
    }
    
    public double getBinWidth() {
        return this.endBoundary - this.startBoundary;
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o instanceof HistogramBin) {
            final HistogramBin histogramBin = (HistogramBin)o;
            final boolean b = histogramBin.startBoundary == this.startBoundary;
            final boolean b2 = histogramBin.endBoundary == this.endBoundary;
            final boolean b3 = histogramBin.count == this.count;
            return b && b2 && b3;
        }
        return false;
    }
    
    public Object clone() {
        return super.clone();
    }
}
