package com.google.security.zynamics.bindiff.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CFileUtils {
   public static String addLastFileSeparator(String var0) {
      // $FF: Couldn't be decompiled
   }

   public static String concatToFileName(String... var0) {
      // $FF: Couldn't be decompiled
   }

   public static void deleteDirectory(File var0) {
      // $FF: Couldn't be decompiled
   }

   public static List findFiles(File var0, List var1) {
      // $FF: Couldn't be decompiled
   }

   public static String forceFilenameEndsNotWithExtension(String var0, String var1) {
      // $FF: Couldn't be decompiled
   }

   public static String forceFilenameEndsWithExtension(String var0, String var1) {
      // $FF: Couldn't be decompiled
   }

   public static String forceFileSeparators(String var0) {
      return var0.replace(File.separator.equals("/")?"\\":"/", File.separator);
   }

   public static String getFileExtension(String var0) {
      int var1 = var0.lastIndexOf(".");
      return var1 >= 1 && var1 != var0.length() - 1?var0.substring(var1 + 1):"";
   }

   public static boolean hasFileExtension(String var0, String var1) {
      return getFileExtension(var0).equals(var1);
   }

   public static void moveFile(File var0, File var1) {
      if(!var0.exists()) {
         throw new IOException("Source file does not exist.");
      } else if(!var1.exists()) {
         throw new IOException("Destination directory does not exist.");
      } else {
         boolean var2 = var0.renameTo(new File(var1, var0.getName()));
         if(!var2) {
            throw new IOException("Move file failed.");
         }
      }
   }

   public static String removeFileExtension(String var0) {
      int var1 = var0.lastIndexOf(".");
      return var1 < 1?var0:var0.substring(0, var1);
   }

   public static String removeLastFileSeparator(String var0) {
      if(var0 != null && !var0.isEmpty()) {
         String var1 = forceFileSeparators(var0);
         int var2 = var1.lastIndexOf(File.separator);
         return var2 == var1.length() - 1?var1.substring(var2, var1.length() - 1):var1;
      } else {
         return var0;
      }
   }
}
