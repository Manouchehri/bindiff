/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.IViewsFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionsViewsTableModel;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener
implements IViewsFilterCheckboxListener {
    final /* synthetic */ MatchedFunctionsTreeNodeContextPanel this$0;

    private MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener(MatchedFunctionsTreeNodeContextPanel matchedFunctionsTreeNodeContextPanel) {
        this.this$0 = matchedFunctionsTreeNodeContextPanel;
    }

    @Override
    public void functionViewsFilterChanged(boolean bl2, boolean bl3, boolean bl4) {
        RawCallGraph rawCallGraph = MatchedFunctionsTreeNodeContextPanel.access$300(this.this$0).getCallgraph(ESide.PRIMARY);
        RawCallGraph rawCallGraph2 = MatchedFunctionsTreeNodeContextPanel.access$300(this.this$0).getCallgraph(ESide.SECONDARY);
        HashSet hashSet = new HashSet();
        if (!(bl2 || bl3 || bl4)) {
            hashSet.addAll(GraphGetter.getMatchedFunctionPairs(rawCallGraph, rawCallGraph2));
        } else {
            if (bl2) {
                hashSet.addAll(GraphGetter.getStructuralChangedFunctionPairs(rawCallGraph, rawCallGraph2));
            }
            if (bl3) {
                hashSet.addAll(GraphGetter.getInstructionOnlyChangedFunctionPairs(rawCallGraph, rawCallGraph2));
            }
            if (bl4) {
                hashSet.addAll(GraphGetter.getIdenticalFunctionPairs(rawCallGraph, rawCallGraph2));
            }
        }
        ((MatchedFunctionsViewsTableModel)MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0).getTableModel()).setMatchedFunctionPairs(hashSet);
    }

    /* synthetic */ MatchedFunctionsTreeNodeContextPanel$InternalFilterCheckboxListener(MatchedFunctionsTreeNodeContextPanel matchedFunctionsTreeNodeContextPanel, MatchedFunctionsTreeNodeContextPanel$1 matchedFunctionsTreeNodeContextPanel$1) {
        this(matchedFunctionsTreeNodeContextPanel);
    }
}

