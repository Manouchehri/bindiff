package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.security.zynamics.zylib.general.Pair;
import java.util.Comparator;

public class ConfidenceComparator implements Comparator {
   public int compare(Pair var1, Pair var2) {
      return ((Double)var1.second()).doubleValue() > ((Double)var2.second()).doubleValue()?-1:(((Double)var1.second()).doubleValue() < ((Double)var2.second()).doubleValue()?1:0);
   }
}
