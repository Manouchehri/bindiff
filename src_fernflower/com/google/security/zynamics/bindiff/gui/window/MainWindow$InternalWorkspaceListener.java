package com.google.security.zynamics.bindiff.gui.window;

import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$1;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.WorkspaceAdapter;

class MainWindow$InternalWorkspaceListener extends WorkspaceAdapter {
   // $FF: synthetic field
   final MainWindow this$0;

   private MainWindow$InternalWorkspaceListener(MainWindow var1) {
      this.this$0 = var1;
   }

   public void closedWorkspace() {
      this.this$0.setTitle("");
   }

   public void loadedWorkspace(Workspace var1) {
      this.this$0.setTitle(var1.getWorkspaceFilePath());
      MainWindow.access$502(this.this$0, var1.getWorkspaceFilePath());
      MainWindow.access$200(this.this$0);
   }

   // $FF: synthetic method
   MainWindow$InternalWorkspaceListener(MainWindow var1, MainWindow$1 var2) {
      this(var1);
   }
}
