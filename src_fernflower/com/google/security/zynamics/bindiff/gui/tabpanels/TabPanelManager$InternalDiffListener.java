package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$1;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffListenerAdapter;

class TabPanelManager$InternalDiffListener extends DiffListenerAdapter {
   // $FF: synthetic field
   final TabPanelManager this$0;

   private TabPanelManager$InternalDiffListener(TabPanelManager var1) {
      this.this$0 = var1;
   }

   public void closedView(Diff var1) {
      TabPanelManager.access$400(this.this$0, var1);
   }

   // $FF: synthetic method
   TabPanelManager$InternalDiffListener(TabPanelManager var1, TabPanelManager$1 var2) {
      this(var1);
   }
}
