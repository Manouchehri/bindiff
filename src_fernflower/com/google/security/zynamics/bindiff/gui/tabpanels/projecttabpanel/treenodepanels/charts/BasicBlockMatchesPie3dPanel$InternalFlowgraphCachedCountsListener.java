package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;

class BasicBlockMatchesPie3dPanel$InternalFlowgraphCachedCountsListener extends DiffChangeAdapter {
   // $FF: synthetic field
   final BasicBlockMatchesPie3dPanel this$0;

   private BasicBlockMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(BasicBlockMatchesPie3dPanel var1) {
      this.this$0 = var1;
   }

   public void basicblocksCountChanged() {
      BasicBlockMatchesPie3dPanel.access$1000(this.this$0);
   }

   // $FF: synthetic method
   BasicBlockMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(BasicBlockMatchesPie3dPanel var1, BasicBlockMatchesPie3dPanel$1 var2) {
      this(var1);
   }
}
