package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import java.awt.Paint;
import org.jfree.chart.renderer.category.BarRenderer3D;

public class ChartBarRenderer extends BarRenderer3D {
   private final Paint[] colors;

   public ChartBarRenderer(Paint[] var1) {
      this.colors = var1;
   }

   public Paint getItemPaint(int var1, int var2) {
      return this.colors[var2 % this.colors.length];
   }
}
