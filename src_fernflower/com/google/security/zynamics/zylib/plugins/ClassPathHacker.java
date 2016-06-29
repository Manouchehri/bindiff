package com.google.security.zynamics.zylib.plugins;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassPathHacker {
   private static final Class[] parameters = new Class[]{URL.class};

   public static void addFile(File var0) {
      try {
         addURL(var0.toURI().toURL());
      } catch (MalformedURLException var2) {
         assert false : "Malformed URL from toURI()";
      }

   }

   public static void addFile(String var0) {
      File var1 = new File(var0);
      addFile(var1);
   }

   public static void addURL(URL var0) {
      URLClassLoader var1 = (URLClassLoader)ClassLoader.getSystemClassLoader();

      try {
         Method var2 = URLClassLoader.class.getDeclaredMethod("addURL", parameters);
         var2.setAccessible(true);
         var2.invoke(var1, new Object[]{var0});
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }
}
