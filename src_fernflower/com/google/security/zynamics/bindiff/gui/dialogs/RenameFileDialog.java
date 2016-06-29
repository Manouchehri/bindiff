package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.RenameFileDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.RenameFileDialog$InternalActionListener;
import com.google.security.zynamics.zylib.gui.CFilenameFormatter;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.awt.BorderLayout;
import java.awt.Window;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class RenameFileDialog extends BaseDialog {
   private final RenameFileDialog$InternalActionListener buttonListener = new RenameFileDialog$InternalActionListener(this, (RenameFileDialog$1)null);
   private final JFormattedTextField nameField = new JFormattedTextField(new CFilenameFormatter(new File(SystemHelpers.getApplicationDataDirectory())));
   private final String borderTitle;
   private final String extension;
   private final JButton ok = new JButton("Ok");
   private final JButton cancel = new JButton("Cancel");
   private boolean okPressed = false;

   public RenameFileDialog(Window var1, String var2, String var3, String var4, String var5) {
      super(var1, var2);
      this.extension = var5;
      this.borderTitle = var3;
      this.setDefaultText(var4);
      this.init();
   }

   private void setDefaultText(String var1) {
      String var2 = "";

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         String var4 = this.nameField.getText();
         char var6;
         if(var4.equals("")) {
            var6 = var1.charAt(var3);
            var4 = (new StringBuilder(1 + String.valueOf(var2).length())).append(var2).append(var6).toString();
         } else {
            String var5 = String.valueOf(var4);
            var6 = var1.charAt(var3);
            var4 = (new StringBuilder(1 + String.valueOf(var5).length())).append(var5).append(var6).toString();
         }

         this.nameField.setText(var4);
         if(!this.nameField.getText().equals("")) {
            var2 = var4;
         }
      }

   }

   private void init() {
      // $FF: Couldn't be decompiled
   }

   public void dispose() {
      this.ok.removeActionListener(this.buttonListener);
      this.cancel.removeActionListener(this.buttonListener);
      super.dispose();
   }

   public String getFileName(boolean var1) {
      // $FF: Couldn't be decompiled
   }

   public boolean isOkPressed() {
      return this.okPressed;
   }

   public void setVisible(boolean var1) {
      if(var1) {
         this.ok.addActionListener(this.buttonListener);
         this.cancel.addActionListener(this.buttonListener);
         this.okPressed = false;
      }

      super.setVisible(var1);
   }

   // $FF: synthetic method
   static boolean access$102(RenameFileDialog var0, boolean var1) {
      return var0.okPressed = var1;
   }

   // $FF: synthetic method
   static JButton access$200(RenameFileDialog var0) {
      return var0.ok;
   }
}
