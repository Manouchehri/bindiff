package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.SaveAsViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveAsViewDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SaveAsViewDialog$InternalButtonListener implements ActionListener {
   // $FF: synthetic field
   final SaveAsViewDialog this$0;

   private SaveAsViewDialog$InternalButtonListener(SaveAsViewDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource().equals(SaveAsViewDialog.access$100(this.this$0))) {
         SaveAsViewDialog.access$202(this.this$0, true);
      } else {
         SaveAsViewDialog.access$202(this.this$0, false);
      }

      this.this$0.dispose();
   }

   // $FF: synthetic method
   SaveAsViewDialog$InternalButtonListener(SaveAsViewDialog var1, SaveAsViewDialog$1 var2) {
      this(var1);
   }
}
