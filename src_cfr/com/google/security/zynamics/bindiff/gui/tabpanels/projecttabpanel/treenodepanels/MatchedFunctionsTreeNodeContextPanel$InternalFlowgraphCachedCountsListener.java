/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;

class MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener
extends DiffChangeAdapter {
    final /* synthetic */ MatchedFunctionsTreeNodeContextPanel this$0;

    private MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(MatchedFunctionsTreeNodeContextPanel matchedFunctionsTreeNodeContextPanel) {
        this.this$0 = matchedFunctionsTreeNodeContextPanel;
    }

    @Override
    public void basicblocksCountChanged() {
        MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
    }

    @Override
    public void callsCountChanged() {
        MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
    }

    @Override
    public void instructionsCountsChanged() {
        MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
    }

    @Override
    public void jumpsCountChanged() {
        MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
    }

    /* synthetic */ MatchedFunctionsTreeNodeContextPanel$InternalFlowgraphCachedCountsListener(MatchedFunctionsTreeNodeContextPanel matchedFunctionsTreeNodeContextPanel, MatchedFunctionsTreeNodeContextPanel$1 matchedFunctionsTreeNodeContextPanel$1) {
        this(matchedFunctionsTreeNodeContextPanel);
    }
}

