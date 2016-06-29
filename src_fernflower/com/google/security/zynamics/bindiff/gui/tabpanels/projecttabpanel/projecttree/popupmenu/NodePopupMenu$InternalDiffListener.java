package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NodePopupMenu$1;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffListenerAdapter;

class NodePopupMenu$InternalDiffListener extends DiffListenerAdapter {
   // $FF: synthetic field
   final NodePopupMenu this$0;

   private NodePopupMenu$InternalDiffListener(NodePopupMenu var1) {
      this.this$0 = var1;
   }

   public void closedView(Diff var1) {
      NodePopupMenu.access$200(this.this$0, var1);
   }

   public void loadedDiff(Diff var1) {
      NodePopupMenu.access$200(this.this$0, var1);
      if(var1.getMatches() == null) {
         NodePopupMenu.access$300(this.this$0).setEnabled(false);
      }

   }

   public void loadedView(Diff var1) {
      NodePopupMenu.access$200(this.this$0, var1);
   }

   public void removedDiff(Diff var1) {
      NodePopupMenu.access$200(this.this$0, var1);
      NodePopupMenu.access$400(this.this$0);
      NodePopupMenu.access$600(this.this$0).getWorkspaceTree().removeListener(NodePopupMenu.access$500(this.this$0));
   }

   public void unloadedDiff(Diff var1) {
      NodePopupMenu.access$200(this.this$0, var1);
   }

   // $FF: synthetic method
   NodePopupMenu$InternalDiffListener(NodePopupMenu var1, NodePopupMenu$1 var2) {
      this(var1);
   }
}
