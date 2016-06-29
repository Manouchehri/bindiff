package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.tree.*;

class SelectionHistoryTreePanel$InternalTreeMouseListener extends MouseAdapter
{
    final /* synthetic */ SelectionHistoryTreePanel this$0;
    
    private SelectionHistoryTreePanel$InternalTreeMouseListener(final SelectionHistoryTreePanel this$0) {
        this.this$0 = this$0;
    }
    
    private TreePath getTreePath(final MouseEvent mouseEvent) {
        return this.this$0.tree.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        final TreePath treePath = this.getTreePath(mouseEvent);
        if (treePath == null) {
            return;
        }
        final Object lastPathComponent = treePath.getLastPathComponent();
        if (mouseEvent.getButton() == 1) {
            this.this$0.graph.getPrimaryGraph().getSelectionHistory().setEnabled(false);
            this.this$0.graph.getSecondaryGraph().getSelectionHistory().setEnabled(false);
            this.this$0.graph.getCombinedGraph().getSelectionHistory().setEnabled(false);
            if (lastPathComponent instanceof SelectionHistoryTreeGroupNode) {
                final SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode = (SelectionHistoryTreeGroupNode)lastPathComponent;
                if (this.this$0.graph instanceof SingleGraph) {
                    final Collection singleGraphSelection = selectionHistoryTreeGroupNode.getSnapshot().getSingleGraphSelection();
                    if (new HashSet(singleGraphSelection).equals(new HashSet(GraphNodeFilter.filterNodes(this.this$0.graph, GraphNodeFilter$Criterium.SELECTED)))) {
                        this.this$0.unselectSingleNodes(singleGraphSelection);
                    }
                    else {
                        this.this$0.selectSingleNodes(singleGraphSelection);
                    }
                }
                else if (this.this$0.graph instanceof CombinedGraph) {
                    final Collection combinedGraphSelection = selectionHistoryTreeGroupNode.getSnapshot().getCombinedGraphSelection();
                    if (new HashSet(combinedGraphSelection).equals(new HashSet(GraphNodeFilter.filterNodes(this.this$0.graph, GraphNodeFilter$Criterium.SELECTED)))) {
                        this.this$0.unselectCombinedNodes(combinedGraphSelection);
                    }
                    else {
                        this.this$0.selectCombinedNodes(combinedGraphSelection);
                    }
                }
            }
            else if (lastPathComponent instanceof SelectionHistoryTreeNode) {
                final ZyGraphNode node = ((SelectionHistoryTreeNode)lastPathComponent).getNode();
                final boolean selected = node.isSelected();
                this.this$0.graph.getIntermediateListeners().removeIntermediateListener(this.this$0.graphSelectionListener);
                if (node instanceof SingleDiffNode) {
                    ((SingleGraph)this.this$0.graph).selectNode(node, !selected);
                }
                else if (node instanceof CombinedDiffNode) {
                    ((CombinedGraph)this.this$0.graph).selectNode(node, !selected);
                }
                this.this$0.graph.getIntermediateListeners().addIntermediateListener(this.this$0.graphSelectionListener);
            }
            this.this$0.graph.getPrimaryGraph().getSelectionHistory().setEnabled(true);
            this.this$0.graph.getSecondaryGraph().getSelectionHistory().setEnabled(true);
            this.this$0.graph.getCombinedGraph().getSelectionHistory().setEnabled(true);
        }
    }
}
