package com.google.security.zynamics.zylib.io;

import com.google.security.zynamics.zylib.gui.CFileChooser;
import java.io.File;

public class DirectoryChooser extends CFileChooser {
   private static final long serialVersionUID = 5354437749644373707L;

   public DirectoryChooser(String var1) {
      this.setCurrentDirectory(new File("."));
      this.setDialogTitle(var1);
      this.setFileSelectionMode(1);
      this.setAcceptAllFileFilterUsed(false);
   }
}
