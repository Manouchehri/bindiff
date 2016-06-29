package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import javax.swing.event.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import javax.swing.tree.*;

class SelectionHistoryTreePanel$InternalTreeSelectionListener implements TreeSelectionListener
{
    final /* synthetic */ SelectionHistoryTreePanel this$0;
    
    private SelectionHistoryTreePanel$InternalTreeSelectionListener(final SelectionHistoryTreePanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void valueChanged(final TreeSelectionEvent treeSelectionEvent) {
        final SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode = (SelectionHistoryTreeGroupNode)this.this$0.tree.getLastSelectedPathComponent();
        if (selectionHistoryTreeGroupNode == null || selectionHistoryTreeGroupNode.getParent() != this.this$0.model.getRoot()) {
            return;
        }
        final SelectionSnapshot snapshot = this.this$0.selectionHistory.getSnapshot(this.this$0.selectionHistory.getNumberOfSnapshots() - this.this$0.model.getIndexOfChild(this.this$0.model.getRoot(), selectionHistoryTreeGroupNode) - 1);
        if (this.this$0.graph instanceof SingleGraph) {
            this.this$0.selectSingleNodes(snapshot.getSingleGraphSelection());
        }
        else if (this.this$0.graph instanceof CombinedGraph) {
            this.this$0.selectCombinedNodes(snapshot.getCombinedGraphSelection());
        }
        this.this$0.tree.updateUI();
    }
}
