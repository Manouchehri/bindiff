package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel$1;
import java.text.AttributedString;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.data.general.PieDataset;

class InstructionMatchesPie3dPanel$CustomLabelGenerator implements PieSectionLabelGenerator {
   // $FF: synthetic field
   final InstructionMatchesPie3dPanel this$0;

   private InstructionMatchesPie3dPanel$CustomLabelGenerator(InstructionMatchesPie3dPanel var1) {
      this.this$0 = var1;
   }

   public AttributedString generateAttributedSectionLabel(PieDataset var1, Comparable var2) {
      return null;
   }

   public String generateSectionLabel(PieDataset var1, Comparable var2) {
      String var3 = null;
      if(var1 != null) {
         if(var2.equals(InstructionMatchesPie3dPanel.access$300()[0])) {
            var3 = String.format("%d\n%.1f%s", new Object[]{Integer.valueOf(InstructionMatchesPie3dPanel.access$400(this.this$0)), Double.valueOf(InstructionMatchesPie3dPanel.access$500(this.this$0)), "%"});
         } else if(var2.equals(InstructionMatchesPie3dPanel.access$300()[1])) {
            var3 = String.format("%d\n%.1f%s", new Object[]{Integer.valueOf(InstructionMatchesPie3dPanel.access$600(this.this$0)), Double.valueOf(InstructionMatchesPie3dPanel.access$700(this.this$0)), "%"});
         } else if(var2.equals(InstructionMatchesPie3dPanel.access$300()[2])) {
            var3 = String.format("%d\n%.1f%s", new Object[]{Integer.valueOf(InstructionMatchesPie3dPanel.access$800(this.this$0)), Double.valueOf(InstructionMatchesPie3dPanel.access$900(this.this$0)), "%"});
         }
      }

      return var3;
   }

   // $FF: synthetic method
   InstructionMatchesPie3dPanel$CustomLabelGenerator(InstructionMatchesPie3dPanel var1, InstructionMatchesPie3dPanel$1 var2) {
      this(var1);
   }
}
