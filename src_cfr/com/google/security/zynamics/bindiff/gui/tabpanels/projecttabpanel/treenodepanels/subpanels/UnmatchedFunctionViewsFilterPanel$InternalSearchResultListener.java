/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.IViewSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.helpers.GraphGetter;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ListSelectionModel;

class UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener
implements IViewSearchFieldListener {
    final /* synthetic */ UnmatchedFunctionViewsFilterPanel this$0;

    private UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener(UnmatchedFunctionViewsFilterPanel unmatchedFunctionViewsFilterPanel) {
        this.this$0 = unmatchedFunctionViewsFilterPanel;
    }

    @Override
    public void reset() {
        UnmatchedFunctionViewsTableModel unmatchedFunctionViewsTableModel = (UnmatchedFunctionViewsTableModel)UnmatchedFunctionViewsFilterPanel.access$700(this.this$0).getTableModel();
        Diff diff = unmatchedFunctionViewsTableModel.getDiff();
        HashSet hashSet = new HashSet();
        hashSet.addAll(GraphGetter.getUnmatchedFunctions(diff.getCallgraph(UnmatchedFunctionViewsFilterPanel.access$600(this.this$0))));
        unmatchedFunctionViewsTableModel.setUnmatchedFunctions(hashSet);
        unmatchedFunctionViewsTableModel.fireTableDataChanged();
        UnmatchedFunctionViewsFilterPanel.access$500(this.this$0).setIcon(UnmatchedFunctionViewsFilterPanel.access$400());
        this.this$0.updateUI();
    }

    @Override
    public void searched(List list, boolean bl2) {
        HashSet<RawFunction> hashSet = new HashSet<RawFunction>();
        UnmatchedFunctionViewsTableModel unmatchedFunctionViewsTableModel = (UnmatchedFunctionViewsTableModel)UnmatchedFunctionViewsFilterPanel.access$700(this.this$0).getTableModel();
        CTableSorter cTableSorter = UnmatchedFunctionViewsFilterPanel.access$700(this.this$0).getModel();
        ListSelectionModel listSelectionModel = UnmatchedFunctionViewsFilterPanel.access$700(this.this$0).getSelectionModel();
        for (Integer n2 : list) {
            int n3 = cTableSorter.modelIndex(n2);
            if (bl2) {
                listSelectionModel.addSelectionInterval(n2, n2);
                continue;
            }
            hashSet.add(unmatchedFunctionViewsTableModel.getUnmatchedFunctionAt(n3));
        }
        if (!bl2) {
            unmatchedFunctionViewsTableModel.setUnmatchedFunctions(hashSet);
            unmatchedFunctionViewsTableModel.fireTableDataChanged();
        }
        if (list.size() > 0) {
            UnmatchedFunctionViewsFilterPanel.access$500(this.this$0).setIcon(UnmatchedFunctionViewsFilterPanel.access$800());
        } else {
            UnmatchedFunctionViewsFilterPanel.access$500(this.this$0).setIcon(UnmatchedFunctionViewsFilterPanel.access$400());
        }
        this.this$0.updateUI();
    }

    /* synthetic */ UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener(UnmatchedFunctionViewsFilterPanel unmatchedFunctionViewsFilterPanel, UnmatchedFunctionViewsFilterPanel$1 unmatchedFunctionViewsFilterPanel$1) {
        this(unmatchedFunctionViewsFilterPanel);
    }
}

