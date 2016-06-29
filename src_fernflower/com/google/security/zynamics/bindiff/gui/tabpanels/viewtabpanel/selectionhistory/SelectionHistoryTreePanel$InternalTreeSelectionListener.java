package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

class SelectionHistoryTreePanel$InternalTreeSelectionListener implements TreeSelectionListener {
   // $FF: synthetic field
   final SelectionHistoryTreePanel this$0;

   private SelectionHistoryTreePanel$InternalTreeSelectionListener(SelectionHistoryTreePanel var1) {
      this.this$0 = var1;
   }

   public void valueChanged(TreeSelectionEvent var1) {
      SelectionHistoryTreeGroupNode var2 = (SelectionHistoryTreeGroupNode)SelectionHistoryTreePanel.access$800(this.this$0).getLastSelectedPathComponent();
      if(var2 != null && var2.getParent() == SelectionHistoryTreePanel.access$1000(this.this$0).getRoot()) {
         int var3 = SelectionHistoryTreePanel.access$600(this.this$0).getNumberOfSnapshots() - SelectionHistoryTreePanel.access$1000(this.this$0).getIndexOfChild(SelectionHistoryTreePanel.access$1000(this.this$0).getRoot(), var2) - 1;
         SelectionSnapshot var4 = SelectionHistoryTreePanel.access$600(this.this$0).getSnapshot(var3);
         if(SelectionHistoryTreePanel.access$500(this.this$0) instanceof SingleGraph) {
            SelectionHistoryTreePanel.access$1200(this.this$0, var4.getSingleGraphSelection());
         } else if(SelectionHistoryTreePanel.access$500(this.this$0) instanceof CombinedGraph) {
            SelectionHistoryTreePanel.access$1400(this.this$0, var4.getCombinedGraphSelection());
         }

         SelectionHistoryTreePanel.access$800(this.this$0).updateUI();
      }
   }

   // $FF: synthetic method
   SelectionHistoryTreePanel$InternalTreeSelectionListener(SelectionHistoryTreePanel var1, SelectionHistoryTreePanel$1 var2) {
      this(var1);
   }
}
