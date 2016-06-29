package org.jfree.data.statistics;

import org.jfree.data.category.CategoryDataset;

public interface StatisticalCategoryDataset extends CategoryDataset {
   Number getMeanValue(int var1, int var2);

   Number getMeanValue(Comparable var1, Comparable var2);

   Number getStdDevValue(int var1, int var2);

   Number getStdDevValue(Comparable var1, Comparable var2);
}
