package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CDialogAboutEx;
import com.google.security.zynamics.zylib.gui.CDialogAboutEx$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CDialogAboutEx$InternalActionListener implements ActionListener {
   // $FF: synthetic field
   final CDialogAboutEx this$0;

   private CDialogAboutEx$InternalActionListener(CDialogAboutEx var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.dispose();
   }

   // $FF: synthetic method
   CDialogAboutEx$InternalActionListener(CDialogAboutEx var1, CDialogAboutEx$1 var2) {
      this(var1);
   }
}
