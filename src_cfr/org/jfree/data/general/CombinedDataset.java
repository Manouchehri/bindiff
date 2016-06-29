/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.util.ArrayList;
import java.util.List;
import org.jfree.data.general.CombinationDataset;
import org.jfree.data.general.CombinedDataset$DatasetInfo;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.SeriesDataset;
import org.jfree.data.general.SubSeriesDataset;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;

public class CombinedDataset
extends AbstractIntervalXYDataset
implements CombinationDataset,
IntervalXYDataset,
OHLCDataset,
XYDataset {
    private List datasetInfo = new ArrayList();

    public CombinedDataset() {
    }

    public CombinedDataset(SeriesDataset[] arrseriesDataset) {
        this.add(arrseriesDataset);
    }

    public void add(SeriesDataset seriesDataset) {
        this.fastAdd(seriesDataset);
        DatasetChangeEvent datasetChangeEvent = new DatasetChangeEvent(this, this);
        this.notifyListeners(datasetChangeEvent);
    }

    public void add(SeriesDataset[] arrseriesDataset) {
        int n2 = 0;
        do {
            if (n2 >= arrseriesDataset.length) {
                DatasetChangeEvent datasetChangeEvent = new DatasetChangeEvent(this, this);
                this.notifyListeners(datasetChangeEvent);
                return;
            }
            this.fastAdd(arrseriesDataset[n2]);
            ++n2;
        } while (true);
    }

    public void add(SeriesDataset seriesDataset, int n2) {
        this.add(new SubSeriesDataset(seriesDataset, n2));
    }

    private void fastAdd(SeriesDataset seriesDataset) {
        int n2 = 0;
        while (n2 < seriesDataset.getSeriesCount()) {
            this.datasetInfo.add(new CombinedDataset$DatasetInfo(this, seriesDataset, n2));
            ++n2;
        }
    }

    @Override
    public int getSeriesCount() {
        return this.datasetInfo.size();
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        return CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo).getSeriesKey(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo));
    }

    @Override
    public Number getX(int n2, int n3) {
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        return ((XYDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getX(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
    }

    @Override
    public Number getY(int n2, int n3) {
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        return ((XYDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getY(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
    }

    @Override
    public int getItemCount(int n2) {
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        return ((XYDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getItemCount(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo));
    }

    @Override
    public Number getHigh(int n2, int n3) {
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getHigh(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
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
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getLow(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
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
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getOpen(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
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
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getClose(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
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
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getVolume(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
    }

    @Override
    public double getVolumeValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getVolume(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public Number getStartX(int n2, int n3) {
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        if (!(CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo) instanceof IntervalXYDataset)) return this.getX(n2, n3);
        return ((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getStartX(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
    }

    @Override
    public Number getEndX(int n2, int n3) {
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        if (!(CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo) instanceof IntervalXYDataset)) return this.getX(n2, n3);
        return ((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getEndX(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
    }

    @Override
    public Number getStartY(int n2, int n3) {
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        if (!(CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo) instanceof IntervalXYDataset)) return this.getY(n2, n3);
        return ((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getStartY(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        CombinedDataset$DatasetInfo combinedDataset$DatasetInfo = this.getDatasetInfo(n2);
        if (!(CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo) instanceof IntervalXYDataset)) return this.getY(n2, n3);
        return ((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(combinedDataset$DatasetInfo)).getEndY(CombinedDataset$DatasetInfo.access$000(combinedDataset$DatasetInfo), n3);
    }

    @Override
    public SeriesDataset getParent() {
        SeriesDataset seriesDataset = null;
        int n2 = 0;
        while (n2 < this.datasetInfo.size()) {
            SeriesDataset seriesDataset2 = CombinedDataset$DatasetInfo.access$100(this.getDatasetInfo(n2));
            if (!(seriesDataset2 instanceof CombinationDataset)) return null;
            SeriesDataset seriesDataset3 = ((CombinationDataset)((Object)seriesDataset2)).getParent();
            if (seriesDataset == null) {
                seriesDataset = seriesDataset3;
            } else if (seriesDataset != seriesDataset3) {
                return null;
            }
            ++n2;
        }
        return seriesDataset;
    }

    @Override
    public int[] getMap() {
        int[] arrn = null;
        int n2 = 0;
        while (n2 < this.datasetInfo.size()) {
            SeriesDataset seriesDataset = CombinedDataset$DatasetInfo.access$100(this.getDatasetInfo(n2));
            if (!(seriesDataset instanceof CombinationDataset)) return null;
            int[] arrn2 = ((CombinationDataset)((Object)seriesDataset)).getMap();
            if (arrn2 == null) {
                return null;
            }
            arrn = this.joinMap(arrn, arrn2);
            ++n2;
        }
        return arrn;
    }

    public int getChildPosition(Dataset dataset) {
        int n2 = 0;
        int n3 = 0;
        while (n3 < this.datasetInfo.size()) {
            SeriesDataset seriesDataset = CombinedDataset$DatasetInfo.access$100(this.getDatasetInfo(n3));
            if (seriesDataset instanceof CombinedDataset) {
                int n4 = ((CombinedDataset)seriesDataset).getChildPosition(dataset);
                if (n4 >= 0) {
                    return n2 + n4;
                }
                ++n2;
            } else {
                if (dataset == seriesDataset) {
                    return n2;
                }
                ++n2;
            }
            ++n3;
        }
        return -1;
    }

    private CombinedDataset$DatasetInfo getDatasetInfo(int n2) {
        return (CombinedDataset$DatasetInfo)this.datasetInfo.get(n2);
    }

    private int[] joinMap(int[] arrn, int[] arrn2) {
        if (arrn == null) {
            return arrn2;
        }
        if (arrn2 == null) {
            return arrn;
        }
        int[] arrn3 = new int[arrn.length + arrn2.length];
        System.arraycopy(arrn, 0, arrn3, 0, arrn.length);
        System.arraycopy(arrn2, 0, arrn3, arrn.length, arrn2.length);
        return arrn3;
    }
}

