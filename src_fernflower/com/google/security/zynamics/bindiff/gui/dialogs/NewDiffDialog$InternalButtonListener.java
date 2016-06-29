package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class NewDiffDialog$InternalButtonListener extends AbstractAction {
   // $FF: synthetic field
   final NewDiffDialog this$0;

   private NewDiffDialog$InternalButtonListener(NewDiffDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource().equals(NewDiffDialog.access$300(this.this$0))) {
         if(!NewDiffDialog.access$400(this.this$0)) {
            return;
         }

         NewDiffDialog.access$502(this.this$0, true);
      }

      this.this$0.dispose();
   }

   // $FF: synthetic method
   NewDiffDialog$InternalButtonListener(NewDiffDialog var1, NewDiffDialog$1 var2) {
      this(var1);
   }
}
