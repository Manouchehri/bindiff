package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import com.google.common.io.Files;
import com.google.common.io.ZipFiles$1;
import com.google.common.io.ZipFiles$ZipEntryByteSource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

@GoogleInternal
public final class ZipFiles {
   public static ByteSource asByteSource(ZipFile var0, ZipEntry var1) {
      return new ZipFiles$ZipEntryByteSource(var0, var1);
   }

   public static CharSource asCharSource(ZipFile var0, ZipEntry var1, Charset var2) {
      return asByteSource(var0, var1).asCharSource(var2);
   }

   public static FluentIterable entries(ZipFile var0) {
      Preconditions.checkNotNull(var0);
      return new ZipFiles$1(var0);
   }

   public static void unzipFile(File var0, File var1) {
      // $FF: Couldn't be decompiled
   }

   private static void checkName(String var0) {
      // $FF: Couldn't be decompiled
   }

   public static void zipDirectory(File var0, File var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(var0.isDirectory(), "%s is not a valid directory", new Object[]{var0.getAbsolutePath()});
      Preconditions.checkArgument(!var1.exists(), "%s does already exist, files are not being overwritten", new Object[]{var1.getAbsolutePath()});
      Closer var2 = Closer.create();

      try {
         OutputStream var3 = (OutputStream)var2.register(new BufferedOutputStream(new FileOutputStream(var1)));
         zipDirectory(var0, var3);
      } catch (Throwable var7) {
         throw var2.rethrow(var7);
      } finally {
         var2.close();
      }

   }

   public static void zipDirectory(File var0, OutputStream var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(var0.isDirectory(), "%s is not a valid directory", new Object[]{var0.getAbsolutePath()});
      ZipOutputStream var2 = new ZipOutputStream(var1);
      File[] var3 = var0.listFiles();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         File var6 = var3[var5];
         zipDirectoryInternal(var6, "", var2);
      }

      var2.finish();
   }

   private static void zipDirectoryInternal(File var0, String var1, ZipOutputStream var2) {
      String var3;
      if("".equals(var1)) {
         var3 = var0.getName();
      } else {
         String var4 = String.valueOf(var0.getName());
         var3 = (new StringBuilder(1 + String.valueOf(var1).length() + String.valueOf(var4).length())).append(var1).append("/").append(var4).toString();
      }

      ZipEntry var8;
      if(var0.isDirectory()) {
         if(var0.list().length == 0) {
            var8 = new ZipEntry(String.valueOf(var3).concat("/"));
            var2.putNextEntry(var8);
         } else {
            File[] var9 = var0.listFiles();
            int var5 = var9.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               File var7 = var9[var6];
               zipDirectoryInternal(var7, var3, var2);
            }
         }
      } else {
         var8 = new ZipEntry(var3);
         var2.putNextEntry(var8);
         Files.asByteSource(var0).copyTo((OutputStream)var2);
      }

   }
}
