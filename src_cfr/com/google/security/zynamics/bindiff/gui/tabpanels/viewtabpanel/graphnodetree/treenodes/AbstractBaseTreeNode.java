/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.filter.IGraphNodeMultiFilterListener;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ITreeNodeSearcherListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ITreeNodeSorterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$InternalGraphFilterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$InternalGraphVisibilityListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$InternalTreeNodeSearcherListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$InternalTreeNodeSorterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;

public abstract class AbstractBaseTreeNode
extends AbstractTreeNode {
    private AbstractBaseTreeNode$InternalTreeNodeSearcherListener searchListener;
    private AbstractBaseTreeNode$InternalGraphFilterListener filterListener;
    private AbstractBaseTreeNode$InternalTreeNodeSorterListener sorterListener;
    private AbstractBaseTreeNode$InternalGraphVisibilityListener visibilityListener;

    public AbstractBaseTreeNode(AbstractRootTreeNode abstractRootTreeNode) {
        super(abstractRootTreeNode);
        this.searchListener = new AbstractBaseTreeNode$InternalTreeNodeSearcherListener(this, null);
        this.filterListener = new AbstractBaseTreeNode$InternalGraphFilterListener(this, null);
        this.sorterListener = new AbstractBaseTreeNode$InternalTreeNodeSorterListener(this, null);
        this.visibilityListener = new AbstractBaseTreeNode$InternalGraphVisibilityListener(this, null);
        this.getSearcher().addListener(this.searchListener);
        this.getFilter().addListener(this.filterListener);
        this.getSorter().addListener(this.sorterListener);
        this.getGraph().getCombinedGraph().getIntermediateListeners().addIntermediateListener(this.visibilityListener);
    }

    @Override
    protected void delete() {
        this.getSearcher().removeListener(this.searchListener);
        this.getFilter().removeListener(this.filterListener);
        this.getSorter().removeListener(this.sorterListener);
        this.getGraph().getCombinedGraph().getIntermediateListeners().removeIntermediateListener(this.visibilityListener);
        this.filterListener = null;
        this.searchListener = null;
        this.sorterListener = null;
        this.visibilityListener = null;
        super.delete();
    }

    protected abstract void updateTreeNodes(boolean var1);
}

