package org.jfree.data.xy;

import org.jfree.data.xy.XYDataset;

public interface XYZDataset extends XYDataset {
   Number getZ(int var1, int var2);

   double getZValue(int var1, int var2);
}
