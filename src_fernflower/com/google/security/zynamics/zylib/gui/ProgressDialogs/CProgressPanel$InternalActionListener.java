package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CProgressPanel$InternalActionListener implements ActionListener {
   // $FF: synthetic field
   final CProgressPanel this$0;

   private CProgressPanel$InternalActionListener(CProgressPanel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      CProgressPanel.access$300(this.this$0);
   }

   // $FF: synthetic method
   CProgressPanel$InternalActionListener(CProgressPanel var1, CProgressPanel$1 var2) {
      this(var1);
   }
}
