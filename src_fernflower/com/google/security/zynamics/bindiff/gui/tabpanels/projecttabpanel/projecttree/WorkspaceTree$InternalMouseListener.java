package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class WorkspaceTree$InternalMouseListener extends MouseAdapter {
   // $FF: synthetic field
   final WorkspaceTree this$0;

   private WorkspaceTree$InternalMouseListener(WorkspaceTree var1) {
      this.this$0 = var1;
   }

   public void mousePressed(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         WorkspaceTree.access$300(this.this$0, var1);
      } else if(var1.getClickCount() == 2) {
         WorkspaceTree.access$400(this.this$0, var1);
      }

   }

   public void mouseReleased(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         WorkspaceTree.access$300(this.this$0, var1);
      }

   }

   // $FF: synthetic method
   WorkspaceTree$InternalMouseListener(WorkspaceTree var1, WorkspaceTree$1 var2) {
      this(var1);
   }
}
