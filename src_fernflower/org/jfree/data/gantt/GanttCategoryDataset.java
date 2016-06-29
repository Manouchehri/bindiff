package org.jfree.data.gantt;

import org.jfree.data.category.IntervalCategoryDataset;

public interface GanttCategoryDataset extends IntervalCategoryDataset {
   Number getPercentComplete(int var1, int var2);

   Number getPercentComplete(Comparable var1, Comparable var2);

   int getSubIntervalCount(int var1, int var2);

   int getSubIntervalCount(Comparable var1, Comparable var2);

   Number getStartValue(int var1, int var2, int var3);

   Number getStartValue(Comparable var1, Comparable var2, int var3);

   Number getEndValue(int var1, int var2, int var3);

   Number getEndValue(Comparable var1, Comparable var2, int var3);

   Number getPercentComplete(int var1, int var2, int var3);

   Number getPercentComplete(Comparable var1, Comparable var2, int var3);
}
