/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.util.List;
import org.jfree.data.KeyedObjects2D;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.util.ObjectUtilities;

public class DefaultBoxAndWhiskerCategoryDataset
extends AbstractDataset
implements RangeInfo,
BoxAndWhiskerCategoryDataset {
    protected KeyedObjects2D data = new KeyedObjects2D();
    private Number minimumRangeValue = null;
    private Number maximumRangeValue = null;
    private Range rangeBounds = new Range(0.0, 0.0);

    public void add(List list, Comparable comparable, Comparable comparable2) {
        BoxAndWhiskerItem boxAndWhiskerItem = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(list);
        this.add(boxAndWhiskerItem, comparable, comparable2);
    }

    public void add(BoxAndWhiskerItem boxAndWhiskerItem, Comparable comparable, Comparable comparable2) {
        this.data.addObject(boxAndWhiskerItem, comparable, comparable2);
        double d2 = boxAndWhiskerItem.getMinOutlier().doubleValue();
        double d3 = boxAndWhiskerItem.getMaxOutlier().doubleValue();
        if (this.maximumRangeValue == null) {
            this.maximumRangeValue = new Double(d3);
        } else if (d3 > this.maximumRangeValue.doubleValue()) {
            this.maximumRangeValue = new Double(d3);
        }
        if (this.minimumRangeValue == null) {
            this.minimumRangeValue = new Double(d2);
        } else if (d2 < this.minimumRangeValue.doubleValue()) {
            this.minimumRangeValue = new Double(d2);
        }
        this.rangeBounds = new Range(this.minimumRangeValue.doubleValue(), this.maximumRangeValue.doubleValue());
        this.fireDatasetChanged();
    }

    public BoxAndWhiskerItem getItem(int n2, int n3) {
        return (BoxAndWhiskerItem)this.data.getObject(n2, n3);
    }

    @Override
    public Number getValue(int n2, int n3) {
        return this.getMedianValue(n2, n3);
    }

    @Override
    public Number getValue(Comparable comparable, Comparable comparable2) {
        return this.getMedianValue(comparable, comparable2);
    }

    @Override
    public Number getMeanValue(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n2, n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMean();
    }

    @Override
    public Number getMeanValue(Comparable comparable, Comparable comparable2) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMean();
    }

    @Override
    public Number getMedianValue(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n2, n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMedian();
    }

    @Override
    public Number getMedianValue(Comparable comparable, Comparable comparable2) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMedian();
    }

    @Override
    public Number getQ1Value(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n2, n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getQ1();
    }

    @Override
    public Number getQ1Value(Comparable comparable, Comparable comparable2) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getQ1();
    }

    @Override
    public Number getQ3Value(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n2, n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getQ3();
    }

    @Override
    public Number getQ3Value(Comparable comparable, Comparable comparable2) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getQ3();
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

    @Override
    public Number getMinRegularValue(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n2, n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMinRegularValue();
    }

    @Override
    public Number getMinRegularValue(Comparable comparable, Comparable comparable2) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMinRegularValue();
    }

    @Override
    public Number getMaxRegularValue(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n2, n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMaxRegularValue();
    }

    @Override
    public Number getMaxRegularValue(Comparable comparable, Comparable comparable2) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMaxRegularValue();
    }

    @Override
    public Number getMinOutlier(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n2, n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMinOutlier();
    }

    @Override
    public Number getMinOutlier(Comparable comparable, Comparable comparable2) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMinOutlier();
    }

    @Override
    public Number getMaxOutlier(int n2, int n3) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n2, n3);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMaxOutlier();
    }

    @Override
    public Number getMaxOutlier(Comparable comparable, Comparable comparable2) {
        Number number = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem == null) return number;
        return boxAndWhiskerItem.getMaxOutlier();
    }

    @Override
    public List getOutliers(int n2, int n3) {
        List list = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(n2, n3);
        if (boxAndWhiskerItem == null) return list;
        return boxAndWhiskerItem.getOutliers();
    }

    @Override
    public List getOutliers(Comparable comparable, Comparable comparable2) {
        List list = null;
        BoxAndWhiskerItem boxAndWhiskerItem = (BoxAndWhiskerItem)this.data.getObject(comparable, comparable2);
        if (boxAndWhiskerItem == null) return list;
        return boxAndWhiskerItem.getOutliers();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DefaultBoxAndWhiskerCategoryDataset)) return false;
        DefaultBoxAndWhiskerCategoryDataset defaultBoxAndWhiskerCategoryDataset = (DefaultBoxAndWhiskerCategoryDataset)object;
        return ObjectUtilities.equal(this.data, defaultBoxAndWhiskerCategoryDataset.data);
    }
}

