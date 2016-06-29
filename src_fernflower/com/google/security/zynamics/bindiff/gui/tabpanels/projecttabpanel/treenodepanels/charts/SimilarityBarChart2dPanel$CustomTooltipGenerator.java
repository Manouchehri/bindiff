package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.SimilarityBarChart2dPanel;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.data.category.CategoryDataset;

public class SimilarityBarChart2dPanel$CustomTooltipGenerator implements CategoryToolTipGenerator {
   // $FF: synthetic field
   final SimilarityBarChart2dPanel this$0;

   public SimilarityBarChart2dPanel$CustomTooltipGenerator(SimilarityBarChart2dPanel var1) {
      this.this$0 = var1;
   }

   public String generateToolTip(CategoryDataset var1, int var2, int var3) {
      String var4 = null;
      double var5 = (double)var3 / 10.0D;
      String var7 = "";
      if(var5 == 1.0D) {
         var7 = "= 1.0";
      } else {
         var7 = String.format("%.1f - %.1f", new Object[]{Double.valueOf(var5), Double.valueOf(var5 + 0.1D)});
      }

      var4 = String.format("%.0f %s (%s %s)", new Object[]{var1.getValue(var2, var3), "Matched Functions", "Similarity", var7});
      return var4;
   }
}
