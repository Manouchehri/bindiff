package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.NewWorkspaceDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewWorkspaceDialog$1;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.io.DirectoryChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class NewWorkspaceDialog$InternalActionListener implements ActionListener {
   // $FF: synthetic field
   final NewWorkspaceDialog this$0;

   private NewWorkspaceDialog$InternalActionListener(NewWorkspaceDialog var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if(var1.getSource() == NewWorkspaceDialog.access$100(this.this$0).getButton()) {
         DirectoryChooser var2 = new DirectoryChooser("Select workspace location");
         var2.setSelectedFile(new File(NewWorkspaceDialog.access$100(this.this$0).getText()));
         if(var2.showOpenDialog(this.this$0) == 0) {
            File var3 = var2.getSelectedFile();
            if(var3.exists()) {
               NewWorkspaceDialog.access$100(this.this$0).setText(var2.getSelectedFile().getAbsolutePath());
            } else {
               CMessageBox.showError(var2, "Workspace directory does not exist. Please choose a valid one.");
            }
         }

      } else {
         if(var1.getSource() == NewWorkspaceDialog.access$200(this.this$0)) {
            if(!NewWorkspaceDialog.access$300(this.this$0)) {
               return;
            }

            NewWorkspaceDialog.access$402(this.this$0, true);
         }

         this.this$0.dispose();
      }
   }

   // $FF: synthetic method
   NewWorkspaceDialog$InternalActionListener(NewWorkspaceDialog var1, NewWorkspaceDialog$1 var2) {
      this(var1);
   }
}
