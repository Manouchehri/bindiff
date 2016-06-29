package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenu;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class WorkspaceMenu$2 extends AbstractAction {
   // $FF: synthetic field
   final WorkspaceMenu this$0;

   WorkspaceMenu$2(WorkspaceMenu var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      WorkspaceMenu.access$100(this.this$0).newWorkspace();
   }
}
