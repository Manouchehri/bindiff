package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables$1;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class Throwables {
   private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
   @VisibleForTesting
   static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
   @Nullable
   private static final Object jla = getJLA();
   @Nullable
   private static final Method getStackTraceElementMethod;
   @Nullable
   private static final Method getStackTraceDepthMethod;

   public static void propagateIfInstanceOf(@Nullable Throwable var0, Class var1) {
      if(var0 != null && var1.isInstance(var0)) {
         throw (Throwable)var1.cast(var0);
      }
   }

   public static void propagateIfPossible(@Nullable Throwable var0) {
      propagateIfInstanceOf(var0, Error.class);
      propagateIfInstanceOf(var0, RuntimeException.class);
   }

   public static void propagateIfPossible(@Nullable Throwable var0, Class var1) {
      propagateIfInstanceOf(var0, var1);
      propagateIfPossible(var0);
   }

   public static void propagateIfPossible(@Nullable Throwable var0, Class var1, Class var2) {
      Preconditions.checkNotNull(var2);
      propagateIfInstanceOf(var0, var1);
      propagateIfPossible(var0, var2);
   }

   public static RuntimeException propagate(Throwable var0) {
      propagateIfPossible((Throwable)Preconditions.checkNotNull(var0));
      throw new RuntimeException(var0);
   }

   @CheckReturnValue
   public static Throwable getRootCause(Throwable var0) {
      Throwable var1;
      while((var1 = var0.getCause()) != null) {
         var0 = var1;
      }

      return var0;
   }

   @CheckReturnValue
   @Beta
   public static List getCausalChain(Throwable var0) {
      Preconditions.checkNotNull(var0);

      ArrayList var1;
      for(var1 = new ArrayList(4); var0 != null; var0 = var0.getCause()) {
         var1.add(var0);
      }

      return Collections.unmodifiableList(var1);
   }

   @CheckReturnValue
   public static String getStackTraceAsString(Throwable var0) {
      StringWriter var1 = new StringWriter();
      var0.printStackTrace(new PrintWriter(var1));
      return var1.toString();
   }

   @CheckReturnValue
   @Beta
   public static List lazyStackTrace(Throwable var0) {
      return lazyStackTraceIsLazy()?jlaStackTrace(var0):Collections.unmodifiableList(Arrays.asList(var0.getStackTrace()));
   }

   @CheckReturnValue
   @Beta
   public static boolean lazyStackTraceIsLazy() {
      return getStackTraceElementMethod != null & getStackTraceDepthMethod != null;
   }

   private static List jlaStackTrace(Throwable var0) {
      Preconditions.checkNotNull(var0);
      return new Throwables$1(var0);
   }

   private static Object invokeAccessibleNonThrowingMethod(Method var0, Object var1, Object... var2) {
      try {
         return var0.invoke(var1, var2);
      } catch (IllegalAccessException var4) {
         throw new RuntimeException(var4);
      } catch (InvocationTargetException var5) {
         throw propagate(var5.getCause());
      }
   }

   @Nullable
   private static Object getJLA() {
      try {
         Class var0 = Class.forName("sun.misc.SharedSecrets", false, (ClassLoader)null);
         Method var1 = var0.getMethod("getJavaLangAccess", new Class[0]);
         return var1.invoke((Object)null, new Object[0]);
      } catch (ThreadDeath var2) {
         throw var2;
      } catch (Throwable var3) {
         return null;
      }
   }

   @Nullable
   private static Method getGetMethod() {
      return getJlaMethod("getStackTraceElement", new Class[]{Throwable.class, Integer.TYPE});
   }

   @Nullable
   private static Method getSizeMethod() {
      return getJlaMethod("getStackTraceDepth", new Class[]{Throwable.class});
   }

   @Nullable
   private static Method getJlaMethod(String var0, Class... var1) {
      try {
         return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader)null).getMethod(var0, var1);
      } catch (ThreadDeath var3) {
         throw var3;
      } catch (Throwable var4) {
         return null;
      }
   }

   // $FF: synthetic method
   static Method access$000() {
      return getStackTraceElementMethod;
   }

   // $FF: synthetic method
   static Object access$100() {
      return jla;
   }

   // $FF: synthetic method
   static Object access$200(Method var0, Object var1, Object[] var2) {
      return invokeAccessibleNonThrowingMethod(var0, var1, var2);
   }

   // $FF: synthetic method
   static Method access$300() {
      return getStackTraceDepthMethod;
   }

   static {
      getStackTraceElementMethod = jla == null?null:getGetMethod();
      getStackTraceDepthMethod = jla == null?null:getSizeMethod();
   }
}
