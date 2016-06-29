/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.IntervalXYDelegate;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.util.ObjectUtilities;

public class DefaultTableXYDataset
extends AbstractIntervalXYDataset
implements DomainInfo,
IntervalXYDataset,
TableXYDataset {
    private List data = null;
    private HashSet xPoints = null;
    private boolean propagateEvents = true;
    private boolean autoPrune = false;
    private IntervalXYDelegate intervalDelegate;

    public DefaultTableXYDataset() {
        this(false);
    }

    public DefaultTableXYDataset(boolean bl2) {
        this.autoPrune = bl2;
        this.data = new ArrayList();
        this.xPoints = new HashSet();
        this.intervalDelegate = new IntervalXYDelegate(this, false);
        this.addChangeListener(this.intervalDelegate);
    }

    public boolean isAutoPrune() {
        return this.autoPrune;
    }

    public void addSeries(XYSeries xYSeries) {
        if (xYSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        if (xYSeries.getAllowDuplicateXValues()) {
            throw new IllegalArgumentException("Cannot accept XYSeries that allow duplicate values. Use XYSeries(seriesName, <sort>, false) constructor.");
        }
        this.updateXPoints(xYSeries);
        this.data.add(xYSeries);
        xYSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }

    private void updateXPoints(XYSeries xYSeries) {
        Number number;
        if (xYSeries == null) {
            throw new IllegalArgumentException("Null 'series' not permitted.");
        }
        HashSet<Number> hashSet = new HashSet<Number>();
        boolean bl2 = this.propagateEvents;
        this.propagateEvents = false;
        for (int i2 = 0; i2 < xYSeries.getItemCount(); ++i2) {
            number = xYSeries.getX(i2);
            hashSet.add(number);
            if (this.xPoints.contains(number)) continue;
            this.xPoints.add(number);
            int n2 = this.data.size();
            for (int i3 = 0; i3 < n2; ++i3) {
                XYSeries xYSeries2 = (XYSeries)this.data.get(i3);
                if (xYSeries2.equals(xYSeries)) continue;
                xYSeries2.add(number, null);
            }
        }
        Iterator iterator = this.xPoints.iterator();
        do {
            if (!iterator.hasNext()) {
                this.propagateEvents = bl2;
                return;
            }
            number = (Number)iterator.next();
            if (hashSet.contains(number)) continue;
            xYSeries.add(number, null);
        } while (true);
    }

    public void updateXPoints() {
        this.propagateEvents = false;
        for (int i2 = 0; i2 < this.data.size(); ++i2) {
            this.updateXPoints((XYSeries)this.data.get(i2));
        }
        if (this.autoPrune) {
            this.prune();
        }
        this.propagateEvents = true;
    }

    @Override
    public int getSeriesCount() {
        return this.data.size();
    }

    @Override
    public int getItemCount() {
        if (this.xPoints != null) return this.xPoints.size();
        return 0;
    }

    public XYSeries getSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Index outside valid range.");
        if (n2 < this.getSeriesCount()) return (XYSeries)this.data.get(n2);
        throw new IllegalArgumentException("Index outside valid range.");
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

    public void removeAllSeries() {
        int n2 = 0;
        do {
            if (n2 >= this.data.size()) {
                this.data.clear();
                this.xPoints.clear();
                this.fireDatasetChanged();
                return;
            }
            XYSeries xYSeries = (XYSeries)this.data.get(n2);
            xYSeries.removeChangeListener(this);
            ++n2;
        } while (true);
    }

    public void removeSeries(XYSeries xYSeries) {
        if (xYSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        if (!this.data.contains(xYSeries)) return;
        xYSeries.removeChangeListener(this);
        this.data.remove(xYSeries);
        if (this.data.size() == 0) {
            this.xPoints.clear();
        }
        this.fireDatasetChanged();
    }

    public void removeSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Index outside valid range.");
        if (n2 > this.getSeriesCount()) {
            throw new IllegalArgumentException("Index outside valid range.");
        }
        XYSeries xYSeries = (XYSeries)this.data.get(n2);
        xYSeries.removeChangeListener(this);
        this.data.remove(n2);
        if (this.data.size() == 0) {
            this.xPoints.clear();
        } else if (this.autoPrune) {
            this.prune();
        }
        this.fireDatasetChanged();
    }

    public void removeAllValuesForX(Number number) {
        if (number == null) {
            throw new IllegalArgumentException("Null 'x' argument.");
        }
        boolean bl2 = this.propagateEvents;
        this.propagateEvents = false;
        int n2 = 0;
        do {
            if (n2 >= this.data.size()) {
                this.propagateEvents = bl2;
                this.xPoints.remove(number);
                this.fireDatasetChanged();
                return;
            }
            XYSeries xYSeries = (XYSeries)this.data.get(n2);
            xYSeries.remove(number);
            ++n2;
        } while (true);
    }

    protected boolean canPrune(Number number) {
        int n2 = 0;
        while (n2 < this.data.size()) {
            XYSeries xYSeries = (XYSeries)this.data.get(n2);
            if (xYSeries.getY(xYSeries.indexOf(number)) != null) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public void prune() {
        HashSet hashSet = (HashSet)this.xPoints.clone();
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Number number = (Number)iterator.next();
            if (!this.canPrune(number)) continue;
            this.removeAllValuesForX(number);
        }
    }

    @Override
    public void seriesChanged(SeriesChangeEvent seriesChangeEvent) {
        if (!this.propagateEvents) return;
        this.updateXPoints();
        this.fireDatasetChanged();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DefaultTableXYDataset)) {
            return false;
        }
        DefaultTableXYDataset defaultTableXYDataset = (DefaultTableXYDataset)object;
        if (this.autoPrune != defaultTableXYDataset.autoPrune) {
            return false;
        }
        if (this.propagateEvents != defaultTableXYDataset.propagateEvents) {
            return false;
        }
        if (!this.intervalDelegate.equals(defaultTableXYDataset.intervalDelegate)) {
            return false;
        }
        if (ObjectUtilities.equal(this.data, defaultTableXYDataset.data)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.data != null ? this.data.hashCode() : 0;
        n2 = 29 * n2 + (this.xPoints != null ? this.xPoints.hashCode() : 0);
        n2 = 29 * n2 + (this.propagateEvents ? 1 : 0);
        return 29 * n2 + (this.autoPrune ? 1 : 0);
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

    public double getIntervalPositionFactor() {
        return this.intervalDelegate.getIntervalPositionFactor();
    }

    public void setIntervalPositionFactor(double d2) {
        this.intervalDelegate.setIntervalPositionFactor(d2);
        this.fireDatasetChanged();
    }

    public double getIntervalWidth() {
        return this.intervalDelegate.getIntervalWidth();
    }

    public void setIntervalWidth(double d2) {
        this.intervalDelegate.setFixedIntervalWidth(d2);
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

