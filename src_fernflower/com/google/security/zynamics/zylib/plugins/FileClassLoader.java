package com.google.security.zynamics.zylib.plugins;

import com.google.security.zynamics.zylib.plugins.MultiClassLoader;

public class FileClassLoader extends MultiClassLoader {
   private final String filePrefix;

   public FileClassLoader(String var1) {
      this.filePrefix = var1;
   }

   protected byte[] loadClassBytes(String var1) {
      // $FF: Couldn't be decompiled
   }
}
