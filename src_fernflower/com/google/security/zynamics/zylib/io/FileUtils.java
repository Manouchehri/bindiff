package com.google.security.zynamics.zylib.io;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.io.StreamUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class FileUtils {
   public static String calcMD5(File var0) {
      FileInputStream var1 = new FileInputStream(var0);
      byte[] var2 = new byte[(int)var0.length()];
      var1.read(var2);
      var1.close();

      MessageDigest var3;
      try {
         var3 = MessageDigest.getInstance("MD5");
      } catch (NoSuchAlgorithmException var10) {
         assert false : "MD5 not in list of algorithms";

         throw new RuntimeException(var10);
      }

      var3.update(var2);
      byte[] var4 = var3.digest();
      StringBuilder var5 = new StringBuilder();
      byte[] var6 = var4;
      int var7 = var4.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         byte var9 = var6[var8];
         var5.append(String.format("%02X", new Object[]{Byte.valueOf(var9)}));
      }

      return var5.toString();
   }

   public static boolean containsDirectory(File var0, String var1) {
      if(var0 != null && var0.isDirectory()) {
         File[] var2 = var0.listFiles();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            File var5 = var2[var4];
            if(var5.isDirectory() && var5.getName().equals(var1)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static boolean containsFile(File var0, String var1) {
      if(var0 != null && var0.isDirectory()) {
         File[] var2 = var0.listFiles();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            File var5 = var2[var4];
            if(var5.getName().equals(var1)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static boolean createDirectory(String var0) {
      return (new File(var0)).mkdirs();
   }

   public static String ensureTrailingSlash(String var0) {
      if(var0 != null && !var0.equals("")) {
         StringBuilder var1 = new StringBuilder(var0);

         while(var1.charAt(var1.length() - 1) == File.separatorChar) {
            var1.deleteCharAt(var1.length() - 1);
         }

         return var1.append(File.separatorChar).toString();
      } else {
         return "";
      }
   }

   public static boolean exists(String var0) {
      return (new File(var0)).exists();
   }

   public static String extractNameFromPath(String var0) {
      return (new File(var0)).getName();
   }

   public static String findLocalRootPath(Class var0) {
      // $FF: Couldn't be decompiled
   }

   public static String getFileBasename(File var0) {
      String var1 = var0.getName();
      int var2 = var1.lastIndexOf(".");
      return var2 == -1?var1:var1.substring(0, var2);
   }

   public static String getFileExtension(File var0) {
      String var1 = var0.getAbsolutePath();
      return var1.substring(var1.lastIndexOf(".") + 1);
   }

   public static String getPathEllipsis(String var0, int var1) {
      return getPathEllipsis(var0, var1, "...");
   }

   public static String getPathEllipsis(String var0, int var1, String var2) {
      int var3 = var0.length();
      int var4 = var2.length();
      Preconditions.checkArgument(var1 >= 4 * var4, "Maximum length too short");
      if(var3 <= var1) {
         return var0;
      } else {
         int var5 = 0;
         char var6 = File.separatorChar;

         boolean var7;
         for(var7 = false; !var7 && var5 < var3; ++var5) {
            var6 = var0.charAt(var5);
            var7 = var6 == 47 || var6 == 92;
         }

         StringBuilder var8 = new StringBuilder();
         if(!var7) {
            var8.append(var0.substring(0, var1 - var4));
            var8.append(var2);
         } else {
            int var9 = var0.lastIndexOf(var6);
            int var10 = var1 - (var3 - var9);
            int var11 = var10 / 2 - var4 / 2;
            if(var11 > 0) {
               var8.append(var0.substring(0, var11 - var4 % 2 + var10 % 2));
               var8.append(var2);
               var8.append(var0.substring(var9 - var11 + var4 % 2));
            } else {
               var8.append(var0.substring(0, 3));
               var8.append(var2);
               var8.append(var0.substring(var9, var9 + var1 - 3 - 2 * var4));
               var8.append(var2);
            }
         }

         return var8.toString();
      }
   }

   public static String readTextfile(File var0) {
      StringBuffer var1 = new StringBuffer();
      BufferedReader var2 = new BufferedReader(new FileReader(var0));
      String var3 = System.getProperty("line.separator");

      try {
         String var4 = null;

         while((var4 = var2.readLine()) != null) {
            var1.append(var4);
            var1.append(var3);
         }
      } finally {
         var2.close();
      }

      return var1.toString();
   }

   public static String readTextfile(String var0) {
      return readTextfile(new File(var0));
   }

   public static List readTextfileLines(File var0) {
      return StreamUtils.readLinesFromReader(new FileReader(var0));
   }

   public static void writeBinaryFile(File var0, byte[] var1) {
      FileOutputStream var2 = new FileOutputStream(var0);

      try {
         var2.write(var1);
      } finally {
         var2.close();
      }

   }

   public static void writeTextFile(File var0, String var1) {
      Preconditions.checkNotNull(var0, "Error: file argument can not be null");
      Preconditions.checkNotNull(var1, "Error: text argument can not be null");
      BufferedWriter var2 = new BufferedWriter(new FileWriter(var0));

      try {
         var2.write(var1);
      } finally {
         var2.close();
      }

   }
}
