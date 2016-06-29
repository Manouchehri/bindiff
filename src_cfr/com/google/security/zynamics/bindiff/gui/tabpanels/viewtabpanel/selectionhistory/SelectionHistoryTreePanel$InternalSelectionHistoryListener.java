/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISelectionHistoryListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import javax.swing.tree.MutableTreeNode;

class SelectionHistoryTreePanel$InternalSelectionHistoryListener
implements ISelectionHistoryListener {
    final /* synthetic */ SelectionHistoryTreePanel this$0;

    private SelectionHistoryTreePanel$InternalSelectionHistoryListener(SelectionHistoryTreePanel selectionHistoryTreePanel) {
        this.this$0 = selectionHistoryTreePanel;
    }

    @Override
    public void finishedRedo() {
        SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().addIntermediateListener(SelectionHistoryTreePanel.access$700(this.this$0));
        SelectionHistoryTreePanel.access$800(this.this$0).updateUI();
    }

    @Override
    public void finishedUndo() {
        SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().addIntermediateListener(SelectionHistoryTreePanel.access$700(this.this$0));
        SelectionHistoryTreePanel.access$800(this.this$0).updateUI();
    }

    @Override
    public void snapshotAdded(SelectionSnapshot selectionSnapshot) {
        SelectionHistoryTreePanel.access$900(this.this$0, selectionSnapshot);
    }

    @Override
    public void snapshotRemoved() {
        SelectionHistoryRootNode selectionHistoryRootNode = (SelectionHistoryRootNode)SelectionHistoryTreePanel.access$1000(this.this$0).getRoot();
        int n2 = selectionHistoryRootNode.getChildCount();
        SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode = (SelectionHistoryTreeGroupNode)SelectionHistoryTreePanel.access$1000(this.this$0).getChild(selectionHistoryRootNode, n2 - 1);
        selectionHistoryTreeGroupNode.dispose();
        SelectionHistoryTreePanel.access$1000(this.this$0).removeNodeFromParent(selectionHistoryTreeGroupNode);
    }

    @Override
    public void startedRedo() {
        SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().removeIntermediateListener(SelectionHistoryTreePanel.access$700(this.this$0));
    }

    @Override
    public void startedUndo() {
        SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().removeIntermediateListener(SelectionHistoryTreePanel.access$700(this.this$0));
    }

    /* synthetic */ SelectionHistoryTreePanel$InternalSelectionHistoryListener(SelectionHistoryTreePanel selectionHistoryTreePanel, SelectionHistoryTreePanel$1 selectionHistoryTreePanel$1) {
        this(selectionHistoryTreePanel);
    }
}

