/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ITreeNodeSorterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$1;

class AbstractBaseTreeNode$InternalTreeNodeSorterListener
implements ITreeNodeSorterListener {
    final /* synthetic */ AbstractBaseTreeNode this$0;

    private AbstractBaseTreeNode$InternalTreeNodeSorterListener(AbstractBaseTreeNode abstractBaseTreeNode) {
        this.this$0 = abstractBaseTreeNode;
    }

    @Override
    public void sortingChanged(TreeNodeMultiSorter treeNodeMultiSorter) {
        this.this$0.updateTreeNodes(false);
    }

    /* synthetic */ AbstractBaseTreeNode$InternalTreeNodeSorterListener(AbstractBaseTreeNode abstractBaseTreeNode, AbstractBaseTreeNode$1 abstractBaseTreeNode$1) {
        this(abstractBaseTreeNode);
    }
}

