/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.components.treesearchfield.ITreeSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$1;
import javax.swing.tree.DefaultTreeModel;

class GraphNodeTreePanel$InternalSearchFieldListener
implements ITreeSearchFieldListener {
    final /* synthetic */ GraphNodeTreePanel this$0;

    private GraphNodeTreePanel$InternalSearchFieldListener(GraphNodeTreePanel graphNodeTreePanel) {
        this.this$0 = graphNodeTreePanel;
    }

    @Override
    public void searchChanged(String string) {
        TreeNodeSearcher treeNodeSearcher = ((AbstractRootTreeNode)GraphNodeTreePanel.access$300(this.this$0).getModel().getRoot()).getSearcher();
        treeNodeSearcher.setSearchString(string);
        this.this$0.updateClearTreeSearchIcons();
    }

    /* synthetic */ GraphNodeTreePanel$InternalSearchFieldListener(GraphNodeTreePanel graphNodeTreePanel, GraphNodeTreePanel$1 graphNodeTreePanel$1) {
        this(graphNodeTreePanel);
    }
}

