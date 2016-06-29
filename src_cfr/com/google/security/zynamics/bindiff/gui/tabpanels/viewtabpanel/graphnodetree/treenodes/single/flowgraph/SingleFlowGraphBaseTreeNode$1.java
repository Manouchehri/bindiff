/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class SingleFlowGraphBaseTreeNode$1
extends AbstractAction {
    final /* synthetic */ ESide val$side;
    final /* synthetic */ SingleFlowGraphBaseTreeNode this$0;

    SingleFlowGraphBaseTreeNode$1(SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode, String string, ESide eSide) {
        this.this$0 = singleFlowGraphBaseTreeNode;
        this.val$side = eSide;
        super(string);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        FlowGraphViewData flowGraphViewData = (FlowGraphViewData)SingleFlowGraphBaseTreeNode.access$100(this.this$0);
        ClipboardHelpers.copyToClipboard(flowGraphViewData.getAddress(this.val$side).toHexString());
    }
}

