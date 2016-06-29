package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$1;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.PieDataset;

class CallMatchesPie3dPanel$CustomTooltipGenerator implements PieToolTipGenerator {
   // $FF: synthetic field
   final CallMatchesPie3dPanel this$0;

   private CallMatchesPie3dPanel$CustomTooltipGenerator(CallMatchesPie3dPanel var1) {
      this.this$0 = var1;
   }

   public String generateToolTip(PieDataset var1, Comparable var2) {
      if(var1 != null) {
         if(var2.equals(CallMatchesPie3dPanel.access$300()[0])) {
            return String.format("%s %d (%.1f%s)", new Object[]{CallMatchesPie3dPanel.access$300()[0], Integer.valueOf(CallMatchesPie3dPanel.access$400(this.this$0)), Double.valueOf(CallMatchesPie3dPanel.access$500(this.this$0)), "%"});
         }

         if(var2.equals(CallMatchesPie3dPanel.access$300()[1])) {
            return String.format("%s %d (%.1f%s)", new Object[]{CallMatchesPie3dPanel.access$300()[1], Integer.valueOf(CallMatchesPie3dPanel.access$600(this.this$0)), Double.valueOf(CallMatchesPie3dPanel.access$700(this.this$0)), "%"});
         }

         if(var2.equals(CallMatchesPie3dPanel.access$300()[2])) {
            return String.format("%s %d (%.1f%s)", new Object[]{CallMatchesPie3dPanel.access$300()[2], Integer.valueOf(CallMatchesPie3dPanel.access$800(this.this$0)), Double.valueOf(CallMatchesPie3dPanel.access$900(this.this$0)), "%"});
         }
      }

      return null;
   }

   // $FF: synthetic method
   CallMatchesPie3dPanel$CustomTooltipGenerator(CallMatchesPie3dPanel var1, CallMatchesPie3dPanel$1 var2) {
      this(var1);
   }
}
