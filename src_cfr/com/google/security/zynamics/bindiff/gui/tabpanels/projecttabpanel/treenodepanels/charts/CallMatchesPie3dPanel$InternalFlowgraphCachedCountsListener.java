/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.CallMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;

class CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener
extends DiffChangeAdapter {
    final /* synthetic */ CallMatchesPie3dPanel this$0;

    private CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(CallMatchesPie3dPanel callMatchesPie3dPanel) {
        this.this$0 = callMatchesPie3dPanel;
    }

    @Override
    public void callsCountChanged() {
        CallMatchesPie3dPanel.access$1000(this.this$0);
    }

    /* synthetic */ CallMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(CallMatchesPie3dPanel callMatchesPie3dPanel, CallMatchesPie3dPanel$1 callMatchesPie3dPanel$1) {
        this(callMatchesPie3dPanel);
    }
}

