package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.components.MessageBox;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog$1;
import com.google.security.zynamics.bindiff.log.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class SaveFunctionDiffViewDialog$InternalButtonListener implements ActionListener {
   // $FF: synthetic field
   final SaveFunctionDiffViewDialog this$0;

   private SaveFunctionDiffViewDialog$InternalButtonListener(SaveFunctionDiffViewDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource() == SaveFunctionDiffViewDialog.access$300(this.this$0)) {
         try {
            if(!SaveFunctionDiffViewDialog.access$400(this.this$0)) {
               return;
            }

            SaveFunctionDiffViewDialog.access$502(this.this$0, true);
         } catch (IOException var3) {
            Logger.logSevere("Save function diff view failed. Couldn\'t calculate source BinExport MD5.", new Object[0]);
            MessageBox.showError(this.this$0.getParent(), "Save function diff view failed. Couldn\'t calculate source BinExport MD5.");
            return;
         }
      }

      this.this$0.dispose();
   }

   // $FF: synthetic method
   SaveFunctionDiffViewDialog$InternalButtonListener(SaveFunctionDiffViewDialog var1, SaveFunctionDiffViewDialog$1 var2) {
      this(var1);
   }
}
