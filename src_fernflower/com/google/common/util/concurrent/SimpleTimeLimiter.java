package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.SimpleTimeLimiter$1;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public final class SimpleTimeLimiter implements TimeLimiter {
   private final ExecutorService executor;

   public SimpleTimeLimiter(ExecutorService var1) {
      this.executor = (ExecutorService)Preconditions.checkNotNull(var1);
   }

   public SimpleTimeLimiter() {
      this(Executors.newCachedThreadPool());
   }

   public Object newProxy(Object var1, Class var2, long var3, TimeUnit var5) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var5);
      Preconditions.checkArgument(var3 > 0L, "bad timeout: %s", new Object[]{Long.valueOf(var3)});
      Preconditions.checkArgument(var2.isInterface(), "interfaceType must be an interface type");
      Set var6 = findInterruptibleMethods(var2);
      SimpleTimeLimiter$1 var7 = new SimpleTimeLimiter$1(this, var1, var3, var5, var6);
      return newProxy(var2, var7);
   }

   public Object callWithTimeout(Callable var1, long var2, TimeUnit var4, boolean var5) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var4);
      Preconditions.checkArgument(var2 > 0L, "timeout must be positive: %s", new Object[]{Long.valueOf(var2)});
      Future var6 = this.executor.submit(var1);

      try {
         if(var5) {
            try {
               return var6.get(var2, var4);
            } catch (InterruptedException var8) {
               var6.cancel(true);
               throw var8;
            }
         } else {
            return Uninterruptibles.getUninterruptibly(var6, var2, var4);
         }
      } catch (ExecutionException var9) {
         throw throwCause(var9, true);
      } catch (TimeoutException var10) {
         var6.cancel(true);
         throw new UncheckedTimeoutException(var10);
      }
   }

   private static Exception throwCause(Exception var0, boolean var1) {
      Throwable var2 = var0.getCause();
      if(var2 == null) {
         throw var0;
      } else {
         if(var1) {
            StackTraceElement[] var3 = (StackTraceElement[])ObjectArrays.concat(var2.getStackTrace(), var0.getStackTrace(), StackTraceElement.class);
            var2.setStackTrace(var3);
         }

         if(var2 instanceof Exception) {
            throw (Exception)var2;
         } else if(var2 instanceof Error) {
            throw (Error)var2;
         } else {
            throw var0;
         }
      }
   }

   private static Set findInterruptibleMethods(Class var0) {
      HashSet var1 = Sets.newHashSet();
      Method[] var2 = var0.getMethods();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Method var5 = var2[var4];
         if(declaresInterruptedEx(var5)) {
            var1.add(var5);
         }
      }

      return var1;
   }

   private static boolean declaresInterruptedEx(Method var0) {
      Class[] var1 = var0.getExceptionTypes();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Class var4 = var1[var3];
         if(var4 == InterruptedException.class) {
            return true;
         }
      }

      return false;
   }

   private static Object newProxy(Class var0, InvocationHandler var1) {
      Object var2 = Proxy.newProxyInstance(var0.getClassLoader(), new Class[]{var0}, var1);
      return var0.cast(var2);
   }

   // $FF: synthetic method
   static Exception access$000(Exception var0, boolean var1) {
      return throwCause(var0, var1);
   }
}
