package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CFileChooser;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import javax.swing.filechooser.FileFilter;

class CFileChooser$CFileNameExtensionFilter extends FileFilter {
   private final List m_fileExtensions;
   private final String m_fileDescription;
   // $FF: synthetic field
   final CFileChooser this$0;

   public CFileChooser$CFileNameExtensionFilter(CFileChooser var1, List var2, String var3) {
      this.this$0 = var1;
      this.m_fileExtensions = var2;
      this.m_fileDescription = var3;
   }

   public boolean accept(File var1) {
      boolean var2 = false;
      String var3 = var1.getName().toLowerCase();
      Iterator var4 = this.m_fileExtensions.iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         var2 = var3.endsWith(var5.toLowerCase());
         if(var2) {
            break;
         }
      }

      return var2 || var1.isDirectory();
   }

   public String getDescription() {
      return this.m_fileDescription;
   }
}
