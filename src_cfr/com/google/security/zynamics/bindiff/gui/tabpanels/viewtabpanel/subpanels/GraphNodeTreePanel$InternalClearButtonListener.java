/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.tree.DefaultTreeModel;

class GraphNodeTreePanel$InternalClearButtonListener
implements ActionListener {
    final /* synthetic */ GraphNodeTreePanel this$0;

    private GraphNodeTreePanel$InternalClearButtonListener(GraphNodeTreePanel graphNodeTreePanel) {
        this.this$0 = graphNodeTreePanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GraphNodeMultiFilter graphNodeMultiFilter = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getFilter();
        graphNodeMultiFilter.clearSettings(false);
        GraphNodeTreePanel.access$400(this.this$0).setDefaults(1);
        TreeNodeSearcher treeNodeSearcher = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getSearcher();
        treeNodeSearcher.setSearchString("");
        GraphNodeTreePanel.access$500(this.this$0).clear();
        GraphNodeTreePanel.access$700(this.this$0).setIcon(GraphNodeTreePanel.access$600());
    }

    /* synthetic */ GraphNodeTreePanel$InternalClearButtonListener(GraphNodeTreePanel graphNodeTreePanel, GraphNodeTreePanel$1 graphNodeTreePanel$1) {
        this(graphNodeTreePanel);
    }
}

