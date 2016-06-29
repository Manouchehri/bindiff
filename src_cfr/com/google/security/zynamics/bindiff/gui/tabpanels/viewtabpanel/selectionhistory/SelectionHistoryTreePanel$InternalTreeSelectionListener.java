/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import java.util.Collection;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;

class SelectionHistoryTreePanel$InternalTreeSelectionListener
implements TreeSelectionListener {
    final /* synthetic */ SelectionHistoryTreePanel this$0;

    private SelectionHistoryTreePanel$InternalTreeSelectionListener(SelectionHistoryTreePanel selectionHistoryTreePanel) {
        this.this$0 = selectionHistoryTreePanel;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode = (SelectionHistoryTreeGroupNode)SelectionHistoryTreePanel.access$800(this.this$0).getLastSelectedPathComponent();
        if (selectionHistoryTreeGroupNode == null) return;
        if (selectionHistoryTreeGroupNode.getParent() != SelectionHistoryTreePanel.access$1000(this.this$0).getRoot()) {
            return;
        }
        int n2 = SelectionHistoryTreePanel.access$600(this.this$0).getNumberOfSnapshots() - SelectionHistoryTreePanel.access$1000(this.this$0).getIndexOfChild(SelectionHistoryTreePanel.access$1000(this.this$0).getRoot(), selectionHistoryTreeGroupNode) - 1;
        SelectionSnapshot selectionSnapshot = SelectionHistoryTreePanel.access$600(this.this$0).getSnapshot(n2);
        if (SelectionHistoryTreePanel.access$500(this.this$0) instanceof SingleGraph) {
            SelectionHistoryTreePanel.access$1200(this.this$0, selectionSnapshot.getSingleGraphSelection());
        } else if (SelectionHistoryTreePanel.access$500(this.this$0) instanceof CombinedGraph) {
            SelectionHistoryTreePanel.access$1400(this.this$0, selectionSnapshot.getCombinedGraphSelection());
        }
        SelectionHistoryTreePanel.access$800(this.this$0).updateUI();
    }

    /* synthetic */ SelectionHistoryTreePanel$InternalTreeSelectionListener(SelectionHistoryTreePanel selectionHistoryTreePanel, SelectionHistoryTreePanel$1 selectionHistoryTreePanel$1) {
        this(selectionHistoryTreePanel);
    }
}

