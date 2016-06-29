/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.JumpMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;

class JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener
extends DiffChangeAdapter {
    final /* synthetic */ JumpMatchesPie3dPanel this$0;

    private JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(JumpMatchesPie3dPanel jumpMatchesPie3dPanel) {
        this.this$0 = jumpMatchesPie3dPanel;
    }

    @Override
    public void jumpsCountChanged() {
        JumpMatchesPie3dPanel.access$1000(this.this$0);
    }

    /* synthetic */ JumpMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(JumpMatchesPie3dPanel jumpMatchesPie3dPanel, JumpMatchesPie3dPanel$1 jumpMatchesPie3dPanel$1) {
        this(jumpMatchesPie3dPanel);
    }
}

