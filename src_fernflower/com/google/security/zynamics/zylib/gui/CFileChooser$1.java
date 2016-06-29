package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CFileChooser;
import java.io.File;
import javax.swing.filechooser.FileFilter;

class CFileChooser$1 extends FileFilter {
   // $FF: synthetic field
   final String val$fileExtension;
   // $FF: synthetic field
   final String val$fileDescription;
   // $FF: synthetic field
   final CFileChooser this$0;

   CFileChooser$1(CFileChooser var1, String var2, String var3) {
      this.this$0 = var1;
      this.val$fileExtension = var2;
      this.val$fileDescription = var3;
   }

   public boolean accept(File var1) {
      return "".equals(this.val$fileExtension)?var1.isDirectory() || var1.canExecute():var1.isDirectory() || var1.getName().toLowerCase().endsWith(this.val$fileExtension.toLowerCase()) || this.val$fileExtension.equals("*");
   }

   public String getDescription() {
      String var1 = this.val$fileDescription;
      String var2 = this.val$fileExtension;
      return (new StringBuilder(5 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(" (*.").append(var2).append(")").toString();
   }
}
