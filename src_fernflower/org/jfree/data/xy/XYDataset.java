package org.jfree.data.xy;

import org.jfree.data.DomainOrder;
import org.jfree.data.general.SeriesDataset;

public interface XYDataset extends SeriesDataset {
   DomainOrder getDomainOrder();

   int getItemCount(int var1);

   Number getX(int var1, int var2);

   double getXValue(int var1, int var2);

   Number getY(int var1, int var2);

   double getYValue(int var1, int var2);
}
