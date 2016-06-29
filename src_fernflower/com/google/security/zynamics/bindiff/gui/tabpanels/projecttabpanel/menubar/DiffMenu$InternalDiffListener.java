package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$1;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffListenerAdapter;

class DiffMenu$InternalDiffListener extends DiffListenerAdapter {
   // $FF: synthetic field
   final DiffMenu this$0;

   private DiffMenu$InternalDiffListener(DiffMenu var1) {
      this.this$0 = var1;
   }

   public void loadedDiff(Diff var1) {
      DiffMenu.access$300(this.this$0).setEnabled(!var1.isLoaded());
      DiffMenu.access$400(this.this$0).setEnabled(var1.isLoaded());
   }

   public void removedDiff(Diff var1) {
      DiffMenu.access$600(this.this$0).getWorkspaceTree().removeListener(DiffMenu.access$500(this.this$0));
   }

   public void unloadedDiff(Diff var1) {
      DiffMenu.access$300(this.this$0).setEnabled(!var1.isLoaded());
      DiffMenu.access$400(this.this$0).setEnabled(var1.isLoaded());
   }

   // $FF: synthetic method
   DiffMenu$InternalDiffListener(DiffMenu var1, DiffMenu$1 var2) {
      this(var1);
   }
}
