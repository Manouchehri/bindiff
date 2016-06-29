package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog$1;
import java.io.IOException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class SaveFunctionDiffViewDialog$InternalDocumentListener implements DocumentListener {
   // $FF: synthetic field
   final SaveFunctionDiffViewDialog this$0;

   private SaveFunctionDiffViewDialog$InternalDocumentListener(SaveFunctionDiffViewDialog var1) {
      this.this$0 = var1;
   }

   private void update() {
      try {
         SaveFunctionDiffViewDialog.access$800(this.this$0);
      } catch (IOException var2) {
         ;
      }

   }

   public void changedUpdate(DocumentEvent var1) {
      this.update();
   }

   public void insertUpdate(DocumentEvent var1) {
      this.update();
   }

   public void removeUpdate(DocumentEvent var1) {
      this.update();
   }

   // $FF: synthetic method
   SaveFunctionDiffViewDialog$InternalDocumentListener(SaveFunctionDiffViewDialog var1, SaveFunctionDiffViewDialog$1 var2) {
      this(var1);
   }
}
