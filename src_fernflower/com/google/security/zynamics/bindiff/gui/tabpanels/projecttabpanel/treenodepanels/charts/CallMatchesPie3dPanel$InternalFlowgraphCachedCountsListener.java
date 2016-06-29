package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;

class CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener extends DiffChangeAdapter {
   // $FF: synthetic field
   final CallMatchesPie3dPanel this$0;

   private CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(CallMatchesPie3dPanel var1) {
      this.this$0 = var1;
   }

   public void callsCountChanged() {
      CallMatchesPie3dPanel.access$1000(this.this$0);
   }

   // $FF: synthetic method
   CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(CallMatchesPie3dPanel var1, CallMatchesPie3dPanel$1 var2) {
      this(var1);
   }
}
