package org.jfree.chart.axis;

import java.io.*;

public abstract class TickUnit implements Serializable, Comparable
{
    private static final long serialVersionUID = 510179855057013974L;
    private double size;
    
    public TickUnit(final double size) {
        this.size = size;
    }
    
    public double getSize() {
        return this.size;
    }
    
    public String valueToString(final double n) {
        return String.valueOf(n);
    }
    
    public int compareTo(final Object o) {
        if (!(o instanceof TickUnit)) {
            return -1;
        }
        final TickUnit tickUnit = (TickUnit)o;
        if (this.size > tickUnit.getSize()) {
            return 1;
        }
        if (this.size < tickUnit.getSize()) {
            return -1;
        }
        return 0;
    }
    
    public boolean equals(final Object o) {
        return o != null && (o == this || (o instanceof TickUnit && this.size == ((TickUnit)o).size));
    }
    
    public int hashCode() {
        final long n = (this.size != 0.0) ? Double.doubleToLongBits(this.size) : 0L;
        return (int)(n ^ n >>> 32);
    }
}
