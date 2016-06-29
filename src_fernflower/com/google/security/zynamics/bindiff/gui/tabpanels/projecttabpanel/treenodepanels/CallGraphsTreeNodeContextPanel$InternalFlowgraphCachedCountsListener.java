package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.CallGraphsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.CallGraphsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;
import com.google.security.zynamics.bindiff.project.matches.MatchData;

class CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener extends DiffChangeAdapter {
   // $FF: synthetic field
   final CallGraphsTreeNodeContextPanel this$0;

   private CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(CallGraphsTreeNodeContextPanel var1) {
      this.this$0 = var1;
   }

   public void basicblocksCountChanged() {
      MatchData var1 = CallGraphsTreeNodeContextPanel.access$100(this.this$0).getMatches();
      int var2 = var1.getSizeOfMatchedBasicblocks();
      int var3 = var1.getSizeOfUnmatchedBasicblocks(ESide.PRIMARY);
      int var4 = var1.getSizeOfUnmatchedBasicblocks(ESide.SECONDARY);
      CallGraphsTreeNodeContextPanel.access$200(this.this$0).updateData(var2, var3);
      CallGraphsTreeNodeContextPanel.access$300(this.this$0).updateData(var2, var4);
   }

   public void callsCountChanged() {
      MatchData var1 = CallGraphsTreeNodeContextPanel.access$100(this.this$0).getMatches();
      int var2 = var1.getSizeOfMatchedCalls();
      int var3 = var1.getSizeOfChangedCalls();
      int var4 = var1.getSizeOfUnmatchedCalls(ESide.PRIMARY);
      int var5 = var1.getSizeOfUnmatchedCalls(ESide.SECONDARY);
      CallGraphsTreeNodeContextPanel.access$400(this.this$0).updateData(var2, var3, var4);
      CallGraphsTreeNodeContextPanel.access$500(this.this$0).updateData(var2, var3, var5);
   }

   public void functionsCountChanged() {
      MatchData var1 = CallGraphsTreeNodeContextPanel.access$100(this.this$0).getMatches();
      int var2 = var1.getSizeOfMatchedFunctions();
      int var3 = var1.getSizeOfChangedFunctions();
      int var4 = var1.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
      int var5 = var1.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
      CallGraphsTreeNodeContextPanel.access$600(this.this$0).updateData(var2, var3, var4);
      CallGraphsTreeNodeContextPanel.access$700(this.this$0).updateData(var2, var3, var5);
   }

   public void instructionsCountsChanged() {
      MatchData var1 = CallGraphsTreeNodeContextPanel.access$100(this.this$0).getMatches();
      int var2 = var1.getSizeOfMatchedInstructions();
      int var3 = var1.getSizeOfUnmatchedInstructions(ESide.PRIMARY);
      int var4 = var1.getSizeOfUnmatchedInstructions(ESide.SECONDARY);
      CallGraphsTreeNodeContextPanel.access$800(this.this$0).updateData(var2, var3);
      CallGraphsTreeNodeContextPanel.access$900(this.this$0).updateData(var2, var4);
   }

   public void jumpsCountChanged() {
      MatchData var1 = CallGraphsTreeNodeContextPanel.access$100(this.this$0).getMatches();
      int var2 = var1.getSizeOfMatchedJumps();
      int var3 = var1.getSizeOfUnmatchedJumps(ESide.PRIMARY);
      int var4 = var1.getSizeOfUnmatchedJumps(ESide.SECONDARY);
      CallGraphsTreeNodeContextPanel.access$1000(this.this$0).updateData(var2, var3);
      CallGraphsTreeNodeContextPanel.access$1100(this.this$0).updateData(var2, var4);
   }

   // $FF: synthetic method
   CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(CallGraphsTreeNodeContextPanel var1, CallGraphsTreeNodeContextPanel$1 var2) {
      this(var1);
   }
}
