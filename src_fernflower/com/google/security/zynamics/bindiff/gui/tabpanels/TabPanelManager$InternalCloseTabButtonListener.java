package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.ICloseTabButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.gui.CMessageBox;

class TabPanelManager$InternalCloseTabButtonListener implements ICloseTabButtonListener {
   // $FF: synthetic field
   final TabPanelManager this$0;

   private TabPanelManager$InternalCloseTabButtonListener(TabPanelManager var1) {
      this.this$0 = var1;
   }

   public boolean closing(TabButtonComponent var1) {
      ViewTabPanel var2 = (ViewTabPanel)var1.getTabPanel();
      ViewData var3 = var2.getView();
      if(var2.getController().hasChanged()) {
         var2.getTabPanelManager().selectTab(var2);
         int var4 = CMessageBox.showYesNoCancelQuestion(TabPanelManager.access$300(this.this$0), String.format("\'%s\' has been modified. Save?", new Object[]{var3.getViewName()}));
         if(var4 == 2) {
            return false;
         }

         var2.getController().closeView(var4 == 0);
      } else {
         var2.getController().closeView(false);
      }

      return true;
   }

   // $FF: synthetic method
   TabPanelManager$InternalCloseTabButtonListener(TabPanelManager var1, TabPanelManager$1 var2) {
      this(var1);
   }
}
