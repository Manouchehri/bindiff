/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.IntervalXYDelegate;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;

public class CategoryTableXYDataset
extends AbstractIntervalXYDataset
implements DomainInfo,
IntervalXYDataset,
TableXYDataset {
    private DefaultKeyedValues2D values = new DefaultKeyedValues2D(true);
    private IntervalXYDelegate intervalDelegate;

    public CategoryTableXYDataset() {
        this.intervalDelegate = new IntervalXYDelegate(this);
        this.addChangeListener(this.intervalDelegate);
    }

    public void add(double d2, double d3, String string) {
        this.add(new Double(d2), new Double(d3), string, true);
    }

    public void add(Number number, Number number2, String string, boolean bl2) {
        this.values.addValue(number2, (Comparable)((Object)number), (Comparable)((Object)string));
        if (!bl2) return;
        this.fireDatasetChanged();
    }

    public void remove(double d2, String string) {
        this.remove(new Double(d2), string, true);
    }

    public void remove(Number number, String string, boolean bl2) {
        this.values.removeValue((Comparable)((Object)number), (Comparable)((Object)string));
        if (!bl2) return;
        this.fireDatasetChanged();
    }

    @Override
    public int getSeriesCount() {
        return this.values.getColumnCount();
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.values.getColumnKey(n2);
    }

    @Override
    public int getItemCount() {
        return this.values.getRowCount();
    }

    @Override
    public int getItemCount(int n2) {
        return this.getItemCount();
    }

    @Override
    public Number getX(int n2, int n3) {
        return (Number)((Object)this.values.getRowKey(n3));
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
        return this.values.getValue(n3, n2);
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return this.getY(n2, n3);
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

    public boolean equals(Object object) {
        if (!(object instanceof CategoryTableXYDataset)) {
            return false;
        }
        CategoryTableXYDataset categoryTableXYDataset = (CategoryTableXYDataset)object;
        if (!this.intervalDelegate.equals(categoryTableXYDataset.intervalDelegate)) {
            return false;
        }
        if (this.values.equals(categoryTableXYDataset.values)) return true;
        return false;
    }
}

