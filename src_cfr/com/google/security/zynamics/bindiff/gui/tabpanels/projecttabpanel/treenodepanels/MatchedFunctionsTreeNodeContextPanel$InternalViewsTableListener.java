/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionsViewsTableModel;

class MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener
implements IMatchedFunctionsViewsTableListener {
    final /* synthetic */ MatchedFunctionsTreeNodeContextPanel this$0;

    private MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener(MatchedFunctionsTreeNodeContextPanel matchedFunctionsTreeNodeContextPanel) {
        this.this$0 = matchedFunctionsTreeNodeContextPanel;
    }

    @Override
    public void rowSelectionChanged(MatchedFunctionViewsTable matchedFunctionViewsTable) {
        MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
    }

    @Override
    public void tableDataChanged(MatchedFunctionsViewsTableModel matchedFunctionsViewsTableModel) {
        MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
        MatchedFunctionsTreeNodeContextPanel.access$600(this.this$0);
    }

    /* synthetic */ MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener(MatchedFunctionsTreeNodeContextPanel matchedFunctionsTreeNodeContextPanel, MatchedFunctionsTreeNodeContextPanel$1 matchedFunctionsTreeNodeContextPanel$1) {
        this(matchedFunctionsTreeNodeContextPanel);
    }
}

