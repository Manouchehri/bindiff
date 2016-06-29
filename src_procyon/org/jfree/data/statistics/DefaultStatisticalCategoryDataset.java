package org.jfree.data.statistics;

import org.jfree.data.general.*;
import java.util.*;
import org.jfree.data.*;

public class DefaultStatisticalCategoryDataset extends AbstractDataset implements RangeInfo, StatisticalCategoryDataset
{
    private KeyedObjects2D data;
    private double minimumRangeValue;
    private double minimumRangeValueIncStdDev;
    private double maximumRangeValue;
    private double maximumRangeValueIncStdDev;
    
    public DefaultStatisticalCategoryDataset() {
        this.data = new KeyedObjects2D();
        this.minimumRangeValue = Double.NaN;
        this.maximumRangeValue = Double.NaN;
        this.minimumRangeValueIncStdDev = Double.NaN;
        this.maximumRangeValueIncStdDev = Double.NaN;
    }
    
    public Number getMeanValue(final int n, final int n2) {
        Number mean = null;
        final MeanAndStandardDeviation meanAndStandardDeviation = (MeanAndStandardDeviation)this.data.getObject(n, n2);
        if (meanAndStandardDeviation != null) {
            mean = meanAndStandardDeviation.getMean();
        }
        return mean;
    }
    
    public Number getValue(final int n, final int n2) {
        return this.getMeanValue(n, n2);
    }
    
    public Number getValue(final Comparable comparable, final Comparable comparable2) {
        return this.getMeanValue(comparable, comparable2);
    }
    
    public Number getMeanValue(final Comparable comparable, final Comparable comparable2) {
        Number mean = null;
        final MeanAndStandardDeviation meanAndStandardDeviation = (MeanAndStandardDeviation)this.data.getObject(comparable, comparable2);
        if (meanAndStandardDeviation != null) {
            mean = meanAndStandardDeviation.getMean();
        }
        return mean;
    }
    
    public Number getStdDevValue(final int n, final int n2) {
        Number standardDeviation = null;
        final MeanAndStandardDeviation meanAndStandardDeviation = (MeanAndStandardDeviation)this.data.getObject(n, n2);
        if (meanAndStandardDeviation != null) {
            standardDeviation = meanAndStandardDeviation.getStandardDeviation();
        }
        return standardDeviation;
    }
    
    public Number getStdDevValue(final Comparable comparable, final Comparable comparable2) {
        Number standardDeviation = null;
        final MeanAndStandardDeviation meanAndStandardDeviation = (MeanAndStandardDeviation)this.data.getObject(comparable, comparable2);
        if (meanAndStandardDeviation != null) {
            standardDeviation = meanAndStandardDeviation.getStandardDeviation();
        }
        return standardDeviation;
    }
    
    public int getColumnIndex(final Comparable comparable) {
        return this.data.getColumnIndex(comparable);
    }
    
    public Comparable getColumnKey(final int n) {
        return this.data.getColumnKey(n);
    }
    
    public List getColumnKeys() {
        return this.data.getColumnKeys();
    }
    
    public int getRowIndex(final Comparable comparable) {
        return this.data.getRowIndex(comparable);
    }
    
    public Comparable getRowKey(final int n) {
        return this.data.getRowKey(n);
    }
    
    public List getRowKeys() {
        return this.data.getRowKeys();
    }
    
    public int getRowCount() {
        return this.data.getRowCount();
    }
    
    public int getColumnCount() {
        return this.data.getColumnCount();
    }
    
    public void add(final double n, final double n2, final Comparable comparable, final Comparable comparable2) {
        this.add(new Double(n), new Double(n2), comparable, comparable2);
    }
    
    public void add(final Number n, final Number n2, final Comparable comparable, final Comparable comparable2) {
        this.data.addObject(new MeanAndStandardDeviation(n, n2), comparable, comparable2);
        double doubleValue = 0.0;
        double doubleValue2 = 0.0;
        if (n != null) {
            doubleValue = n.doubleValue();
        }
        if (n2 != null) {
            doubleValue2 = n2.doubleValue();
        }
        if (!Double.isNaN(doubleValue) && (Double.isNaN(this.maximumRangeValue) || doubleValue > this.maximumRangeValue)) {
            this.maximumRangeValue = doubleValue;
        }
        if (!Double.isNaN(doubleValue + doubleValue2) && (Double.isNaN(this.maximumRangeValueIncStdDev) || doubleValue + doubleValue2 > this.maximumRangeValueIncStdDev)) {
            this.maximumRangeValueIncStdDev = doubleValue + doubleValue2;
        }
        if (!Double.isNaN(doubleValue) && (Double.isNaN(this.minimumRangeValue) || doubleValue < this.minimumRangeValue)) {
            this.minimumRangeValue = doubleValue;
        }
        if (!Double.isNaN(doubleValue - doubleValue2) && (Double.isNaN(this.minimumRangeValueIncStdDev) || doubleValue - doubleValue2 < this.minimumRangeValueIncStdDev)) {
            this.minimumRangeValueIncStdDev = doubleValue - doubleValue2;
        }
        this.fireDatasetChanged();
    }
    
    public double getRangeLowerBound(final boolean b) {
        return this.minimumRangeValue;
    }
    
    public double getRangeUpperBound(final boolean b) {
        return this.maximumRangeValue;
    }
    
    public Range getRangeBounds(final boolean b) {
        Range range = null;
        if (b) {
            if (!Double.isNaN(this.minimumRangeValueIncStdDev) && !Double.isNaN(this.maximumRangeValueIncStdDev)) {
                range = new Range(this.minimumRangeValueIncStdDev, this.maximumRangeValueIncStdDev);
            }
        }
        else if (!Double.isNaN(this.minimumRangeValue) && !Double.isNaN(this.maximumRangeValue)) {
            range = new Range(this.minimumRangeValue, this.maximumRangeValue);
        }
        return range;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof DefaultStatisticalCategoryDataset && this.data.equals(((DefaultStatisticalCategoryDataset)o).data));
    }
}
