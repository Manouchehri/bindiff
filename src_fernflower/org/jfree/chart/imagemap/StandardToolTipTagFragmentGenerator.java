package org.jfree.chart.imagemap;

import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;

public class StandardToolTipTagFragmentGenerator implements ToolTipTagFragmentGenerator {
   public String generateToolTipFragment(String var1) {
      return " title=\"" + var1 + "\" alt=\"\"";
   }
}
