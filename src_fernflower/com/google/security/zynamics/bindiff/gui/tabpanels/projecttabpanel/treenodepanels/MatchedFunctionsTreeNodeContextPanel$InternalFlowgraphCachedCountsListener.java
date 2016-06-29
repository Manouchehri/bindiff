package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;

class MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener extends DiffChangeAdapter {
   // $FF: synthetic field
   final MatchedFunctionsTreeNodeContextPanel this$0;

   private MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(MatchedFunctionsTreeNodeContextPanel var1) {
      this.this$0 = var1;
   }

   public void basicblocksCountChanged() {
      MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
   }

   public void callsCountChanged() {
      MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
   }

   public void instructionsCountsChanged() {
      MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
   }

   public void jumpsCountChanged() {
      MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
   }

   // $FF: synthetic method
   MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(MatchedFunctionsTreeNodeContextPanel var1, MatchedFunctionsTreeNodeContextPanel$1 var2) {
      this(var1);
   }
}
