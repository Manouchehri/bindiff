package org.jfree.data.general;

import java.io.*;

public abstract class AbstractSeriesDataset extends AbstractDataset implements Serializable, SeriesChangeListener, SeriesDataset
{
    private static final long serialVersionUID = -6074996219705033171L;
    
    public abstract int getSeriesCount();
    
    public abstract Comparable getSeriesKey(final int p0);
    
    public int indexOf(final Comparable comparable) {
        for (int seriesCount = this.getSeriesCount(), i = 0; i < seriesCount; ++i) {
            if (this.getSeriesKey(i).equals(comparable)) {
                return i;
            }
        }
        return -1;
    }
    
    public void seriesChanged(final SeriesChangeEvent seriesChangeEvent) {
        this.fireDatasetChanged();
    }
}
