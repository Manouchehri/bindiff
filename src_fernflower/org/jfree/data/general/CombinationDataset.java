package org.jfree.data.general;

import org.jfree.data.general.SeriesDataset;

public interface CombinationDataset {
   SeriesDataset getParent();

   int[] getMap();
}
