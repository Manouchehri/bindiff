/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import org.jfree.data.general.CombinationDataset;
import org.jfree.data.general.SeriesDataset;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;

public class SubSeriesDataset
extends AbstractIntervalXYDataset
implements CombinationDataset,
IntervalXYDataset,
OHLCDataset {
    private SeriesDataset parent = null;
    private int[] map;

    public SubSeriesDataset(SeriesDataset seriesDataset, int[] arrn) {
        this.parent = seriesDataset;
        this.map = arrn;
    }

    public SubSeriesDataset(SeriesDataset seriesDataset, int n2) {
        this(seriesDataset, new int[]{n2});
    }

    @Override
    public Number getHigh(int n2, int n3) {
        return ((OHLCDataset)this.parent).getHigh(this.map[n2], n3);
    }

    @Override
    public double getHighValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getHigh(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public Number getLow(int n2, int n3) {
        return ((OHLCDataset)this.parent).getLow(this.map[n2], n3);
    }

    @Override
    public double getLowValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getLow(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public Number getOpen(int n2, int n3) {
        return ((OHLCDataset)this.parent).getOpen(this.map[n2], n3);
    }

    @Override
    public double getOpenValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getOpen(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public Number getClose(int n2, int n3) {
        return ((OHLCDataset)this.parent).getClose(this.map[n2], n3);
    }

    @Override
    public double getCloseValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getClose(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public Number getVolume(int n2, int n3) {
        return ((OHLCDataset)this.parent).getVolume(this.map[n2], n3);
    }

    @Override
    public double getVolumeValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getVolume(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public Number getX(int n2, int n3) {
        return ((XYDataset)this.parent).getX(this.map[n2], n3);
    }

    @Override
    public Number getY(int n2, int n3) {
        return ((XYDataset)this.parent).getY(this.map[n2], n3);
    }

    @Override
    public int getItemCount(int n2) {
        return ((XYDataset)this.parent).getItemCount(this.map[n2]);
    }

    @Override
    public int getSeriesCount() {
        return this.map.length;
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.parent.getSeriesKey(this.map[n2]);
    }

    @Override
    public Number getStartX(int n2, int n3) {
        if (!(this.parent instanceof IntervalXYDataset)) return this.getX(n2, n3);
        return ((IntervalXYDataset)this.parent).getStartX(this.map[n2], n3);
    }

    @Override
    public Number getEndX(int n2, int n3) {
        if (!(this.parent instanceof IntervalXYDataset)) return this.getX(n2, n3);
        return ((IntervalXYDataset)this.parent).getEndX(this.map[n2], n3);
    }

    @Override
    public Number getStartY(int n2, int n3) {
        if (!(this.parent instanceof IntervalXYDataset)) return this.getY(n2, n3);
        return ((IntervalXYDataset)this.parent).getStartY(this.map[n2], n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        if (!(this.parent instanceof IntervalXYDataset)) return this.getY(n2, n3);
        return ((IntervalXYDataset)this.parent).getEndY(this.map[n2], n3);
    }

    @Override
    public SeriesDataset getParent() {
        return this.parent;
    }

    @Override
    public int[] getMap() {
        return (int[])this.map.clone();
    }
}

