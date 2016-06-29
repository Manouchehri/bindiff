/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.IViewSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionsViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ListSelectionModel;

class MatchedFunctionViewsFilterPanel$InternalSearchResultListener
implements IViewSearchFieldListener {
    final /* synthetic */ MatchedFunctionViewsFilterPanel this$0;

    private MatchedFunctionViewsFilterPanel$InternalSearchResultListener(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel) {
        this.this$0 = matchedFunctionViewsFilterPanel;
    }

    @Override
    public void reset() {
        MatchedFunctionsViewsTableModel matchedFunctionsViewsTableModel = (MatchedFunctionsViewsTableModel)MatchedFunctionViewsFilterPanel.access$1100(this.this$0).getTableModel();
        Diff diff = matchedFunctionsViewsTableModel.getDiff();
        RawCallGraph rawCallGraph = diff.getCallgraph(ESide.PRIMARY);
        RawCallGraph rawCallGraph2 = diff.getCallgraph(ESide.SECONDARY);
        HashSet hashSet = new HashSet();
        if (MatchedFunctionViewsFilterPanel.access$700(this.this$0).isSelected() && MatchedFunctionViewsFilterPanel.access$800(this.this$0).isSelected() && MatchedFunctionViewsFilterPanel.access$900(this.this$0).isSelected()) {
            hashSet.addAll(GraphGetter.getMatchedFunctionPairs(rawCallGraph, rawCallGraph2));
        } else {
            if (MatchedFunctionViewsFilterPanel.access$700(this.this$0).isSelected()) {
                hashSet.addAll(GraphGetter.getStructuralChangedFunctionPairs(rawCallGraph, rawCallGraph2));
            }
            if (MatchedFunctionViewsFilterPanel.access$800(this.this$0).isSelected()) {
                hashSet.addAll(GraphGetter.getInstructionOnlyChangedFunctionPairs(rawCallGraph, rawCallGraph2));
            }
            if (MatchedFunctionViewsFilterPanel.access$900(this.this$0).isSelected()) {
                hashSet.addAll(GraphGetter.getIdenticalFunctionPairs(rawCallGraph, rawCallGraph2));
            }
        }
        matchedFunctionsViewsTableModel.setMatchedFunctionPairs(hashSet);
        matchedFunctionsViewsTableModel.fireTableDataChanged();
        MatchedFunctionViewsFilterPanel.access$600(this.this$0).setIcon(MatchedFunctionViewsFilterPanel.access$500());
        this.this$0.updateUI();
    }

    @Override
    public void searched(List list, boolean bl2) {
        HashSet<Pair> hashSet = new HashSet<Pair>();
        MatchedFunctionsViewsTableModel matchedFunctionsViewsTableModel = (MatchedFunctionsViewsTableModel)MatchedFunctionViewsFilterPanel.access$1100(this.this$0).getTableModel();
        CTableSorter cTableSorter = MatchedFunctionViewsFilterPanel.access$1100(this.this$0).getModel();
        ListSelectionModel listSelectionModel = MatchedFunctionViewsFilterPanel.access$1100(this.this$0).getSelectionModel();
        for (Integer n2 : list) {
            int n3 = cTableSorter.modelIndex(n2);
            if (bl2) {
                listSelectionModel.addSelectionInterval(n2, n2);
                continue;
            }
            hashSet.add(matchedFunctionsViewsTableModel.getMatchedFunctionPairAt(n3));
        }
        if (!bl2) {
            matchedFunctionsViewsTableModel.setMatchedFunctionPairs(hashSet);
            matchedFunctionsViewsTableModel.fireTableDataChanged();
        }
        if (list.size() > 0) {
            MatchedFunctionViewsFilterPanel.access$600(this.this$0).setIcon(MatchedFunctionViewsFilterPanel.access$1200());
        } else {
            MatchedFunctionViewsFilterPanel.access$600(this.this$0).setIcon(MatchedFunctionViewsFilterPanel.access$500());
        }
        this.this$0.updateUI();
    }

    /* synthetic */ MatchedFunctionViewsFilterPanel$InternalSearchResultListener(MatchedFunctionViewsFilterPanel matchedFunctionViewsFilterPanel, MatchedFunctionViewsFilterPanel$1 matchedFunctionViewsFilterPanel$1) {
        this(matchedFunctionViewsFilterPanel);
    }
}

