package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

public class SystemUtils {
   public static void createUserDirectoy() {
      File var0 = new File(SystemHelpers.getApplicationDataDirectory("BinDiff"));
      if(!var0.exists()) {
         var0.mkdir();
      }

   }

   public static File getBinDiffTempDirectory() {
      File var0 = new File(SystemHelpers.getTempDirectory("BinDiff"));
      if(!var0.exists() && !var0.mkdirs()) {
         throw new IOException("Failed to create zynamics BinDiff\'s temporary directory.");
      } else {
         return var0;
      }
   }

   public static String getCurrentUserPersonalFolder() {
      JFileChooser var0 = new JFileChooser();
      return var0.getFileSystemView().getDefaultDirectory().getPath();
   }
}
