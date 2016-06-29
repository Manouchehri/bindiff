/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.filter.IGraphNodeMultiFilterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$1;

class AbstractBaseTreeNode$InternalGraphFilterListener
implements IGraphNodeMultiFilterListener {
    final /* synthetic */ AbstractBaseTreeNode this$0;

    private AbstractBaseTreeNode$InternalGraphFilterListener(AbstractBaseTreeNode abstractBaseTreeNode) {
        this.this$0 = abstractBaseTreeNode;
    }

    @Override
    public void filterChanged(GraphNodeMultiFilter graphNodeMultiFilter) {
        this.this$0.updateTreeNodes(false);
    }

    /* synthetic */ AbstractBaseTreeNode$InternalGraphFilterListener(AbstractBaseTreeNode abstractBaseTreeNode, AbstractBaseTreeNode$1 abstractBaseTreeNode$1) {
        this(abstractBaseTreeNode);
    }
}

