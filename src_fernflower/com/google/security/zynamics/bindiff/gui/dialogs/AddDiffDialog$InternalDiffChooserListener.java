package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class AddDiffDialog$InternalDiffChooserListener implements ActionListener {
   // $FF: synthetic field
   final AddDiffDialog this$0;

   private AddDiffDialog$InternalDiffChooserListener(AddDiffDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      BinDiffConfigFile var2 = BinDiffConfigFile.getInstance();
      File var3 = AddDiffDialog.access$500(this.this$0, "Choose Diff", new File(var2.getMainSettings().getAddExistingDiffLastDir()));
      if(var3 != null && var3.exists()) {
         AddDiffDialog.access$600(this.this$0).setText(var3.getPath());
         var2.getMainSettings().setAddExistingDiffLastDir(var3.getParent());
         AddDiffDialog.access$700(this.this$0);
      }

   }

   // $FF: synthetic method
   AddDiffDialog$InternalDiffChooserListener(AddDiffDialog var1, AddDiffDialog$1 var2) {
      this(var1);
   }
}
