package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;

class AbstractBaseTreeNode$InternalTreeNodeSorterListener implements ITreeNodeSorterListener
{
    final /* synthetic */ AbstractBaseTreeNode this$0;
    
    private AbstractBaseTreeNode$InternalTreeNodeSorterListener(final AbstractBaseTreeNode this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void sortingChanged(final TreeNodeMultiSorter treeNodeMultiSorter) {
        this.this$0.updateTreeNodes(false);
    }
}
