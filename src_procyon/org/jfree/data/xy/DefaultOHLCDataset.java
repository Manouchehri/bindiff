package org.jfree.data.xy;

import java.util.*;

public class DefaultOHLCDataset extends AbstractXYDataset implements OHLCDataset
{
    private Comparable key;
    private OHLCDataItem[] data;
    
    public DefaultOHLCDataset(final Comparable key, final OHLCDataItem[] data) {
        this.key = key;
        this.data = data;
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.key;
    }
    
    public Number getX(final int n, final int n2) {
        return new Long(this.data[n2].getDate().getTime());
    }
    
    public Date getXDate(final int n, final int n2) {
        return this.data[n2].getDate();
    }
    
    public Number getY(final int n, final int n2) {
        return this.getClose(n, n2);
    }
    
    public Number getHigh(final int n, final int n2) {
        return this.data[n2].getHigh();
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
        return this.data[n2].getLow();
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
        return this.data[n2].getOpen();
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
        return this.data[n2].getClose();
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
        return this.data[n2].getVolume();
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
        return this.data.length;
    }
    
    public void sortDataByDate() {
        Arrays.sort(this.data);
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DefaultOHLCDataset)) {
            return false;
        }
        final DefaultOHLCDataset defaultOHLCDataset = (DefaultOHLCDataset)o;
        return this.key.equals(defaultOHLCDataset.key) && Arrays.equals(this.data, defaultOHLCDataset.data);
    }
}
