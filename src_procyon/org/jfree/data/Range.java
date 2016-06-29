package org.jfree.data;

import java.io.*;

public strictfp class Range implements Serializable
{
    private static final long serialVersionUID = -906333695431863380L;
    private double lower;
    private double upper;
    
    public Range(final double lower, final double upper) {
        if (lower > upper) {
            throw new IllegalArgumentException("Range(double, double): require lower (" + lower + ") <= upper (" + upper + ").");
        }
        this.lower = lower;
        this.upper = upper;
    }
    
    public strictfp double getLowerBound() {
        return this.lower;
    }
    
    public strictfp double getUpperBound() {
        return this.upper;
    }
    
    public strictfp double getLength() {
        return this.upper - this.lower;
    }
    
    public strictfp double getCentralValue() {
        return this.lower / 2.0 + this.upper / 2.0;
    }
    
    public strictfp boolean contains(final double n) {
        return n >= this.lower && n <= this.upper;
    }
    
    public strictfp boolean intersects(final double n, final double n2) {
        if (n <= this.lower) {
            return n2 > this.lower;
        }
        return n < this.upper && n2 >= n;
    }
    
    public strictfp double constrain(final double n) {
        double n2 = n;
        if (!this.contains(n)) {
            if (n > this.upper) {
                n2 = this.upper;
            }
            else if (n < this.lower) {
                n2 = this.lower;
            }
        }
        return n2;
    }
    
    public static strictfp Range combine(final Range range, final Range range2) {
        if (range == null) {
            return range2;
        }
        if (range2 == null) {
            return range;
        }
        return new Range(Math.min(range.getLowerBound(), range2.getLowerBound()), Math.max(range.getUpperBound(), range2.getUpperBound()));
    }
    
    public static strictfp Range expandToInclude(final Range range, final double n) {
        if (range == null) {
            return new Range(n, n);
        }
        if (n < range.getLowerBound()) {
            return new Range(n, range.getUpperBound());
        }
        if (n > range.getUpperBound()) {
            return new Range(range.getLowerBound(), n);
        }
        return range;
    }
    
    public static strictfp Range expand(final Range range, final double n, final double n2) {
        if (range == null) {
            throw new IllegalArgumentException("Null 'range' argument.");
        }
        final double length = range.getLength();
        return new Range(range.getLowerBound() - length * n, range.getUpperBound() + length * n2);
    }
    
    public static strictfp Range shift(final Range range, final double n) {
        return shift(range, n, false);
    }
    
    public static strictfp Range shift(final Range range, final double n, final boolean b) {
        if (b) {
            return new Range(range.getLowerBound() + n, range.getUpperBound() + n);
        }
        return new Range(shiftWithNoZeroCrossing(range.getLowerBound(), n), shiftWithNoZeroCrossing(range.getUpperBound(), n));
    }
    
    private static strictfp double shiftWithNoZeroCrossing(final double n, final double n2) {
        if (n > 0.0) {
            return Math.max(n + n2, 0.0);
        }
        if (n < 0.0) {
            return Math.min(n + n2, 0.0);
        }
        return n + n2;
    }
    
    public strictfp boolean equals(final Object o) {
        if (!(o instanceof Range)) {
            return false;
        }
        final Range range = (Range)o;
        return this.lower == range.lower && this.upper == range.upper;
    }
    
    public strictfp int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.lower);
        final int n = (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
        final long doubleToLongBits2 = Double.doubleToLongBits(this.upper);
        return 29 * n + (int)(doubleToLongBits2 ^ doubleToLongBits2 >>> 32);
    }
    
    public strictfp String toString() {
        return "Range[" + this.lower + "," + this.upper + "]";
    }
}
