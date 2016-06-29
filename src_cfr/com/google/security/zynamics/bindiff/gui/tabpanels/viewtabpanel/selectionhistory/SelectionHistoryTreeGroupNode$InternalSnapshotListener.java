/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISnapshotListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNodeWrapper;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

final class SelectionHistoryTreeGroupNode$InternalSnapshotListener
implements ISnapshotListener {
    final /* synthetic */ SelectionHistoryTreeGroupNode this$0;

    private SelectionHistoryTreeGroupNode$InternalSnapshotListener(SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode) {
        this.this$0 = selectionHistoryTreeGroupNode;
    }

    @Override
    public void addedNode(ZyGraphNode zyGraphNode) {
        SelectionHistoryTreeNode selectionHistoryTreeNode = new SelectionHistoryTreeNode(zyGraphNode);
        this.this$0.add(selectionHistoryTreeNode);
        this.this$0.setUserObject(new SelectionHistoryTreeNodeWrapper(SelectionHistoryTreeGroupNode.access$100(this.this$0), SelectionHistoryTreeGroupNode.access$200(this.this$0)));
    }

    @Override
    public void finished() {
        ((DefaultTreeModel)this.this$0.getTree().getModel()).nodeStructureChanged(this.this$0);
        this.this$0.getTree().updateUI();
    }

    @Override
    public void removedNode(ZyGraphNode zyGraphNode) {
        int n2 = 0;
        while (n2 < this.this$0.getChildCount()) {
            SelectionHistoryTreeNode selectionHistoryTreeNode = (SelectionHistoryTreeNode)this.this$0.getChildAt(n2);
            if (selectionHistoryTreeNode.getNode() == zyGraphNode) {
                ((DefaultTreeModel)this.this$0.getTree().getModel()).removeNodeFromParent(selectionHistoryTreeNode);
                selectionHistoryTreeNode.removeFromParent();
                this.this$0.setUserObject(new SelectionHistoryTreeNodeWrapper(SelectionHistoryTreeGroupNode.access$100(this.this$0), SelectionHistoryTreeGroupNode.access$200(this.this$0)));
                return;
            }
            ++n2;
        }
    }

    /* synthetic */ SelectionHistoryTreeGroupNode$InternalSnapshotListener(SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode, SelectionHistoryTreeGroupNode$1 selectionHistoryTreeGroupNode$1) {
        this(selectionHistoryTreeGroupNode);
    }
}

