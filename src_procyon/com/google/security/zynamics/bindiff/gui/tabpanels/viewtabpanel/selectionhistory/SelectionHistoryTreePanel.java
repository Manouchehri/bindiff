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

public class SelectionHistoryTreePanel extends JPanel
{
    private SelectionHistoryTree tree;
    private DefaultTreeModel model;
    private final SelectionHistoryTreePanel$InternalGraphSelectionListener graphSelectionListener;
    private final SelectionHistoryTreePanel$InternalGraphVisibilityListener graphVisibilityListener;
    private final SelectionHistoryTreePanel$InternalSelectionHistoryListener selectionHistoryListener;
    private final SelectionHistoryTreePanel$InternalTreeSelectionListener treeSelectionListener;
    private final SelectionHistoryTreePanel$InternalTreeMouseListener treeMouseListener;
    private int childCount;
    private BinDiffGraph graph;
    private final SelectionHistory selectionHistory;
    
    public SelectionHistoryTreePanel(final ViewTabPanelFunctions viewTabPanelFunctions, final BinDiffGraph binDiffGraph, final SelectionHistory selectionHistory) {
        super(new BorderLayout());
        this.graphSelectionListener = new SelectionHistoryTreePanel$InternalGraphSelectionListener(this, null);
        this.graphVisibilityListener = new SelectionHistoryTreePanel$InternalGraphVisibilityListener(this, null);
        this.selectionHistoryListener = new SelectionHistoryTreePanel$InternalSelectionHistoryListener(this, null);
        this.treeSelectionListener = new SelectionHistoryTreePanel$InternalTreeSelectionListener(this, null);
        this.treeMouseListener = new SelectionHistoryTreePanel$InternalTreeMouseListener(this, null);
        this.childCount = 0;
        Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.selectionHistory = (SelectionHistory)Preconditions.checkNotNull(selectionHistory);
        this.tree = this.createTree(viewTabPanelFunctions);
        this.createPanel();
        this.selectionHistory.addHistoryListener(this.selectionHistoryListener);
        binDiffGraph.getIntermediateListeners().addIntermediateListener(this.graphSelectionListener);
        binDiffGraph.getIntermediateListeners().addIntermediateListener(this.graphVisibilityListener);
        this.tree.addTreeSelectionListener(this.treeSelectionListener);
        this.tree.addMouseListener(this.treeMouseListener);
        ToolTipManager.sharedInstance().registerComponent(this.tree);
    }
    
    private void createPanel() {
        this.tree.setRootVisible(true);
        this.tree.setSelectionModel(null);
        this.add(new JScrollPane(this.tree), "Center");
    }
    
    private SelectionHistoryTree createTree(final ViewTabPanelFunctions viewTabPanelFunctions) {
        final SelectionHistoryRootNode selectionHistoryRootNode = new SelectionHistoryRootNode(viewTabPanelFunctions, this.graph, "Selection History");
        final SelectionHistoryTree tree = new SelectionHistoryTree(selectionHistoryRootNode);
        selectionHistoryRootNode.setTree(tree);
        (this.model = new DefaultTreeModel(selectionHistoryRootNode)).nodeStructureChanged(selectionHistoryRootNode);
        tree.setRootVisible(true);
        tree.getSelectionModel().setSelectionMode(1);
        return tree;
    }
    
    private void insertSnapshot(final SelectionSnapshot selectionSnapshot) {
        final SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode = new SelectionHistoryTreeGroupNode(selectionSnapshot, this.childCount);
        final Iterator<ZyGraphNode> iterator = selectionSnapshot.getSelection().iterator();
        while (iterator.hasNext()) {
            selectionHistoryTreeGroupNode.add(new SelectionHistoryTreeNode(iterator.next()));
        }
        ++this.childCount;
        this.model.insertNodeInto(selectionHistoryTreeGroupNode, (MutableTreeNode)this.model.getRoot(), 0);
    }
    
    private void selectCombinedNodes(final Collection collection) {
        this.graph.getIntermediateListeners().removeIntermediateListener(this.graphSelectionListener);
        if (this.graph instanceof CombinedGraph) {
            ((CombinedGraph)this.graph).selectNodes(GraphNodeFilter.filterNodes(this.graph, GraphNodeFilter$Criterium.SELECTED), false);
            ((CombinedGraph)this.graph).selectNodes(collection, true);
        }
        this.graph.getIntermediateListeners().addIntermediateListener(this.graphSelectionListener);
    }
    
    private void selectSingleNodes(final Collection collection) {
        this.graph.getIntermediateListeners().removeIntermediateListener(this.graphSelectionListener);
        if (this.graph instanceof SingleGraph) {
            ((SingleGraph)this.graph).selectNodes(GraphNodeFilter.filterNodes(this.graph, GraphNodeFilter$Criterium.SELECTED), false);
            ((SingleGraph)this.graph).selectNodes(collection, true);
        }
        this.graph.getIntermediateListeners().addIntermediateListener(this.graphSelectionListener);
    }
    
    private void unselectCombinedNodes(final Collection collection) {
        this.graph.getIntermediateListeners().removeIntermediateListener(this.graphSelectionListener);
        if (this.graph instanceof CombinedGraph) {
            ((CombinedGraph)this.graph).selectNodes(collection, false);
        }
        this.graph.getIntermediateListeners().addIntermediateListener(this.graphSelectionListener);
    }
    
    private void unselectSingleNodes(final Collection collection) {
        this.graph.getIntermediateListeners().removeIntermediateListener(this.graphSelectionListener);
        if (this.graph instanceof SingleGraph) {
            ((SingleGraph)this.graph).selectNodes(collection, false);
        }
        this.graph.getIntermediateListeners().addIntermediateListener(this.graphSelectionListener);
    }
    
    public void dispose() {
        this.selectionHistory.removeHistoryListener(this.selectionHistoryListener);
        this.graph.getIntermediateListeners().removeIntermediateListener(this.graphSelectionListener);
        this.graph.getIntermediateListeners().removeIntermediateListener(this.graphVisibilityListener);
        this.tree.removeMouseListener(this.treeMouseListener);
        this.tree.removeTreeSelectionListener(this.treeSelectionListener);
        this.tree.setSelectionModel(new DefaultTreeSelectionModel());
        this.tree.setCellRenderer(null);
        this.tree.dispose();
        this.tree = null;
        this.graph = null;
    }
    
    public int getChildCount() {
        return this.childCount;
    }
}
