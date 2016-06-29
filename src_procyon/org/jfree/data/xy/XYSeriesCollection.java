package org.jfree.data.xy;

import java.io.*;
import org.jfree.util.*;
import java.util.*;
import org.jfree.data.*;
import org.jfree.data.general.*;

public class XYSeriesCollection extends AbstractIntervalXYDataset implements Serializable, DomainInfo, IntervalXYDataset
{
    private static final long serialVersionUID = -7590013825931496766L;
    private List data;
    private IntervalXYDelegate intervalDelegate;
    
    public XYSeriesCollection() {
        this(null);
    }
    
    public XYSeriesCollection(final XYSeries xySeries) {
        this.data = new ArrayList();
        this.addChangeListener(this.intervalDelegate = new IntervalXYDelegate(this, false));
        if (xySeries != null) {
            this.data.add(xySeries);
            xySeries.addChangeListener(this);
        }
    }
    
    public void addSeries(final XYSeries xySeries) {
        if (xySeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(xySeries);
        xySeries.addChangeListener(this);
        this.fireDatasetChanged();
    }
    
    public void removeSeries(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Series index out of bounds.");
        }
        this.data.get(n).removeChangeListener(this);
        this.data.remove(n);
        this.fireDatasetChanged();
    }
    
    public void removeSeries(final XYSeries xySeries) {
        if (xySeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        if (this.data.contains(xySeries)) {
            xySeries.removeChangeListener(this);
            this.data.remove(xySeries);
            this.fireDatasetChanged();
        }
    }
    
    public void removeAllSeries() {
        for (int i = 0; i < this.data.size(); ++i) {
            ((XYSeries)this.data.get(i)).removeChangeListener(this);
        }
        this.data.clear();
        this.fireDatasetChanged();
    }
    
    public int getSeriesCount() {
        return this.data.size();
    }
    
    public List getSeries() {
        return Collections.unmodifiableList((List<?>)this.data);
    }
    
    public XYSeries getSeries(final int n) {
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
        return this.data.get(n).getDataItem(n2).getX();
    }
    
    public Number getStartX(final int n, final int n2) {
        return this.intervalDelegate.getStartX(n, n2);
    }
    
    public Number getEndX(final int n, final int n2) {
        return this.intervalDelegate.getEndX(n, n2);
    }
    
    public Number getY(final int n, final int n2) {
        return this.data.get(n).getDataItem(n2).getY();
    }
    
    public Number getStartY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof XYSeriesCollection && ObjectUtilities.equal(this.data, ((XYSeriesCollection)o).data));
    }
    
    public Object clone() {
        final XYSeriesCollection collection = (XYSeriesCollection)super.clone();
        collection.data = (List)ObjectUtilities.deepClone(this.data);
        collection.intervalDelegate = (IntervalXYDelegate)this.intervalDelegate.clone();
        return collection;
    }
    
    public int hashCode() {
        return (this.data != null) ? this.data.hashCode() : 0;
    }
    
    public double getDomainLowerBound(final boolean b) {
        return this.intervalDelegate.getDomainLowerBound(b);
    }
    
    public double getDomainUpperBound(final boolean b) {
        return this.intervalDelegate.getDomainUpperBound(b);
    }
    
    public Range getDomainBounds(final boolean b) {
        if (b) {
            return this.intervalDelegate.getDomainBounds(b);
        }
        return DatasetUtilities.iterateDomainBounds(this, b);
    }
    
    public double getIntervalWidth() {
        return this.intervalDelegate.getIntervalWidth();
    }
    
    public void setIntervalWidth(final double fixedIntervalWidth) {
        if (fixedIntervalWidth < 0.0) {
            throw new IllegalArgumentException("Negative 'width' argument.");
        }
        this.intervalDelegate.setFixedIntervalWidth(fixedIntervalWidth);
        this.fireDatasetChanged();
    }
    
    public double getIntervalPositionFactor() {
        return this.intervalDelegate.getIntervalPositionFactor();
    }
    
    public void setIntervalPositionFactor(final double intervalPositionFactor) {
        this.intervalDelegate.setIntervalPositionFactor(intervalPositionFactor);
        this.fireDatasetChanged();
    }
    
    public boolean isAutoWidth() {
        return this.intervalDelegate.isAutoWidth();
    }
    
    public void setAutoWidth(final boolean autoWidth) {
        this.intervalDelegate.setAutoWidth(autoWidth);
        this.fireDatasetChanged();
    }
}
