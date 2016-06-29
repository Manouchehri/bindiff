package org.jfree.data.statistics;

import org.jfree.data.xy.*;
import org.jfree.data.*;
import java.util.*;

public class DefaultBoxAndWhiskerXYDataset extends AbstractXYDataset implements RangeInfo, BoxAndWhiskerXYDataset
{
    private Comparable seriesKey;
    private List dates;
    private List items;
    private Number minimumRangeValue;
    private Number maximumRangeValue;
    private Range rangeBounds;
    private double outlierCoefficient;
    private double faroutCoefficient;
    
    public DefaultBoxAndWhiskerXYDataset(final Comparable seriesKey) {
        this.outlierCoefficient = 1.5;
        this.faroutCoefficient = 2.0;
        this.seriesKey = seriesKey;
        this.dates = new ArrayList();
        this.items = new ArrayList();
        this.minimumRangeValue = null;
        this.maximumRangeValue = null;
        this.rangeBounds = null;
    }
    
    public void add(final Date date, final BoxAndWhiskerItem boxAndWhiskerItem) {
        this.dates.add(date);
        this.items.add(boxAndWhiskerItem);
        if (this.minimumRangeValue == null) {
            this.minimumRangeValue = boxAndWhiskerItem.getMinRegularValue();
        }
        else if (boxAndWhiskerItem.getMinRegularValue().doubleValue() < this.minimumRangeValue.doubleValue()) {
            this.minimumRangeValue = boxAndWhiskerItem.getMinRegularValue();
        }
        if (this.maximumRangeValue == null) {
            this.maximumRangeValue = boxAndWhiskerItem.getMaxRegularValue();
        }
        else if (boxAndWhiskerItem.getMaxRegularValue().doubleValue() > this.maximumRangeValue.doubleValue()) {
            this.maximumRangeValue = boxAndWhiskerItem.getMaxRegularValue();
        }
        this.rangeBounds = new Range(this.minimumRangeValue.doubleValue(), this.maximumRangeValue.doubleValue());
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.seriesKey;
    }
    
    public BoxAndWhiskerItem getItem(final int n, final int n2) {
        return this.items.get(n2);
    }
    
    public Number getX(final int n, final int n2) {
        return new Long(this.dates.get(n2).getTime());
    }
    
    public Date getXDate(final int n, final int n2) {
        return this.dates.get(n2);
    }
    
    public Number getY(final int n, final int n2) {
        return new Double(this.getMeanValue(n, n2).doubleValue());
    }
    
    public Number getMeanValue(final int n, final int n2) {
        Number mean = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = this.items.get(n2);
        if (boxAndWhiskerItem != null) {
            mean = boxAndWhiskerItem.getMean();
        }
        return mean;
    }
    
    public Number getMedianValue(final int n, final int n2) {
        Number median = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = this.items.get(n2);
        if (boxAndWhiskerItem != null) {
            median = boxAndWhiskerItem.getMedian();
        }
        return median;
    }
    
    public Number getQ1Value(final int n, final int n2) {
        Number q1 = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = this.items.get(n2);
        if (boxAndWhiskerItem != null) {
            q1 = boxAndWhiskerItem.getQ1();
        }
        return q1;
    }
    
    public Number getQ3Value(final int n, final int n2) {
        Number q3 = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = this.items.get(n2);
        if (boxAndWhiskerItem != null) {
            q3 = boxAndWhiskerItem.getQ3();
        }
        return q3;
    }
    
    public Number getMinRegularValue(final int n, final int n2) {
        Number minRegularValue = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = this.items.get(n2);
        if (boxAndWhiskerItem != null) {
            minRegularValue = boxAndWhiskerItem.getMinRegularValue();
        }
        return minRegularValue;
    }
    
    public Number getMaxRegularValue(final int n, final int n2) {
        Number maxRegularValue = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = this.items.get(n2);
        if (boxAndWhiskerItem != null) {
            maxRegularValue = boxAndWhiskerItem.getMaxRegularValue();
        }
        return maxRegularValue;
    }
    
    public Number getMinOutlier(final int n, final int n2) {
        Number minOutlier = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = this.items.get(n2);
        if (boxAndWhiskerItem != null) {
            minOutlier = boxAndWhiskerItem.getMinOutlier();
        }
        return minOutlier;
    }
    
    public Number getMaxOutlier(final int n, final int n2) {
        Number maxOutlier = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = this.items.get(n2);
        if (boxAndWhiskerItem != null) {
            maxOutlier = boxAndWhiskerItem.getMaxOutlier();
        }
        return maxOutlier;
    }
    
    public List getOutliers(final int n, final int n2) {
        List outliers = null;
        final BoxAndWhiskerItem boxAndWhiskerItem = this.items.get(n2);
        if (boxAndWhiskerItem != null) {
            outliers = boxAndWhiskerItem.getOutliers();
        }
        return outliers;
    }
    
    public double getOutlierCoefficient() {
        return this.outlierCoefficient;
    }
    
    public double getFaroutCoefficient() {
        return this.faroutCoefficient;
    }
    
    public int getSeriesCount() {
        return 1;
    }
    
    public int getItemCount(final int n) {
        return this.dates.size();
    }
    
    public void setOutlierCoefficient(final double outlierCoefficient) {
        this.outlierCoefficient = outlierCoefficient;
    }
    
    public void setFaroutCoefficient(final double faroutCoefficient) {
        if (faroutCoefficient > this.getOutlierCoefficient()) {
            this.faroutCoefficient = faroutCoefficient;
            return;
        }
        throw new IllegalArgumentException("Farout value must be greater than the outlier value, which is currently set at: (" + this.getOutlierCoefficient() + ")");
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
}
