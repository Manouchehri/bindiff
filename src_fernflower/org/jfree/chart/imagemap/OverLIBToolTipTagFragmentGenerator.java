package org.jfree.chart.imagemap;

import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;

public class OverLIBToolTipTagFragmentGenerator implements ToolTipTagFragmentGenerator {
   public String generateToolTipFragment(String var1) {
      return " onMouseOver=\"return overlib(\'" + var1 + "\');\" onMouseOut=\"return nd();\"";
   }
}
