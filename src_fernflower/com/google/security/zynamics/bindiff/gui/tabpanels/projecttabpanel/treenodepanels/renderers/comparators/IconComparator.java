package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.comparators;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import javax.swing.Icon;

public class IconComparator implements Comparator {
   public int compare(Icon var1, Icon var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      return var1.toString().compareTo(var2.toString());
   }
}
