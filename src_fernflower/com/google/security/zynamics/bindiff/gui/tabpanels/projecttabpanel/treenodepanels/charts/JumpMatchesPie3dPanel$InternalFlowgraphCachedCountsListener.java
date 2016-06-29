package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;

class JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener extends DiffChangeAdapter {
   // $FF: synthetic field
   final JumpMatchesPie3dPanel this$0;

   private JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(JumpMatchesPie3dPanel var1) {
      this.this$0 = var1;
   }

   public void jumpsCountChanged() {
      JumpMatchesPie3dPanel.access$1000(this.this$0);
   }

   // $FF: synthetic method
   JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(JumpMatchesPie3dPanel var1, JumpMatchesPie3dPanel$1 var2) {
      this(var1);
   }
}
