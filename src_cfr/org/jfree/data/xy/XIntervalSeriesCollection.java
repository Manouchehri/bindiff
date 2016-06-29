/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.ComparableObjectItem;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XIntervalDataItem;
import org.jfree.data.xy.XIntervalSeries;
import org.jfree.util.ObjectUtilities;

public class XIntervalSeriesCollection
extends AbstractIntervalXYDataset
implements Serializable,
IntervalXYDataset {
    private List data = new ArrayList();

    public void addSeries(XIntervalSeries xIntervalSeries) {
        if (xIntervalSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(xIntervalSeries);
        xIntervalSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }

    @Override
    public int getSeriesCount() {
        return this.data.size();
    }

    public XIntervalSeries getSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Series index out of bounds");
        if (n2 < this.getSeriesCount()) return (XIntervalSeries)this.data.get(n2);
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
        XIntervalSeries xIntervalSeries = (XIntervalSeries)this.data.get(n2);
        XIntervalDataItem xIntervalDataItem = (XIntervalDataItem)xIntervalSeries.getDataItem(n3);
        return xIntervalDataItem.getX();
    }

    @Override
    public Number getY(int n2, int n3) {
        XIntervalSeries xIntervalSeries = (XIntervalSeries)this.data.get(n2);
        XIntervalDataItem xIntervalDataItem = (XIntervalDataItem)xIntervalSeries.getDataItem(n3);
        return new Double(xIntervalDataItem.getYValue());
    }

    @Override
    public Number getStartX(int n2, int n3) {
        XIntervalSeries xIntervalSeries = (XIntervalSeries)this.data.get(n2);
        XIntervalDataItem xIntervalDataItem = (XIntervalDataItem)xIntervalSeries.getDataItem(n3);
        return new Double(xIntervalDataItem.getXLowValue());
    }

    @Override
    public Number getEndX(int n2, int n3) {
        XIntervalSeries xIntervalSeries = (XIntervalSeries)this.data.get(n2);
        XIntervalDataItem xIntervalDataItem = (XIntervalDataItem)xIntervalSeries.getDataItem(n3);
        return new Double(xIntervalDataItem.getXHighValue());
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XIntervalSeriesCollection)) {
            return false;
        }
        XIntervalSeriesCollection xIntervalSeriesCollection = (XIntervalSeriesCollection)object;
        return ObjectUtilities.equal(this.data, xIntervalSeriesCollection.data);
    }

    @Override
    public Object clone() {
        XIntervalSeriesCollection xIntervalSeriesCollection = (XIntervalSeriesCollection)super.clone();
        xIntervalSeriesCollection.data = (List)ObjectUtilities.deepClone(this.data);
        return xIntervalSeriesCollection;
    }
}

