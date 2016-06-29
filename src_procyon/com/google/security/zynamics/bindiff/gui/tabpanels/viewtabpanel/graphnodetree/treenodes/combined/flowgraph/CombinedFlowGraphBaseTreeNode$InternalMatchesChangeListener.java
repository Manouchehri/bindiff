package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.project.helpers.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.utils.*;

class CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener implements IMatchesChangeListener
{
    final /* synthetic */ CombinedFlowGraphBaseTreeNode this$0;
    
    private CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener(final CombinedFlowGraphBaseTreeNode this$0) {
        this.this$0 = this$0;
    }
    
    private boolean isAffected(final IAddress address, final IAddress address2) {
        final IAddress address3 = this.this$0.getRootNode().getView().getAddress(ESide.PRIMARY);
        final IAddress address4 = this.this$0.getRootNode().getView().getAddress(ESide.SECONDARY);
        return address.equals(address3) && address2.equals(address4);
    }
    
    @Override
    public void addedBasicblockMatch(final IAddress address, final IAddress address2, final IAddress address3, final IAddress address4) {
        if (this.isAffected(address, address2)) {
            CombinedDiffNode combinedDiffNode = null;
            for (final CombinedDiffNode combinedDiffNode2 : this.this$0.getRootNode().getGraph().getNodes()) {
                final IAddress address5 = (combinedDiffNode2.getPrimaryRawNode() == null) ? null : combinedDiffNode2.getPrimaryRawNode().getAddress();
                final IAddress address6 = (combinedDiffNode2.getSecondaryRawNode() == null) ? null : combinedDiffNode2.getSecondaryRawNode().getAddress();
                if (address3.equals(address5) && address4.equals(address6)) {
                    combinedDiffNode = combinedDiffNode2;
                    break;
                }
            }
            if (combinedDiffNode != null) {
                int n = 0;
                for (int i = 1; i < this.this$0.getChildCount(); ++i) {
                    final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode = (CombinedFlowGraphBasicBlockTreeNode)this.this$0.getChildAt(i);
                    final RawCombinedBasicBlock combinedBasicblock = combinedFlowGraphBasicBlockTreeNode.getCombinedBasicblock();
                    if (address3.equals(combinedBasicblock.getAddress(ESide.PRIMARY))) {
                        this.this$0.basicblockTreeNodes.remove(combinedFlowGraphBasicBlockTreeNode);
                        this.this$0.remove(combinedFlowGraphBasicBlockTreeNode);
                        if (n != 0) {
                            final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode2 = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), combinedDiffNode);
                            this.this$0.basicblockTreeNodes.add(combinedFlowGraphBasicBlockTreeNode2);
                            this.this$0.add(combinedFlowGraphBasicBlockTreeNode2);
                            break;
                        }
                        n = 1;
                    }
                    else if (address4.equals(combinedBasicblock.getAddress(ESide.SECONDARY))) {
                        this.this$0.basicblockTreeNodes.remove(combinedFlowGraphBasicBlockTreeNode);
                        this.this$0.remove(combinedFlowGraphBasicBlockTreeNode);
                        if (n != 0) {
                            final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode3 = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), combinedDiffNode);
                            this.this$0.basicblockTreeNodes.add(combinedFlowGraphBasicBlockTreeNode3);
                            this.this$0.add(combinedFlowGraphBasicBlockTreeNode3);
                            break;
                        }
                        n = 1;
                    }
                }
                this.this$0.updateTreeNodes(true);
            }
        }
    }
    
    @Override
    public void removedBasicblockMatch(final IAddress address, final IAddress address2, final IAddress address3, final IAddress address4) {
        if (this.isAffected(address, address2)) {
            CombinedDiffNode combinedDiffNode = null;
            CombinedDiffNode combinedDiffNode2 = null;
            for (final CombinedDiffNode combinedDiffNode3 : this.this$0.getRootNode().getGraph().getNodes()) {
                final IAddress address5 = (combinedDiffNode3.getPrimaryRawNode() == null) ? null : combinedDiffNode3.getPrimaryRawNode().getAddress();
                final IAddress address6 = (combinedDiffNode3.getSecondaryRawNode() == null) ? null : combinedDiffNode3.getSecondaryRawNode().getAddress();
                if (address3.equals(address5) && address6 == null) {
                    combinedDiffNode = combinedDiffNode3;
                    if (combinedDiffNode != null && combinedDiffNode2 != null) {
                        break;
                    }
                }
                if (address4.equals(address6) && address5 == null) {
                    combinedDiffNode2 = combinedDiffNode3;
                    if (combinedDiffNode != null && combinedDiffNode2 != null) {
                        break;
                    }
                    continue;
                }
            }
            if (combinedDiffNode != null && combinedDiffNode2 != null) {
                for (int i = 0; i < this.this$0.getChildCount(); ++i) {
                    final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode = (CombinedFlowGraphBasicBlockTreeNode)this.this$0.getChildAt(i);
                    final RawCombinedBasicBlock combinedBasicblock = combinedFlowGraphBasicBlockTreeNode.getCombinedBasicblock();
                    if (address3.equals(combinedBasicblock.getAddress(ESide.PRIMARY)) && address4.equals(combinedBasicblock.getAddress(ESide.SECONDARY))) {
                        final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode2 = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), combinedDiffNode);
                        final CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode3 = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), combinedDiffNode2);
                        this.this$0.insert(combinedFlowGraphBasicBlockTreeNode2, i);
                        this.this$0.basicblockTreeNodes.set(this.this$0.basicblockTreeNodes.indexOf(combinedFlowGraphBasicBlockTreeNode), combinedFlowGraphBasicBlockTreeNode2);
                        this.this$0.basicblockTreeNodes.add(combinedFlowGraphBasicBlockTreeNode3);
                        break;
                    }
                }
                this.this$0.updateTreeNodes(true);
            }
        }
    }
}
