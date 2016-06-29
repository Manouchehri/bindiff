package org.ibex.nestedvm.util;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.TimeZone;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

public abstract class Platform {
   private static final Platform p;
   static Class class$org$ibex$nestedvm$util$Platform;

   public static String getProperty(String var0) {
      try {
         return System.getProperty(var0);
      } catch (SecurityException var2) {
         return null;
      }
   }

   abstract boolean _atomicCreateFile(File var1);

   public static boolean atomicCreateFile(File var0) {
      return p._atomicCreateFile(var0);
   }

   abstract Seekable$Lock _lockFile(Seekable var1, RandomAccessFile var2, long var3, long var5, boolean var7);

   public static Seekable$Lock lockFile(Seekable var0, RandomAccessFile var1, long var2, long var4, boolean var6) {
      return p._lockFile(var0, var1, var2, var4, var6);
   }

   abstract void _socketHalfClose(Socket var1, boolean var2);

   public static void socketHalfClose(Socket var0, boolean var1) {
      p._socketHalfClose(var0, var1);
   }

   abstract void _socketSetKeepAlive(Socket var1, boolean var2);

   public static void socketSetKeepAlive(Socket var0, boolean var1) {
      p._socketSetKeepAlive(var0, var1);
   }

   abstract InetAddress _inetAddressFromBytes(byte[] var1);

   public static InetAddress inetAddressFromBytes(byte[] var0) {
      return p._inetAddressFromBytes(var0);
   }

   abstract String _timeZoneGetDisplayName(TimeZone var1, boolean var2, boolean var3, Locale var4);

   public static String timeZoneGetDisplayName(TimeZone var0, boolean var1, boolean var2, Locale var3) {
      return p._timeZoneGetDisplayName(var0, var1, var2, var3);
   }

   public static String timeZoneGetDisplayName(TimeZone var0, boolean var1, boolean var2) {
      return timeZoneGetDisplayName(var0, var1, var2, Locale.getDefault());
   }

   abstract void _setFileLength(RandomAccessFile var1, int var2);

   public static void setFileLength(RandomAccessFile var0, int var1) {
      p._setFileLength(var0, var1);
   }

   abstract File[] _listRoots();

   public static File[] listRoots() {
      return p._listRoots();
   }

   abstract File _getRoot(File var1);

   public static File getRoot(File var0) {
      return p._getRoot(var0);
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      float var0;
      try {
         if(getProperty("java.vm.name").equals("SableVM")) {
            var0 = 1.2F;
         } else {
            var0 = Float.valueOf(getProperty("java.specification.version")).floatValue();
         }
      } catch (Exception var4) {
         System.err.println("WARNING: " + var4 + " while trying to find jvm version -  assuming 1.1");
         var0 = 1.1F;
      }

      String var1;
      if(var0 >= 1.4F) {
         var1 = "Jdk14";
      } else if(var0 >= 1.3F) {
         var1 = "Jdk13";
      } else if(var0 >= 1.2F) {
         var1 = "Jdk12";
      } else {
         if(var0 < 1.1F) {
            throw new Error("JVM Specification version: " + var0 + " is too old. (see org.ibex.util.Platform to add support)");
         }

         var1 = "Jdk11";
      }

      try {
         p = (Platform)Class.forName((class$org$ibex$nestedvm$util$Platform == null?(class$org$ibex$nestedvm$util$Platform = class$("org.ibex.nestedvm.util.Platform")):class$org$ibex$nestedvm$util$Platform).getName() + "$" + var1).newInstance();
      } catch (Exception var3) {
         var3.printStackTrace();
         throw new Error("Error instansiating platform class");
      }
   }
}
