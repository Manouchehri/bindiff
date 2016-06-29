/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data;

import java.io.Serializable;

public strictfp class Range
implements Serializable {
    private static final long serialVersionUID = -906333695431863380L;
    private double lower;
    private double upper;

    public Range(double d2, double d3) {
        if (d2 > d3) {
            String string = new StringBuffer().append("Range(double, double): require lower (").append(d2).append(") <= upper (").append(d3).append(").").toString();
            throw new IllegalArgumentException(string);
        }
        this.lower = d2;
        this.upper = d3;
    }

    public double getLowerBound() {
        return this.lower;
    }

    public double getUpperBound() {
        return this.upper;
    }

    public double getLength() {
        return this.upper - this.lower;
    }

    public double getCentralValue() {
        return this.lower / 2.0 + this.upper / 2.0;
    }

    public boolean contains(double d2) {
        if (d2 < this.lower) return false;
        if (d2 > this.upper) return false;
        return true;
    }

    public boolean intersects(double d2, double d3) {
        if (d2 <= this.lower) {
            if (d3 <= this.lower) return false;
            return true;
        }
        if (d2 >= this.upper) return false;
        if (d3 < d2) return false;
        return true;
    }

    public double constrain(double d2) {
        double d3 = d2;
        if (this.contains(d2)) return d3;
        if (d2 > this.upper) {
            return this.upper;
        }
        if (d2 >= this.lower) return d3;
        return this.lower;
    }

    public static Range combine(Range range, Range range2) {
        if (range == null) {
            return range2;
        }
        if (range2 == null) {
            return range;
        }
        double d2 = Math.min(range.getLowerBound(), range2.getLowerBound());
        double d3 = Math.max(range.getUpperBound(), range2.getUpperBound());
        return new Range(d2, d3);
    }

    public static Range expandToInclude(Range range, double d2) {
        if (range == null) {
            return new Range(d2, d2);
        }
        if (d2 < range.getLowerBound()) {
            return new Range(d2, range.getUpperBound());
        }
        if (d2 <= range.getUpperBound()) return range;
        return new Range(range.getLowerBound(), d2);
    }

    public static Range expand(Range range, double d2, double d3) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        double d4 = range.getLength();
        double d5 = d4 * d2;
        double d6 = d4 * d3;
        return new Range(range.getLowerBound() - d5, range.getUpperBound() + d6);
    }

    public static Range shift(Range range, double d2) {
        return Range.shift(range, d2, false);
    }

    public static Range shift(Range range, double d2, boolean bl2) {
        if (!bl2) return new Range(Range.shiftWithNoZeroCrossing(range.getLowerBound(), d2), Range.shiftWithNoZeroCrossing(range.getUpperBound(), d2));
        return new Range(range.getLowerBound() + d2, range.getUpperBound() + d2);
    }

    private static double shiftWithNoZeroCrossing(double d2, double d3) {
        if (d2 > 0.0) {
            return Math.max(d2 + d3, 0.0);
        }
        if (d2 >= 0.0) return d2 + d3;
        return Math.min(d2 + d3, 0.0);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Range)) {
            return false;
        }
        Range range = (Range)object;
        if (this.lower != range.lower) {
            return false;
        }
        if (this.upper == range.upper) return true;
        return false;
    }

    public int hashCode() {
        long l2 = Double.doubleToLongBits(this.lower);
        int n2 = (int)(l2 ^ l2 >>> 32);
        l2 = Double.doubleToLongBits(this.upper);
        return 29 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    public String toString() {
        return new StringBuffer().append("Range[").append(this.lower).append(",").append(this.upper).append("]").toString();
    }
}

