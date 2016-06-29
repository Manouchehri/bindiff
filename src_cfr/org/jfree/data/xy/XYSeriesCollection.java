/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.IntervalXYDelegate;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.util.ObjectUtilities;

public class XYSeriesCollection
extends AbstractIntervalXYDataset
implements Serializable,
DomainInfo,
IntervalXYDataset {
    private static final long serialVersionUID = -7590013825931496766L;
    private List data = new ArrayList();
    private IntervalXYDelegate intervalDelegate;

    public XYSeriesCollection() {
        this(null);
    }

    public XYSeriesCollection(XYSeries xYSeries) {
        this.intervalDelegate = new IntervalXYDelegate(this, false);
        this.addChangeListener(this.intervalDelegate);
        if (xYSeries == null) return;
        this.data.add(xYSeries);
        xYSeries.addChangeListener(this);
    }

    public void addSeries(XYSeries xYSeries) {
        if (xYSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(xYSeries);
        xYSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }

    public void removeSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Series index out of bounds.");
        if (n2 >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Series index out of bounds.");
        }
        XYSeries xYSeries = (XYSeries)this.data.get(n2);
        xYSeries.removeChangeListener(this);
        this.data.remove(n2);
        this.fireDatasetChanged();
    }

    public void removeSeries(XYSeries xYSeries) {
        if (xYSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        if (!this.data.contains(xYSeries)) return;
        xYSeries.removeChangeListener(this);
        this.data.remove(xYSeries);
        this.fireDatasetChanged();
    }

    public void removeAllSeries() {
        int n2 = 0;
        do {
            if (n2 >= this.data.size()) {
                this.data.clear();
                this.fireDatasetChanged();
                return;
            }
            XYSeries xYSeries = (XYSeries)this.data.get(n2);
            xYSeries.removeChangeListener(this);
            ++n2;
        } while (true);
    }

    @Override
    public int getSeriesCount() {
        return this.data.size();
    }

    public List getSeries() {
        return Collections.unmodifiableList(this.data);
    }

    public XYSeries getSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Series index out of bounds");
        if (n2 < this.getSeriesCount()) return (XYSeries)this.data.get(n2);
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
        XYSeries xYSeries = (XYSeries)this.data.get(n2);
        XYDataItem xYDataItem = xYSeries.getDataItem(n3);
        return xYDataItem.getX();
    }

    @Override
    public Number getStartX(int n2, int n3) {
        return this.intervalDelegate.getStartX(n2, n3);
    }

    @Override
    public Number getEndX(int n2, int n3) {
        return this.intervalDelegate.getEndX(n2, n3);
    }

    @Override
    public Number getY(int n2, int n3) {
        XYSeries xYSeries = (XYSeries)this.data.get(n2);
        XYDataItem xYDataItem = xYSeries.getDataItem(n3);
        return xYDataItem.getY();
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
        if (!(object instanceof XYSeriesCollection)) {
            return false;
        }
        XYSeriesCollection xYSeriesCollection = (XYSeriesCollection)object;
        return ObjectUtilities.equal(this.data, xYSeriesCollection.data);
    }

    @Override
    public Object clone() {
        XYSeriesCollection xYSeriesCollection = (XYSeriesCollection)super.clone();
        xYSeriesCollection.data = (List)ObjectUtilities.deepClone(this.data);
        xYSeriesCollection.intervalDelegate = (IntervalXYDelegate)this.intervalDelegate.clone();
        return xYSeriesCollection;
    }

    public int hashCode() {
        if (this.data == null) return 0;
        int n2 = this.data.hashCode();
        return n2;
    }

    @Override
    public double getDomainLowerBound(boolean bl2) {
        return this.intervalDelegate.getDomainLowerBound(bl2);
    }

    @Override
    public double getDomainUpperBound(boolean bl2) {
        return this.intervalDelegate.getDomainUpperBound(bl2);
    }

    @Override
    public Range getDomainBounds(boolean bl2) {
        if (!bl2) return DatasetUtilities.iterateDomainBounds(this, bl2);
        return this.intervalDelegate.getDomainBounds(bl2);
    }

    public double getIntervalWidth() {
        return this.intervalDelegate.getIntervalWidth();
    }

    public void setIntervalWidth(double d2) {
        if (d2 < 0.0) {
            throw new IllegalArgumentException("Negative 'width' argument.");
        }
        this.intervalDelegate.setFixedIntervalWidth(d2);
        this.fireDatasetChanged();
    }

    public double getIntervalPositionFactor() {
        return this.intervalDelegate.getIntervalPositionFactor();
    }

    public void setIntervalPositionFactor(double d2) {
        this.intervalDelegate.setIntervalPositionFactor(d2);
        this.fireDatasetChanged();
    }

    public boolean isAutoWidth() {
        return this.intervalDelegate.isAutoWidth();
    }

    public void setAutoWidth(boolean bl2) {
        this.intervalDelegate.setAutoWidth(bl2);
        this.fireDatasetChanged();
    }
}

