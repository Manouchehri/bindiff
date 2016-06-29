package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import javax.swing.tree.*;

class SelectionHistoryTreePanel$InternalSelectionHistoryListener implements ISelectionHistoryListener
{
    final /* synthetic */ SelectionHistoryTreePanel this$0;
    
    private SelectionHistoryTreePanel$InternalSelectionHistoryListener(final SelectionHistoryTreePanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void finishedRedo() {
        this.this$0.graph.getIntermediateListeners().addIntermediateListener(this.this$0.graphSelectionListener);
        this.this$0.tree.updateUI();
    }
    
    @Override
    public void finishedUndo() {
        this.this$0.graph.getIntermediateListeners().addIntermediateListener(this.this$0.graphSelectionListener);
        this.this$0.tree.updateUI();
    }
    
    @Override
    public void snapshotAdded(final SelectionSnapshot selectionSnapshot) {
        this.this$0.insertSnapshot(selectionSnapshot);
    }
    
    @Override
    public void snapshotRemoved() {
        final SelectionHistoryRootNode selectionHistoryRootNode = (SelectionHistoryRootNode)this.this$0.model.getRoot();
        final SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode = (SelectionHistoryTreeGroupNode)this.this$0.model.getChild(selectionHistoryRootNode, selectionHistoryRootNode.getChildCount() - 1);
        selectionHistoryTreeGroupNode.dispose();
        this.this$0.model.removeNodeFromParent(selectionHistoryTreeGroupNode);
    }
    
    @Override
    public void startedRedo() {
        this.this$0.graph.getIntermediateListeners().removeIntermediateListener(this.this$0.graphSelectionListener);
    }
    
    @Override
    public void startedUndo() {
        this.this$0.graph.getIntermediateListeners().removeIntermediateListener(this.this$0.graphSelectionListener);
    }
}
