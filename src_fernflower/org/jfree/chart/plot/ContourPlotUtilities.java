package org.jfree.chart.plot;

import org.jfree.data.Range;
import org.jfree.data.contour.ContourDataset;
import org.jfree.data.contour.DefaultContourDataset;

public abstract class ContourPlotUtilities {
   public static Range visibleRange(ContourDataset var0, Range var1, Range var2) {
      Range var3 = null;
      var3 = ((DefaultContourDataset)var0).getZValueRange(var1, var2);
      return var3;
   }
}
