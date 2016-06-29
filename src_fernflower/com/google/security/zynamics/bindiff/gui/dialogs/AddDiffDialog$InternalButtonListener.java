package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class AddDiffDialog$InternalButtonListener extends AbstractAction {
   // $FF: synthetic field
   final AddDiffDialog this$0;

   private AddDiffDialog$InternalButtonListener(AddDiffDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource().equals(AddDiffDialog.access$200(this.this$0))) {
         if(!AddDiffDialog.access$300(this.this$0)) {
            return;
         }

         AddDiffDialog.access$402(this.this$0, true);
      }

      this.this$0.dispose();
   }

   // $FF: synthetic method
   AddDiffDialog$InternalButtonListener(AddDiffDialog var1, AddDiffDialog$1 var2) {
      this(var1);
   }
}
