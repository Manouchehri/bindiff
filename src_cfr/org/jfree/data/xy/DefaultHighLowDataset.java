/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.util.Arrays;
import java.util.Date;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.OHLCDataset;

public class DefaultHighLowDataset
extends AbstractXYDataset
implements OHLCDataset {
    private Comparable seriesKey;
    private Date[] date;
    private Number[] high;
    private Number[] low;
    private Number[] open;
    private Number[] close;
    private Number[] volume;

    public DefaultHighLowDataset(Comparable comparable, Date[] arrdate, double[] arrd, double[] arrd2, double[] arrd3, double[] arrd4, double[] arrd5) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        if (arrdate == null) {
            throw new IllegalArgumentException("Null 'date' argument.");
        }
        this.seriesKey = comparable;
        this.date = arrdate;
        this.high = DefaultHighLowDataset.createNumberArray(arrd);
        this.low = DefaultHighLowDataset.createNumberArray(arrd2);
        this.open = DefaultHighLowDataset.createNumberArray(arrd3);
        this.close = DefaultHighLowDataset.createNumberArray(arrd4);
        this.volume = DefaultHighLowDataset.createNumberArray(arrd5);
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.seriesKey;
    }

    @Override
    public Number getX(int n2, int n3) {
        return new Long(this.date[n3].getTime());
    }

    public Date getXDate(int n2, int n3) {
        return this.date[n3];
    }

    @Override
    public Number getY(int n2, int n3) {
        return this.getClose(n2, n3);
    }

    @Override
    public Number getHigh(int n2, int n3) {
        return this.high[n3];
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
        return this.low[n3];
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
        return this.open[n3];
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
        return this.close[n3];
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
        return this.volume[n3];
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
        return this.date.length;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DefaultHighLowDataset)) {
            return false;
        }
        DefaultHighLowDataset defaultHighLowDataset = (DefaultHighLowDataset)object;
        if (!this.seriesKey.equals(defaultHighLowDataset.seriesKey)) {
            return false;
        }
        if (!Arrays.equals(this.date, defaultHighLowDataset.date)) {
            return false;
        }
        if (!Arrays.equals(this.open, defaultHighLowDataset.open)) {
            return false;
        }
        if (!Arrays.equals(this.high, defaultHighLowDataset.high)) {
            return false;
        }
        if (!Arrays.equals(this.low, defaultHighLowDataset.low)) {
            return false;
        }
        if (!Arrays.equals(this.close, defaultHighLowDataset.close)) {
            return false;
        }
        if (Arrays.equals(this.volume, defaultHighLowDataset.volume)) return true;
        return false;
    }

    public static Number[] createNumberArray(double[] arrd) {
        Number[] arrnumber = new Number[arrd.length];
        int n2 = 0;
        while (n2 < arrd.length) {
            arrnumber[n2] = new Double(arrd[n2]);
            ++n2;
        }
        return arrnumber;
    }
}

