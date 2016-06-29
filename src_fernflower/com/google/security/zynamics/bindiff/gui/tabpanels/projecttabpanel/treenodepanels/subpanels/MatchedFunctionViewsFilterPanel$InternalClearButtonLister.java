package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MatchedFunctionViewsFilterPanel$InternalClearButtonLister implements ActionListener {
   // $FF: synthetic field
   final MatchedFunctionViewsFilterPanel this$0;

   private MatchedFunctionViewsFilterPanel$InternalClearButtonLister(MatchedFunctionViewsFilterPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      MatchedFunctionViewsFilterPanel.access$400(this.this$0).reset();
      MatchedFunctionViewsFilterPanel.access$600(this.this$0).setIcon(MatchedFunctionViewsFilterPanel.access$500());
   }

   // $FF: synthetic method
   MatchedFunctionViewsFilterPanel$InternalClearButtonLister(MatchedFunctionViewsFilterPanel var1, MatchedFunctionViewsFilterPanel$1 var2) {
      this(var1);
   }
}
