/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISelectionHistoryListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$InternalGraphSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$InternalGraphVisibilityListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$InternalSelectionHistoryListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$InternalTreeMouseListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$InternalTreeSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ToolTipManager;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

public class SelectionHistoryTreePanel
extends JPanel {
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

    public SelectionHistoryTreePanel(ViewTabPanelFunctions viewTabPanelFunctions, BinDiffGraph binDiffGraph, SelectionHistory selectionHistory) {
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
        this.add((Component)new JScrollPane(this.tree), "Center");
    }

    private SelectionHistoryTree createTree(ViewTabPanelFunctions viewTabPanelFunctions) {
        SelectionHistoryRootNode selectionHistoryRootNode = new SelectionHistoryRootNode(viewTabPanelFunctions, this.graph, "Selection History");
        SelectionHistoryTree selectionHistoryTree = new SelectionHistoryTree(selectionHistoryRootNode);
        selectionHistoryRootNode.setTree(selectionHistoryTree);
        this.model = new DefaultTreeModel(selectionHistoryRootNode);
        this.model.nodeStructureChanged(selectionHistoryRootNode);
        selectionHistoryTree.setRootVisible(true);
        selectionHistoryTree.getSelectionModel().setSelectionMode(1);
        return selectionHistoryTree;
    }

    private void insertSnapshot(SelectionSnapshot selectionSnapshot) {
        SelectionHistoryTreeGroupNode selectionHistoryTreeGroupNode = new SelectionHistoryTreeGroupNode(selectionSnapshot, this.childCount);
        Iterator iterator = selectionSnapshot.getSelection().iterator();
        do {
            if (!iterator.hasNext()) {
                ++this.childCount;
                this.model.insertNodeInto(selectionHistoryTreeGroupNode, (SelectionHistoryRootNode)this.model.getRoot(), 0);
                return;
            }
            ZyGraphNode zyGraphNode = (ZyGraphNode)iterator.next();
            SelectionHistoryTreeNode selectionHistoryTreeNode = new SelectionHistoryTreeNode(zyGraphNode);
            selectionHistoryTreeGroupNode.add(selectionHistoryTreeNode);
        } while (true);
    }

    private void selectCombinedNodes(Collection collection) {
        this.graph.getIntermediateListeners().removeIntermediateListener(this.graphSelectionListener);
        if (this.graph instanceof CombinedGraph) {
            List list = GraphNodeFilter.filterNodes((CombinedGraph)this.graph, GraphNodeFilter$Criterium.SELECTED);
            ((CombinedGraph)this.graph).selectNodes((Collection)list, false);
            ((CombinedGraph)this.graph).selectNodes(collection, true);
        }
        this.graph.getIntermediateListeners().addIntermediateListener(this.graphSelectionListener);
    }

    private void selectSingleNodes(Collection collection) {
        this.graph.getIntermediateListeners().removeIntermediateListener(this.graphSelectionListener);
        if (this.graph instanceof SingleGraph) {
            List list = GraphNodeFilter.filterNodes((SingleGraph)this.graph, GraphNodeFilter$Criterium.SELECTED);
            ((SingleGraph)this.graph).selectNodes((Collection)list, false);
            ((SingleGraph)this.graph).selectNodes(collection, true);
        }
        this.graph.getIntermediateListeners().addIntermediateListener(this.graphSelectionListener);
    }

    private void unselectCombinedNodes(Collection collection) {
        this.graph.getIntermediateListeners().removeIntermediateListener(this.graphSelectionListener);
        if (this.graph instanceof CombinedGraph) {
            ((CombinedGraph)this.graph).selectNodes(collection, false);
        }
        this.graph.getIntermediateListeners().addIntermediateListener(this.graphSelectionListener);
    }

    private void unselectSingleNodes(Collection collection) {
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

    static /* synthetic */ BinDiffGraph access$500(SelectionHistoryTreePanel selectionHistoryTreePanel) {
        return selectionHistoryTreePanel.graph;
    }

    static /* synthetic */ SelectionHistory access$600(SelectionHistoryTreePanel selectionHistoryTreePanel) {
        return selectionHistoryTreePanel.selectionHistory;
    }

    static /* synthetic */ SelectionHistoryTreePanel$InternalGraphSelectionListener access$700(SelectionHistoryTreePanel selectionHistoryTreePanel) {
        return selectionHistoryTreePanel.graphSelectionListener;
    }

    static /* synthetic */ SelectionHistoryTree access$800(SelectionHistoryTreePanel selectionHistoryTreePanel) {
        return selectionHistoryTreePanel.tree;
    }

    static /* synthetic */ void access$900(SelectionHistoryTreePanel selectionHistoryTreePanel, SelectionSnapshot selectionSnapshot) {
        selectionHistoryTreePanel.insertSnapshot(selectionSnapshot);
    }

    static /* synthetic */ DefaultTreeModel access$1000(SelectionHistoryTreePanel selectionHistoryTreePanel) {
        return selectionHistoryTreePanel.model;
    }

    static /* synthetic */ void access$1100(SelectionHistoryTreePanel selectionHistoryTreePanel, Collection collection) {
        selectionHistoryTreePanel.unselectSingleNodes(collection);
    }

    static /* synthetic */ void access$1200(SelectionHistoryTreePanel selectionHistoryTreePanel, Collection collection) {
        selectionHistoryTreePanel.selectSingleNodes(collection);
    }

    static /* synthetic */ void access$1300(SelectionHistoryTreePanel selectionHistoryTreePanel, Collection collection) {
        selectionHistoryTreePanel.unselectCombinedNodes(collection);
    }

    static /* synthetic */ void access$1400(SelectionHistoryTreePanel selectionHistoryTreePanel, Collection collection) {
        selectionHistoryTreePanel.selectCombinedNodes(collection);
    }
}

