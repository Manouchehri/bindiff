package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;

class SelectionHistoryTreeGroupNode$1 extends AbstractAction {
   // $FF: synthetic field
   final SelectionHistoryTreeGroupNode this$0;

   SelectionHistoryTreeGroupNode$1(SelectionHistoryTreeGroupNode var1, String var2) {
      super(var2);
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = SelectionHistoryTreeGroupNode.access$100(this.this$0).getSingleGraphSelection().iterator();

      while(var3.hasNext()) {
         SingleDiffNode var4 = (SingleDiffNode)var3.next();
         var2.append(((RawFunction)var4.getRawNode()).getAddress().toHexString());
         var2.append("\n");
      }

      ClipboardHelpers.copyToClipboard(var2.toString());
   }
}
