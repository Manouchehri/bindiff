/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ITreeNodeSearcherListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$1;

class AbstractBaseTreeNode$InternalTreeNodeSearcherListener
implements ITreeNodeSearcherListener {
    final /* synthetic */ AbstractBaseTreeNode this$0;

    private AbstractBaseTreeNode$InternalTreeNodeSearcherListener(AbstractBaseTreeNode abstractBaseTreeNode) {
        this.this$0 = abstractBaseTreeNode;
    }

    @Override
    public void searchStringChanged(TreeNodeSearcher treeNodeSearcher) {
        this.this$0.updateTreeNodes(true);
    }

    /* synthetic */ AbstractBaseTreeNode$InternalTreeNodeSearcherListener(AbstractBaseTreeNode abstractBaseTreeNode, AbstractBaseTreeNode$1 abstractBaseTreeNode$1) {
        this(abstractBaseTreeNode);
    }
}

