package org.jfree.data.time.ohlc;

import java.io.*;
import org.jfree.data.xy.*;
import org.jfree.data.general.*;
import org.jfree.data.time.*;
import org.jfree.util.*;
import java.util.*;

public class OHLCSeriesCollection extends AbstractXYDataset implements Serializable, OHLCDataset
{
    private List data;
    private TimePeriodAnchor xPosition;
    
    public OHLCSeriesCollection() {
        this.xPosition = TimePeriodAnchor.MIDDLE;
        this.data = new ArrayList();
    }
    
    public void addSeries(final OHLCSeries ohlcSeries) {
        if (ohlcSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(ohlcSeries);
        ohlcSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }
    
    public int getSeriesCount() {
        return this.data.size();
    }
    
    public OHLCSeries getSeries(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Series index out of bounds");
        }
        return this.data.get(n);
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.getSeries(n).getKey();
    }
    
    public int getItemCount(final int n) {
        return this.getSeries(n).getItemCount();
    }
    
    protected synchronized long getX(final RegularTimePeriod regularTimePeriod) {
        long n = 0L;
        if (this.xPosition == TimePeriodAnchor.START) {
            n = regularTimePeriod.getFirstMillisecond();
        }
        else if (this.xPosition == TimePeriodAnchor.MIDDLE) {
            n = regularTimePeriod.getMiddleMillisecond();
        }
        else if (this.xPosition == TimePeriodAnchor.END) {
            n = regularTimePeriod.getLastMillisecond();
        }
        return n;
    }
    
    public double getXValue(final int n, final int n2) {
        return this.getX(((OHLCItem)this.data.get(n).getDataItem(n2)).getPeriod());
    }
    
    public Number getX(final int n, final int n2) {
        return new Double(this.getXValue(n, n2));
    }
    
    public Number getY(final int n, final int n2) {
        return new Double(((OHLCItem)this.data.get(n).getDataItem(n2)).getYValue());
    }
    
    public double getOpenValue(final int n, final int n2) {
        return ((OHLCItem)this.data.get(n).getDataItem(n2)).getOpenValue();
    }
    
    public Number getOpen(final int n, final int n2) {
        return new Double(this.getOpenValue(n, n2));
    }
    
    public double getCloseValue(final int n, final int n2) {
        return ((OHLCItem)this.data.get(n).getDataItem(n2)).getCloseValue();
    }
    
    public Number getClose(final int n, final int n2) {
        return new Double(this.getCloseValue(n, n2));
    }
    
    public double getHighValue(final int n, final int n2) {
        return ((OHLCItem)this.data.get(n).getDataItem(n2)).getHighValue();
    }
    
    public Number getHigh(final int n, final int n2) {
        return new Double(this.getHighValue(n, n2));
    }
    
    public double getLowValue(final int n, final int n2) {
        return ((OHLCItem)this.data.get(n).getDataItem(n2)).getLowValue();
    }
    
    public Number getLow(final int n, final int n2) {
        return new Double(this.getLowValue(n, n2));
    }
    
    public Number getVolume(final int n, final int n2) {
        return null;
    }
    
    public double getVolumeValue(final int n, final int n2) {
        return Double.NaN;
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof OHLCSeriesCollection && ObjectUtilities.equal(this.data, ((OHLCSeriesCollection)o).data));
    }
    
    public Object clone() {
        final OHLCSeriesCollection collection = (OHLCSeriesCollection)super.clone();
        collection.data = (List)ObjectUtilities.deepClone(this.data);
        return collection;
    }
}
