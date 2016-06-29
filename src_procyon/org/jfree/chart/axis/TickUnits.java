package org.jfree.chart.axis;

import java.io.*;
import java.text.*;
import java.util.*;

public class TickUnits implements Serializable, Cloneable, TickUnitSource
{
    private static final long serialVersionUID = 1134174035901467545L;
    private List tickUnits;
    
    public TickUnits() {
        this.tickUnits = new ArrayList();
    }
    
    public void add(final TickUnit tickUnit) {
        if (tickUnit == null) {
            throw new NullPointerException("Null 'unit' argument.");
        }
        this.tickUnits.add(tickUnit);
        Collections.sort((List<Comparable>)this.tickUnits);
    }
    
    public int size() {
        return this.tickUnits.size();
    }
    
    public TickUnit get(final int n) {
        return this.tickUnits.get(n);
    }
    
    public TickUnit getLargerTickUnit(final TickUnit tickUnit) {
        final int binarySearch = Collections.binarySearch(this.tickUnits, tickUnit);
        int n;
        if (binarySearch >= 0) {
            n = binarySearch + 1;
        }
        else {
            n = -binarySearch;
        }
        return (TickUnit)this.tickUnits.get(Math.min(n, this.tickUnits.size() - 1));
    }
    
    public TickUnit getCeilingTickUnit(final TickUnit tickUnit) {
        final int binarySearch = Collections.binarySearch(this.tickUnits, tickUnit);
        if (binarySearch >= 0) {
            return (TickUnit)this.tickUnits.get(binarySearch);
        }
        return (TickUnit)this.tickUnits.get(Math.min(-(binarySearch + 1), this.tickUnits.size() - 1));
    }
    
    public TickUnit getCeilingTickUnit(final double n) {
        return this.getCeilingTickUnit(new NumberTickUnit(n, NumberFormat.getInstance()));
    }
    
    public Object clone() {
        final TickUnits tickUnits = (TickUnits)super.clone();
        tickUnits.tickUnits = new ArrayList(this.tickUnits);
        return tickUnits;
    }
    
    public boolean equals(final Object o) {
        return o != null && (o == this || (o instanceof TickUnits && ((TickUnits)o).tickUnits.equals(this.tickUnits)));
    }
}
