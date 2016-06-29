package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ITreeNodeSorterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$1;

class AbstractBaseTreeNode$InternalTreeNodeSorterListener implements ITreeNodeSorterListener {
   // $FF: synthetic field
   final AbstractBaseTreeNode this$0;

   private AbstractBaseTreeNode$InternalTreeNodeSorterListener(AbstractBaseTreeNode var1) {
      this.this$0 = var1;
   }

   public void sortingChanged(TreeNodeMultiSorter var1) {
      this.this$0.updateTreeNodes(false);
   }

   // $FF: synthetic method
   AbstractBaseTreeNode$InternalTreeNodeSorterListener(AbstractBaseTreeNode var1, AbstractBaseTreeNode$1 var2) {
      this(var1);
   }
}
