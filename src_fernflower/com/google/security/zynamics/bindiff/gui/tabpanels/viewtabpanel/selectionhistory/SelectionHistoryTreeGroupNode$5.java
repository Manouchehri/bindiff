package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;

class SelectionHistoryTreeGroupNode$5 extends AbstractAction {
   // $FF: synthetic field
   final SelectionHistoryTreeGroupNode this$0;

   SelectionHistoryTreeGroupNode$5(SelectionHistoryTreeGroupNode var1, String var2) {
      super(var2);
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = SelectionHistoryTreeGroupNode.access$100(this.this$0).getCombinedGraphSelection().iterator();

      while(var3.hasNext()) {
         CombinedDiffNode var4 = (CombinedDiffNode)var3.next();
         RawFunction var5 = (RawFunction)var4.getSecondaryRawNode();
         if(var5 != null) {
            var2.append(var5.getAddress().toHexString());
            var2.append("\n");
         }
      }

      ClipboardHelpers.copyToClipboard(var2.toString());
   }
}
