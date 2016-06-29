package org.jfree.io;

import java.io.File;
import java.util.StringTokenizer;

public class FileUtilities {
   public static File findFileOnClassPath(String var0) {
      String var1 = System.getProperty("java.class.path");
      String var2 = System.getProperty("path.separator");
      StringTokenizer var3 = new StringTokenizer(var1, var2);

      while(var3.hasMoreTokens()) {
         String var4 = var3.nextToken();
         File var5 = new File(var4);
         File var6 = var5.getAbsoluteFile();
         File var7;
         if(var6.isFile()) {
            var7 = new File(var6.getParent(), var0);
            if(var7.exists()) {
               return var7;
            }
         } else {
            var7 = new File(var5, var0);
            if(var7.exists()) {
               return var7;
            }
         }
      }

      return null;
   }
}
