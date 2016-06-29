package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class WorkspaceMenu$1 extends AbstractAction {
   // $FF: synthetic field
   final String val$workspace;
   // $FF: synthetic field
   final WorkspaceMenu this$0;

   WorkspaceMenu$1(WorkspaceMenu var1, String var2) {
      this.this$0 = var1;
      this.val$workspace = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      WorkspaceMenu.access$100(this.this$0).closeWorkspace();
      WorkspaceMenu.access$100(this.this$0).loadWorkspace(this.val$workspace);
   }
}
