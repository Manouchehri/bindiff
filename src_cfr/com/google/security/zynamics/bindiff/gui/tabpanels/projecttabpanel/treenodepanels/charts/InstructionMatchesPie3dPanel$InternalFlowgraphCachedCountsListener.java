/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.InstructionMatchesPie3dPanel$1;
import com.google.security.zynamics.bindiff.project.diff.DiffChangeAdapter;

class InstructionMatchesPie3dPanel$InternalFlowgraphCachedCountsListener
extends DiffChangeAdapter {
    final /* synthetic */ InstructionMatchesPie3dPanel this$0;

    private InstructionMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(InstructionMatchesPie3dPanel instructionMatchesPie3dPanel) {
        this.this$0 = instructionMatchesPie3dPanel;
    }

    @Override
    public void instructionsCountsChanged() {
        InstructionMatchesPie3dPanel.access$1000(this.this$0);
    }

    /* synthetic */ InstructionMatchesPie3dPanel$InternalFlowgraphCachedCountsListener(InstructionMatchesPie3dPanel instructionMatchesPie3dPanel, InstructionMatchesPie3dPanel$1 instructionMatchesPie3dPanel$1) {
        this(instructionMatchesPie3dPanel);
    }
}

