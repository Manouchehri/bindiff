package org.jfree.data.xy;

import java.io.*;
import java.util.*;
import org.jfree.data.general.*;
import org.jfree.util.*;

public class XYIntervalSeriesCollection extends AbstractIntervalXYDataset implements Serializable, IntervalXYDataset
{
    private List data;
    
    public XYIntervalSeriesCollection() {
        this.data = new ArrayList();
    }
    
    public void addSeries(final XYIntervalSeries xyIntervalSeries) {
        if (xyIntervalSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(xyIntervalSeries);
        xyIntervalSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }
    
    public int getSeriesCount() {
        return this.data.size();
    }
    
    public XYIntervalSeries getSeries(final int n) {
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
    
    public double getStartXValue(final int n, final int n2) {
        return this.data.get(n).getXLowValue(n2);
    }
    
    public double getEndXValue(final int n, final int n2) {
        return this.data.get(n).getXHighValue(n2);
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
        return new Double(this.getYValue(n, n2));
    }
    
    public Number getStartX(final int n, final int n2) {
        return new Double(this.getStartXValue(n, n2));
    }
    
    public Number getEndX(final int n, final int n2) {
        return new Double(this.getEndXValue(n, n2));
    }
    
    public Number getStartY(final int n, final int n2) {
        return new Double(this.getStartYValue(n, n2));
    }
    
    public Number getEndY(final int n, final int n2) {
        return new Double(this.getEndYValue(n, n2));
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof XYIntervalSeriesCollection && ObjectUtilities.equal(this.data, ((XYIntervalSeriesCollection)o).data));
    }
    
    public Object clone() {
        final XYIntervalSeriesCollection collection = (XYIntervalSeriesCollection)super.clone();
        collection.data = new ArrayList(this.getSeriesCount());
        for (int i = 0; i < this.data.size(); ++i) {
            collection.data.set(i, this.getSeries(i).clone());
        }
        return collection;
    }
}
