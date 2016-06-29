package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.DiffMenu$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.IWorkspaceTreeListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;

class DiffMenu$InternalWorkspaceTreeListener implements IWorkspaceTreeListener {
   // $FF: synthetic field
   final DiffMenu this$0;

   private DiffMenu$InternalWorkspaceTreeListener(DiffMenu var1) {
      this.this$0 = var1;
   }

   public void changedSelection(AbstractTreeNode var1) {
      Diff var2 = var1.getDiff();
      if(var2 == null) {
         DiffMenu.access$800(this.this$0).setEnabled(true);
         DiffMenu.access$900(this.this$0).setEnabled(true);
         DiffMenu.access$300(this.this$0).setEnabled(false);
         DiffMenu.access$400(this.this$0).setEnabled(false);
         DiffMenu.access$1000(this.this$0).setEnabled(false);
         DiffMenu.access$700(this.this$0);
      } else {
         DiffMenu.access$300(this.this$0).setEnabled(!var2.isLoaded());
         DiffMenu.access$400(this.this$0).setEnabled(var2.isLoaded());
         DiffMenu.access$1000(this.this$0).setEnabled(var2.isLoaded());
         DiffMenu.access$1100(this.this$0, var2);
      }

   }

   // $FF: synthetic method
   DiffMenu$InternalWorkspaceTreeListener(DiffMenu var1, DiffMenu$1 var2) {
      this(var1);
   }
}
