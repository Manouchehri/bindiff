package org.ibex.nestedvm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormatSymbols;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.TimeZone;
import org.ibex.nestedvm.util.Platform;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

class Platform$Jdk11 extends Platform {
   boolean _atomicCreateFile(File var1) {
      if(var1.exists()) {
         return false;
      } else {
         (new FileOutputStream(var1)).close();
         return true;
      }
   }

   Seekable$Lock _lockFile(Seekable var1, RandomAccessFile var2, long var3, long var5, boolean var7) {
      throw new IOException("file locking requires jdk 1.4+");
   }

   void _socketHalfClose(Socket var1, boolean var2) {
      throw new IOException("half closing sockets not supported");
   }

   InetAddress _inetAddressFromBytes(byte[] var1) {
      if(var1.length != 4) {
         throw new UnknownHostException("only ipv4 addrs supported");
      } else {
         return InetAddress.getByName("" + (var1[0] & 255) + "." + (var1[1] & 255) + "." + (var1[2] & 255) + "." + (var1[3] & 255));
      }
   }

   void _socketSetKeepAlive(Socket var1, boolean var2) {
      if(var2) {
         throw new SocketException("keepalive not supported");
      }
   }

   String _timeZoneGetDisplayName(TimeZone var1, boolean var2, boolean var3, Locale var4) {
      String[][] var5 = (new DateFormatSymbols(var4)).getZoneStrings();
      String var6 = var1.getID();

      for(int var7 = 0; var7 < var5.length; ++var7) {
         if(var5[var7][0].equals(var6)) {
            return var5[var7][var2?(var3?3:4):(var3?1:2)];
         }
      }

      StringBuffer var9 = new StringBuffer("GMT");
      int var8 = var1.getRawOffset() / 1000;
      if(var8 < 0) {
         var9.append("-");
         var8 = -var8;
      } else {
         var9.append("+");
      }

      var9.append(var8 / 3600);
      var8 %= 3600;
      if(var8 > 0) {
         var9.append(":").append(var8 / 60);
      }

      var8 %= 60;
      if(var8 > 0) {
         var9.append(":").append(var8);
      }

      return var9.toString();
   }

   void _setFileLength(RandomAccessFile var1, int var2) {
      FileInputStream var3 = new FileInputStream(var1.getFD());
      FileOutputStream var4 = new FileOutputStream(var1.getFD());

      byte[] var5;
      int var6;
      for(var5 = new byte[1024]; var2 > 0; var2 -= var6) {
         var6 = var3.read(var5, 0, Math.min(var2, var5.length));
         if(var6 == -1) {
            break;
         }

         var4.write(var5, 0, var6);
      }

      if(var2 != 0) {
         for(var6 = 0; var6 < var5.length; ++var6) {
            var5[var6] = 0;
         }

         while(var2 > 0) {
            var4.write(var5, 0, Math.min(var2, var5.length));
            var2 -= var5.length;
         }

      }
   }

   RandomAccessFile _truncatedRandomAccessFile(File var1, String var2) {
      (new FileOutputStream(var1)).close();
      return new RandomAccessFile(var1, var2);
   }

   File[] _listRoots() {
      String[] var1 = new String[]{"java.home", "java.class.path", "java.library.path", "java.io.tmpdir", "java.ext.dirs", "user.home", "user.dir"};
      Hashtable var2 = new Hashtable();

      for(int var3 = 0; var3 < var1.length; ++var3) {
         String var4 = getProperty(var1[var3]);
         int var6;
         if(var4 != null) {
            do {
               String var5 = var4;
               if((var6 = var4.indexOf(File.pathSeparatorChar)) != -1) {
                  var5 = var4.substring(0, var6);
                  var4 = var4.substring(var6 + 1);
               }

               File var7 = getRoot(new File(var5));
               var2.put(var7, Boolean.TRUE);
            } while(var6 != -1);
         }
      }

      File[] var8 = new File[var2.size()];
      int var9 = 0;

      for(Enumeration var10 = var2.keys(); var10.hasMoreElements(); var8[var9++] = (File)var10.nextElement()) {
         ;
      }

      return var8;
   }

   File _getRoot(File var1) {
      if(!var1.isAbsolute()) {
         var1 = new File(var1.getAbsolutePath());
      }

      String var2;
      while((var2 = var1.getParent()) != null) {
         var1 = new File(var2);
      }

      if(var1.getPath().length() == 0) {
         var1 = new File("/");
      }

      return var1;
   }
}
