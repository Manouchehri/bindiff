package org.jfree.data.general;

import org.jfree.data.xy.*;
import java.util.*;

public class CombinedDataset extends AbstractIntervalXYDataset implements CombinationDataset, IntervalXYDataset, OHLCDataset, XYDataset
{
    private List datasetInfo;
    
    public CombinedDataset() {
        this.datasetInfo = new ArrayList();
    }
    
    public CombinedDataset(final SeriesDataset[] array) {
        this.datasetInfo = new ArrayList();
        this.add(array);
    }
    
    public void add(final SeriesDataset seriesDataset) {
        this.fastAdd(seriesDataset);
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public void add(final SeriesDataset[] array) {
        for (int i = 0; i < array.length; ++i) {
            this.fastAdd(array[i]);
        }
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public void add(final SeriesDataset seriesDataset, final int n) {
        this.add(new SubSeriesDataset(seriesDataset, n));
    }
    
    private void fastAdd(final SeriesDataset seriesDataset) {
        for (int i = 0; i < seriesDataset.getSeriesCount(); ++i) {
            this.datasetInfo.add(new CombinedDataset$DatasetInfo(this, seriesDataset, i));
        }
    }
    
    public int getSeriesCount() {
        return this.datasetInfo.size();
    }
    
    public Comparable getSeriesKey(final int n) {
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        return CombinedDataset$DatasetInfo.access$100(datasetInfo).getSeriesKey(CombinedDataset$DatasetInfo.access$000(datasetInfo));
    }
    
    public Number getX(final int n, final int n2) {
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        return ((XYDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getX(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
    }
    
    public Number getY(final int n, final int n2) {
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        return ((XYDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getY(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
    }
    
    public int getItemCount(final int n) {
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        return ((XYDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getItemCount(CombinedDataset$DatasetInfo.access$000(datasetInfo));
    }
    
    public Number getHigh(final int n, final int n2) {
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getHigh(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
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
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getLow(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
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
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getOpen(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
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
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getClose(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
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
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getVolume(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
    }
    
    public double getVolumeValue(final int n, final int n2) {
        double doubleValue = Double.NaN;
        final Number volume = this.getVolume(n, n2);
        if (volume != null) {
            doubleValue = volume.doubleValue();
        }
        return doubleValue;
    }
    
    public Number getStartX(final int n, final int n2) {
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        if (CombinedDataset$DatasetInfo.access$100(datasetInfo) instanceof IntervalXYDataset) {
            return ((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getStartX(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
        }
        return this.getX(n, n2);
    }
    
    public Number getEndX(final int n, final int n2) {
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        if (CombinedDataset$DatasetInfo.access$100(datasetInfo) instanceof IntervalXYDataset) {
            return ((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getEndX(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
        }
        return this.getX(n, n2);
    }
    
    public Number getStartY(final int n, final int n2) {
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        if (CombinedDataset$DatasetInfo.access$100(datasetInfo) instanceof IntervalXYDataset) {
            return ((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getStartY(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
        }
        return this.getY(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        final CombinedDataset$DatasetInfo datasetInfo = this.getDatasetInfo(n);
        if (CombinedDataset$DatasetInfo.access$100(datasetInfo) instanceof IntervalXYDataset) {
            return ((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(datasetInfo)).getEndY(CombinedDataset$DatasetInfo.access$000(datasetInfo), n2);
        }
        return this.getY(n, n2);
    }
    
    public SeriesDataset getParent() {
        SeriesDataset seriesDataset = null;
        for (int i = 0; i < this.datasetInfo.size(); ++i) {
            final SeriesDataset access$100 = CombinedDataset$DatasetInfo.access$100(this.getDatasetInfo(i));
            if (!(access$100 instanceof CombinationDataset)) {
                return null;
            }
            final SeriesDataset parent = ((CombinationDataset)access$100).getParent();
            if (seriesDataset == null) {
                seriesDataset = parent;
            }
            else if (seriesDataset != parent) {
                return null;
            }
        }
        return seriesDataset;
    }
    
    public int[] getMap() {
        int[] joinMap = null;
        for (int i = 0; i < this.datasetInfo.size(); ++i) {
            final SeriesDataset access$100 = CombinedDataset$DatasetInfo.access$100(this.getDatasetInfo(i));
            if (!(access$100 instanceof CombinationDataset)) {
                return null;
            }
            final int[] map = ((CombinationDataset)access$100).getMap();
            if (map == null) {
                return null;
            }
            joinMap = this.joinMap(joinMap, map);
        }
        return joinMap;
    }
    
    public int getChildPosition(final Dataset dataset) {
        int n = 0;
        for (int i = 0; i < this.datasetInfo.size(); ++i) {
            final SeriesDataset access$100 = CombinedDataset$DatasetInfo.access$100(this.getDatasetInfo(i));
            if (access$100 instanceof CombinedDataset) {
                final int childPosition = ((CombinedDataset)access$100).getChildPosition(dataset);
                if (childPosition >= 0) {
                    return n + childPosition;
                }
                ++n;
            }
            else {
                if (dataset == access$100) {
                    return n;
                }
                ++n;
            }
        }
        return -1;
    }
    
    private CombinedDataset$DatasetInfo getDatasetInfo(final int n) {
        return this.datasetInfo.get(n);
    }
    
    private int[] joinMap(final int[] array, final int[] array2) {
        if (array == null) {
            return array2;
        }
        if (array2 == null) {
            return array;
        }
        final int[] array3 = new int[array.length + array2.length];
        System.arraycopy(array, 0, array3, 0, array.length);
        System.arraycopy(array2, 0, array3, array.length, array2.length);
        return array3;
    }
}
