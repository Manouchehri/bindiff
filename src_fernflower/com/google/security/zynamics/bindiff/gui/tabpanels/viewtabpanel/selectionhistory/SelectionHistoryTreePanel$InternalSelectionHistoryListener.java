package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISelectionHistoryListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryRootNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;

class SelectionHistoryTreePanel$InternalSelectionHistoryListener implements ISelectionHistoryListener {
   // $FF: synthetic field
   final SelectionHistoryTreePanel this$0;

   private SelectionHistoryTreePanel$InternalSelectionHistoryListener(SelectionHistoryTreePanel var1) {
      this.this$0 = var1;
   }

   public void finishedRedo() {
      SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)SelectionHistoryTreePanel.access$700(this.this$0));
      SelectionHistoryTreePanel.access$800(this.this$0).updateUI();
   }

   public void finishedUndo() {
      SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)SelectionHistoryTreePanel.access$700(this.this$0));
      SelectionHistoryTreePanel.access$800(this.this$0).updateUI();
   }

   public void snapshotAdded(SelectionSnapshot var1) {
      SelectionHistoryTreePanel.access$900(this.this$0, var1);
   }

   public void snapshotRemoved() {
      SelectionHistoryRootNode var1 = (SelectionHistoryRootNode)SelectionHistoryTreePanel.access$1000(this.this$0).getRoot();
      int var2 = var1.getChildCount();
      SelectionHistoryTreeGroupNode var3 = (SelectionHistoryTreeGroupNode)SelectionHistoryTreePanel.access$1000(this.this$0).getChild(var1, var2 - 1);
      var3.dispose();
      SelectionHistoryTreePanel.access$1000(this.this$0).removeNodeFromParent(var3);
   }

   public void startedRedo() {
      SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)SelectionHistoryTreePanel.access$700(this.this$0));
   }

   public void startedUndo() {
      SelectionHistoryTreePanel.access$500(this.this$0).getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)SelectionHistoryTreePanel.access$700(this.this$0));
   }

   // $FF: synthetic method
   SelectionHistoryTreePanel$InternalSelectionHistoryListener(SelectionHistoryTreePanel var1, SelectionHistoryTreePanel$1 var2) {
      this(var1);
   }
}
