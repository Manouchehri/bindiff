package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.zylib.gui.tables.*;
import com.google.security.zynamics.bindiff.gui.components.viewsearchfield.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import java.awt.event.*;
import java.util.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.utils.*;

class UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener implements IViewSearchFieldListener
{
    final /* synthetic */ UnmatchedFunctionViewsFilterPanel this$0;
    
    private UnmatchedFunctionViewsFilterPanel$InternalSearchResultListener(final UnmatchedFunctionViewsFilterPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void reset() {
        final UnmatchedFunctionViewsTableModel unmatchedFunctionViewsTableModel = (UnmatchedFunctionViewsTableModel)this.this$0.unmatchedFunctionsViewTable.getTableModel();
        final Diff diff = unmatchedFunctionViewsTableModel.getDiff();
        final HashSet unmatchedFunctions = new HashSet();
        unmatchedFunctions.addAll(GraphGetter.getUnmatchedFunctions(diff.getCallgraph(this.this$0.side)));
        unmatchedFunctionViewsTableModel.setUnmatchedFunctions(unmatchedFunctions);
        unmatchedFunctionViewsTableModel.fireTableDataChanged();
        this.this$0.clearButton.setIcon(UnmatchedFunctionViewsFilterPanel.ICON_CLEAR_GRAY);
        this.this$0.updateUI();
    }
    
    @Override
    public void searched(final List list, final boolean b) {
        final HashSet<RawFunction> unmatchedFunctions = new HashSet<RawFunction>();
        final UnmatchedFunctionViewsTableModel unmatchedFunctionViewsTableModel = (UnmatchedFunctionViewsTableModel)this.this$0.unmatchedFunctionsViewTable.getTableModel();
        final CTableSorter model = this.this$0.unmatchedFunctionsViewTable.getModel();
        final ListSelectionModel selectionModel = this.this$0.unmatchedFunctionsViewTable.getSelectionModel();
        for (final Integer n : list) {
            final int modelIndex = model.modelIndex(n);
            if (b) {
                selectionModel.addSelectionInterval(n, n);
            }
            else {
                unmatchedFunctions.add(unmatchedFunctionViewsTableModel.getUnmatchedFunctionAt(modelIndex));
            }
        }
        if (!b) {
            unmatchedFunctionViewsTableModel.setUnmatchedFunctions(unmatchedFunctions);
            unmatchedFunctionViewsTableModel.fireTableDataChanged();
        }
        if (list.size() > 0) {
            this.this$0.clearButton.setIcon(UnmatchedFunctionViewsFilterPanel.ICON_CLEAR);
        }
        else {
            this.this$0.clearButton.setIcon(UnmatchedFunctionViewsFilterPanel.ICON_CLEAR_GRAY);
        }
        this.this$0.updateUI();
    }
}
