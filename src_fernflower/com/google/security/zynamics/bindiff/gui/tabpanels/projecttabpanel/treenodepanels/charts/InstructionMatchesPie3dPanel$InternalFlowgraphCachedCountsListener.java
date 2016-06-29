package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;

class InstructionMatchesPie3dPanel$InternalFlowgraphCachedCountsListener extends DiffChangeAdapter {
   // $FF: synthetic field
   final InstructionMatchesPie3dPanel this$0;

   private InstructionMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(InstructionMatchesPie3dPanel var1) {
      this.this$0 = var1;
   }

   public void instructionsCountsChanged() {
      InstructionMatchesPie3dPanel.access$1000(this.this$0);
   }

   // $FF: synthetic method
   InstructionMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(InstructionMatchesPie3dPanel var1, InstructionMatchesPie3dPanel$1 var2) {
      this(var1);
   }
}
