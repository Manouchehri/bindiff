package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$1;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class DiffTreeNodeContextPanel$InternalTimerListener implements ActionListener {
   // $FF: synthetic field
   final DiffTreeNodeContextPanel this$0;

   private DiffTreeNodeContextPanel$InternalTimerListener(DiffTreeNodeContextPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      DiffTreeNodeContextPanel.access$400(this.this$0).setTitleColor(Color.BLACK);
      DiffTreeNodeContextPanel.access$400(this.this$0).setTitle("Description");
      this.this$0.updateUI();
      DiffTreeNodeContextPanel.access$500(this.this$0).stop();
   }

   // $FF: synthetic method
   DiffTreeNodeContextPanel$InternalTimerListener(DiffTreeNodeContextPanel var1, DiffTreeNodeContextPanel$1 var2) {
      this(var1);
   }
}
