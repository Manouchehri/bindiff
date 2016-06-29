package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class NewDiffDialog$InternalSecondaryFileChooserListener implements ActionListener {
   // $FF: synthetic field
   final NewDiffDialog this$0;

   private NewDiffDialog$InternalSecondaryFileChooserListener(NewDiffDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      BinDiffConfigFile var2 = BinDiffConfigFile.getInstance();
      File var3 = NewDiffDialog.access$800(this.this$0, "Choose Secondary File", NewDiffDialog.access$600(this.this$0) == null?new File(var2.getMainSettings().getNewDiffLastSecondaryDir()):NewDiffDialog.access$600(this.this$0), NewDiffDialog.access$700());
      if(var3 != null) {
         NewDiffDialog.access$1100(this.this$0).setText(var3.getPath());
         NewDiffDialog.access$602(this.this$0, var3.getParentFile());
         var2.getMainSettings().setNewDiffLastSecondaryDir(NewDiffDialog.access$600(this.this$0).getPath());
      }

      NewDiffDialog.access$1000(this.this$0);
   }

   // $FF: synthetic method
   NewDiffDialog$InternalSecondaryFileChooserListener(NewDiffDialog var1, NewDiffDialog$1 var2) {
      this(var1);
   }
}
