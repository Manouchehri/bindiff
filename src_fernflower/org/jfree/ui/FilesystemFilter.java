package org.jfree.ui;

import java.io.File;
import java.io.FilenameFilter;
import javax.swing.filechooser.FileFilter;

public class FilesystemFilter extends FileFilter implements FilenameFilter {
   private String[] fileext;
   private String descr;
   private boolean accDirs;

   public FilesystemFilter(String var1, String var2) {
      this(var1, var2, true);
   }

   public FilesystemFilter(String var1, String var2, boolean var3) {
      this(new String[]{var1}, var2, var3);
   }

   public FilesystemFilter(String[] var1, String var2, boolean var3) {
      this.fileext = (String[])((String[])var1.clone());
      this.descr = var2;
      this.accDirs = var3;
   }

   public boolean accept(File var1, String var2) {
      File var3 = new File(var1, var2);
      if(var3.isDirectory() && this.acceptsDirectories()) {
         return true;
      } else {
         for(int var4 = 0; var4 < this.fileext.length; ++var4) {
            if(var2.endsWith(this.fileext[var4])) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean accept(File var1) {
      if(var1.isDirectory() && this.acceptsDirectories()) {
         return true;
      } else {
         for(int var2 = 0; var2 < this.fileext.length; ++var2) {
            if(var1.getName().endsWith(this.fileext[var2])) {
               return true;
            }
         }

         return false;
      }
   }

   public String getDescription() {
      return this.descr;
   }

   public void acceptDirectories(boolean var1) {
      this.accDirs = var1;
   }

   public boolean acceptsDirectories() {
      return this.accDirs;
   }
}
