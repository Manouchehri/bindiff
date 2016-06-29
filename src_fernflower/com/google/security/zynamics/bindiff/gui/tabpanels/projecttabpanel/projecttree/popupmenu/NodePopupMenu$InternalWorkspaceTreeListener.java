package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;

class NodePopupMenu$InternalWorkspaceTreeListener implements IWorkspaceTreeListener {
   // $FF: synthetic field
   final NodePopupMenu this$0;

   private NodePopupMenu$InternalWorkspaceTreeListener(NodePopupMenu var1) {
      this.this$0 = var1;
   }

   public void changedSelection(AbstractTreeNode var1) {
      Diff var2 = var1.getDiff();
      if(var2 == null) {
         NodePopupMenu.access$300(this.this$0).setEnabled(false);
         NodePopupMenu.access$700(this.this$0).setEnabled(false);
         NodePopupMenu.access$800(this.this$0).setEnabled(false);
         NodePopupMenu.access$900(this.this$0).setEnabled(false);
         NodePopupMenu.access$400(this.this$0);
      } else {
         NodePopupMenu.access$200(this.this$0, var2);
         NodePopupMenu.access$1000(this.this$0, var2);
      }

   }

   // $FF: synthetic method
   NodePopupMenu$InternalWorkspaceTreeListener(NodePopupMenu var1, NodePopupMenu$1 var2) {
      this(var1);
   }
}
