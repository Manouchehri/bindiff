package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.zylib.gui.tables.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;

class MatchedFunctionViewsFilterPanel$InternalSearchResultListener implements IViewSearchFieldListener
{
    final /* synthetic */ MatchedFunctionViewsFilterPanel this$0;
    
    private MatchedFunctionViewsFilterPanel$InternalSearchResultListener(final MatchedFunctionViewsFilterPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void reset() {
        final MatchedFunctionsViewsTableModel matchedFunctionsViewsTableModel = (MatchedFunctionsViewsTableModel)this.this$0.matchedFunctionsViewTable.getTableModel();
        final Diff diff = matchedFunctionsViewsTableModel.getDiff();
        final RawCallGraph callgraph = diff.getCallgraph(ESide.PRIMARY);
        final RawCallGraph callgraph2 = diff.getCallgraph(ESide.SECONDARY);
        final HashSet matchedFunctionPairs = new HashSet();
        if (this.this$0.showStructuralChangedFunctions.isSelected() && this.this$0.showInstructionChangedOnlyFunctions.isSelected() && this.this$0.showIdenticalFunctions.isSelected()) {
            matchedFunctionPairs.addAll(GraphGetter.getMatchedFunctionPairs(callgraph, callgraph2));
        }
        else {
            if (this.this$0.showStructuralChangedFunctions.isSelected()) {
                matchedFunctionPairs.addAll(GraphGetter.getStructuralChangedFunctionPairs(callgraph, callgraph2));
            }
            if (this.this$0.showInstructionChangedOnlyFunctions.isSelected()) {
                matchedFunctionPairs.addAll(GraphGetter.getInstructionOnlyChangedFunctionPairs(callgraph, callgraph2));
            }
            if (this.this$0.showIdenticalFunctions.isSelected()) {
                matchedFunctionPairs.addAll(GraphGetter.getIdenticalFunctionPairs(callgraph, callgraph2));
            }
        }
        matchedFunctionsViewsTableModel.setMatchedFunctionPairs(matchedFunctionPairs);
        matchedFunctionsViewsTableModel.fireTableDataChanged();
        this.this$0.clearButton.setIcon(MatchedFunctionViewsFilterPanel.ICON_CLEAR_GRAY);
        this.this$0.updateUI();
    }
    
    @Override
    public void searched(final List list, final boolean b) {
        final HashSet<Pair> matchedFunctionPairs = new HashSet<Pair>();
        final MatchedFunctionsViewsTableModel matchedFunctionsViewsTableModel = (MatchedFunctionsViewsTableModel)this.this$0.matchedFunctionsViewTable.getTableModel();
        final CTableSorter model = this.this$0.matchedFunctionsViewTable.getModel();
        final ListSelectionModel selectionModel = this.this$0.matchedFunctionsViewTable.getSelectionModel();
        for (final Integer n : list) {
            final int modelIndex = model.modelIndex(n);
            if (b) {
                selectionModel.addSelectionInterval(n, n);
            }
            else {
                matchedFunctionPairs.add(matchedFunctionsViewsTableModel.getMatchedFunctionPairAt(modelIndex));
            }
        }
        if (!b) {
            matchedFunctionsViewsTableModel.setMatchedFunctionPairs(matchedFunctionPairs);
            matchedFunctionsViewsTableModel.fireTableDataChanged();
        }
        if (list.size() > 0) {
            this.this$0.clearButton.setIcon(MatchedFunctionViewsFilterPanel.ICON_CLEAR);
        }
        else {
            this.this$0.clearButton.setIcon(MatchedFunctionViewsFilterPanel.ICON_CLEAR_GRAY);
        }
        this.this$0.updateUI();
    }
}
