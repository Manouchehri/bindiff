package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.utils.*;

class SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener implements IMatchesChangeListener
{
    final /* synthetic */ SingleFlowGraphBaseTreeNode this$0;
    
    private SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener(final SingleFlowGraphBaseTreeNode this$0) {
        this.this$0 = this$0;
    }
    
    private void updateTree(final IAddress address, final IAddress address2, final IAddress address3, final IAddress address4) {
        final IAddress address5 = this.this$0.getRootNode().getView().getAddress(ESide.PRIMARY);
        final IAddress address6 = this.this$0.getRootNode().getView().getAddress(ESide.SECONDARY);
        if (address5.equals(address) && address6.equals(address2)) {
            IAddress address7 = address3;
            if (this.this$0.getRootNode().getGraph().getSide() == ESide.SECONDARY) {
                address7 = address4;
            }
            this.this$0.replaceBasicblockTreeNode(address7);
        }
    }
    
    @Override
    public void addedBasicblockMatch(final IAddress address, final IAddress address2, final IAddress address3, final IAddress address4) {
        this.updateTree(address, address2, address3, address4);
    }
    
    @Override
    public void removedBasicblockMatch(final IAddress address, final IAddress address2, final IAddress address3, final IAddress address4) {
        this.updateTree(address, address2, address3, address4);
    }
}
