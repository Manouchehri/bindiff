package org.jfree.data.xy;

import org.jfree.data.general.*;
import org.jfree.util.*;

public class XYBarDataset extends AbstractIntervalXYDataset implements DatasetChangeListener, IntervalXYDataset
{
    private XYDataset underlying;
    private double barWidth;
    
    public XYBarDataset(final XYDataset underlying, final double barWidth) {
        (this.underlying = underlying).addChangeListener(this);
        this.barWidth = barWidth;
    }
    
    public XYDataset getUnderlyingDataset() {
        return this.underlying;
    }
    
    public double getBarWidth() {
        return this.barWidth;
    }
    
    public void setBarWidth(final double barWidth) {
        this.barWidth = barWidth;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public int getSeriesCount() {
        return this.underlying.getSeriesCount();
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.underlying.getSeriesKey(n);
    }
    
    public int getItemCount(final int n) {
        return this.underlying.getItemCount(n);
    }
    
    public Number getX(final int n, final int n2) {
        return this.underlying.getX(n, n2);
    }
    
    public double getXValue(final int n, final int n2) {
        return this.underlying.getXValue(n, n2);
    }
    
    public Number getY(final int n, final int n2) {
        return this.underlying.getY(n, n2);
    }
    
    public double getYValue(final int n, final int n2) {
        return this.underlying.getYValue(n, n2);
    }
    
    public Number getStartX(final int n, final int n2) {
        Number n3 = null;
        final Number x = this.underlying.getX(n, n2);
        if (x != null) {
            n3 = new Double(x.doubleValue() - this.barWidth / 2.0);
        }
        return n3;
    }
    
    public double getStartXValue(final int n, final int n2) {
        return this.getXValue(n, n2) - this.barWidth / 2.0;
    }
    
    public Number getEndX(final int n, final int n2) {
        Number n3 = null;
        final Number x = this.underlying.getX(n, n2);
        if (x != null) {
            n3 = new Double(x.doubleValue() + this.barWidth / 2.0);
        }
        return n3;
    }
    
    public double getEndXValue(final int n, final int n2) {
        return this.getXValue(n, n2) + this.barWidth / 2.0;
    }
    
    public Number getStartY(final int n, final int n2) {
        return this.underlying.getY(n, n2);
    }
    
    public double getStartYValue(final int n, final int n2) {
        return this.getYValue(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        return this.underlying.getY(n, n2);
    }
    
    public double getEndYValue(final int n, final int n2) {
        return this.getYValue(n, n2);
    }
    
    public void datasetChanged(final DatasetChangeEvent datasetChangeEvent) {
        this.notifyListeners(datasetChangeEvent);
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof XYBarDataset)) {
            return false;
        }
        final XYBarDataset xyBarDataset = (XYBarDataset)o;
        return this.underlying.equals(xyBarDataset.underlying) && this.barWidth == xyBarDataset.barWidth;
    }
    
    public Object clone() {
        final XYBarDataset xyBarDataset = (XYBarDataset)super.clone();
        if (this.underlying instanceof PublicCloneable) {
            xyBarDataset.underlying = (XYDataset)((PublicCloneable)this.underlying).clone();
        }
        return xyBarDataset;
    }
}
