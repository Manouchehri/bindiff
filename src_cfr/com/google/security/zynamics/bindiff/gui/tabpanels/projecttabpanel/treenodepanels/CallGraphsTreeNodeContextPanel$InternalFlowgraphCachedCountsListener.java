/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.CallGraphsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.CallGraphsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;
import com.google.security.zynamics.bindiff.project.matches.MatchData;

class CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener
extends DiffChangeAdapter {
    final /* synthetic */ CallGraphsTreeNodeContextPanel this$0;

    private CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel) {
        this.this$0 = callGraphsTreeNodeContextPanel;
    }

    @Override
    public void basicblocksCountChanged() {
        MatchData matchData = CallGraphsTreeNodeContextPanel.access$100(this.this$0).getMatches();
        int n2 = matchData.getSizeOfMatchedBasicblocks();
        int n3 = matchData.getSizeOfUnmatchedBasicblocks(ESide.PRIMARY);
        int n4 = matchData.getSizeOfUnmatchedBasicblocks(ESide.SECONDARY);
        CallGraphsTreeNodeContextPanel.access$200(this.this$0).updateData(n2, n3);
        CallGraphsTreeNodeContextPanel.access$300(this.this$0).updateData(n2, n4);
    }

    @Override
    public void callsCountChanged() {
        MatchData matchData = CallGraphsTreeNodeContextPanel.access$100(this.this$0).getMatches();
        int n2 = matchData.getSizeOfMatchedCalls();
        int n3 = matchData.getSizeOfChangedCalls();
        int n4 = matchData.getSizeOfUnmatchedCalls(ESide.PRIMARY);
        int n5 = matchData.getSizeOfUnmatchedCalls(ESide.SECONDARY);
        CallGraphsTreeNodeContextPanel.access$400(this.this$0).updateData(n2, n3, n4);
        CallGraphsTreeNodeContextPanel.access$500(this.this$0).updateData(n2, n3, n5);
    }

    @Override
    public void functionsCountChanged() {
        MatchData matchData = CallGraphsTreeNodeContextPanel.access$100(this.this$0).getMatches();
        int n2 = matchData.getSizeOfMatchedFunctions();
        int n3 = matchData.getSizeOfChangedFunctions();
        int n4 = matchData.getSizeOfUnmatchedFunctions(ESide.PRIMARY);
        int n5 = matchData.getSizeOfUnmatchedFunctions(ESide.SECONDARY);
        CallGraphsTreeNodeContextPanel.access$600(this.this$0).updateData(n2, n3, n4);
        CallGraphsTreeNodeContextPanel.access$700(this.this$0).updateData(n2, n3, n5);
    }

    @Override
    public void instructionsCountsChanged() {
        MatchData matchData = CallGraphsTreeNodeContextPanel.access$100(this.this$0).getMatches();
        int n2 = matchData.getSizeOfMatchedInstructions();
        int n3 = matchData.getSizeOfUnmatchedInstructions(ESide.PRIMARY);
        int n4 = matchData.getSizeOfUnmatchedInstructions(ESide.SECONDARY);
        CallGraphsTreeNodeContextPanel.access$800(this.this$0).updateData(n2, n3);
        CallGraphsTreeNodeContextPanel.access$900(this.this$0).updateData(n2, n4);
    }

    @Override
    public void jumpsCountChanged() {
        MatchData matchData = CallGraphsTreeNodeContextPanel.access$100(this.this$0).getMatches();
        int n2 = matchData.getSizeOfMatchedJumps();
        int n3 = matchData.getSizeOfUnmatchedJumps(ESide.PRIMARY);
        int n4 = matchData.getSizeOfUnmatchedJumps(ESide.SECONDARY);
        CallGraphsTreeNodeContextPanel.access$1000(this.this$0).updateData(n2, n3);
        CallGraphsTreeNodeContextPanel.access$1100(this.this$0).updateData(n2, n4);
    }

    /* synthetic */ CallGraphsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(CallGraphsTreeNodeContextPanel callGraphsTreeNodeContextPanel, CallGraphsTreeNodeContextPanel$1 callGraphsTreeNodeContextPanel$1) {
        this(callGraphsTreeNodeContextPanel);
    }
}

