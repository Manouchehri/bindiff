package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CDialogEscaper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

class CDialogEscaper$1 implements ActionListener {
   // $FF: synthetic field
   final JDialog val$dialog;
   // $FF: synthetic field
   final CDialogEscaper this$0;

   CDialogEscaper$1(CDialogEscaper var1, JDialog var2) {
      this.this$0 = var1;
      this.val$dialog = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      this.val$dialog.setVisible(false);
      this.val$dialog.dispose();
   }
}
