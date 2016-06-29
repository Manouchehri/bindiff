/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class IntervalXYDelegate
implements Serializable,
Cloneable,
DomainInfo,
DatasetChangeListener,
PublicCloneable {
    private static final long serialVersionUID = -685166711639592857L;
    private XYDataset dataset;
    private boolean autoWidth;
    private double intervalPositionFactor;
    private double fixedIntervalWidth;
    private double autoIntervalWidth;

    public IntervalXYDelegate(XYDataset xYDataset) {
        this(xYDataset, true);
    }

    public IntervalXYDelegate(XYDataset xYDataset, boolean bl2) {
        if (xYDataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        this.dataset = xYDataset;
        this.autoWidth = bl2;
        this.intervalPositionFactor = 0.5;
        this.autoIntervalWidth = Double.POSITIVE_INFINITY;
        this.fixedIntervalWidth = 1.0;
    }

    public boolean isAutoWidth() {
        return this.autoWidth;
    }

    public void setAutoWidth(boolean bl2) {
        this.autoWidth = bl2;
        if (!bl2) return;
        this.autoIntervalWidth = this.recalculateInterval();
    }

    public double getIntervalPositionFactor() {
        return this.intervalPositionFactor;
    }

    public void setIntervalPositionFactor(double d2) {
        if (d2 < 0.0) throw new IllegalArgumentException("Argument 'd' outside valid range.");
        if (1.0 < d2) {
            throw new IllegalArgumentException("Argument 'd' outside valid range.");
        }
        this.intervalPositionFactor = d2;
    }

    public double getFixedIntervalWidth() {
        return this.fixedIntervalWidth;
    }

    public void setFixedIntervalWidth(double d2) {
        if (d2 < 0.0) {
            throw new IllegalArgumentException("Negative 'w' argument.");
        }
        this.fixedIntervalWidth = d2;
        this.autoWidth = false;
    }

    public double getIntervalWidth() {
        if (!this.isAutoWidth()) return this.fixedIntervalWidth;
        if (Double.isInfinite(this.autoIntervalWidth)) return this.fixedIntervalWidth;
        return this.autoIntervalWidth;
    }

    public Number getStartX(int n2, int n3) {
        Double d2 = null;
        Number number = this.dataset.getX(n2, n3);
        if (number == null) return d2;
        return new Double(number.doubleValue() - this.getIntervalPositionFactor() * this.getIntervalWidth());
    }

    public double getStartXValue(int n2, int n3) {
        return this.dataset.getXValue(n2, n3) - this.getIntervalPositionFactor() * this.getIntervalWidth();
    }

    public Number getEndX(int n2, int n3) {
        Double d2 = null;
        Number number = this.dataset.getX(n2, n3);
        if (number == null) return d2;
        return new Double(number.doubleValue() + (1.0 - this.getIntervalPositionFactor()) * this.getIntervalWidth());
    }

    public double getEndXValue(int n2, int n3) {
        return this.dataset.getXValue(n2, n3) + (1.0 - this.getIntervalPositionFactor()) * this.getIntervalWidth();
    }

    @Override
    public double getDomainLowerBound(boolean bl2) {
        double d2 = Double.NaN;
        Range range = this.getDomainBounds(bl2);
        if (range == null) return d2;
        return range.getLowerBound();
    }

    @Override
    public double getDomainUpperBound(boolean bl2) {
        double d2 = Double.NaN;
        Range range = this.getDomainBounds(bl2);
        if (range == null) return d2;
        return range.getUpperBound();
    }

    @Override
    public Range getDomainBounds(boolean bl2) {
        Range range = DatasetUtilities.findDomainBounds(this.dataset, false);
        if (!bl2) return range;
        if (range == null) return range;
        double d2 = this.getIntervalWidth() * this.getIntervalPositionFactor();
        double d3 = this.getIntervalWidth() - d2;
        return new Range(range.getLowerBound() - d2, range.getUpperBound() + d3);
    }

    @Override
    public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
        if (!this.autoWidth) return;
        this.autoIntervalWidth = this.recalculateInterval();
    }

    private double recalculateInterval() {
        double d2 = Double.POSITIVE_INFINITY;
        int n2 = this.dataset.getSeriesCount();
        int n3 = 0;
        while (n3 < n2) {
            d2 = Math.min(d2, this.calculateIntervalForSeries(n3));
            ++n3;
        }
        return d2;
    }

    private double calculateIntervalForSeries(int n2) {
        double d2 = Double.POSITIVE_INFINITY;
        int n3 = this.dataset.getItemCount(n2);
        if (n3 <= 1) return d2;
        double d3 = this.dataset.getXValue(n2, 0);
        int n4 = 1;
        while (n4 < n3) {
            double d4 = this.dataset.getXValue(n2, n4);
            d2 = Math.min(d2, d4 - d3);
            d3 = d4;
            ++n4;
        }
        return d2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof IntervalXYDelegate)) {
            return false;
        }
        IntervalXYDelegate intervalXYDelegate = (IntervalXYDelegate)object;
        if (this.autoWidth != intervalXYDelegate.autoWidth) {
            return false;
        }
        if (this.intervalPositionFactor != intervalXYDelegate.intervalPositionFactor) {
            return false;
        }
        if (this.fixedIntervalWidth == intervalXYDelegate.fixedIntervalWidth) return true;
        return false;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}

