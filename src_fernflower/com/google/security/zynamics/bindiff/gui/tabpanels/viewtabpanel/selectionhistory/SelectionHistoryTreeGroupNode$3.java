package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;

class SelectionHistoryTreeGroupNode$3 extends AbstractAction {
   // $FF: synthetic field
   final SelectionHistoryTreeGroupNode this$0;

   SelectionHistoryTreeGroupNode$3(SelectionHistoryTreeGroupNode var1, String var2) {
      super(var2);
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = SelectionHistoryTreeGroupNode.access$100(this.this$0).getSingleGraphSelection().iterator();

      while(var3.hasNext()) {
         SingleDiffNode var4 = (SingleDiffNode)var3.next();
         var2.append(((RawBasicBlock)var4.getRawNode()).getAddress().toHexString());
         var2.append("\n");
      }

      ClipboardHelpers.copyToClipboard(var2.toString());
   }
}
