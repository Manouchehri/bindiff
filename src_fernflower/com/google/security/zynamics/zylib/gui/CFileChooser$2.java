package com.google.security.zynamics.zylib.gui;

import java.io.File;
import java.io.FilenameFilter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

final class CFileChooser$2 implements FilenameFilter {
   // $FF: synthetic field
   final JFileChooser val$chooser;

   CFileChooser$2(JFileChooser var1) {
      this.val$chooser = var1;
   }

   public boolean accept(File var1, String var2) {
      FileFilter var10000 = this.val$chooser.getFileFilter();
      String var3 = String.valueOf(var1.getPath());
      String var4 = String.valueOf(File.pathSeparator);
      return var10000.accept(new File((new StringBuilder(0 + String.valueOf(var3).length() + String.valueOf(var4).length() + String.valueOf(var2).length())).append(var3).append(var4).append(var2).toString()));
   }
}
