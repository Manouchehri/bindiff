package org.jfree.chart.axis;

import org.jfree.chart.axis.NumberTick;
import org.jfree.ui.TextAnchor;

public class CyclicNumberAxis$CycleBoundTick extends NumberTick {
   public boolean mapToLastCycle;

   public CyclicNumberAxis$CycleBoundTick(boolean var1, Number var2, String var3, TextAnchor var4, TextAnchor var5, double var6) {
      super(var2, var3, var4, var5, var6);
      this.mapToLastCycle = var1;
   }
}
