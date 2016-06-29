package com.google.security.zynamics.bindiff.gui.dialogs.printing;

import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphOptionsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PrintGraphPreviewDialog$InternalButtonListener implements ActionListener {
   // $FF: synthetic field
   final PrintGraphPreviewDialog this$0;

   private PrintGraphPreviewDialog$InternalButtonListener(PrintGraphPreviewDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource() != PrintGraphPreviewDialog.access$700(this.this$0) && var1.getSource() != PrintGraphPreviewDialog.access$400(this.this$0)) {
         if(var1.getSource() == PrintGraphPreviewDialog.access$800(this.this$0)) {
            PrintGraphOptionsDialog var2 = new PrintGraphOptionsDialog(this.this$0, PrintGraphPreviewDialog.access$900(this.this$0));
            if(var2.isOkPressed()) {
               PrintGraphPreviewDialog.access$1000(this.this$0).setPages(0, PrintGraphPreviewDialog.access$900(this.this$0).c(), PrintGraphPreviewDialog.access$900(this.this$0).c() * PrintGraphPreviewDialog.access$900(this.this$0).b());
            }
         }
      } else {
         this.this$0.dispose();
      }

   }

   // $FF: synthetic method
   PrintGraphPreviewDialog$InternalButtonListener(PrintGraphPreviewDialog var1, PrintGraphPreviewDialog$1 var2) {
      this(var1);
   }
}
