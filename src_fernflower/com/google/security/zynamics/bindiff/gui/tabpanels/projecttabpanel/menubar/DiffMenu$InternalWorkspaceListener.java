package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$1;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceAdapter;

class DiffMenu$InternalWorkspaceListener extends WorkspaceAdapter {
   // $FF: synthetic field
   final DiffMenu this$0;

   private DiffMenu$InternalWorkspaceListener(DiffMenu var1) {
      this.this$0 = var1;
   }

   public void closedWorkspace() {
      this.this$0.setEnabled(false);
      DiffMenu.access$700(this.this$0);
   }

   public void loadedWorkspace(Workspace var1) {
      this.this$0.setEnabled(true);
      DiffMenu.access$800(this.this$0).setEnabled(true);
      DiffMenu.access$900(this.this$0).setEnabled(true);
      DiffMenu.access$300(this.this$0).setEnabled(false);
      DiffMenu.access$400(this.this$0).setEnabled(false);
      DiffMenu.access$1000(this.this$0).setEnabled(false);
   }

   // $FF: synthetic method
   DiffMenu$InternalWorkspaceListener(DiffMenu var1, DiffMenu$1 var2) {
      this(var1);
   }
}
