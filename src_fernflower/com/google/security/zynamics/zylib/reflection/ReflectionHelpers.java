package com.google.security.zynamics.zylib.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelpers {
   public static Object getField(Class var0, Object var1, String var2) {
      Field var3 = var0.getDeclaredField(var2);
      var3.setAccessible(true);
      return var3.get(var1);
   }

   public static Object getField(Object var0, String var1) {
      Class var2 = var0.getClass();
      Field var3 = var2.getDeclaredField(var1);
      var3.setAccessible(true);
      return var3.get(var0);
   }

   public static Method getMethod(Object var0, String var1, Class... var2) {
      Class var3 = var0.getClass();
      Class[] var4 = new Class[var2.length];
      int var5 = 0;
      Class[] var6 = var2;
      int var7 = var2.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         Class var9 = var6[var8];
         var4[var5++] = var9;
      }

      Method var10 = var3.getDeclaredMethod(var1, var4);
      return var10;
   }

   public static Object getMethod(Object var0, String var1, Object... var2) {
      Class var3 = var0.getClass();
      Class[] var4 = new Class[var2.length];
      int var5 = 0;
      Object[] var6 = var2;
      int var7 = var2.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         Object var9 = var6[var8];
         var4[var5++] = var9.getClass();
      }

      Method var10 = var3.getDeclaredMethod(var1, var4);
      return var10;
   }

   public static Object getStaticField(Class var0, String var1) {
      Field var2 = var0.getDeclaredField(var1);
      var2.setAccessible(true);
      return var2.get((Object)null);
   }
}
