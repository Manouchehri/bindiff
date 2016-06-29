package org.jfree.data.statistics;

import java.util.List;
import org.jfree.data.xy.XYDataset;

public interface BoxAndWhiskerXYDataset extends XYDataset {
   Number getMeanValue(int var1, int var2);

   Number getMedianValue(int var1, int var2);

   Number getQ1Value(int var1, int var2);

   Number getQ3Value(int var1, int var2);

   Number getMinRegularValue(int var1, int var2);

   Number getMaxRegularValue(int var1, int var2);

   Number getMinOutlier(int var1, int var2);

   Number getMaxOutlier(int var1, int var2);

   List getOutliers(int var1, int var2);

   double getOutlierCoefficient();

   double getFaroutCoefficient();
}
