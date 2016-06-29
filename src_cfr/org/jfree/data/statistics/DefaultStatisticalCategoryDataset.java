/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.util.List;
import org.jfree.data.KeyedObjects2D;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.statistics.MeanAndStandardDeviation;
import org.jfree.data.statistics.StatisticalCategoryDataset;

public class DefaultStatisticalCategoryDataset
extends AbstractDataset
implements RangeInfo,
StatisticalCategoryDataset {
    private KeyedObjects2D data = new KeyedObjects2D();
    private double minimumRangeValue = Double.NaN;
    private double minimumRangeValueIncStdDev = Double.NaN;
    private double maximumRangeValue = Double.NaN;
    private double maximumRangeValueIncStdDev = Double.NaN;

    @Override
    public Number getMeanValue(int n2, int n3) {
        Number number = null;
        MeanAndStandardDeviation meanAndStandardDeviation = (MeanAndStandardDeviation)this.data.getObject(n2, n3);
        if (meanAndStandardDeviation == null) return number;
        return meanAndStandardDeviation.getMean();
    }

    @Override
    public Number getValue(int n2, int n3) {
        return this.getMeanValue(n2, n3);
    }

    @Override
    public Number getValue(Comparable comparable, Comparable comparable2) {
        return this.getMeanValue(comparable, comparable2);
    }

    @Override
    public Number getMeanValue(Comparable comparable, Comparable comparable2) {
        Number number = null;
        MeanAndStandardDeviation meanAndStandardDeviation = (MeanAndStandardDeviation)this.data.getObject(comparable, comparable2);
        if (meanAndStandardDeviation == null) return number;
        return meanAndStandardDeviation.getMean();
    }

    @Override
    public Number getStdDevValue(int n2, int n3) {
        Number number = null;
        MeanAndStandardDeviation meanAndStandardDeviation = (MeanAndStandardDeviation)this.data.getObject(n2, n3);
        if (meanAndStandardDeviation == null) return number;
        return meanAndStandardDeviation.getStandardDeviation();
    }

    @Override
    public Number getStdDevValue(Comparable comparable, Comparable comparable2) {
        Number number = null;
        MeanAndStandardDeviation meanAndStandardDeviation = (MeanAndStandardDeviation)this.data.getObject(comparable, comparable2);
        if (meanAndStandardDeviation == null) return number;
        return meanAndStandardDeviation.getStandardDeviation();
    }

    @Override
    public int getColumnIndex(Comparable comparable) {
        return this.data.getColumnIndex(comparable);
    }

    @Override
    public Comparable getColumnKey(int n2) {
        return this.data.getColumnKey(n2);
    }

    @Override
    public List getColumnKeys() {
        return this.data.getColumnKeys();
    }

    @Override
    public int getRowIndex(Comparable comparable) {
        return this.data.getRowIndex(comparable);
    }

    @Override
    public Comparable getRowKey(int n2) {
        return this.data.getRowKey(n2);
    }

    @Override
    public List getRowKeys() {
        return this.data.getRowKeys();
    }

    @Override
    public int getRowCount() {
        return this.data.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return this.data.getColumnCount();
    }

    public void add(double d2, double d3, Comparable comparable, Comparable comparable2) {
        this.add(new Double(d2), new Double(d3), comparable, comparable2);
    }

    public void add(Number number, Number number2, Comparable comparable, Comparable comparable2) {
        MeanAndStandardDeviation meanAndStandardDeviation = new MeanAndStandardDeviation(number, number2);
        this.data.addObject(meanAndStandardDeviation, comparable, comparable2);
        double d2 = 0.0;
        double d3 = 0.0;
        if (number != null) {
            d2 = number.doubleValue();
        }
        if (number2 != null) {
            d3 = number2.doubleValue();
        }
        if (!Double.isNaN(d2) && (Double.isNaN(this.maximumRangeValue) || d2 > this.maximumRangeValue)) {
            this.maximumRangeValue = d2;
        }
        if (!Double.isNaN(d2 + d3) && (Double.isNaN(this.maximumRangeValueIncStdDev) || d2 + d3 > this.maximumRangeValueIncStdDev)) {
            this.maximumRangeValueIncStdDev = d2 + d3;
        }
        if (!Double.isNaN(d2) && (Double.isNaN(this.minimumRangeValue) || d2 < this.minimumRangeValue)) {
            this.minimumRangeValue = d2;
        }
        if (!Double.isNaN(d2 - d3) && (Double.isNaN(this.minimumRangeValueIncStdDev) || d2 - d3 < this.minimumRangeValueIncStdDev)) {
            this.minimumRangeValueIncStdDev = d2 - d3;
        }
        this.fireDatasetChanged();
    }

    @Override
    public double getRangeLowerBound(boolean bl2) {
        return this.minimumRangeValue;
    }

    @Override
    public double getRangeUpperBound(boolean bl2) {
        return this.maximumRangeValue;
    }

    @Override
    public Range getRangeBounds(boolean bl2) {
        Range range = null;
        if (bl2) {
            if (Double.isNaN(this.minimumRangeValueIncStdDev)) return range;
            if (Double.isNaN(this.maximumRangeValueIncStdDev)) return range;
            return new Range(this.minimumRangeValueIncStdDev, this.maximumRangeValueIncStdDev);
        }
        if (Double.isNaN(this.minimumRangeValue)) return range;
        if (Double.isNaN(this.maximumRangeValue)) return range;
        return new Range(this.minimumRangeValue, this.maximumRangeValue);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DefaultStatisticalCategoryDataset)) {
            return false;
        }
        DefaultStatisticalCategoryDataset defaultStatisticalCategoryDataset = (DefaultStatisticalCategoryDataset)object;
        if (this.data.equals(defaultStatisticalCategoryDataset.data)) return true;
        return false;
    }
}

