package com.google.security.zynamics.bindiff.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IoWriterUtils {
   public static void writeByteArrary(OutputStream var0, byte[] var1) {
      var0.write(var1);
   }

   public static void writeIntegerValue(OutputStream var0, int var1) {
      var0.write(var1 & 255);
      var0.write(var1 >>> 8 & 255);
      var0.write(var1 >>> 16 & 255);
      var0.write(var1 >>> 24);
   }

   public static void writeLongValue(OutputStream var0, long var1) {
      var0.write((int)(var1 & 255L));
      var0.write((int)(var1 >>> 8 & 255L));
      var0.write((int)(var1 >>> 16 & 255L));
      var0.write((int)(var1 >>> 24 & 255L));
      var0.write((int)(var1 >>> 32 & 255L));
      var0.write((int)(var1 >>> 40 & 255L));
      var0.write((int)(var1 >>> 48 & 255L));
      var0.write((int)(var1 >>> 56));
   }

   public static void writeNewZipFile(String var0, List var1) {
      byte[] var2 = new byte[1024];
      ZipOutputStream var3 = new ZipOutputStream(new FileOutputStream(var0));
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         File var5 = (File)var4.next();
         FileInputStream var6 = new FileInputStream(var5);
         var3.putNextEntry(new ZipEntry(var5.getName()));

         int var7;
         while((var7 = var6.read(var2)) > 0) {
            var3.write(var2, 0, var7);
         }

         var3.closeEntry();
         var6.close();
      }

      var3.finish();
      var3.close();
   }

   public static void writeShortValue(OutputStream var0, int var1) {
      if(var1 > 32767) {
         throw new IOException("Value out of range exception.");
      } else {
         var0.write(var1 & 255);
         var0.write(var1 >>> 8);
      }
   }

   public static void writeStringValue(OutputStream var0, String var1) {
      var0.write(var1.getBytes());
   }
}
