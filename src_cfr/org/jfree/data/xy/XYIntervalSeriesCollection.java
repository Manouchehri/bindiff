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
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.util.ObjectUtilities;

public class XYIntervalSeriesCollection
extends AbstractIntervalXYDataset
implements Serializable,
IntervalXYDataset {
    private List data = new ArrayList();

    public void addSeries(XYIntervalSeries xYIntervalSeries) {
        if (xYIntervalSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(xYIntervalSeries);
        xYIntervalSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }

    @Override
    public int getSeriesCount() {
        return this.data.size();
    }

    public XYIntervalSeries getSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Series index out of bounds");
        if (n2 < this.getSeriesCount()) return (XYIntervalSeries)this.data.get(n2);
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
        XYIntervalSeries xYIntervalSeries = (XYIntervalSeries)this.data.get(n2);
        return xYIntervalSeries.getX(n3);
    }

    @Override
    public double getStartXValue(int n2, int n3) {
        XYIntervalSeries xYIntervalSeries = (XYIntervalSeries)this.data.get(n2);
        return xYIntervalSeries.getXLowValue(n3);
    }

    @Override
    public double getEndXValue(int n2, int n3) {
        XYIntervalSeries xYIntervalSeries = (XYIntervalSeries)this.data.get(n2);
        return xYIntervalSeries.getXHighValue(n3);
    }

    @Override
    public double getYValue(int n2, int n3) {
        XYIntervalSeries xYIntervalSeries = (XYIntervalSeries)this.data.get(n2);
        return xYIntervalSeries.getYValue(n3);
    }

    @Override
    public double getStartYValue(int n2, int n3) {
        XYIntervalSeries xYIntervalSeries = (XYIntervalSeries)this.data.get(n2);
        return xYIntervalSeries.getYLowValue(n3);
    }

    @Override
    public double getEndYValue(int n2, int n3) {
        XYIntervalSeries xYIntervalSeries = (XYIntervalSeries)this.data.get(n2);
        return xYIntervalSeries.getYHighValue(n3);
    }

    @Override
    public Number getY(int n2, int n3) {
        return new Double(this.getYValue(n2, n3));
    }

    @Override
    public Number getStartX(int n2, int n3) {
        return new Double(this.getStartXValue(n2, n3));
    }

    @Override
    public Number getEndX(int n2, int n3) {
        return new Double(this.getEndXValue(n2, n3));
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return new Double(this.getStartYValue(n2, n3));
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return new Double(this.getEndYValue(n2, n3));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYIntervalSeriesCollection)) {
            return false;
        }
        XYIntervalSeriesCollection xYIntervalSeriesCollection = (XYIntervalSeriesCollection)object;
        return ObjectUtilities.equal(this.data, xYIntervalSeriesCollection.data);
    }

    @Override
    public Object clone() {
        XYIntervalSeriesCollection xYIntervalSeriesCollection = (XYIntervalSeriesCollection)super.clone();
        int n2 = this.getSeriesCount();
        xYIntervalSeriesCollection.data = new ArrayList(n2);
        int n3 = 0;
        while (n3 < this.data.size()) {
            xYIntervalSeriesCollection.data.set(n3, this.getSeries(n3).clone());
            ++n3;
        }
        return xYIntervalSeriesCollection;
    }
}

