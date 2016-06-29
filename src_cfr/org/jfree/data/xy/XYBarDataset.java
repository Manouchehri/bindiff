/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class XYBarDataset
extends AbstractIntervalXYDataset
implements DatasetChangeListener,
IntervalXYDataset {
    private XYDataset underlying;
    private double barWidth;

    public XYBarDataset(XYDataset xYDataset, double d2) {
        this.underlying = xYDataset;
        this.underlying.addChangeListener(this);
        this.barWidth = d2;
    }

    public XYDataset getUnderlyingDataset() {
        return this.underlying;
    }

    public double getBarWidth() {
        return this.barWidth;
    }

    public void setBarWidth(double d2) {
        this.barWidth = d2;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    @Override
    public int getSeriesCount() {
        return this.underlying.getSeriesCount();
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.underlying.getSeriesKey(n2);
    }

    @Override
    public int getItemCount(int n2) {
        return this.underlying.getItemCount(n2);
    }

    @Override
    public Number getX(int n2, int n3) {
        return this.underlying.getX(n2, n3);
    }

    @Override
    public double getXValue(int n2, int n3) {
        return this.underlying.getXValue(n2, n3);
    }

    @Override
    public Number getY(int n2, int n3) {
        return this.underlying.getY(n2, n3);
    }

    @Override
    public double getYValue(int n2, int n3) {
        return this.underlying.getYValue(n2, n3);
    }

    @Override
    public Number getStartX(int n2, int n3) {
        Double d2 = null;
        Number number = this.underlying.getX(n2, n3);
        if (number == null) return d2;
        return new Double(number.doubleValue() - this.barWidth / 2.0);
    }

    @Override
    public double getStartXValue(int n2, int n3) {
        return this.getXValue(n2, n3) - this.barWidth / 2.0;
    }

    @Override
    public Number getEndX(int n2, int n3) {
        Double d2 = null;
        Number number = this.underlying.getX(n2, n3);
        if (number == null) return d2;
        return new Double(number.doubleValue() + this.barWidth / 2.0);
    }

    @Override
    public double getEndXValue(int n2, int n3) {
        return this.getXValue(n2, n3) + this.barWidth / 2.0;
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return this.underlying.getY(n2, n3);
    }

    @Override
    public double getStartYValue(int n2, int n3) {
        return this.getYValue(n2, n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return this.underlying.getY(n2, n3);
    }

    @Override
    public double getEndYValue(int n2, int n3) {
        return this.getYValue(n2, n3);
    }

    @Override
    public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
        this.notifyListeners(datasetChangeEvent);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XYBarDataset)) {
            return false;
        }
        XYBarDataset xYBarDataset = (XYBarDataset)object;
        if (!this.underlying.equals(xYBarDataset.underlying)) {
            return false;
        }
        if (this.barWidth == xYBarDataset.barWidth) return true;
        return false;
    }

    @Override
    public Object clone() {
        XYBarDataset xYBarDataset = (XYBarDataset)super.clone();
        if (!(this.underlying instanceof PublicCloneable)) return xYBarDataset;
        xYBarDataset.underlying = (XYDataset)((PublicCloneable)((Object)this.underlying)).clone();
        return xYBarDataset;
    }
}

