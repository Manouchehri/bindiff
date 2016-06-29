package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph.CombinedFlowGraphBaseTreeNode;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class CombinedFlowGraphBaseTreeNode$2 extends AbstractAction {
   // $FF: synthetic field
   final CombinedFlowGraphBaseTreeNode this$0;

   CombinedFlowGraphBaseTreeNode$2(CombinedFlowGraphBaseTreeNode var1, String var2) {
      super(var2);
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      FlowGraphViewData var2 = (FlowGraphViewData)CombinedFlowGraphBaseTreeNode.access$200(this.this$0);
      ClipboardHelpers.copyToClipboard(var2.getFunctionName(ESide.PRIMARY));
   }
}
