/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IUnmatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTableModel;

class UnmatchedFunctionViewsPanel$InternalViewsTableListener
implements IUnmatchedFunctionsViewsTableListener {
    final /* synthetic */ UnmatchedFunctionViewsPanel this$0;

    private UnmatchedFunctionViewsPanel$InternalViewsTableListener(UnmatchedFunctionViewsPanel unmatchedFunctionViewsPanel) {
        this.this$0 = unmatchedFunctionViewsPanel;
    }

    @Override
    public void rowSelectionChanged(UnmatchedFunctionViewsTable unmatchedFunctionViewsTable) {
    }

    @Override
    public void tableDataChanged(UnmatchedFunctionViewsTableModel unmatchedFunctionViewsTableModel) {
        UnmatchedFunctionViewsPanel.access$100(this.this$0);
    }

    /* synthetic */ UnmatchedFunctionViewsPanel$InternalViewsTableListener(UnmatchedFunctionViewsPanel unmatchedFunctionViewsPanel, UnmatchedFunctionViewsPanel$1 unmatchedFunctionViewsPanel$1) {
        this(unmatchedFunctionViewsPanel);
    }
}

