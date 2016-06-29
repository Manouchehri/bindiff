package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph.SingleCallGraphBaseTreeNode;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class SingleCallGraphBaseTreeNode$3 extends AbstractAction {
   // $FF: synthetic field
   final ESide val$side;
   // $FF: synthetic field
   final SingleCallGraphBaseTreeNode this$0;

   SingleCallGraphBaseTreeNode$3(SingleCallGraphBaseTreeNode var1, String var2, ESide var3) {
      super(var2);
      this.this$0 = var1;
      this.val$side = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = SingleCallGraphBaseTreeNode.access$200(this.this$0).getMetaData().getIdbName(this.val$side);
      ClipboardHelpers.copyToClipboard(var2);
   }
}
