package com.google.security.zynamics.bindiff.gui.tabpanels.menubar;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.menubar.HelpMenu;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class HelpMenu$4 extends AbstractAction {
   // $FF: synthetic field
   final TabPanelFunctions val$controller;
   // $FF: synthetic field
   final HelpMenu this$0;

   HelpMenu$4(HelpMenu var1, TabPanelFunctions var2) {
      this.this$0 = var1;
      this.val$controller = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      this.val$controller.checkForUpdates();
   }
}
