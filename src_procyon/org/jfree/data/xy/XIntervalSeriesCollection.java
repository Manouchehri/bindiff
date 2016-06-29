package org.jfree.data.xy;

import java.io.*;
import org.jfree.data.general.*;
import org.jfree.util.*;
import java.util.*;

public class XIntervalSeriesCollection extends AbstractIntervalXYDataset implements Serializable, IntervalXYDataset
{
    private List data;
    
    public XIntervalSeriesCollection() {
        this.data = new ArrayList();
    }
    
    public void addSeries(final XIntervalSeries xIntervalSeries) {
        if (xIntervalSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(xIntervalSeries);
        xIntervalSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }
    
    public int getSeriesCount() {
        return this.data.size();
    }
    
    public XIntervalSeries getSeries(final int n) {
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
        return ((XIntervalDataItem)this.data.get(n).getDataItem(n2)).getX();
    }
    
    public Number getY(final int n, final int n2) {
        return new Double(((XIntervalDataItem)this.data.get(n).getDataItem(n2)).getYValue());
    }
    
    public Number getStartX(final int n, final int n2) {
        return new Double(((XIntervalDataItem)this.data.get(n).getDataItem(n2)).getXLowValue());
    }
    
    public Number getEndX(final int n, final int n2) {
        return new Double(((XIntervalDataItem)this.data.get(n).getDataItem(n2)).getXHighValue());
    }
    
    public Number getStartY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof XIntervalSeriesCollection && ObjectUtilities.equal(this.data, ((XIntervalSeriesCollection)o).data));
    }
    
    public Object clone() {
        final XIntervalSeriesCollection collection = (XIntervalSeriesCollection)super.clone();
        collection.data = (List)ObjectUtilities.deepClone(this.data);
        return collection;
    }
}
