package org.jfree.data.xy;

import java.io.*;
import org.jfree.data.general.*;
import org.jfree.util.*;
import java.util.*;

public class YIntervalSeriesCollection extends AbstractIntervalXYDataset implements Serializable, IntervalXYDataset
{
    private List data;
    
    public YIntervalSeriesCollection() {
        this.data = new ArrayList();
    }
    
    public void addSeries(final YIntervalSeries yIntervalSeries) {
        if (yIntervalSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(yIntervalSeries);
        yIntervalSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }
    
    public int getSeriesCount() {
        return this.data.size();
    }
    
    public YIntervalSeries getSeries(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Series index out of bounds");
        }
        return this.data.get(n);
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.getSeries(n).getKey();
    }
    
    public int getItemCount(final int n) {
        return this.getSeries(n).getItemCount();
    }
    
    public Number getX(final int n, final int n2) {
        return this.data.get(n).getX(n2);
    }
    
    public double getYValue(final int n, final int n2) {
        return this.data.get(n).getYValue(n2);
    }
    
    public double getStartYValue(final int n, final int n2) {
        return this.data.get(n).getYLowValue(n2);
    }
    
    public double getEndYValue(final int n, final int n2) {
        return this.data.get(n).getYHighValue(n2);
    }
    
    public Number getY(final int n, final int n2) {
        return new Double(this.data.get(n).getYValue(n2));
    }
    
    public Number getStartX(final int n, final int n2) {
        return this.getX(n, n2);
    }
    
    public Number getEndX(final int n, final int n2) {
        return this.getX(n, n2);
    }
    
    public Number getStartY(final int n, final int n2) {
        return new Double(this.data.get(n).getYLowValue(n2));
    }
    
    public Number getEndY(final int n, final int n2) {
        return new Double(this.data.get(n).getYHighValue(n2));
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof YIntervalSeriesCollection && ObjectUtilities.equal(this.data, ((YIntervalSeriesCollection)o).data));
    }
    
    public Object clone() {
        final YIntervalSeriesCollection collection = (YIntervalSeriesCollection)super.clone();
        collection.data = (List)ObjectUtilities.deepClone(this.data);
        return collection;
    }
}
