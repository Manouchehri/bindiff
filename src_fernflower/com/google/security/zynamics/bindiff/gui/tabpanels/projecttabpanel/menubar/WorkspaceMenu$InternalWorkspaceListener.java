package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu$1;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceAdapter;

class WorkspaceMenu$InternalWorkspaceListener extends WorkspaceAdapter {
   // $FF: synthetic field
   final WorkspaceMenu this$0;

   private WorkspaceMenu$InternalWorkspaceListener(WorkspaceMenu var1) {
      this.this$0 = var1;
   }

   public void closedWorkspace() {
      this.this$0.enableSubmenus(false);
   }

   public void loadedWorkspace(Workspace var1) {
      this.this$0.enableSubmenus(true);
      String var2 = var1.getWorkspaceFilePath();
      if(!var2.isEmpty()) {
         int var3 = WorkspaceMenu.access$200(this.this$0).indexOf(var2);
         if(var3 >= 0) {
            String var4 = (String)WorkspaceMenu.access$200(this.this$0).get(0);
            WorkspaceMenu.access$200(this.this$0).set(0, WorkspaceMenu.access$200(this.this$0).get(var3));
            WorkspaceMenu.access$200(this.this$0).set(var3, var4);
         } else {
            WorkspaceMenu.access$200(this.this$0).remove(3);
            WorkspaceMenu.access$200(this.this$0).add(0, var2);
         }

         WorkspaceMenu.access$300(this.this$0);
      }
   }

   // $FF: synthetic method
   WorkspaceMenu$InternalWorkspaceListener(WorkspaceMenu var1, WorkspaceMenu$1 var2) {
      this(var1);
   }
}
