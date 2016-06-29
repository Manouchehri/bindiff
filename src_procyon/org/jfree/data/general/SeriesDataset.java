package org.jfree.data.general;

public interface SeriesDataset extends Dataset
{
    int getSeriesCount();
    
    Comparable getSeriesKey(final int p0);
    
    int indexOf(final Comparable p0);
}
