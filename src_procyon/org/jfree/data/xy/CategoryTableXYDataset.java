package org.jfree.data.xy;

import org.jfree.data.*;
import org.jfree.data.general.*;

public class CategoryTableXYDataset extends AbstractIntervalXYDataset implements DomainInfo, IntervalXYDataset, TableXYDataset
{
    private DefaultKeyedValues2D values;
    private IntervalXYDelegate intervalDelegate;
    
    public CategoryTableXYDataset() {
        this.values = new DefaultKeyedValues2D(true);
        this.addChangeListener(this.intervalDelegate = new IntervalXYDelegate(this));
    }
    
    public void add(final double n, final double n2, final String s) {
        this.add(new Double(n), new Double(n2), s, true);
    }
    
    public void add(final Number n, final Number n2, final String s, final boolean b) {
        this.values.addValue(n2, (Comparable)n, s);
        if (b) {
            this.fireDatasetChanged();
        }
    }
    
    public void remove(final double n, final String s) {
        this.remove(new Double(n), s, true);
    }
    
    public void remove(final Number n, final String s, final boolean b) {
        this.values.removeValue((Comparable)n, s);
        if (b) {
            this.fireDatasetChanged();
        }
    }
    
    public int getSeriesCount() {
        return this.values.getColumnCount();
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.values.getColumnKey(n);
    }
    
    public int getItemCount() {
        return this.values.getRowCount();
    }
    
    public int getItemCount(final int n) {
        return this.getItemCount();
    }
    
    public Number getX(final int n, final int n2) {
        return (Number)this.values.getRowKey(n2);
    }
    
    public Number getStartX(final int n, final int n2) {
        return this.intervalDelegate.getStartX(n, n2);
    }
    
    public Number getEndX(final int n, final int n2) {
        return this.intervalDelegate.getEndX(n, n2);
    }
    
    public Number getY(final int n, final int n2) {
        return this.values.getValue(n2, n);
    }
    
    public Number getStartY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        return this.getY(n, n2);
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
    
    public double getIntervalPositionFactor() {
        return this.intervalDelegate.getIntervalPositionFactor();
    }
    
    public void setIntervalPositionFactor(final double intervalPositionFactor) {
        this.intervalDelegate.setIntervalPositionFactor(intervalPositionFactor);
        this.fireDatasetChanged();
    }
    
    public double getIntervalWidth() {
        return this.intervalDelegate.getIntervalWidth();
    }
    
    public void setIntervalWidth(final double fixedIntervalWidth) {
        this.intervalDelegate.setFixedIntervalWidth(fixedIntervalWidth);
        this.fireDatasetChanged();
    }
    
    public boolean isAutoWidth() {
        return this.intervalDelegate.isAutoWidth();
    }
    
    public void setAutoWidth(final boolean autoWidth) {
        this.intervalDelegate.setAutoWidth(autoWidth);
        this.fireDatasetChanged();
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof CategoryTableXYDataset)) {
            return false;
        }
        final CategoryTableXYDataset categoryTableXYDataset = (CategoryTableXYDataset)o;
        return this.intervalDelegate.equals(categoryTableXYDataset.intervalDelegate) && this.values.equals(categoryTableXYDataset.values);
    }
}
