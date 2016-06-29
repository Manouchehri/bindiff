package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel$1;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.PieDataset;

class FunctionMatchesPie3dPanel$CustomTooltipGenerator implements PieToolTipGenerator {
   // $FF: synthetic field
   final FunctionMatchesPie3dPanel this$0;

   private FunctionMatchesPie3dPanel$CustomTooltipGenerator(FunctionMatchesPie3dPanel var1) {
      this.this$0 = var1;
   }

   public String generateToolTip(PieDataset var1, Comparable var2) {
      return var1 == null?null:(var2.equals("Matched Functions")?String.format("%s %d (%.1f%s)", new Object[]{"Matched Functions", Integer.valueOf(FunctionMatchesPie3dPanel.access$200(this.this$0)), Double.valueOf(FunctionMatchesPie3dPanel.access$300(this.this$0)), "%"}):(var2.equals("Primary unmatched Functions")?String.format("%s %d (%.1f%s)", new Object[]{"Primary unmatched Functions", Integer.valueOf(FunctionMatchesPie3dPanel.access$400(this.this$0)), Double.valueOf(FunctionMatchesPie3dPanel.access$500(this.this$0)), "%"}):(var2.equals("Secondary unmatched Functions")?String.format("%s %d (%.1f%s)", new Object[]{"Secondary unmatched Functions", Integer.valueOf(FunctionMatchesPie3dPanel.access$600(this.this$0)), Double.valueOf(FunctionMatchesPie3dPanel.access$700(this.this$0)), "%"}):null)));
   }

   // $FF: synthetic method
   FunctionMatchesPie3dPanel$CustomTooltipGenerator(FunctionMatchesPie3dPanel var1, FunctionMatchesPie3dPanel$1 var2) {
      this(var1);
   }
}
