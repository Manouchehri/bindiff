package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.flowgraph.SingleFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class SingleFlowGraphBaseTreeNode$2 extends AbstractAction {
   // $FF: synthetic field
   final ESide val$side;
   // $FF: synthetic field
   final SingleFlowGraphBaseTreeNode this$0;

   SingleFlowGraphBaseTreeNode$2(SingleFlowGraphBaseTreeNode var1, String var2, ESide var3) {
      super(var2);
      this.this$0 = var1;
      this.val$side = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      FlowGraphViewData var2 = (FlowGraphViewData)SingleFlowGraphBaseTreeNode.access$200(this.this$0);
      ClipboardHelpers.copyToClipboard(var2.getFunctionName(this.val$side));
   }
}
