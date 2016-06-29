package org.jfree.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.jfree.util.ArrayUtilities;
import org.jfree.util.Log;
import org.jfree.util.PublicCloneable;

public final class ObjectUtilities {
   public static final String THREAD_CONTEXT = "ThreadContext";
   public static final String CLASS_CONTEXT = "ClassContext";
   private static String classLoaderSource = "ThreadContext";
   private static ClassLoader classLoader;
   static Class class$org$jfree$util$ObjectUtilities;

   public static String getClassLoaderSource() {
      return classLoaderSource;
   }

   public static void setClassLoaderSource(String var0) {
      classLoaderSource = var0;
   }

   public static boolean equal(Object var0, Object var1) {
      return var0 == var1?true:(var0 != null?var0.equals(var1):false);
   }

   public static int hashCode(Object var0) {
      int var1 = 0;
      if(var0 != null) {
         var1 = var0.hashCode();
      }

      return var1;
   }

   public static Object clone(Object var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'object\' argument.");
      } else if(var0 instanceof PublicCloneable) {
         PublicCloneable var5 = (PublicCloneable)var0;
         return var5.clone();
      } else {
         try {
            Method var1 = var0.getClass().getMethod("clone", (Class[])null);
            if(Modifier.isPublic(var1.getModifiers())) {
               return var1.invoke(var0, (Object[])null);
            }
         } catch (NoSuchMethodException var2) {
            Log.warn("Object without clone() method is impossible.");
         } catch (IllegalAccessException var3) {
            Log.warn("Object.clone(): unable to call method.");
         } catch (InvocationTargetException var4) {
            Log.warn("Object without clone() method is impossible.");
         }

         throw new CloneNotSupportedException("Failed to clone.");
      }
   }

   public static Collection deepClone(Collection var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'collection\' argument.");
      } else {
         Collection var1 = (Collection)clone(var0);
         var1.clear();
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            if(var3 != null) {
               var1.add(clone(var3));
            } else {
               var1.add((Object)null);
            }
         }

         return var1;
      }
   }

   public static synchronized void setClassLoader(ClassLoader var0) {
      classLoader = var0;
   }

   public static ClassLoader getClassLoader() {
      return classLoader;
   }

   public static synchronized ClassLoader getClassLoader(Class var0) {
      if(classLoader != null) {
         return classLoader;
      } else {
         ClassLoader var1;
         if("ThreadContext".equals(classLoaderSource)) {
            var1 = Thread.currentThread().getContextClassLoader();
            if(var1 != null) {
               return var1;
            }
         }

         var1 = var0.getClassLoader();
         return var1 == null?ClassLoader.getSystemClassLoader():var1;
      }
   }

   public static URL getResource(String var0, Class var1) {
      ClassLoader var2 = getClassLoader(var1);
      return var2 == null?null:var2.getResource(var0);
   }

   public static URL getResourceRelative(String var0, Class var1) {
      ClassLoader var2 = getClassLoader(var1);
      String var3 = convertName(var0, var1);
      return var2 == null?null:var2.getResource(var3);
   }

   private static String convertName(String var0, Class var1) {
      if(var0.startsWith("/")) {
         return var0.substring(1);
      } else {
         while(var1.isArray()) {
            var1 = var1.getComponentType();
         }

         String var2 = var1.getName();
         int var3 = var2.lastIndexOf(46);
         if(var3 == -1) {
            return var0;
         } else {
            String var4 = var2.substring(0, var3);
            return var4.replace('.', '/') + "/" + var0;
         }
      }
   }

   public static InputStream getResourceAsStream(String var0, Class var1) {
      URL var2 = getResource(var0, var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            return var2.openStream();
         } catch (IOException var4) {
            return null;
         }
      }
   }

   public static InputStream getResourceRelativeAsStream(String var0, Class var1) {
      URL var2 = getResourceRelative(var0, var1);
      if(var2 == null) {
         return null;
      } else {
         try {
            return var2.openStream();
         } catch (IOException var4) {
            return null;
         }
      }
   }

   public static Object loadAndInstantiate(String var0, Class var1) {
      try {
         ClassLoader var2 = getClassLoader(var1);
         Class var3 = var2.loadClass(var0);
         return var3.newInstance();
      } catch (Exception var4) {
         return null;
      }
   }

   public static Object loadAndInstantiate(String var0, Class var1, Class var2) {
      try {
         ClassLoader var3 = getClassLoader(var1);
         Class var4 = var3.loadClass(var0);
         return var2.isAssignableFrom(var4)?var4.newInstance():null;
      } catch (Exception var5) {
         return null;
      }
   }

   public static boolean isJDK14() {
      ClassLoader var0 = getClassLoader(class$org$jfree$util$ObjectUtilities == null?(class$org$jfree$util$ObjectUtilities = class$("org.jfree.util.ObjectUtilities")):class$org$jfree$util$ObjectUtilities);
      if(var0 != null) {
         try {
            var0.loadClass("java.util.RandomAccess");
            return true;
         } catch (ClassNotFoundException var5) {
            return false;
         } catch (Exception var6) {
            ;
         }
      }

      try {
         String var1 = System.getProperty("java.vm.specification.version");
         if(var1 == null) {
            return false;
         } else {
            String[] var2 = parseVersions(var1);
            String[] var3 = new String[]{"1", "4"};
            return ArrayUtilities.compareVersionArrays(var2, var3) >= 0;
         }
      } catch (Exception var4) {
         return false;
      }
   }

   private static String[] parseVersions(String var0) {
      if(var0 == null) {
         return new String[0];
      } else {
         ArrayList var1 = new ArrayList();
         StringTokenizer var2 = new StringTokenizer(var0, ".");

         while(var2.hasMoreTokens()) {
            var1.add(var2.nextToken());
         }

         return (String[])((String[])var1.toArray(new String[var1.size()]));
      }
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
