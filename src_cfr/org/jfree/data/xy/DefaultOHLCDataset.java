/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.util.Arrays;
import java.util.Date;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;

public class DefaultOHLCDataset
extends AbstractXYDataset
implements OHLCDataset {
    private Comparable key;
    private OHLCDataItem[] data;

    public DefaultOHLCDataset(Comparable comparable, OHLCDataItem[] arroHLCDataItem) {
        this.key = comparable;
        this.data = arroHLCDataItem;
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.key;
    }

    @Override
    public Number getX(int n2, int n3) {
        return new Long(this.data[n3].getDate().getTime());
    }

    public Date getXDate(int n2, int n3) {
        return this.data[n3].getDate();
    }

    @Override
    public Number getY(int n2, int n3) {
        return this.getClose(n2, n3);
    }

    @Override
    public Number getHigh(int n2, int n3) {
        return this.data[n3].getHigh();
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
        return this.data[n3].getLow();
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
        return this.data[n3].getOpen();
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
        return this.data[n3].getClose();
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
        return this.data[n3].getVolume();
    }

    @Override
    public double getVolumeValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getVolume(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public int getSeriesCount() {
        return 1;
    }

    @Override
    public int getItemCount(int n2) {
        return this.data.length;
    }

    public void sortDataByDate() {
        Arrays.sort(this.data);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DefaultOHLCDataset)) {
            return false;
        }
        DefaultOHLCDataset defaultOHLCDataset = (DefaultOHLCDataset)object;
        if (!this.key.equals(defaultOHLCDataset.key)) {
            return false;
        }
        if (Arrays.equals(this.data, defaultOHLCDataset.data)) return true;
        return false;
    }
}

