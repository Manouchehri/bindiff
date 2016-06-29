package org.jfree.data.statistics;

import java.io.*;
import org.jfree.util.*;

public class SimpleHistogramBin implements Serializable, Cloneable, Comparable, PublicCloneable
{
    private static final long serialVersionUID = 3480862537505941742L;
    private double lowerBound;
    private double upperBound;
    private boolean includeLowerBound;
    private boolean includeUpperBound;
    private int itemCount;
    
    public SimpleHistogramBin(final double n, final double n2) {
        this(n, n2, true, true);
    }
    
    public SimpleHistogramBin(final double lowerBound, final double upperBound, final boolean includeLowerBound, final boolean includeUpperBound) {
        if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Invalid bounds");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.includeLowerBound = includeLowerBound;
        this.includeUpperBound = includeUpperBound;
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
    
    public void setItemCount(final int itemCount) {
        this.itemCount = itemCount;
    }
    
    public boolean accepts(final double n) {
        if (Double.isNaN(n)) {
            return false;
        }
        if (n < this.lowerBound) {
            return false;
        }
        if (n > this.upperBound) {
            return false;
        }
        if (n == this.lowerBound) {
            return this.includeLowerBound;
        }
        return n != this.upperBound || this.includeUpperBound;
    }
    
    public boolean overlapsWith(final SimpleHistogramBin simpleHistogramBin) {
        if (this.upperBound < simpleHistogramBin.lowerBound) {
            return false;
        }
        if (this.lowerBound > simpleHistogramBin.upperBound) {
            return false;
        }
        if (this.upperBound == simpleHistogramBin.lowerBound) {
            return this.includeUpperBound && simpleHistogramBin.includeLowerBound;
        }
        return this.lowerBound != simpleHistogramBin.upperBound || (this.includeLowerBound && simpleHistogramBin.includeUpperBound);
    }
    
    public int compareTo(final Object o) {
        if (!(o instanceof SimpleHistogramBin)) {
            return 0;
        }
        final SimpleHistogramBin simpleHistogramBin = (SimpleHistogramBin)o;
        if (this.lowerBound < simpleHistogramBin.lowerBound) {
            return -1;
        }
        if (this.lowerBound > simpleHistogramBin.lowerBound) {
            return 1;
        }
        if (this.upperBound < simpleHistogramBin.upperBound) {
            return -1;
        }
        if (this.upperBound > simpleHistogramBin.upperBound) {
            return 1;
        }
        return 0;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof SimpleHistogramBin)) {
            return false;
        }
        final SimpleHistogramBin simpleHistogramBin = (SimpleHistogramBin)o;
        return this.lowerBound == simpleHistogramBin.lowerBound && this.upperBound == simpleHistogramBin.upperBound && this.includeLowerBound == simpleHistogramBin.includeLowerBound && this.includeUpperBound == simpleHistogramBin.includeUpperBound && this.itemCount == simpleHistogramBin.itemCount;
    }
    
    public Object clone() {
        return super.clone();
    }
}
