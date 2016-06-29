/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.AbstractXYDataset;

public class DefaultBoxAndWhiskerXYDataset
extends AbstractXYDataset
implements RangeInfo,
BoxAndWhiskerXYDataset {
    private Comparable seriesKey;
    private List dates;
    private List items;
    private Number minimumRangeValue;
    private Number maximumRangeValue;
    private Range rangeBounds;
    private double outlierCoefficient = 1.5;
    private double faroutCoefficient = 2.0;

    public DefaultBoxAndWhiskerXYDataset(Comparable comparable) {
        this.seriesKey = comparable;
        this.dates = new ArrayList();
        this.items = new ArrayList();
        this.minimumRangeValue = null;
        this.maximumRangeValue = null;
        this.rangeBounds = null;
    }

    public void add(Date date, BoxAndWhiskerItem boxAndWhiskerItem) {
        this.dates.add(date);
        this.items.add(boxAndWhiskerItem);
        if (this.minimumRangeValue == null) {
            this.minimumRangeValue = boxAndWhiskerItem.getMinRegularValue();
        } else if (boxAndWhiskerItem.getMinRegularValue().doubleValue() < this.minimumRangeValue.doubleValue()) {
            this.minimumRangeValue = boxAndWhiskerItem.getMinRegularValue();
        }
        if (this.maximumRangeValue == null) {
            this.maximumRangeValue = boxAndWhiskerItem.getMaxRegularValue();
        } else if (boxAndWhiskerItem.getMaxRegularValue().doubleValue() > this.maximumRangeValue.doubleValue()) {
            this.maximumRangeValue = boxAndWhiskerItem.getMaxRegularValue();
        }
        this.rangeBounds = new Range(this.minimumRangeValue.doubleValue(), this.maximumRangeValue.doubleValue());
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.seriesKey;
    }

    public BoxAndWhiskerItem getItem(int n2, int n3) {
        return (BoxAndWhiskerItem)this.items.get(n3);
    }

    @Override
    public Number getX(int n2, int n3) {
        return new Long(((Date)this.dates.get(n3)).getTime());
    }

    public Date getXDate(int n2, int n3) {
        return (Date)this.dates.get(n3);
    }

    @Override
    public Number getY(int n2, int n3) {
        return new Double(this.getMeanValue(n2, n3).doubleValue());
    }

    @Override
    public Number getMeanValue(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.items.get(n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMean();
    }

    @Override
    public Number getMedianValue(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.items.get(n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMedian();
    }

    @Override
    public Number getQ1Value(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.items.get(n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getQ1();
    }

    @Override
    public Number getQ3Value(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.items.get(n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getQ3();
    }

    @Override
    public Number getMinRegularValue(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.items.get(n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMinRegularValue();
    }

    @Override
    public Number getMaxRegularValue(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.items.get(n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMaxRegularValue();
    }

    @Override
    public Number getMinOutlier(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.items.get(n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMinOutlier();
    }

    @Override
    public Number getMaxOutlier(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.items.get(n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMaxOutlier();
    }

    @Override
    public List getOutliers(int n2, int n3) {
        List list = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.items.get(n3);
        if (boxAndWhiskerItem == null) return list;
        return boxAndWhiskerItem.getOutliers();
    }

    @Override
    public double getOutlierCoefficient() {
        return this.outlierCoefficient;
    }

    @Override
    public double getFaroutCoefficient() {
        return this.faroutCoefficient;
    }

    @Override
    public int getSeriesCount() {
        return 1;
    }

    @Override
    public int getItemCount(int n2) {
        return this.dates.size();
    }

    public void setOutlierCoefficient(double d2) {
        this.outlierCoefficient = d2;
    }

    public void setFaroutCoefficient(double d2) {
        if (d2 <= this.getOutlierCoefficient()) throw new IllegalArgumentException(new StringBuffer().append("Farout value must be greater than the outlier value, which is currently set at: (").append(this.getOutlierCoefficient()).append(")").toString());
        this.faroutCoefficient = d2;
    }

    @Override
    public double getRangeLowerBound(boolean bl2) {
        double d2 = Double.NaN;
        if (this.minimumRangeValue == null) return d2;
        return this.minimumRangeValue.doubleValue();
    }

    @Override
    public double getRangeUpperBound(boolean bl2) {
        double d2 = Double.NaN;
        if (this.maximumRangeValue == null) return d2;
        return this.maximumRangeValue.doubleValue();
    }

    @Override
    public Range getRangeBounds(boolean bl2) {
        return this.rangeBounds;
    }
}

