package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.filter.IGraphNodeMultiFilterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$1;

class AbstractBaseTreeNode$InternalGraphFilterListener implements IGraphNodeMultiFilterListener {
   // $FF: synthetic field
   final AbstractBaseTreeNode this$0;

   private AbstractBaseTreeNode$InternalGraphFilterListener(AbstractBaseTreeNode var1) {
      this.this$0 = var1;
   }

   public void filterChanged(GraphNodeMultiFilter var1) {
      this.this$0.updateTreeNodes(false);
   }

   // $FF: synthetic method
   AbstractBaseTreeNode$InternalGraphFilterListener(AbstractBaseTreeNode var1, AbstractBaseTreeNode$1 var2) {
      this(var1);
   }
}
