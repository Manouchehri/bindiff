/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.swing.tree.TreePath;

class SelectionHistoryTreePanel$InternalTreeMouseListener
extends MouseAdapter {
    final /* synthetic */ SelectionHistoryTreePanel this$0;

    private SelectionHistoryTreePanel$InternalTreeMouseListener(SelectionHistoryTreePanel selectionHistoryTreePanel) {
        this.this$0 = selectionHistoryTreePanel;
    }

    private TreePath getTreePath(MouseEvent mouseEvent) {
        return SelectionHistoryTreePanel.access$800(this.this$0).getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        TreePath treePath = this.getTreePath(mouseEvent);
        if (treePath == null) {
            return;
        }
        Object object = treePath.getLastPathComponent();
        if (mouseEvent.getButton() != 1) return;
        SelectionHistoryTreePanel.access$500(this.this$0).getPrimaryGraph().getSelectionHistory().setEnabled(false);
        SelectionHistoryTreePanel.access$500(this.this$0).getSecondaryGraph().getSelectionHistory().setEnabled(false);
        SelectionHistoryTreePanel.access$500(this.this$0).getCombinedGraph().getSelectionHistory().setEnabled(false);
        if (object instanceof SelectionHistoryTreeGroupNode) {
            SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode = (SelectionHistoryTreeGroupNode)object;
            if (SelectionHistoryTreePanel.access$500(this.this$0) instanceof SingleGraph) {
                List list;
                Collection collection = selectionHistoryTreeGroupNode.getSnapshot().getSingleGraphSelection();
                if (new HashSet(collection).equals(new HashSet(list = GraphNodeFilter.filterNodes((SingleGraph)SelectionHistoryTreePanel.access$500(this.this$0), GraphNodeFilter$Criterium.SELECTED)))) {
                    SelectionHistoryTreePanel.access$1100(this.this$0, collection);
                } else {
                    SelectionHistoryTreePanel.access$1200(this.this$0, collection);
                }
            } else if (SelectionHistoryTreePanel.access$500(this.this$0) instanceof CombinedGraph) {
                List list;
                Collection collection = selectionHistoryTreeGroupNode.getSnapshot().getCombinedGraphSelection();
                if (new HashSet(collection).equals(new HashSet(list = GraphNodeFilter.filterNodes((CombinedGraph)SelectionHistoryTreePanel.access$500(this.this$0), GraphNodeFilter$Criterium.SELECTED)))) {
                    SelectionHistoryTreePanel.access$1300(this.this$0, collection);
                } else {
                    SelectionHistoryTreePanel.access$1400(this.this$0, collection);
                }
            }
        } else if (object instanceof SelectionHistoryTreeNode) {
            SelectionHistoryTreeNode selectionHistoryTreeNode = (SelectionHistoryTreeNode)object;
            ZyGraphNode zyGraphNode = selectionHistoryTreeNode.getNode();
            boolean bl2 = zyGraphNode.isSelected();
            SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().removeIntermediateListener(SelectionHistoryTreePanel.access$700(this.this$0));
            if (zyGraphNode instanceof SingleDiffNode) {
                ((SingleGraph)SelectionHistoryTreePanel.access$500(this.this$0)).selectNode((SingleDiffNode)zyGraphNode, !bl2);
            } else if (zyGraphNode instanceof CombinedDiffNode) {
                ((CombinedGraph)SelectionHistoryTreePanel.access$500(this.this$0)).selectNode((CombinedDiffNode)zyGraphNode, !bl2);
            }
            SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().addIntermediateListener(SelectionHistoryTreePanel.access$700(this.this$0));
        }
        SelectionHistoryTreePanel.access$500(this.this$0).getPrimaryGraph().getSelectionHistory().setEnabled(true);
        SelectionHistoryTreePanel.access$500(this.this$0).getSecondaryGraph().getSelectionHistory().setEnabled(true);
        SelectionHistoryTreePanel.access$500(this.this$0).getCombinedGraph().getSelectionHistory().setEnabled(true);
    }

    /* synthetic */ SelectionHistoryTreePanel$InternalTreeMouseListener(SelectionHistoryTreePanel selectionHistoryTreePanel, SelectionHistoryTreePanel$1 selectionHistoryTreePanel$1) {
        this(selectionHistoryTreePanel);
    }
}

