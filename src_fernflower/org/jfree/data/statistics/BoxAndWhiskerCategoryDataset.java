package org.jfree.data.statistics;

import java.util.List;
import org.jfree.data.category.CategoryDataset;

public interface BoxAndWhiskerCategoryDataset extends CategoryDataset {
   Number getMeanValue(int var1, int var2);

   Number getMeanValue(Comparable var1, Comparable var2);

   Number getMedianValue(int var1, int var2);

   Number getMedianValue(Comparable var1, Comparable var2);

   Number getQ1Value(int var1, int var2);

   Number getQ1Value(Comparable var1, Comparable var2);

   Number getQ3Value(int var1, int var2);

   Number getQ3Value(Comparable var1, Comparable var2);

   Number getMinRegularValue(int var1, int var2);

   Number getMinRegularValue(Comparable var1, Comparable var2);

   Number getMaxRegularValue(int var1, int var2);

   Number getMaxRegularValue(Comparable var1, Comparable var2);

   Number getMinOutlier(int var1, int var2);

   Number getMinOutlier(Comparable var1, Comparable var2);

   Number getMaxOutlier(int var1, int var2);

   Number getMaxOutlier(Comparable var1, Comparable var2);

   List getOutliers(int var1, int var2);

   List getOutliers(Comparable var1, Comparable var2);
}
