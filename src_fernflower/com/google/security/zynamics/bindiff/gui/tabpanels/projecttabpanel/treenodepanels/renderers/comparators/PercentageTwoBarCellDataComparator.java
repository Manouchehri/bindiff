package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import java.util.Comparator;

public class PercentageTwoBarCellDataComparator implements Comparator {
   public int compare(PercentageTwoBarCellData var1, PercentageTwoBarCellData var2) {
      double var3 = var1.getSortByValue() - var2.getSortByValue();
      return var3 > 0.0D?1:(var3 < 0.0D?-1:0);
   }
}
