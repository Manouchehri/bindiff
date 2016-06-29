package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class DirectoryDiffDialog$InternalButtonListener extends AbstractAction {
   // $FF: synthetic field
   final DirectoryDiffDialog this$0;

   private DirectoryDiffDialog$InternalButtonListener(DirectoryDiffDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource().equals(DirectoryDiffDialog.access$200(this.this$0))) {
         DirectoryDiffDialog.access$300(this.this$0, true);
      } else if(var1.getSource().equals(DirectoryDiffDialog.access$400(this.this$0))) {
         DirectoryDiffDialog.access$300(this.this$0, false);
      } else if(var1.getSource().equals(DirectoryDiffDialog.access$500(this.this$0))) {
         if(DirectoryDiffDialog.access$600(this.this$0).isEditing()) {
            DirectoryDiffDialog.access$600(this.this$0).getCellEditor().stopCellEditing();
         }

         if(!DirectoryDiffDialog.access$700(this.this$0)) {
            return;
         }

         DirectoryDiffDialog.access$802(this.this$0, true);
         this.this$0.dispose();
      } else {
         DirectoryDiffDialog.access$802(this.this$0, false);
         this.this$0.dispose();
      }

   }

   // $FF: synthetic method
   DirectoryDiffDialog$InternalButtonListener(DirectoryDiffDialog var1, DirectoryDiffDialog$1 var2) {
      this(var1);
   }
}
