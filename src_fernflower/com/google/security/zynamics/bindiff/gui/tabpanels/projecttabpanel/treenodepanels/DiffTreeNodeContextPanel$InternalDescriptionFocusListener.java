package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$1;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class DiffTreeNodeContextPanel$InternalDescriptionFocusListener implements FocusListener {
   // $FF: synthetic field
   final DiffTreeNodeContextPanel this$0;

   private DiffTreeNodeContextPanel$InternalDescriptionFocusListener(DiffTreeNodeContextPanel var1) {
      this.this$0 = var1;
   }

   public void focusGained(FocusEvent var1) {
   }

   public void focusLost(FocusEvent var1) {
      DiffTreeNodeContextPanel.access$300(this.this$0);
   }

   // $FF: synthetic method
   DiffTreeNodeContextPanel$InternalDescriptionFocusListener(DiffTreeNodeContextPanel var1, DiffTreeNodeContextPanel$1 var2) {
      this(var1);
   }
}
