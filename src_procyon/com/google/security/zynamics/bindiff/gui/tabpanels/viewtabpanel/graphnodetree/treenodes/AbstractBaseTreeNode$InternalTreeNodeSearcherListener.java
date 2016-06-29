package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;

class AbstractBaseTreeNode$InternalTreeNodeSearcherListener implements ITreeNodeSearcherListener
{
    final /* synthetic */ AbstractBaseTreeNode this$0;
    
    private AbstractBaseTreeNode$InternalTreeNodeSearcherListener(final AbstractBaseTreeNode this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void searchStringChanged(final TreeNodeSearcher treeNodeSearcher) {
        this.this$0.updateTreeNodes(true);
    }
}
