package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISnapshotListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeGroupNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreeNodeWrapper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import javax.swing.tree.DefaultTreeModel;

final class SelectionHistoryTreeGroupNode$InternalSnapshotListener implements ISnapshotListener {
   // $FF: synthetic field
   final SelectionHistoryTreeGroupNode this$0;

   private SelectionHistoryTreeGroupNode$InternalSnapshotListener(SelectionHistoryTreeGroupNode var1) {
      this.this$0 = var1;
   }

   public void addedNode(ZyGraphNode var1) {
      SelectionHistoryTreeNode var2 = new SelectionHistoryTreeNode(var1);
      this.this$0.add(var2);
      this.this$0.setUserObject(new SelectionHistoryTreeNodeWrapper(SelectionHistoryTreeGroupNode.access$100(this.this$0), SelectionHistoryTreeGroupNode.access$200(this.this$0)));
   }

   public void finished() {
      ((DefaultTreeModel)this.this$0.getTree().getModel()).nodeStructureChanged(this.this$0);
      this.this$0.getTree().updateUI();
   }

   public void removedNode(ZyGraphNode var1) {
      for(int var2 = 0; var2 < this.this$0.getChildCount(); ++var2) {
         SelectionHistoryTreeNode var3 = (SelectionHistoryTreeNode)this.this$0.getChildAt(var2);
         if(var3.getNode() == var1) {
            ((DefaultTreeModel)this.this$0.getTree().getModel()).removeNodeFromParent(var3);
            var3.removeFromParent();
            this.this$0.setUserObject(new SelectionHistoryTreeNodeWrapper(SelectionHistoryTreeGroupNode.access$100(this.this$0), SelectionHistoryTreeGroupNode.access$200(this.this$0)));
            break;
         }
      }

   }

   // $FF: synthetic method
   SelectionHistoryTreeGroupNode$InternalSnapshotListener(SelectionHistoryTreeGroupNode var1, SelectionHistoryTreeGroupNode$1 var2) {
      this(var1);
   }
}
