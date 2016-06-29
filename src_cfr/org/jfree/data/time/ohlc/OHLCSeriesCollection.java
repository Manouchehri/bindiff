/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.time.ohlc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.ComparableObjectItem;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.ohlc.OHLCItem;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.util.ObjectUtilities;

public class OHLCSeriesCollection
extends AbstractXYDataset
implements Serializable,
OHLCDataset {
    private List data = new ArrayList();
    private TimePeriodAnchor xPosition = TimePeriodAnchor.MIDDLE;

    public void addSeries(OHLCSeries oHLCSeries) {
        if (oHLCSeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        this.data.add(oHLCSeries);
        oHLCSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }

    @Override
    public int getSeriesCount() {
        return this.data.size();
    }

    public OHLCSeries getSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Series index out of bounds");
        if (n2 < this.getSeriesCount()) return (OHLCSeries)this.data.get(n2);
        throw new IllegalArgumentException("Series index out of bounds");
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.getSeries(n2).getKey();
    }

    @Override
    public int getItemCount(int n2) {
        return this.getSeries(n2).getItemCount();
    }

    protected synchronized long getX(RegularTimePeriod regularTimePeriod) {
        long l2 = 0;
        if (this.xPosition == TimePeriodAnchor.START) {
            return regularTimePeriod.getFirstMillisecond();
        }
        if (this.xPosition == TimePeriodAnchor.MIDDLE) {
            return regularTimePeriod.getMiddleMillisecond();
        }
        if (this.xPosition != TimePeriodAnchor.END) return l2;
        return regularTimePeriod.getLastMillisecond();
    }

    @Override
    public double getXValue(int n2, int n3) {
        OHLCSeries oHLCSeries = (OHLCSeries)this.data.get(n2);
        OHLCItem oHLCItem = (OHLCItem)oHLCSeries.getDataItem(n3);
        RegularTimePeriod regularTimePeriod = oHLCItem.getPeriod();
        return this.getX(regularTimePeriod);
    }

    @Override
    public Number getX(int n2, int n3) {
        return new Double(this.getXValue(n2, n3));
    }

    @Override
    public Number getY(int n2, int n3) {
        OHLCSeries oHLCSeries = (OHLCSeries)this.data.get(n2);
        OHLCItem oHLCItem = (OHLCItem)oHLCSeries.getDataItem(n3);
        return new Double(oHLCItem.getYValue());
    }

    @Override
    public double getOpenValue(int n2, int n3) {
        OHLCSeries oHLCSeries = (OHLCSeries)this.data.get(n2);
        OHLCItem oHLCItem = (OHLCItem)oHLCSeries.getDataItem(n3);
        return oHLCItem.getOpenValue();
    }

    @Override
    public Number getOpen(int n2, int n3) {
        return new Double(this.getOpenValue(n2, n3));
    }

    @Override
    public double getCloseValue(int n2, int n3) {
        OHLCSeries oHLCSeries = (OHLCSeries)this.data.get(n2);
        OHLCItem oHLCItem = (OHLCItem)oHLCSeries.getDataItem(n3);
        return oHLCItem.getCloseValue();
    }

    @Override
    public Number getClose(int n2, int n3) {
        return new Double(this.getCloseValue(n2, n3));
    }

    @Override
    public double getHighValue(int n2, int n3) {
        OHLCSeries oHLCSeries = (OHLCSeries)this.data.get(n2);
        OHLCItem oHLCItem = (OHLCItem)oHLCSeries.getDataItem(n3);
        return oHLCItem.getHighValue();
    }

    @Override
    public Number getHigh(int n2, int n3) {
        return new Double(this.getHighValue(n2, n3));
    }

    @Override
    public double getLowValue(int n2, int n3) {
        OHLCSeries oHLCSeries = (OHLCSeries)this.data.get(n2);
        OHLCItem oHLCItem = (OHLCItem)oHLCSeries.getDataItem(n3);
        return oHLCItem.getLowValue();
    }

    @Override
    public Number getLow(int n2, int n3) {
        return new Double(this.getLowValue(n2, n3));
    }

    @Override
    public Number getVolume(int n2, int n3) {
        return null;
    }

    @Override
    public double getVolumeValue(int n2, int n3) {
        return Double.NaN;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof OHLCSeriesCollection)) {
            return false;
        }
        OHLCSeriesCollection oHLCSeriesCollection = (OHLCSeriesCollection)object;
        return ObjectUtilities.equal(this.data, oHLCSeriesCollection.data);
    }

    @Override
    public Object clone() {
        OHLCSeriesCollection oHLCSeriesCollection = (OHLCSeriesCollection)super.clone();
        oHLCSeriesCollection.data = (List)ObjectUtilities.deepClone(this.data);
        return oHLCSeriesCollection;
    }
}

