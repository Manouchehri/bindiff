package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.RenameFileDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.RenameFileDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RenameFileDialog$InternalActionListener implements ActionListener {
   // $FF: synthetic field
   final RenameFileDialog this$0;

   private RenameFileDialog$InternalActionListener(RenameFileDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      RenameFileDialog.access$102(this.this$0, var1.getSource() == RenameFileDialog.access$200(this.this$0));
      this.this$0.dispose();
   }

   // $FF: synthetic method
   RenameFileDialog$InternalActionListener(RenameFileDialog var1, RenameFileDialog$1 var2) {
      this(var1);
   }
}
