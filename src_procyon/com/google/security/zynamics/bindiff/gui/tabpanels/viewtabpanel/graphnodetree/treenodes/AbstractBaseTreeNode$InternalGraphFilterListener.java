package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.graph.filter.*;

class AbstractBaseTreeNode$InternalGraphFilterListener implements IGraphNodeMultiFilterListener
{
    final /* synthetic */ AbstractBaseTreeNode this$0;
    
    private AbstractBaseTreeNode$InternalGraphFilterListener(final AbstractBaseTreeNode this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void filterChanged(final GraphNodeMultiFilter graphNodeMultiFilter) {
        this.this$0.updateTreeNodes(false);
    }
}
