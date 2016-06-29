/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class CombinedFlowGraphBaseTreeNode$4
extends AbstractAction {
    final /* synthetic */ CombinedFlowGraphBaseTreeNode this$0;

    CombinedFlowGraphBaseTreeNode$4(CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode, String string) {
        this.this$0 = combinedFlowGraphBaseTreeNode;
        super(string);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        FlowGraphViewData flowGraphViewData = (FlowGraphViewData)CombinedFlowGraphBaseTreeNode.access$400(this.this$0);
        ClipboardHelpers.copyToClipboard(flowGraphViewData.getFunctionName(ESide.SECONDARY));
    }
}

