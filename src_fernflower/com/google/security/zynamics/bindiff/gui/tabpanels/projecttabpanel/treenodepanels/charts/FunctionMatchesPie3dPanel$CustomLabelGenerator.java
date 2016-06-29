package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.FunctionMatchesPie3dPanel$1;
import java.text.AttributedString;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.data.general.PieDataset;

class FunctionMatchesPie3dPanel$CustomLabelGenerator implements PieSectionLabelGenerator {
   // $FF: synthetic field
   final FunctionMatchesPie3dPanel this$0;

   private FunctionMatchesPie3dPanel$CustomLabelGenerator(FunctionMatchesPie3dPanel var1) {
      this.this$0 = var1;
   }

   public AttributedString generateAttributedSectionLabel(PieDataset var1, Comparable var2) {
      return null;
   }

   public String generateSectionLabel(PieDataset var1, Comparable var2) {
      return var1 == null?null:(var2.equals("Matched Functions")?String.format("%d\n%.1f%s", new Object[]{Integer.valueOf(FunctionMatchesPie3dPanel.access$200(this.this$0)), Double.valueOf(FunctionMatchesPie3dPanel.access$300(this.this$0)), "%"}):(var2.equals("Primary unmatched Functions")?String.format("%d\n%.1f%s", new Object[]{Integer.valueOf(FunctionMatchesPie3dPanel.access$400(this.this$0)), Double.valueOf(FunctionMatchesPie3dPanel.access$500(this.this$0)), "%"}):(var2.equals("Secondary unmatched Functions")?String.format("%d\n%.1f%s", new Object[]{Integer.valueOf(FunctionMatchesPie3dPanel.access$600(this.this$0)), Double.valueOf(FunctionMatchesPie3dPanel.access$700(this.this$0)), "%"}):null)));
   }

   // $FF: synthetic method
   FunctionMatchesPie3dPanel$CustomLabelGenerator(FunctionMatchesPie3dPanel var1, FunctionMatchesPie3dPanel$1 var2) {
      this(var1);
   }
}
