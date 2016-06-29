package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import java.util.Comparator;

public class PercentageThreeBarCellDataComparator implements Comparator {
   public int compare(PercentageThreeBarCellData var1, PercentageThreeBarCellData var2) {
      if(var1 == null && var2 == null) {
         return 0;
      } else if(var1 == null) {
         return 1;
      } else if(var2 == null) {
         return -1;
      } else {
         double var3 = var1.getSortByValue() - var2.getSortByValue();
         return var3 > 0.0D?1:(var3 < 0.0D?-1:0);
      }
   }
}
