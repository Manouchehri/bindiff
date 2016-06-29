/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBasicBlockTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphRootTreeNode;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Collection;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

class CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener
implements IMatchesChangeListener {
    final /* synthetic */ CombinedFlowGraphBaseTreeNode this$0;

    private CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener(CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode) {
        this.this$0 = combinedFlowGraphBaseTreeNode;
    }

    private boolean isAffected(IAddress iAddress, IAddress iAddress2) {
        IAddress iAddress3 = this.this$0.getRootNode().getView().getAddress(ESide.PRIMARY);
        IAddress iAddress4 = this.this$0.getRootNode().getView().getAddress(ESide.SECONDARY);
        if (!iAddress.equals(iAddress3)) return false;
        if (!iAddress2.equals(iAddress4)) return false;
        return true;
    }

    @Override
    public void addedBasicblockMatch(IAddress iAddress, IAddress iAddress2, IAddress iAddress3, IAddress iAddress4) {
        Object object;
        Object object2;
        if (!this.isAffected(iAddress, iAddress2)) return;
        CombinedDiffNode combinedDiffNode = null;
        for (CombinedDiffNode combinedDiffNode2 : this.this$0.getRootNode().getGraph().getNodes()) {
            object2 = combinedDiffNode2.getPrimaryRawNode() == null ? null : combinedDiffNode2.getPrimaryRawNode().getAddress();
            Object object3 = object = combinedDiffNode2.getSecondaryRawNode() == null ? null : combinedDiffNode2.getSecondaryRawNode().getAddress();
            if (!iAddress3.equals(object2) || !iAddress4.equals(object)) continue;
            combinedDiffNode = combinedDiffNode2;
            break;
        }
        if (combinedDiffNode == null) return;
        boolean bl2 = false;
        for (int i2 = 1; i2 < this.this$0.getChildCount(); ++i2) {
            object2 = (CombinedFlowGraphBasicBlockTreeNode)this.this$0.getChildAt(i2);
            object = object2.getCombinedBasicblock();
            if (iAddress3.equals(object.getAddress(ESide.PRIMARY))) {
                CombinedFlowGraphBaseTreeNode.access$500(this.this$0).remove(object2);
                this.this$0.remove((MutableTreeNode)object2);
                if (bl2) {
                    CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), combinedDiffNode);
                    CombinedFlowGraphBaseTreeNode.access$500(this.this$0).add(combinedFlowGraphBasicBlockTreeNode);
                    this.this$0.add(combinedFlowGraphBasicBlockTreeNode);
                    break;
                }
                bl2 = true;
                continue;
            }
            if (!iAddress4.equals(object.getAddress(ESide.SECONDARY))) continue;
            CombinedFlowGraphBaseTreeNode.access$500(this.this$0).remove(object2);
            this.this$0.remove((MutableTreeNode)object2);
            if (bl2) {
                CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), combinedDiffNode);
                CombinedFlowGraphBaseTreeNode.access$500(this.this$0).add(combinedFlowGraphBasicBlockTreeNode);
                this.this$0.add(combinedFlowGraphBasicBlockTreeNode);
                break;
            }
            bl2 = true;
        }
        this.this$0.updateTreeNodes(true);
    }

    @Override
    public void removedBasicblockMatch(IAddress iAddress, IAddress iAddress2, IAddress iAddress3, IAddress iAddress4) {
        Object object;
        Object object2;
        if (!this.isAffected(iAddress, iAddress2)) return;
        Object object3 = null;
        Object object4 = null;
        for (Object object52 : this.this$0.getRootNode().getGraph().getNodes()) {
            object2 = object52.getPrimaryRawNode() == null ? null : object52.getPrimaryRawNode().getAddress();
            Object object6 = object = object52.getSecondaryRawNode() == null ? null : object52.getSecondaryRawNode().getAddress();
            if (iAddress3.equals(object2) && object == null && (object3 = object52) != null && object4 != null) break;
            if (!iAddress4.equals(object) || object2 != null) continue;
            object4 = object52;
            if (object3 == null || object4 == null) continue;
        }
        if (object3 == null) return;
        if (object4 == null) return;
        for (int i2 = 0; i2 < this.this$0.getChildCount(); ++i2) {
            Object object52;
            object52 = (CombinedFlowGraphBasicBlockTreeNode)this.this$0.getChildAt(i2);
            object2 = object52.getCombinedBasicblock();
            if (!iAddress3.equals(object2.getAddress(ESide.PRIMARY)) || !iAddress4.equals(object2.getAddress(ESide.SECONDARY))) continue;
            object = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), (CombinedDiffNode)object3);
            CombinedFlowGraphBasicBlockTreeNode combinedFlowGraphBasicBlockTreeNode = new CombinedFlowGraphBasicBlockTreeNode(this.this$0.getRootNode(), (CombinedDiffNode)object4);
            this.this$0.insert((MutableTreeNode)object, i2);
            int n2 = CombinedFlowGraphBaseTreeNode.access$500(this.this$0).indexOf(object52);
            CombinedFlowGraphBaseTreeNode.access$500(this.this$0).set(n2, object);
            CombinedFlowGraphBaseTreeNode.access$500(this.this$0).add(combinedFlowGraphBasicBlockTreeNode);
            break;
        }
        this.this$0.updateTreeNodes(true);
    }

    /* synthetic */ CombinedFlowGraphBaseTreeNode$InternalMatchesChangeListener(CombinedFlowGraphBaseTreeNode combinedFlowGraphBaseTreeNode, CombinedFlowGraphBaseTreeNode$1 combinedFlowGraphBaseTreeNode$1) {
        this(combinedFlowGraphBaseTreeNode);
    }
}

