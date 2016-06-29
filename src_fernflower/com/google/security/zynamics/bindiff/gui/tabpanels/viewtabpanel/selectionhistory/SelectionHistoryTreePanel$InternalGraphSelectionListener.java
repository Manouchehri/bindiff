package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;

class SelectionHistoryTreePanel$InternalGraphSelectionListener implements IZyGraphSelectionListener {
   private SelectionSnapshot lastSnapshot;
   // $FF: synthetic field
   final SelectionHistoryTreePanel this$0;

   private SelectionHistoryTreePanel$InternalGraphSelectionListener(SelectionHistoryTreePanel var1) {
      this.this$0 = var1;
   }

   public void selectionChanged() {
      SelectionSnapshot var1 = new SelectionSnapshot(GraphNodeFilter.filterNodes((AbstractZyGraph)SelectionHistoryTreePanel.access$500(this.this$0), GraphNodeFilter$Criterium.SELECTED));
      if(var1.getNumberOfSelectedNodes() != 0 && !var1.equals(this.lastSnapshot)) {
         SelectionHistoryTreePanel.access$600(this.this$0).addSnapshot(var1);
         this.lastSnapshot = var1;
      }

      this.this$0.updateUI();
   }

   // $FF: synthetic method
   SelectionHistoryTreePanel$InternalGraphSelectionListener(SelectionHistoryTreePanel var1, SelectionHistoryTreePanel$1 var2) {
      this(var1);
   }
}
