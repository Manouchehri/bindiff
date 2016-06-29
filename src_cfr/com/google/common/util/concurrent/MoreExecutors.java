/*
 * Decompiled with CFR 0_115.
 */
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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

@GwtCompatible(emulated=1)
public final class MoreExecutors {
    private MoreExecutors() {
    }

    @Beta
    @GwtIncompatible(value="TODO")
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long l2, TimeUnit timeUnit) {
        return new MoreExecutors$Application().getExitingExecutorService(threadPoolExecutor, l2, timeUnit);
    }

    @Beta
    @GwtIncompatible(value="TODO")
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long l2, TimeUnit timeUnit) {
        return new MoreExecutors$Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor, l2, timeUnit);
    }

    @Beta
    @GwtIncompatible(value="TODO")
    public static void addDelayedShutdownHook(ExecutorService executorService, long l2, TimeUnit timeUnit) {
        new MoreExecutors$Application().addDelayedShutdownHook(executorService, l2, timeUnit);
    }

    @Beta
    @GwtIncompatible(value="concurrency")
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        return new MoreExecutors$Application().getExitingExecutorService(threadPoolExecutor);
    }

    @Beta
    @GwtIncompatible(value="TODO")
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new MoreExecutors$Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor);
    }

    @GwtIncompatible(value="TODO")
    private static void useDaemonThreadFactory(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
    }

    @Deprecated
    @GwtIncompatible(value="TODO")
    public static ListeningExecutorService sameThreadExecutor() {
        return new MoreExecutors$DirectExecutorService(null);
    }

    @GwtIncompatible(value="TODO")
    public static ListeningExecutorService newDirectExecutorService() {
        return new MoreExecutors$DirectExecutorService(null);
    }

    public static Executor directExecutor() {
        return MoreExecutors$DirectExecutor.INSTANCE;
    }

    @GwtIncompatible(value="TODO")
    public static ListeningExecutorService listeningDecorator(ExecutorService executorService) {
        ListeningExecutorService listeningExecutorService;
        if (executorService instanceof ListeningExecutorService) {
            listeningExecutorService = (ListeningExecutorService)executorService;
            return listeningExecutorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            listeningExecutorService = new MoreExecutors$ScheduledListeningDecorator((ScheduledExecutorService)executorService);
            return listeningExecutorService;
        }
        listeningExecutorService = new MoreExecutors$ListeningDecorator(executorService);
        return listeningExecutorService;
    }

    @GwtIncompatible(value="TODO")
    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        ListeningScheduledExecutorService listeningScheduledExecutorService;
        if (scheduledExecutorService instanceof ListeningScheduledExecutorService) {
            listeningScheduledExecutorService = (ListeningScheduledExecutorService)scheduledExecutorService;
            return listeningScheduledExecutorService;
        }
        listeningScheduledExecutorService = new MoreExecutors$ScheduledListeningDecorator(scheduledExecutorService);
        return listeningScheduledExecutorService;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @GwtIncompatible(value="TODO")
    public static Object invokeAnyImpl(ListeningExecutorService var0, Collection var1_1, boolean var2_2, long var3_3) {
        Preconditions.checkNotNull(var0);
        var5_4 = var1_1.size();
        Preconditions.checkArgument(var5_4 > 0);
        var6_5 = Lists.newArrayListWithCapacity(var5_4);
        var7_6 = Queues.newLinkedBlockingQueue();
        var8_7 = null;
        var9_8 = var2_2 != false ? System.nanoTime() : 0;
        var11_9 = var1_1.iterator();
        var6_5.add(MoreExecutors.submitAndAddQueueListener(var0, (Callable)var11_9.next(), var7_6));
        --var5_4;
        var12_10 = 1;
        do lbl-1000: // 4 sources:
        {
            if ((var13_11 = (Future)var7_6.poll()) == null) {
                if (var5_4 > 0) {
                    --var5_4;
                    var6_5.add(MoreExecutors.submitAndAddQueueListener(var0, (Callable)var11_9.next(), var7_6));
                    ++var12_10;
                } else {
                    if (var12_10 == 0) {
                        if (var8_7 != null) throw var8_7;
                        var8_7 = new ExecutionException(null);
                        throw var8_7;
                    }
                    if (var2_2) {
                        var13_11 = (Future)var7_6.poll(var3_3, TimeUnit.NANOSECONDS);
                        if (var13_11 == null) {
                            throw new TimeoutException();
                        }
                        var14_12 = System.nanoTime();
                        var3_3 -= var14_12 - var9_8;
                        var9_8 = var14_12;
                    } else {
                        var13_11 = (Future)var7_6.take();
                    }
                }
            }
            if (var13_11 == null) continue;
            --var12_10;
            try {
                var14_13 = var13_11.get();
                return var14_13;
            }
            catch (ExecutionException var14_14) {
                var8_7 = var14_14;
            }
            catch (RuntimeException var14_15) {
                var8_7 = new ExecutionException(var14_15);
                continue;
            }
            break;
        } while (true);
        ** GOTO lbl-1000
        finally {
            var15_16 = var6_5.iterator();
            do {
                if (!var15_16.hasNext()) {
                }
                var16_17 = (Future)var15_16.next();
                var16_17.cancel(true);
            } while (true);
        }
    }

    @GwtIncompatible(value="TODO")
    private static ListenableFuture submitAndAddQueueListener(ListeningExecutorService listeningExecutorService, Callable callable, BlockingQueue blockingQueue) {
        ListenableFuture listenableFuture = listeningExecutorService.submit(callable);
        listenableFuture.addListener(new MoreExecutors$1(blockingQueue, listenableFuture), MoreExecutors.directExecutor());
        return listenableFuture;
    }

    @Beta
    @GwtIncompatible(value="concurrency")
    public static ThreadFactory platformThreadFactory() {
        if (!MoreExecutors.isAppEngine()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        }
        catch (IllegalAccessException var0) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", var0);
        }
        catch (ClassNotFoundException var0_1) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", var0_1);
        }
        catch (NoSuchMethodException var0_2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", var0_2);
        }
        catch (InvocationTargetException var0_3) {
            throw Throwables.propagate(var0_3.getCause());
        }
    }

    @GwtIncompatible(value="TODO")
    private static boolean isAppEngine() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) == null) return false;
            return true;
        }
        catch (ClassNotFoundException var0) {
            return false;
        }
        catch (InvocationTargetException var0_1) {
            return false;
        }
        catch (IllegalAccessException var0_2) {
            return false;
        }
        catch (NoSuchMethodException var0_3) {
            return false;
        }
    }

    @GwtIncompatible(value="concurrency")
    static Thread newThread(String string, Runnable runnable) {
        Preconditions.checkNotNull(string);
        Preconditions.checkNotNull(runnable);
        Thread thread = MoreExecutors.platformThreadFactory().newThread(runnable);
        try {
            thread.setName(string);
            return thread;
        }
        catch (SecurityException var3_3) {
            // empty catch block
        }
        return thread;
    }

    @GwtIncompatible(value="concurrency")
    public static Executor renamingDecorator(Executor executor, Supplier supplier) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(supplier);
        if (!MoreExecutors.isAppEngine()) return new MoreExecutors$2(executor, supplier);
        return executor;
    }

    @GwtIncompatible(value="concurrency")
    public static ExecutorService renamingDecorator(ExecutorService executorService, Supplier supplier) {
        Preconditions.checkNotNull(executorService);
        Preconditions.checkNotNull(supplier);
        if (!MoreExecutors.isAppEngine()) return new MoreExecutors$3(executorService, supplier);
        return executorService;
    }

    @GwtIncompatible(value="concurrency")
    public static ScheduledExecutorService renamingDecorator(ScheduledExecutorService scheduledExecutorService, Supplier supplier) {
        Preconditions.checkNotNull(scheduledExecutorService);
        Preconditions.checkNotNull(supplier);
        if (!MoreExecutors.isAppEngine()) return new MoreExecutors$4(scheduledExecutorService, supplier);
        return scheduledExecutorService;
    }

    @GoogleInternal
    @GwtIncompatible(value="TODO")
    public static ListeningExecutorService rateLimitingExecutorService(RateLimiter rateLimiter, ListeningScheduledExecutorService listeningScheduledExecutorService) {
        return new RateLimitingExecutorService(rateLimiter, listeningScheduledExecutorService, 1);
    }

    @GoogleInternal
    @GwtIncompatible(value="TODO")
    public static ListeningExecutorService rateLimitingExecutorService(RateLimiter rateLimiter, ListeningScheduledExecutorService listeningScheduledExecutorService, int n2) {
        return new RateLimitingExecutorService(rateLimiter, listeningScheduledExecutorService, n2);
    }

    @Beta
    @GwtIncompatible(value="concurrency")
    public static boolean shutdownAndAwaitTermination(ExecutorService executorService, long l2, TimeUnit timeUnit) {
        Preconditions.checkNotNull((Object)timeUnit);
        executorService.shutdown();
        try {
            long l3 = TimeUnit.NANOSECONDS.convert(l2, timeUnit) / 2;
            if (executorService.awaitTermination(l3, TimeUnit.NANOSECONDS)) return executorService.isTerminated();
            executorService.shutdownNow();
            executorService.awaitTermination(l3, TimeUnit.NANOSECONDS);
            return executorService.isTerminated();
        }
        catch (InterruptedException var4_4) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    static /* synthetic */ void access$000(ThreadPoolExecutor threadPoolExecutor) {
        MoreExecutors.useDaemonThreadFactory(threadPoolExecutor);
    }
}

