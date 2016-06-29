package org.jfree.data.general;

import org.jfree.data.general.Dataset;

public interface SeriesDataset extends Dataset {
   int getSeriesCount();

   Comparable getSeriesKey(int var1);

   int indexOf(Comparable var1);
}
