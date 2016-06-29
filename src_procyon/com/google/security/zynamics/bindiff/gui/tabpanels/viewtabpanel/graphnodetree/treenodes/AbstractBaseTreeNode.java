package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;

public abstract class AbstractBaseTreeNode extends AbstractTreeNode
{
    private AbstractBaseTreeNode$InternalTreeNodeSearcherListener searchListener;
    private AbstractBaseTreeNode$InternalGraphFilterListener filterListener;
    private AbstractBaseTreeNode$InternalTreeNodeSorterListener sorterListener;
    private AbstractBaseTreeNode$InternalGraphVisibilityListener visibilityListener;
    
    public AbstractBaseTreeNode(final AbstractRootTreeNode abstractRootTreeNode) {
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
    
    protected abstract void updateTreeNodes(final boolean p0);
}
