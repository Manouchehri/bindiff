package org.jfree.ui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ExtensionFileFilter extends FileFilter {
   private String description;
   private String extension;

   public ExtensionFileFilter(String var1, String var2) {
      this.description = var1;
      this.extension = var2;
   }

   public boolean accept(File var1) {
      if(var1.isDirectory()) {
         return true;
      } else {
         String var2 = var1.getName().toLowerCase();
         return var2.endsWith(this.extension);
      }
   }

   public String getDescription() {
      return this.description;
   }
}
