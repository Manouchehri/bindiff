package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.MessageBox;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SaveFunctionDiffViewDialog$InternalCheckboxListener implements ActionListener {
   // $FF: synthetic field
   final SaveFunctionDiffViewDialog this$0;

   private SaveFunctionDiffViewDialog$InternalCheckboxListener(SaveFunctionDiffViewDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource() == SaveFunctionDiffViewDialog.access$600(this.this$0) && SaveFunctionDiffViewDialog.access$600(this.this$0).isSelected() || var1.getSource() == SaveFunctionDiffViewDialog.access$700(this.this$0) && SaveFunctionDiffViewDialog.access$700(this.this$0).isSelected()) {
         MessageBox.showWarning(this.this$0, String.format("There is already a \'%s\' file with different content existing!\nIf you choose override make sure that the new and the existing disassembly are\nstructurally identical, e.g. only comments have been added or modified. Otherwise,\nexisting older saved views may not be loadable anymore!", new Object[]{this.this$0.getExportBinaryTargetFile(var1.getSource() == SaveFunctionDiffViewDialog.access$600(this.this$0)?ESide.PRIMARY:ESide.SECONDARY).getName()}));
      }

   }

   // $FF: synthetic method
   SaveFunctionDiffViewDialog$InternalCheckboxListener(SaveFunctionDiffViewDialog var1, SaveFunctionDiffViewDialog$1 var2) {
      this(var1);
   }
}
