package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsFilterPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister implements ActionListener {
   // $FF: synthetic field
   final UnmatchedFunctionViewsFilterPanel this$0;

   private UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister(UnmatchedFunctionViewsFilterPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      UnmatchedFunctionViewsFilterPanel.access$300(this.this$0).reset();
      UnmatchedFunctionViewsFilterPanel.access$500(this.this$0).setIcon(UnmatchedFunctionViewsFilterPanel.access$400());
   }

   // $FF: synthetic method
   UnmatchedFunctionViewsFilterPanel$InternalClearButtonLister(UnmatchedFunctionViewsFilterPanel var1, UnmatchedFunctionViewsFilterPanel$1 var2) {
      this(var1);
   }
}
