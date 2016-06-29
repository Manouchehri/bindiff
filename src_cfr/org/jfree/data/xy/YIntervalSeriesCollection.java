/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.util.ObjectUtilities;

public class YIntervalSeriesCollection
extends AbstractIntervalXYDataset
implements Serializable,
IntervalXYDataset {
    private List data = new ArrayList();

    public void addSeries(YIntervalSeries yIntervalSeries) {
        if (yIntervalSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(yIntervalSeries);
        yIntervalSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }

    @Override
    public int getSeriesCount() {
        return this.data.size();
    }

    public YIntervalSeries getSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Series index out of bounds");
        if (n2 < this.getSeriesCount()) return (YIntervalSeries)this.data.get(n2);
        throw new IllegalArgumentException("Series index out of bounds");
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.getSeries(n2).getKey();
    }

    @Override
    public int getItemCount(int n2) {
        return this.getSeries(n2).getItemCount();
    }

    @Override
    public Number getX(int n2, int n3) {
        YIntervalSeries yIntervalSeries = (YIntervalSeries)this.data.get(n2);
        return yIntervalSeries.getX(n3);
    }

    @Override
    public double getYValue(int n2, int n3) {
        YIntervalSeries yIntervalSeries = (YIntervalSeries)this.data.get(n2);
        return yIntervalSeries.getYValue(n3);
    }

    @Override
    public double getStartYValue(int n2, int n3) {
        YIntervalSeries yIntervalSeries = (YIntervalSeries)this.data.get(n2);
        return yIntervalSeries.getYLowValue(n3);
    }

    @Override
    public double getEndYValue(int n2, int n3) {
        YIntervalSeries yIntervalSeries = (YIntervalSeries)this.data.get(n2);
        return yIntervalSeries.getYHighValue(n3);
    }

    @Override
    public Number getY(int n2, int n3) {
        YIntervalSeries yIntervalSeries = (YIntervalSeries)this.data.get(n2);
        return new Double(yIntervalSeries.getYValue(n3));
    }

    @Override
    public Number getStartX(int n2, int n3) {
        return this.getX(n2, n3);
    }

    @Override
    public Number getEndX(int n2, int n3) {
        return this.getX(n2, n3);
    }

    @Override
    public Number getStartY(int n2, int n3) {
        YIntervalSeries yIntervalSeries = (YIntervalSeries)this.data.get(n2);
        return new Double(yIntervalSeries.getYLowValue(n3));
    }

    @Override
    public Number getEndY(int n2, int n3) {
        YIntervalSeries yIntervalSeries = (YIntervalSeries)this.data.get(n2);
        return new Double(yIntervalSeries.getYHighValue(n3));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof YIntervalSeriesCollection)) {
            return false;
        }
        YIntervalSeriesCollection yIntervalSeriesCollection = (YIntervalSeriesCollection)object;
        return ObjectUtilities.equal(this.data, yIntervalSeriesCollection.data);
    }

    @Override
    public Object clone() {
        YIntervalSeriesCollection yIntervalSeriesCollection = (YIntervalSeriesCollection)super.clone();
        yIntervalSeriesCollection.data = (List)ObjectUtilities.deepClone(this.data);
        return yIntervalSeriesCollection;
    }
}

