/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;

class SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener
implements IMatchesChangeListener {
    final /* synthetic */ SingleFlowGraphBaseTreeNode this$0;

    private SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener(SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode) {
        this.this$0 = singleFlowGraphBaseTreeNode;
    }

    private void updateTree(IAddress iAddress, IAddress iAddress2, IAddress iAddress3, IAddress iAddress4) {
        IAddress iAddress5 = this.this$0.getRootNode().getView().getAddress(ESide.PRIMARY);
        IAddress iAddress6 = this.this$0.getRootNode().getView().getAddress(ESide.SECONDARY);
        if (!iAddress5.equals(iAddress)) return;
        if (!iAddress6.equals(iAddress2)) return;
        IAddress iAddress7 = iAddress3;
        if (this.this$0.getRootNode().getGraph().getSide() == ESide.SECONDARY) {
            iAddress7 = iAddress4;
        }
        SingleFlowGraphBaseTreeNode.access$300(this.this$0, iAddress7);
    }

    @Override
    public void addedBasicblockMatch(IAddress iAddress, IAddress iAddress2, IAddress iAddress3, IAddress iAddress4) {
        this.updateTree(iAddress, iAddress2, iAddress3, iAddress4);
    }

    @Override
    public void removedBasicblockMatch(IAddress iAddress, IAddress iAddress2, IAddress iAddress3, IAddress iAddress4) {
        this.updateTree(iAddress, iAddress2, iAddress3, iAddress4);
    }

    /* synthetic */ SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener(SingleFlowGraphBaseTreeNode singleFlowGraphBaseTreeNode, SingleFlowGraphBaseTreeNode$1 singleFlowGraphBaseTreeNode$1) {
        this(singleFlowGraphBaseTreeNode);
    }
}

