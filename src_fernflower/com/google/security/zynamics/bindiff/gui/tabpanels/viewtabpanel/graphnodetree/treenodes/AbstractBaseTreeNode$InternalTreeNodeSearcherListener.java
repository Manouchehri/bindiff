package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.ITreeNodeSearcherListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$1;

class AbstractBaseTreeNode$InternalTreeNodeSearcherListener implements ITreeNodeSearcherListener {
   // $FF: synthetic field
   final AbstractBaseTreeNode this$0;

   private AbstractBaseTreeNode$InternalTreeNodeSearcherListener(AbstractBaseTreeNode var1) {
      this.this$0 = var1;
   }

   public void searchStringChanged(TreeNodeSearcher var1) {
      this.this$0.updateTreeNodes(true);
   }

   // $FF: synthetic method
   AbstractBaseTreeNode$InternalTreeNodeSearcherListener(AbstractBaseTreeNode var1, AbstractBaseTreeNode$1 var2) {
      this(var1);
   }
}
