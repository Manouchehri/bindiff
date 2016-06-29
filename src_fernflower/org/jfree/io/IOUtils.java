package org.jfree.io;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class IOUtils {
   private static IOUtils instance;

   public static IOUtils getInstance() {
      if(instance == null) {
         instance = new IOUtils();
      }

      return instance;
   }

   private boolean isFileStyleProtocol(URL var1) {
      return var1.getProtocol().equals("http")?true:(var1.getProtocol().equals("https")?true:(var1.getProtocol().equals("ftp")?true:(var1.getProtocol().equals("file")?true:var1.getProtocol().equals("jar"))));
   }

   private List parseName(String var1) {
      ArrayList var2 = new ArrayList();
      StringTokenizer var3 = new StringTokenizer(var1, "/");

      while(var3.hasMoreElements()) {
         String var4 = (String)var3.nextElement();
         if(var4.length() != 0) {
            var2.add(var4);
         }
      }

      return var2;
   }

   private String formatName(List var1, String var2) {
      StringBuffer var3 = new StringBuffer();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         var3.append(var4.next());
         if(var4.hasNext()) {
            var3.append("/");
         }
      }

      if(var2 != null) {
         var3.append('?');
         var3.append(var2);
      }

      return var3.toString();
   }

   private int startsWithUntil(List var1, List var2) {
      int var3 = Math.min(var2.size(), var1.size());

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = (String)var1.get(var4);
         String var6 = (String)var2.get(var4);
         if(!var5.equals(var6)) {
            return var4;
         }
      }

      return var3;
   }

   private boolean isSameService(URL var1, URL var2) {
      return !var1.getProtocol().equals(var2.getProtocol())?false:(!var1.getHost().equals(var2.getHost())?false:var1.getPort() == var2.getPort());
   }

   public String createRelativeURL(URL var1, URL var2) {
      if(var1 == null) {
         throw new NullPointerException("content url must not be null.");
      } else if(var2 == null) {
         throw new NullPointerException("baseURL must not be null.");
      } else if(this.isFileStyleProtocol(var1) && this.isSameService(var1, var2)) {
         List var3 = this.parseName(this.getPath(var1));
         List var4 = this.parseName(this.getPath(var2));
         String var5 = this.getQuery(var1);
         if(!this.isPath(var2)) {
            var4.remove(var4.size() - 1);
         }

         if(var1.equals(var2)) {
            return (String)var3.get(var3.size() - 1);
         } else {
            int var6 = this.startsWithUntil(var3, var4);
            if(var6 == 0) {
               return var1.toExternalForm();
            } else {
               if(var6 == var3.size()) {
                  --var6;
               }

               ArrayList var7 = new ArrayList();
               if(var4.size() >= var3.size()) {
                  int var8 = var4.size() - var6;

                  for(int var9 = 0; var9 < var8; ++var9) {
                     var7.add("..");
                  }
               }

               var7.addAll(var3.subList(var6, var3.size()));
               return this.formatName(var7, var5);
            }
         }
      } else {
         return var1.toExternalForm();
      }
   }

   private boolean isPath(URL var1) {
      if(this.getPath(var1).endsWith("/")) {
         return true;
      } else {
         if(var1.getProtocol().equals("file")) {
            File var2 = new File(this.getPath(var1));

            try {
               if(var2.isDirectory()) {
                  return true;
               }
            } catch (SecurityException var4) {
               ;
            }
         }

         return false;
      }
   }

   private String getQuery(URL var1) {
      String var2 = var1.getFile();
      int var3 = var2.indexOf(63);
      return var3 == -1?null:var2.substring(var3 + 1);
   }

   private String getPath(URL var1) {
      String var2 = var1.getFile();
      int var3 = var2.indexOf(63);
      return var3 == -1?var2:var2.substring(0, var3);
   }

   public void copyStreams(InputStream var1, OutputStream var2) {
      this.copyStreams(var1, var2, 4096);
   }

   public void copyStreams(InputStream var1, OutputStream var2, int var3) {
      byte[] var4 = new byte[var3];

      for(int var5 = var1.read(var4); var5 > -1; var5 = var1.read(var4)) {
         var2.write(var4, 0, var5);
      }

   }

   public void copyWriter(Reader var1, Writer var2) {
      this.copyWriter(var1, var2, 4096);
   }

   public void copyWriter(Reader var1, Writer var2, int var3) {
      char[] var4 = new char[var3];

      for(int var5 = var1.read(var4); var5 > -1; var5 = var1.read(var4)) {
         var2.write(var4, 0, var5);
      }

   }

   public String getFileName(URL var1) {
      String var2 = var1.getFile();
      int var3 = var2.lastIndexOf("/");
      return var3 < 0?var2:var2.substring(var3);
   }

   public String stripFileExtension(String var1) {
      int var2 = var1.lastIndexOf(".");
      return var2 < 1?var1:var1.substring(0, var2);
   }

   public String getFileExtension(String var1) {
      int var2 = var1.lastIndexOf(".");
      return var2 < 1?"":var1.substring(var2);
   }

   public boolean isSubDirectory(File var1, File var2) {
      var1 = var1.getCanonicalFile();
      var2 = var2.getCanonicalFile();

      for(File var3 = var2; var3 != null; var3 = var3.getParentFile()) {
         if(var1.equals(var3)) {
            return true;
         }
      }

      return false;
   }
}
