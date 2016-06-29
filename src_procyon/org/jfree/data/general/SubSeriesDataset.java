package org.jfree.data.general;

import org.jfree.data.xy.*;

public class SubSeriesDataset extends AbstractIntervalXYDataset implements CombinationDataset, IntervalXYDataset, OHLCDataset
{
    private SeriesDataset parent;
    private int[] map;
    
    public SubSeriesDataset(final SeriesDataset parent, final int[] map) {
        this.parent = null;
        this.parent = parent;
        this.map = map;
    }
    
    public SubSeriesDataset(final SeriesDataset seriesDataset, final int n) {
        this(seriesDataset, new int[] { n });
    }
    
    public Number getHigh(final int n, final int n2) {
        return ((OHLCDataset)this.parent).getHigh(this.map[n], n2);
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
        return ((OHLCDataset)this.parent).getLow(this.map[n], n2);
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
        return ((OHLCDataset)this.parent).getOpen(this.map[n], n2);
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
        return ((OHLCDataset)this.parent).getClose(this.map[n], n2);
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
        return ((OHLCDataset)this.parent).getVolume(this.map[n], n2);
    }
    
    public double getVolumeValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number volume = this.getVolume(n, n2);
        if (volume != null) {
            doubleValue = volume.doubleValue();
        }
        return doubleValue;
    }
    
    public Number getX(final int n, final int n2) {
        return ((XYDataset)this.parent).getX(this.map[n], n2);
    }
    
    public Number getY(final int n, final int n2) {
        return ((XYDataset)this.parent).getY(this.map[n], n2);
    }
    
    public int getItemCount(final int n) {
        return ((XYDataset)this.parent).getItemCount(this.map[n]);
    }
    
    public int getSeriesCount() {
        return this.map.length;
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.parent.getSeriesKey(this.map[n]);
    }
    
    public Number getStartX(final int n, final int n2) {
        if (this.parent instanceof IntervalXYDataset) {
            return ((IntervalXYDataset)this.parent).getStartX(this.map[n], n2);
        }
        return this.getX(n, n2);
    }
    
    public Number getEndX(final int n, final int n2) {
        if (this.parent instanceof IntervalXYDataset) {
            return ((IntervalXYDataset)this.parent).getEndX(this.map[n], n2);
        }
        return this.getX(n, n2);
    }
    
    public Number getStartY(final int n, final int n2) {
        if (this.parent instanceof IntervalXYDataset) {
            return ((IntervalXYDataset)this.parent).getStartY(this.map[n], n2);
        }
        return this.getY(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        if (this.parent instanceof IntervalXYDataset) {
            return ((IntervalXYDataset)this.parent).getEndY(this.map[n], n2);
        }
        return this.getY(n, n2);
    }
    
    public SeriesDataset getParent() {
        return this.parent;
    }
    
    public int[] getMap() {
        return this.map.clone();
    }
}
