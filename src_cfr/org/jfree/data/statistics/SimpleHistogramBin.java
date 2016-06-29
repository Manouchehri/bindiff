/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.io.Serializable;
import org.jfree.util.PublicCloneable;

public class SimpleHistogramBin
implements Serializable,
Cloneable,
Comparable,
PublicCloneable {
    private static final long serialVersionUID = 3480862537505941742L;
    private double lowerBound;
    private double upperBound;
    private boolean includeLowerBound;
    private boolean includeUpperBound;
    private int itemCount;

    public SimpleHistogramBin(double d2, double d3) {
        this(d2, d3, true, true);
    }

    public SimpleHistogramBin(double d2, double d3, boolean bl2, boolean bl3) {
        if (d2 >= d3) {
            throw new IllegalArgumentException("Invalid bounds");
        }
        this.lowerBound = d2;
        this.upperBound = d3;
        this.includeLowerBound = bl2;
        this.includeUpperBound = bl3;
        this.itemCount = 0;
    }

    public double getLowerBound() {
        return this.lowerBound;
    }

    public double getUpperBound() {
        return this.upperBound;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(int n2) {
        this.itemCount = n2;
    }

    public boolean accepts(double d2) {
        if (Double.isNaN(d2)) {
            return false;
        }
        if (d2 < this.lowerBound) {
            return false;
        }
        if (d2 > this.upperBound) {
            return false;
        }
        if (d2 == this.lowerBound) {
            return this.includeLowerBound;
        }
        if (d2 != this.upperBound) return true;
        return this.includeUpperBound;
    }

    public boolean overlapsWith(SimpleHistogramBin simpleHistogramBin) {
        if (this.upperBound < simpleHistogramBin.lowerBound) {
            return false;
        }
        if (this.lowerBound > simpleHistogramBin.upperBound) {
            return false;
        }
        if (this.upperBound == simpleHistogramBin.lowerBound) {
            if (!this.includeUpperBound) return false;
            if (!simpleHistogramBin.includeLowerBound) return false;
            return true;
        }
        if (this.lowerBound != simpleHistogramBin.upperBound) return true;
        if (!this.includeLowerBound) return false;
        if (!simpleHistogramBin.includeUpperBound) return false;
        return true;
    }

    public int compareTo(Object object) {
        if (!(object instanceof SimpleHistogramBin)) {
            return 0;
        }
        SimpleHistogramBin simpleHistogramBin = (SimpleHistogramBin)object;
        if (this.lowerBound < simpleHistogramBin.lowerBound) {
            return -1;
        }
        if (this.lowerBound > simpleHistogramBin.lowerBound) {
            return 1;
        }
        if (this.upperBound < simpleHistogramBin.upperBound) {
            return -1;
        }
        if (this.upperBound <= simpleHistogramBin.upperBound) return 0;
        return 1;
    }

    public boolean equals(Object object) {
        if (!(object instanceof SimpleHistogramBin)) {
            return false;
        }
        SimpleHistogramBin simpleHistogramBin = (SimpleHistogramBin)object;
        if (this.lowerBound != simpleHistogramBin.lowerBound) {
            return false;
        }
        if (this.upperBound != simpleHistogramBin.upperBound) {
            return false;
        }
        if (this.includeLowerBound != simpleHistogramBin.includeLowerBound) {
            return false;
        }
        if (this.includeUpperBound != simpleHistogramBin.includeUpperBound) {
            return false;
        }
        if (this.itemCount == simpleHistogramBin.itemCount) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

