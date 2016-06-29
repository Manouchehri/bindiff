package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NoNodePopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.NoNodePopupMenu$1;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceAdapter;

class NoNodePopupMenu$InternalWorkspaceListener extends WorkspaceAdapter {
   // $FF: synthetic field
   final NoNodePopupMenu this$0;

   private NoNodePopupMenu$InternalWorkspaceListener(NoNodePopupMenu var1) {
      this.this$0 = var1;
   }

   public void closedWorkspace() {
      NoNodePopupMenu.access$100(this.this$0, false);
   }

   public void loadedWorkspace(Workspace var1) {
      NoNodePopupMenu.access$100(this.this$0, true);
   }

   // $FF: synthetic method
   NoNodePopupMenu$InternalWorkspaceListener(NoNodePopupMenu var1, NoNodePopupMenu$1 var2) {
      this(var1);
   }
}
