package com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels;

import com.google.security.zynamics.bindiff.gui.dialogs.mainsettings.panels.GeneralPanel;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.FileChooser.FileChooserPanel;
import com.google.security.zynamics.zylib.io.DirectoryChooser;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class GeneralPanel$InternalDirectoryListener implements ActionListener {
   final FileChooserPanel panel;
   final String title;
   // $FF: synthetic field
   final GeneralPanel this$0;

   public GeneralPanel$InternalDirectoryListener(GeneralPanel var1, FileChooserPanel var2, String var3) {
      this.this$0 = var1;
      this.panel = var2;
      this.title = var3;
   }

   private String selectDirectory(Container var1) {
      DirectoryChooser var2 = new DirectoryChooser(this.title);
      var2.setCurrentDirectory(new File(this.panel.getText()));
      if(var2.showOpenDialog(var1) == 0) {
         File var3 = var2.getSelectedFile();
         if(!var3.exists()) {
            CMessageBox.showError(var1, "Directory does not exist.");
            return null;
         } else if(!var3.canExecute()) {
            CMessageBox.showError(var1, "Directory is not executable.");
            return null;
         } else {
            return var3.getAbsolutePath();
         }
      } else {
         return null;
      }
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = this.selectDirectory(this.this$0.getParent());
      if(var2 != null) {
         this.panel.setText(var2);
      }

   }
}
