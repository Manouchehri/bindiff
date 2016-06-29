package org.jfree.data.statistics;

import org.jfree.data.general.*;
import org.jfree.data.*;
import java.util.*;
import org.jfree.util.*;

public class DefaultBoxAndWhiskerCategoryDataset extends AbstractDataset implements RangeInfo, BoxAndWhiskerCategoryDataset
{
    protected KeyedObjects2D data;
    private Number minimumRangeValue;
    private Number maximumRangeValue;
    private Range rangeBounds;
    
    public DefaultBoxAndWhiskerCategoryDataset() {
        this.data = new KeyedObjects2D();
        this.minimumRangeValue = null;
        this.maximumRangeValue = null;
        this.rangeBounds = new Range(0.0, 0.0);
    }
    
    public void add(final List list, final Comparable comparable, final Comparable comparable2) {
        this.add(BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(list), comparable, comparable2);
    }
    
    public void add(final BoxAndWhiskerItem boxAndWhiskerItem, final Comparable comparable, final Comparable comparable2) {
        this.data.addObject(boxAndWhiskerItem, comparable, comparable2);
        final double doubleValue = boxAndWhiskerItem.getMinOutlier().doubleValue();
        final double doubleValue2 = boxAndWhiskerItem.getMaxOutlier().doubleValue();
        if (this.maximumRangeValue == null) {
            this.maximumRangeValue = new Double(doubleValue2);
        }
        else if (doubleValue2 > this.maximumRangeValue.doubleValue()) {
            this.maximumRangeValue = new Double(doubleValue2);
        }
        if (this.minimumRangeValue == null) {
            this.minimumRangeValue = new Double(doubleValue);
        }
        else if (doubleValue < this.minimumRangeValue.doubleValue()) {
            this.minimumRangeValue = new Double(doubleValue);
        }
        this.rangeBounds = new Range(this.minimumRangeValue.doubleValue(), this.maximumRangeValue.doubleValue());
        this.fireDatasetChanged();
    }
    
    public BoxAndWhiskerItem getItem(final int n, final int n2) {
        return (BoxAndWhiskerItem)this.data.getObject(n, n2);
    }
    
    public Number getValue(final int n, final int n2) {
        return this.getMedianValue(n, n2);
    }
    
    public Number getValue(final Comparable comparable, final Comparable comparable2) {
        return this.getMedianValue(comparable, comparable2);
    }
    
    public Number getMeanValue(final int n, final int n2) {
        Number mean = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n, n2);
        if (boxAndWhiskerItem != null) {
            mean = boxAndWhiskerItem.getMean();
        }
        return mean;
    }
    
    public Number getMeanValue(final Comparable comparable, final Comparable comparable2) {
        Number mean = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem != null) {
            mean = boxAndWhiskerItem.getMean();
        }
        return mean;
    }
    
    public Number getMedianValue(final int n, final int n2) {
        Number median = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n, n2);
        if (boxAndWhiskerItem != null) {
            median = boxAndWhiskerItem.getMedian();
        }
        return median;
    }
    
    public Number getMedianValue(final Comparable comparable, final Comparable comparable2) {
        Number median = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem != null) {
            median = boxAndWhiskerItem.getMedian();
        }
        return median;
    }
    
    public Number getQ1Value(final int n, final int n2) {
        Number q1 = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n, n2);
        if (boxAndWhiskerItem != null) {
            q1 = boxAndWhiskerItem.getQ1();
        }
        return q1;
    }
    
    public Number getQ1Value(final Comparable comparable, final Comparable comparable2) {
        Number q1 = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem != null) {
            q1 = boxAndWhiskerItem.getQ1();
        }
        return q1;
    }
    
    public Number getQ3Value(final int n, final int n2) {
        Number q3 = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n, n2);
        if (boxAndWhiskerItem != null) {
            q3 = boxAndWhiskerItem.getQ3();
        }
        return q3;
    }
    
    public Number getQ3Value(final Comparable comparable, final Comparable comparable2) {
        Number q3 = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem != null) {
            q3 = boxAndWhiskerItem.getQ3();
        }
        return q3;
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
    
    public double getRangeLowerBound(final boolean b) {
        double doubleValue = Double.NaN;
        if (this.minimumRangeValue != null) {
            doubleValue = this.minimumRangeValue.doubleValue();
        }
        return doubleValue;
    }
    
    public double getRangeUpperBound(final boolean b) {
        double doubleValue = Double.NaN;
        if (this.maximumRangeValue != null) {
            doubleValue = this.maximumRangeValue.doubleValue();
        }
        return doubleValue;
    }
    
    public Range getRangeBounds(final boolean b) {
        return this.rangeBounds;
    }
    
    public Number getMinRegularValue(final int n, final int n2) {
        Number minRegularValue = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n, n2);
        if (boxAndWhiskerItem != null) {
            minRegularValue = boxAndWhiskerItem.getMinRegularValue();
        }
        return minRegularValue;
    }
    
    public Number getMinRegularValue(final Comparable comparable, final Comparable comparable2) {
        Number minRegularValue = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem != null) {
            minRegularValue = boxAndWhiskerItem.getMinRegularValue();
        }
        return minRegularValue;
    }
    
    public Number getMaxRegularValue(final int n, final int n2) {
        Number maxRegularValue = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n, n2);
        if (boxAndWhiskerItem != null) {
            maxRegularValue = boxAndWhiskerItem.getMaxRegularValue();
        }
        return maxRegularValue;
    }
    
    public Number getMaxRegularValue(final Comparable comparable, final Comparable comparable2) {
        Number maxRegularValue = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem != null) {
            maxRegularValue = boxAndWhiskerItem.getMaxRegularValue();
        }
        return maxRegularValue;
    }
    
    public Number getMinOutlier(final int n, final int n2) {
        Number minOutlier = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n, n2);
        if (boxAndWhiskerItem != null) {
            minOutlier = boxAndWhiskerItem.getMinOutlier();
        }
        return minOutlier;
    }
    
    public Number getMinOutlier(final Comparable comparable, final Comparable comparable2) {
        Number minOutlier = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem != null) {
            minOutlier = boxAndWhiskerItem.getMinOutlier();
        }
        return minOutlier;
    }
    
    public Number getMaxOutlier(final int n, final int n2) {
        Number maxOutlier = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n, n2);
        if (boxAndWhiskerItem != null) {
            maxOutlier = boxAndWhiskerItem.getMaxOutlier();
        }
        return maxOutlier;
    }
    
    public Number getMaxOutlier(final Comparable comparable, final Comparable comparable2) {
        Number maxOutlier = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem != null) {
            maxOutlier = boxAndWhiskerItem.getMaxOutlier();
        }
        return maxOutlier;
    }
    
    public List getOutliers(final int n, final int n2) {
        List outliers = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n, n2);
        if (boxAndWhiskerItem != null) {
            outliers = boxAndWhiskerItem.getOutliers();
        }
        return outliers;
    }
    
    public List getOutliers(final Comparable comparable, final Comparable comparable2) {
        List outliers = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem != null) {
            outliers = boxAndWhiskerItem.getOutliers();
        }
        return outliers;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof DefaultBoxAndWhiskerCategoryDataset && ObjectUtilities.equal(this.data, ((DefaultBoxAndWhiskerCategoryDataset)o).data));
    }
}
