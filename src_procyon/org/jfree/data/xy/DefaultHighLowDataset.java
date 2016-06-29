package org.jfree.data.xy;

import java.util.*;

public class DefaultHighLowDataset extends AbstractXYDataset implements OHLCDataset
{
    private Comparable seriesKey;
    private Date[] date;
    private Number[] high;
    private Number[] low;
    private Number[] open;
    private Number[] close;
    private Number[] volume;
    
    public DefaultHighLowDataset(final Comparable seriesKey, final Date[] date, final double[] array, final double[] array2, final double[] array3, final double[] array4, final double[] array5) {
        if (seriesKey == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        if (date == null) {
            throw new IllegalArgumentException("Null 'date' argument.");
        }
        this.seriesKey = seriesKey;
        this.date = date;
        this.high = createNumberArray(array);
        this.low = createNumberArray(array2);
        this.open = createNumberArray(array3);
        this.close = createNumberArray(array4);
        this.volume = createNumberArray(array5);
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.seriesKey;
    }
    
    public Number getX(final int n, final int n2) {
        return new Long(this.date[n2].getTime());
    }
    
    public Date getXDate(final int n, final int n2) {
        return this.date[n2];
    }
    
    public Number getY(final int n, final int n2) {
        return this.getClose(n, n2);
    }
    
    public Number getHigh(final int n, final int n2) {
        return this.high[n2];
    }
    
    public double getHighValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number high = this.getHigh(n, n2);
        if (high != null) {
            doubleValue = high.doubleValue();
        }
        return doubleValue;
    }
    
    public Number getLow(final int n, final int n2) {
        return this.low[n2];
    }
    
    public double getLowValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number low = this.getLow(n, n2);
        if (low != null) {
            doubleValue = low.doubleValue();
        }
        return doubleValue;
    }
    
    public Number getOpen(final int n, final int n2) {
        return this.open[n2];
    }
    
    public double getOpenValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number open = this.getOpen(n, n2);
        if (open != null) {
            doubleValue = open.doubleValue();
        }
        return doubleValue;
    }
    
    public Number getClose(final int n, final int n2) {
        return this.close[n2];
    }
    
    public double getCloseValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number close = this.getClose(n, n2);
        if (close != null) {
            doubleValue = close.doubleValue();
        }
        return doubleValue;
    }
    
    public Number getVolume(final int n, final int n2) {
        return this.volume[n2];
    }
    
    public double getVolumeValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number volume = this.getVolume(n, n2);
        if (volume != null) {
            doubleValue = volume.doubleValue();
        }
        return doubleValue;
    }
    
    public int getSeriesCount() {
        return 1;
    }
    
    public int getItemCount(final int n) {
        return this.date.length;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DefaultHighLowDataset)) {
            return false;
        }
        final DefaultHighLowDataset defaultHighLowDataset = (DefaultHighLowDataset)o;
        return this.seriesKey.equals(defaultHighLowDataset.seriesKey) && Arrays.equals(this.date, defaultHighLowDataset.date) && Arrays.equals(this.open, defaultHighLowDataset.open) && Arrays.equals(this.high, defaultHighLowDataset.high) && Arrays.equals(this.low, defaultHighLowDataset.low) && Arrays.equals(this.close, defaultHighLowDataset.close) && Arrays.equals(this.volume, defaultHighLowDataset.volume);
    }
    
    public static Number[] createNumberArray(final double[] array) {
        final Number[] array2 = new Number[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = new Double(array[i]);
        }
        return array2;
    }
}
