package org.jfree.chart.imagemap;

import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;

public class DynamicDriveToolTipTagFragmentGenerator implements ToolTipTagFragmentGenerator {
   protected String title = "";
   protected int style = 1;

   public DynamicDriveToolTipTagFragmentGenerator() {
   }

   public DynamicDriveToolTipTagFragmentGenerator(String var1, int var2) {
      this.title = var1;
      this.style = var2;
   }

   public String generateToolTipFragment(String var1) {
      return " onMouseOver=\"return stm([\'" + this.title + "\',\'" + var1 + "\'],Style[" + this.style + "]);\"" + " onMouseOut=\"return htm();\"";
   }
}
