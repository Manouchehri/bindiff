package com.google.security.zynamics.zylib.plugins;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public final class JarResources {
   private final Hashtable htSizes = new Hashtable();
   private final Hashtable htJarContents = new Hashtable();
   private final String jarFileName;
   public boolean debugOn = false;

   public JarResources(String var1) {
      this.jarFileName = var1;
      this.init();
   }

   private String dumpZipEntry(ZipEntry var1) {
      StringBuffer var2 = new StringBuffer();
      if(var1.isDirectory()) {
         var2.append("d ");
      } else {
         var2.append("f ");
      }

      if(var1.getMethod() == 0) {
         var2.append("stored   ");
      } else {
         var2.append("defalted ");
      }

      var2.append(var1.getName());
      var2.append("\t");
      long var3 = var1.getSize();
      var2.append((new StringBuilder(20)).append(var3).toString());
      if(var1.getMethod() == 8) {
         var3 = var1.getCompressedSize();
         var2.append((new StringBuilder(21)).append("/").append(var3).toString());
      }

      return var2.toString();
   }

   private void init() {
      try {
         ZipFile var1 = new ZipFile(this.jarFileName);

         ZipEntry var3;
         for(Enumeration var2 = var1.entries(); var2.hasMoreElements(); this.htSizes.put(var3.getName(), Integer.valueOf((int)var3.getSize()))) {
            var3 = (ZipEntry)var2.nextElement();
            if(this.debugOn) {
               System.out.println(this.dumpZipEntry(var3));
            }
         }

         var1.close();
         FileInputStream var19 = new FileInputStream(this.jarFileName);
         BufferedInputStream var4 = new BufferedInputStream(var19);
         ZipInputStream var5 = new ZipInputStream(var4);
         ZipEntry var6 = null;

         while(true) {
            do {
               if((var6 = var5.getNextEntry()) == null) {
                  var5.close();
                  return;
               }
            } while(var6.isDirectory());

            PrintStream var10000;
            if(this.debugOn) {
               var10000 = System.out;
               String var7 = String.valueOf(var6.getName());
               long var8 = var6.getSize();
               var10000.println((new StringBuilder(44 + String.valueOf(var7).length())).append("ze.getName()=").append(var7).append(",").append("getSize()=").append(var8).toString());
            }

            int var20 = (int)var6.getSize();
            if(var20 == -1) {
               var20 = ((Integer)this.htSizes.get(var6.getName())).intValue();
            }

            byte[] var21 = new byte[var20];
            int var9 = 0;

            int var22;
            for(boolean var10 = false; var20 - var9 > 0; var9 += var22) {
               var22 = var5.read(var21, var9, var20 - var9);
               if(var22 == -1) {
                  break;
               }
            }

            this.htJarContents.put(var6.getName(), var21);
            if(this.debugOn) {
               var10000 = System.out;
               String var11 = String.valueOf(var6.getName());
               long var14 = var6.getCompressedSize();
               var10000.println((new StringBuilder(60 + String.valueOf(var11).length())).append(var11).append("  rb=").append(var9).append(",size=").append(var20).append(",csize=").append(var14).toString());
            }
         }
      } catch (NullPointerException var16) {
         System.out.println("done.");
      } catch (FileNotFoundException var17) {
         var17.printStackTrace();
      } catch (IOException var18) {
         var18.printStackTrace();
      }

   }

   public byte[] getResource(String var1) {
      return (byte[])this.htJarContents.get(var1);
   }
}
