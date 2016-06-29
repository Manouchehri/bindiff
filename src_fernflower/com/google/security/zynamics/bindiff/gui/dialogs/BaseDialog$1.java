package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BaseDialog$1 implements ActionListener {
   // $FF: synthetic field
   final BaseDialog this$0;

   BaseDialog$1(BaseDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.this$0.setVisible(false);
      this.this$0.dispose();
   }
}
