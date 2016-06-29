/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BasicBlockMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;

class BasicBlockMatchesPie3dPanel$InternalFlowgraphCachedCountsListener
extends DiffChangeAdapter {
    final /* synthetic */ BasicBlockMatchesPie3dPanel this$0;

    private BasicBlockMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(BasicBlockMatchesPie3dPanel basicBlockMatchesPie3dPanel) {
        this.this$0 = basicBlockMatchesPie3dPanel;
    }

    @Override
    public void basicblocksCountChanged() {
        BasicBlockMatchesPie3dPanel.access$1000(this.this$0);
    }

    /* synthetic */ BasicBlockMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(BasicBlockMatchesPie3dPanel basicBlockMatchesPie3dPanel, BasicBlockMatchesPie3dPanel$1 basicBlockMatchesPie3dPanel$1) {
        this(basicBlockMatchesPie3dPanel);
    }
}

