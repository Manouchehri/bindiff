package com.google.security.zynamics.zylib.gui;

public class CFileChooser$FileExtension {
   private final String m_description;
   private final String[] m_extensions;

   public CFileChooser$FileExtension(String var1, String... var2) {
      this.m_description = var1;
      this.m_extensions = var2;
   }

   // $FF: synthetic method
   static String[] access$000(CFileChooser$FileExtension var0) {
      return var0.m_extensions;
   }

   // $FF: synthetic method
   static String access$100(CFileChooser$FileExtension var0) {
      return var0.m_description;
   }
}
