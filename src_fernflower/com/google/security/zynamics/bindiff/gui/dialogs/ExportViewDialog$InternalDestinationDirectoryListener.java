package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ExportViewDialog$InternalDestinationDirectoryListener implements ActionListener {
   // $FF: synthetic field
   final ExportViewDialog this$0;

   private ExportViewDialog$InternalDestinationDirectoryListener(ExportViewDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = ExportViewDialog.access$700(this.this$0, ExportViewDialog.access$400(this.this$0));
      if(var2 != null) {
         ExportViewDialog.access$800(this.this$0).setText(var2);
      }

   }

   // $FF: synthetic method
   ExportViewDialog$InternalDestinationDirectoryListener(ExportViewDialog var1, ExportViewDialog$1 var2) {
      this(var1);
   }
}
