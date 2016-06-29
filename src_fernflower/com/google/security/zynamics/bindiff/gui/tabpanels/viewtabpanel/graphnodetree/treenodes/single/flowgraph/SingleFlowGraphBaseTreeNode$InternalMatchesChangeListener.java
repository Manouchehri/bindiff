package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode$1;
import com.google.security.zynamics.bindiff.project.matches.IMatchesChangeListener;
import com.google.security.zynamics.zylib.disassembly.IAddress;

class SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener implements IMatchesChangeListener {
   // $FF: synthetic field
   final SingleFlowGraphBaseTreeNode this$0;

   private SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener(SingleFlowGraphBaseTreeNode var1) {
      this.this$0 = var1;
   }

   private void updateTree(IAddress var1, IAddress var2, IAddress var3, IAddress var4) {
      IAddress var5 = this.this$0.getRootNode().getView().getAddress(ESide.PRIMARY);
      IAddress var6 = this.this$0.getRootNode().getView().getAddress(ESide.SECONDARY);
      if(var5.equals(var1) && var6.equals(var2)) {
         IAddress var7 = var3;
         if(this.this$0.getRootNode().getGraph().getSide() == ESide.SECONDARY) {
            var7 = var4;
         }

         SingleFlowGraphBaseTreeNode.access$300(this.this$0, var7);
      }

   }

   public void addedBasicblockMatch(IAddress var1, IAddress var2, IAddress var3, IAddress var4) {
      this.updateTree(var1, var2, var3, var4);
   }

   public void removedBasicblockMatch(IAddress var1, IAddress var2, IAddress var3, IAddress var4) {
      this.updateTree(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   SingleFlowGraphBaseTreeNode$InternalMatchesChangeListener(SingleFlowGraphBaseTreeNode var1, SingleFlowGraphBaseTreeNode$1 var2) {
      this(var1);
   }
}
