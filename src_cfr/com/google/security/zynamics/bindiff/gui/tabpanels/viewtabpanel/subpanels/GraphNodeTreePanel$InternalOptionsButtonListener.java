/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EMatchStateFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESelectionFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESideFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$1;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.tree.DefaultTreeModel;

class GraphNodeTreePanel$InternalOptionsButtonListener
implements ActionListener {
    final /* synthetic */ GraphNodeTreePanel this$0;

    private GraphNodeTreePanel$InternalOptionsButtonListener(GraphNodeTreePanel graphNodeTreePanel) {
        this.this$0 = graphNodeTreePanel;
    }

    private void setFilter(boolean bl2) {
        GraphNodeMultiFilter graphNodeMultiFilter = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getFilter();
        graphNodeMultiFilter.setFilter(GraphNodeTreePanel.access$400(this.this$0).getStartAddress(), GraphNodeTreePanel.access$400(this.this$0).getEndAddress(), GraphNodeTreePanel.access$400(this.this$0).getMatchStateFilter(), GraphNodeTreePanel.access$400(this.this$0).getSelectionFilter(), GraphNodeTreePanel.access$400(this.this$0).getVisibilityFilter(), GraphNodeTreePanel.access$400(this.this$0).getSideFilter(), false);
        if (!bl2) return;
        graphNodeMultiFilter.notifyListeners();
    }

    private void setSearcher(boolean bl2) {
        TreeNodeSearcher treeNodeSearcher = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getSearcher();
        boolean bl3 = GraphNodeTreePanel.access$400(this.this$0).getRegEx();
        boolean bl4 = GraphNodeTreePanel.access$400(this.this$0).getCaseSensitive();
        boolean bl5 = GraphNodeTreePanel.access$400(this.this$0).getPrimarySide();
        boolean bl6 = GraphNodeTreePanel.access$400(this.this$0).getSecondarySide();
        boolean bl7 = GraphNodeTreePanel.access$400(this.this$0).getHighlightGraphNodes();
        boolean bl8 = GraphNodeTreePanel.access$400(this.this$0).getUseTemporaryResult();
        treeNodeSearcher.setSearchSettings(bl3, bl4, bl5, bl6, bl8, bl7);
        if (!bl2) return;
        treeNodeSearcher.notifyListeners();
    }

    private void setSorter(boolean bl2) {
        TreeNodeMultiSorter treeNodeMultiSorter = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getSorter();
        int n2 = 0;
        do {
            if (n2 >= 5) {
                if (!bl2) return;
                treeNodeMultiSorter.notifyListeners();
                return;
            }
            ESortByCriterium eSortByCriterium = GraphNodeTreePanel.access$400(this.this$0).getSortByCriterium(n2);
            ESortOrder eSortOrder = GraphNodeTreePanel.access$400(this.this$0).getSortOrder(n2);
            treeNodeMultiSorter.setCriterium(eSortByCriterium, eSortOrder, n2, false);
            ++n2;
        } while (true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!actionEvent.getSource().equals(GraphNodeTreePanel.access$800(this.this$0))) return;
        GraphNodeTreePanel.access$400(this.this$0).setVisible(true);
        if (!GraphNodeTreePanel.access$400(this.this$0).getOkPressed()) return;
        this.setSearcher(false);
        this.setFilter(false);
        this.setSorter(true);
        this.this$0.updateClearTreeSearchIcons();
    }

    /* synthetic */ GraphNodeTreePanel$InternalOptionsButtonListener(GraphNodeTreePanel graphNodeTreePanel, GraphNodeTreePanel$1 graphNodeTreePanel$1) {
        this(graphNodeTreePanel);
    }
}

