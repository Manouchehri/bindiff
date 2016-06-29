package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import javax.swing.tree.*;
import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.utils.*;

final class SelectionHistoryTreeGroupNode$InternalSnapshotListener implements ISnapshotListener
{
    final /* synthetic */ SelectionHistoryTreeGroupNode this$0;
    
    private SelectionHistoryTreeGroupNode$InternalSnapshotListener(final SelectionHistoryTreeGroupNode this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void addedNode(final ZyGraphNode zyGraphNode) {
        this.this$0.add(new SelectionHistoryTreeNode(zyGraphNode));
        this.this$0.setUserObject(new SelectionHistoryTreeNodeWrapper(this.this$0.snapshot, this.this$0.snapshotCount));
    }
    
    @Override
    public void finished() {
        ((DefaultTreeModel)this.this$0.getTree().getModel()).nodeStructureChanged(this.this$0);
        this.this$0.getTree().updateUI();
    }
    
    @Override
    public void removedNode(final ZyGraphNode zyGraphNode) {
        for (int i = 0; i < this.this$0.getChildCount(); ++i) {
            final SelectionHistoryTreeNode selectionHistoryTreeNode = (SelectionHistoryTreeNode)this.this$0.getChildAt(i);
            if (selectionHistoryTreeNode.getNode() == zyGraphNode) {
                ((DefaultTreeModel)this.this$0.getTree().getModel()).removeNodeFromParent(selectionHistoryTreeNode);
                selectionHistoryTreeNode.removeFromParent();
                this.this$0.setUserObject(new SelectionHistoryTreeNodeWrapper(this.this$0.snapshot, this.this$0.snapshotCount));
                break;
            }
        }
    }
}
