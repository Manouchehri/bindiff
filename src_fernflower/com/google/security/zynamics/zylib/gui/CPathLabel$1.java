package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CPathLabel;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CPathLabel$1 implements ActionListener {
   // $FF: synthetic field
   final CPathLabel this$0;

   CPathLabel$1(CPathLabel var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      StringSelection var2 = new StringSelection(CPathLabel.access$001(this.this$0));
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var2, var2);
   }
}
