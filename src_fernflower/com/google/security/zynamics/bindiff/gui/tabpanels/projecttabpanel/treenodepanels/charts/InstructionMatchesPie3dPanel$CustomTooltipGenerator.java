package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel$1;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.PieDataset;

class InstructionMatchesPie3dPanel$CustomTooltipGenerator implements PieToolTipGenerator {
   // $FF: synthetic field
   final InstructionMatchesPie3dPanel this$0;

   private InstructionMatchesPie3dPanel$CustomTooltipGenerator(InstructionMatchesPie3dPanel var1) {
      this.this$0 = var1;
   }

   public String generateToolTip(PieDataset var1, Comparable var2) {
      String var3 = null;
      if(var1 != null) {
         if(var2.equals(InstructionMatchesPie3dPanel.access$300()[0])) {
            var3 = String.format("%s %d (%.1f%s)", new Object[]{InstructionMatchesPie3dPanel.access$300()[0], Integer.valueOf(InstructionMatchesPie3dPanel.access$400(this.this$0)), Double.valueOf(InstructionMatchesPie3dPanel.access$500(this.this$0)), "%"});
         } else if(var2.equals(InstructionMatchesPie3dPanel.access$300()[1])) {
            var3 = String.format("%s %d (%.1f%s)", new Object[]{InstructionMatchesPie3dPanel.access$300()[1], Integer.valueOf(InstructionMatchesPie3dPanel.access$600(this.this$0)), Double.valueOf(InstructionMatchesPie3dPanel.access$700(this.this$0)), "%"});
         } else if(var2.equals(InstructionMatchesPie3dPanel.access$300()[2])) {
            var3 = String.format("%s %d (%.1f%s)", new Object[]{InstructionMatchesPie3dPanel.access$300()[2], Integer.valueOf(InstructionMatchesPie3dPanel.access$800(this.this$0)), Double.valueOf(InstructionMatchesPie3dPanel.access$900(this.this$0)), "%"});
         }
      }

      return var3;
   }

   // $FF: synthetic method
   InstructionMatchesPie3dPanel$CustomTooltipGenerator(InstructionMatchesPie3dPanel var1, InstructionMatchesPie3dPanel$1 var2) {
      this(var1);
   }
}
