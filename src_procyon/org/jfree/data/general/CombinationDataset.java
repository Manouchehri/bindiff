package org.jfree.data.general;

public interface CombinationDataset
{
    SeriesDataset getParent();
    
    int[] getMap();
}
