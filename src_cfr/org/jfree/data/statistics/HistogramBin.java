/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.io.Serializable;

public class HistogramBin
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 7614685080015589931L;
    private int count;
    private double startBoundary;
    private double endBoundary;

    public HistogramBin(double d2, double d3) {
        if (d2 > d3) {
            throw new IllegalArgumentException("HistogramBin():  startBoundary > endBoundary.");
        }
        this.count = 0;
        this.startBoundary = d2;
        this.endBoundary = d3;
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

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof HistogramBin)) return false;
        HistogramBin histogramBin = (HistogramBin)object;
        boolean bl2 = histogramBin.startBoundary == this.startBoundary;
        boolean bl3 = histogramBin.endBoundary == this.endBoundary;
        boolean bl4 = histogramBin.count == this.count;
        if (!bl2) return false;
        if (!bl3) return false;
        if (!bl4) return false;
        return true;
    }

    public Object clone() {
        return super.clone();
    }
}

