package org.jfree.data.xy;

import java.io.*;
import org.jfree.util.*;
import org.jfree.data.*;
import org.jfree.data.general.*;

public class IntervalXYDelegate implements Serializable, Cloneable, DomainInfo, DatasetChangeListener, PublicCloneable
{
    private static final long serialVersionUID = -685166711639592857L;
    private XYDataset dataset;
    private boolean autoWidth;
    private double intervalPositionFactor;
    private double fixedIntervalWidth;
    private double autoIntervalWidth;
    
    public IntervalXYDelegate(final XYDataset xyDataset) {
        this(xyDataset, true);
    }
    
    public IntervalXYDelegate(final XYDataset dataset, final boolean autoWidth) {
        if (dataset == null) {
            throw new IllegalArgumentException("Null 'dataset' argument.");
        }
        this.dataset = dataset;
        this.autoWidth = autoWidth;
        this.intervalPositionFactor = 0.5;
        this.autoIntervalWidth = Double.POSITIVE_INFINITY;
        this.fixedIntervalWidth = 1.0;
    }
    
    public boolean isAutoWidth() {
        return this.autoWidth;
    }
    
    public void setAutoWidth(final boolean autoWidth) {
        this.autoWidth = autoWidth;
        if (autoWidth) {
            this.autoIntervalWidth = this.recalculateInterval();
        }
    }
    
    public double getIntervalPositionFactor() {
        return this.intervalPositionFactor;
    }
    
    public void setIntervalPositionFactor(final double intervalPositionFactor) {
        if (intervalPositionFactor < 0.0 || 1.0 < intervalPositionFactor) {
            throw new IllegalArgumentException("Argument 'd' outside valid range.");
        }
        this.intervalPositionFactor = intervalPositionFactor;
    }
    
    public double getFixedIntervalWidth() {
        return this.fixedIntervalWidth;
    }
    
    public void setFixedIntervalWidth(final double fixedIntervalWidth) {
        if (fixedIntervalWidth < 0.0) {
            throw new IllegalArgumentException("Negative 'w' argument.");
        }
        this.fixedIntervalWidth = fixedIntervalWidth;
        this.autoWidth = false;
    }
    
    public double getIntervalWidth() {
        if (this.isAutoWidth() && !Double.isInfinite(this.autoIntervalWidth)) {
            return this.autoIntervalWidth;
        }
        return this.fixedIntervalWidth;
    }
    
    public Number getStartX(final int n, final int n2) {
        Number n3 = null;
        final Number x = this.dataset.getX(n, n2);
        if (x != null) {
            n3 = new Double(x.doubleValue() - this.getIntervalPositionFactor() * this.getIntervalWidth());
        }
        return n3;
    }
    
    public double getStartXValue(final int n, final int n2) {
        return this.dataset.getXValue(n, n2) - this.getIntervalPositionFactor() * this.getIntervalWidth();
    }
    
    public Number getEndX(final int n, final int n2) {
        Number n3 = null;
        final Number x = this.dataset.getX(n, n2);
        if (x != null) {
            n3 = new Double(x.doubleValue() + (1.0 - this.getIntervalPositionFactor()) * this.getIntervalWidth());
        }
        return n3;
    }
    
    public double getEndXValue(final int n, final int n2) {
        return this.dataset.getXValue(n, n2) + (1.0 - this.getIntervalPositionFactor()) * this.getIntervalWidth();
    }
    
    public double getDomainLowerBound(final boolean b) {
        double lowerBound = Double.NaN;
        final Range domainBounds = this.getDomainBounds(b);
        if (domainBounds != null) {
            lowerBound = domainBounds.getLowerBound();
        }
        return lowerBound;
    }
    
    public double getDomainUpperBound(final boolean b) {
        double upperBound = Double.NaN;
        final Range domainBounds = this.getDomainBounds(b);
        if (domainBounds != null) {
            upperBound = domainBounds.getUpperBound();
        }
        return upperBound;
    }
    
    public Range getDomainBounds(final boolean b) {
        Range domainBounds = DatasetUtilities.findDomainBounds(this.dataset, false);
        if (b && domainBounds != null) {
            final double n = this.getIntervalWidth() * this.getIntervalPositionFactor();
            domainBounds = new Range(domainBounds.getLowerBound() - n, domainBounds.getUpperBound() + (this.getIntervalWidth() - n));
        }
        return domainBounds;
    }
    
    public void datasetChanged(final DatasetChangeEvent datasetChangeEvent) {
        if (this.autoWidth) {
            this.autoIntervalWidth = this.recalculateInterval();
        }
    }
    
    private double recalculateInterval() {
        double min = Double.POSITIVE_INFINITY;
        for (int seriesCount = this.dataset.getSeriesCount(), i = 0; i < seriesCount; ++i) {
            min = Math.min(min, this.calculateIntervalForSeries(i));
        }
        return min;
    }
    
    private double calculateIntervalForSeries(final int n) {
        double min = Double.POSITIVE_INFINITY;
        final int itemCount = this.dataset.getItemCount(n);
        if (itemCount > 1) {
            double xValue = this.dataset.getXValue(n, 0);
            for (int i = 1; i < itemCount; ++i) {
                final double xValue2 = this.dataset.getXValue(n, i);
                min = Math.min(min, xValue2 - xValue);
                xValue = xValue2;
            }
        }
        return min;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IntervalXYDelegate)) {
            return false;
        }
        final IntervalXYDelegate intervalXYDelegate = (IntervalXYDelegate)o;
        return this.autoWidth == intervalXYDelegate.autoWidth && this.intervalPositionFactor == intervalXYDelegate.intervalPositionFactor && this.fixedIntervalWidth == intervalXYDelegate.fixedIntervalWidth;
    }
    
    public Object clone() {
        return super.clone();
    }
}
