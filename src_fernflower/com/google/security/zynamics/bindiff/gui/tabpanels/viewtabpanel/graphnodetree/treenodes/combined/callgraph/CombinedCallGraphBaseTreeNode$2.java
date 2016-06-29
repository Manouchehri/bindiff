package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.callgraph.CombinedCallGraphBaseTreeNode;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class CombinedCallGraphBaseTreeNode$2 extends AbstractAction {
   // $FF: synthetic field
   final CombinedCallGraphBaseTreeNode this$0;

   CombinedCallGraphBaseTreeNode$2(CombinedCallGraphBaseTreeNode var1, String var2) {
      super(var2);
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = CombinedCallGraphBaseTreeNode.access$100(this.this$0).getMetaData().getImageName(ESide.SECONDARY);
      ClipboardHelpers.copyToClipboard(var2);
   }
}
