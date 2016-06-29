package com.google.security.zynamics.zylib.io;

import com.google.security.zynamics.zylib.io.IDirectoryTraversalCallback;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class DirUtils {
   public static void traverse(File var0, IDirectoryTraversalCallback var1) {
      traverse(var0, var1, true);
   }

   public static void traverse(File var0, IDirectoryTraversalCallback var1, boolean var2) {
      File[] var3 = var0.listFiles();
      if(var3 != null) {
         var1.entering(var0);
         File[] var4 = var3;
         int var5 = var3.length;

         int var6;
         File var7;
         for(var6 = 0; var6 < var5; ++var6) {
            var7 = var4[var6];
            if(!var7.isDirectory()) {
               var1.nextFile(var7);
            }
         }

         if(var2) {
            var4 = var3;
            var5 = var3.length;

            for(var6 = 0; var6 < var5; ++var6) {
               var7 = var4[var6];
               if(var7.isDirectory()) {
                  traverse(var7, var1);
               }
            }
         }

         var1.leaving(var0);
      }
   }

   public static void traverse(File var0, IDirectoryTraversalCallback var1, Comparator var2) {
      File[] var3 = var0.listFiles();
      if(var3 != null) {
         Arrays.sort(var3, var2);
         var1.entering(var0);
         File[] var4 = var3;
         int var5 = var3.length;

         int var6;
         File var7;
         for(var6 = 0; var6 < var5; ++var6) {
            var7 = var4[var6];
            if(!var7.isDirectory()) {
               var1.nextFile(var7);
            }
         }

         var4 = var3;
         var5 = var3.length;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = var4[var6];
            if(var7.isDirectory()) {
               traverse(var7, var1);
            }
         }

         var1.leaving(var0);
      }
   }
}
