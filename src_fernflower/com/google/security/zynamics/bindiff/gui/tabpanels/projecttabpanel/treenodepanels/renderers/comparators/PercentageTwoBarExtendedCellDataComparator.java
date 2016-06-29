package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedCellData;
import java.util.Comparator;

public class PercentageTwoBarExtendedCellDataComparator implements Comparator {
   public int compare(PercentageTwoBarExtendedCellData var1, PercentageTwoBarExtendedCellData var2) {
      double var3 = var1.getSortByValue() - var2.getSortByValue();
      return var3 > 0.0D?1:(var3 < 0.0D?-1:0);
   }
}
