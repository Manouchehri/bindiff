package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.IViewsFilterCheckboxListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.MatchedFunctionViewsFilterPanel$1;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;

class MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener implements ItemListener {
   // $FF: synthetic field
   final MatchedFunctionViewsFilterPanel this$0;

   private MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener(MatchedFunctionViewsFilterPanel var1) {
      this.this$0 = var1;
   }

   public void itemStateChanged(ItemEvent var1) {
      boolean var2 = MatchedFunctionViewsFilterPanel.access$700(this.this$0).isSelected();
      boolean var3 = MatchedFunctionViewsFilterPanel.access$800(this.this$0).isSelected();
      boolean var4 = MatchedFunctionViewsFilterPanel.access$900(this.this$0).isSelected();
      Iterator var5 = MatchedFunctionViewsFilterPanel.access$1000(this.this$0).iterator();

      while(var5.hasNext()) {
         IViewsFilterCheckboxListener var6 = (IViewsFilterCheckboxListener)var5.next();
         var6.functionViewsFilterChanged(var2, var3, var4);
      }

      MatchedFunctionViewsFilterPanel.access$600(this.this$0).setIcon(MatchedFunctionViewsFilterPanel.access$500());
      this.this$0.updateUI();
   }

   // $FF: synthetic method
   MatchedFunctionViewsFilterPanel$InternalFilterCheckboxListener(MatchedFunctionViewsFilterPanel var1, MatchedFunctionViewsFilterPanel$1 var2) {
      this(var1);
   }
}
