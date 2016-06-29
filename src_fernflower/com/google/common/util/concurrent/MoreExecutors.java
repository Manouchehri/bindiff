package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors$1;
import com.google.common.util.concurrent.MoreExecutors$2;
import com.google.common.util.concurrent.MoreExecutors$3;
import com.google.common.util.concurrent.MoreExecutors$4;
import com.google.common.util.concurrent.MoreExecutors$Application;
import com.google.common.util.concurrent.MoreExecutors$DirectExecutor;
import com.google.common.util.concurrent.MoreExecutors$DirectExecutorService;
import com.google.common.util.concurrent.MoreExecutors$ListeningDecorator;
import com.google.common.util.concurrent.MoreExecutors$ScheduledListeningDecorator;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimitingExecutorService;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtCompatible(
   emulated = true
)
public final class MoreExecutors {
   @Beta
   @GwtIncompatible("TODO")
   public static ExecutorService getExitingExecutorService(ThreadPoolExecutor var0, long var1, TimeUnit var3) {
      return (new MoreExecutors$Application()).getExitingExecutorService(var0, var1, var3);
   }

   @Beta
   @GwtIncompatible("TODO")
   public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor var0, long var1, TimeUnit var3) {
      return (new MoreExecutors$Application()).getExitingScheduledExecutorService(var0, var1, var3);
   }

   @Beta
   @GwtIncompatible("TODO")
   public static void addDelayedShutdownHook(ExecutorService var0, long var1, TimeUnit var3) {
      (new MoreExecutors$Application()).addDelayedShutdownHook(var0, var1, var3);
   }

   @Beta
   @GwtIncompatible("concurrency")
   public static ExecutorService getExitingExecutorService(ThreadPoolExecutor var0) {
      return (new MoreExecutors$Application()).getExitingExecutorService(var0);
   }

   @Beta
   @GwtIncompatible("TODO")
   public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor var0) {
      return (new MoreExecutors$Application()).getExitingScheduledExecutorService(var0);
   }

   @GwtIncompatible("TODO")
   private static void useDaemonThreadFactory(ThreadPoolExecutor var0) {
      var0.setThreadFactory((new ThreadFactoryBuilder()).setDaemon(true).setThreadFactory(var0.getThreadFactory()).build());
   }

   @Deprecated
   @GwtIncompatible("TODO")
   public static ListeningExecutorService sameThreadExecutor() {
      return new MoreExecutors$DirectExecutorService((MoreExecutors$1)null);
   }

   @GwtIncompatible("TODO")
   public static ListeningExecutorService newDirectExecutorService() {
      return new MoreExecutors$DirectExecutorService((MoreExecutors$1)null);
   }

   public static Executor directExecutor() {
      return MoreExecutors$DirectExecutor.INSTANCE;
   }

   @GwtIncompatible("TODO")
   public static ListeningExecutorService listeningDecorator(ExecutorService var0) {
      return (ListeningExecutorService)(var0 instanceof ListeningExecutorService?(ListeningExecutorService)var0:(var0 instanceof ScheduledExecutorService?new MoreExecutors$ScheduledListeningDecorator((ScheduledExecutorService)var0):new MoreExecutors$ListeningDecorator(var0)));
   }

   @GwtIncompatible("TODO")
   public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService var0) {
      return (ListeningScheduledExecutorService)(var0 instanceof ListeningScheduledExecutorService?(ListeningScheduledExecutorService)var0:new MoreExecutors$ScheduledListeningDecorator(var0));
   }

   @GwtIncompatible("TODO")
   public static Object invokeAnyImpl(ListeningExecutorService var0, Collection var1, boolean var2, long var3) {
      Preconditions.checkNotNull(var0);
      int var5 = var1.size();
      Preconditions.checkArgument(var5 > 0);
      ArrayList var6 = Lists.newArrayListWithCapacity(var5);
      LinkedBlockingQueue var7 = Queues.newLinkedBlockingQueue();
      boolean var23 = false;

      Object var27;
      try {
         var23 = true;
         ExecutionException var8 = null;
         long var9 = var2?System.nanoTime():0L;
         Iterator var11 = var1.iterator();
         var6.add(submitAndAddQueueListener(var0, (Callable)var11.next(), var7));
         --var5;
         int var12 = 1;

         while(true) {
            Future var13 = (Future)var7.poll();
            if(var13 == null) {
               if(var5 > 0) {
                  --var5;
                  var6.add(submitAndAddQueueListener(var0, (Callable)var11.next(), var7));
                  ++var12;
               } else {
                  if(var12 == 0) {
                     if(var8 == null) {
                        var8 = new ExecutionException((Throwable)null);
                     }

                     throw var8;
                  }

                  if(var2) {
                     var13 = (Future)var7.poll(var3, TimeUnit.NANOSECONDS);
                     if(var13 == null) {
                        throw new TimeoutException();
                     }

                     long var14 = System.nanoTime();
                     var3 -= var14 - var9;
                     var9 = var14;
                  } else {
                     var13 = (Future)var7.take();
                  }
               }
            }

            if(var13 != null) {
               --var12;

               try {
                  var27 = var13.get();
                  var23 = false;
                  break;
               } catch (ExecutionException var24) {
                  var8 = var24;
               } catch (RuntimeException var25) {
                  var8 = new ExecutionException(var25);
               }
            }
         }
      } finally {
         if(var23) {
            Iterator var18 = var6.iterator();

            while(var18.hasNext()) {
               Future var19 = (Future)var18.next();
               var19.cancel(true);
            }

         }
      }

      Iterator var15 = var6.iterator();

      while(var15.hasNext()) {
         Future var16 = (Future)var15.next();
         var16.cancel(true);
      }

      return var27;
   }

   @GwtIncompatible("TODO")
   private static ListenableFuture submitAndAddQueueListener(ListeningExecutorService var0, Callable var1, BlockingQueue var2) {
      ListenableFuture var3 = var0.submit(var1);
      var3.addListener(new MoreExecutors$1(var2, var3), directExecutor());
      return var3;
   }

   @Beta
   @GwtIncompatible("concurrency")
   public static ThreadFactory platformThreadFactory() {
      if(!isAppEngine()) {
         return Executors.defaultThreadFactory();
      } else {
         try {
            return (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke((Object)null, new Object[0]);
         } catch (IllegalAccessException var1) {
            throw new RuntimeException("Couldn\'t invoke ThreadManager.currentRequestThreadFactory", var1);
         } catch (ClassNotFoundException var2) {
            throw new RuntimeException("Couldn\'t invoke ThreadManager.currentRequestThreadFactory", var2);
         } catch (NoSuchMethodException var3) {
            throw new RuntimeException("Couldn\'t invoke ThreadManager.currentRequestThreadFactory", var3);
         } catch (InvocationTargetException var4) {
            throw Throwables.propagate(var4.getCause());
         }
      }
   }

   @GwtIncompatible("TODO")
   private static boolean isAppEngine() {
      if(System.getProperty("com.google.appengine.runtime.environment") == null) {
         return false;
      } else {
         try {
            return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke((Object)null, new Object[0]) != null;
         } catch (ClassNotFoundException var1) {
            return false;
         } catch (InvocationTargetException var2) {
            return false;
         } catch (IllegalAccessException var3) {
            return false;
         } catch (NoSuchMethodException var4) {
            return false;
         }
      }
   }

   @GwtIncompatible("concurrency")
   static Thread newThread(String var0, Runnable var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Thread var2 = platformThreadFactory().newThread(var1);

      try {
         var2.setName(var0);
      } catch (SecurityException var4) {
         ;
      }

      return var2;
   }

   @GwtIncompatible("concurrency")
   public static Executor renamingDecorator(Executor var0, Supplier var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return (Executor)(isAppEngine()?var0:new MoreExecutors$2(var0, var1));
   }

   @GwtIncompatible("concurrency")
   public static ExecutorService renamingDecorator(ExecutorService var0, Supplier var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return (ExecutorService)(isAppEngine()?var0:new MoreExecutors$3(var0, var1));
   }

   @GwtIncompatible("concurrency")
   public static ScheduledExecutorService renamingDecorator(ScheduledExecutorService var0, Supplier var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return (ScheduledExecutorService)(isAppEngine()?var0:new MoreExecutors$4(var0, var1));
   }

   @GoogleInternal
   @GwtIncompatible("TODO")
   public static ListeningExecutorService rateLimitingExecutorService(RateLimiter var0, ListeningScheduledExecutorService var1) {
      return new RateLimitingExecutorService(var0, var1, 1);
   }

   @GoogleInternal
   @GwtIncompatible("TODO")
   public static ListeningExecutorService rateLimitingExecutorService(RateLimiter var0, ListeningScheduledExecutorService var1, int var2) {
      return new RateLimitingExecutorService(var0, var1, var2);
   }

   @Beta
   @GwtIncompatible("concurrency")
   public static boolean shutdownAndAwaitTermination(ExecutorService var0, long var1, TimeUnit var3) {
      Preconditions.checkNotNull(var3);
      var0.shutdown();

      try {
         long var4 = TimeUnit.NANOSECONDS.convert(var1, var3) / 2L;
         if(!var0.awaitTermination(var4, TimeUnit.NANOSECONDS)) {
            var0.shutdownNow();
            var0.awaitTermination(var4, TimeUnit.NANOSECONDS);
         }
      } catch (InterruptedException var6) {
         Thread.currentThread().interrupt();
         var0.shutdownNow();
      }

      return var0.isTerminated();
   }

   // $FF: synthetic method
   static void access$000(ThreadPoolExecutor var0) {
      useDaemonThreadFactory(var0);
   }
}
