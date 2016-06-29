package com.google.common.util.concurrent;

import com.google.common.collect.*;
import java.util.*;
import java.util.concurrent.*;
import java.lang.reflect.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

@GwtCompatible(emulated = true)
public final class MoreExecutors
{
    @Beta
    @GwtIncompatible("TODO")
    public static ExecutorService getExitingExecutorService(final ThreadPoolExecutor threadPoolExecutor, final long n, final TimeUnit timeUnit) {
        return new MoreExecutors$Application().getExitingExecutorService(threadPoolExecutor, n, timeUnit);
    }
    
    @Beta
    @GwtIncompatible("TODO")
    public static ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, final long n, final TimeUnit timeUnit) {
        return new MoreExecutors$Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor, n, timeUnit);
    }
    
    @Beta
    @GwtIncompatible("TODO")
    public static void addDelayedShutdownHook(final ExecutorService executorService, final long n, final TimeUnit timeUnit) {
        new MoreExecutors$Application().addDelayedShutdownHook(executorService, n, timeUnit);
    }
    
    @Beta
    @GwtIncompatible("concurrency")
    public static ExecutorService getExitingExecutorService(final ThreadPoolExecutor threadPoolExecutor) {
        return new MoreExecutors$Application().getExitingExecutorService(threadPoolExecutor);
    }
    
    @Beta
    @GwtIncompatible("TODO")
    public static ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new MoreExecutors$Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor);
    }
    
    @GwtIncompatible("TODO")
    private static void useDaemonThreadFactory(final ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
    }
    
    @Deprecated
    @GwtIncompatible("TODO")
    public static ListeningExecutorService sameThreadExecutor() {
        return new MoreExecutors$DirectExecutorService(null);
    }
    
    @GwtIncompatible("TODO")
    public static ListeningExecutorService newDirectExecutorService() {
        return new MoreExecutors$DirectExecutorService(null);
    }
    
    public static Executor directExecutor() {
        return MoreExecutors$DirectExecutor.INSTANCE;
    }
    
    @GwtIncompatible("TODO")
    public static ListeningExecutorService listeningDecorator(final ExecutorService executorService) {
        return (executorService instanceof ListeningExecutorService) ? ((ListeningExecutorService)executorService) : ((executorService instanceof ScheduledExecutorService) ? new MoreExecutors$ScheduledListeningDecorator((ScheduledExecutorService)executorService) : new MoreExecutors$ListeningDecorator(executorService));
    }
    
    @GwtIncompatible("TODO")
    public static ListeningScheduledExecutorService listeningDecorator(final ScheduledExecutorService scheduledExecutorService) {
        return (scheduledExecutorService instanceof ListeningScheduledExecutorService) ? ((ListeningScheduledExecutorService)scheduledExecutorService) : new MoreExecutors$ScheduledListeningDecorator(scheduledExecutorService);
    }
    
    @GwtIncompatible("TODO")
    public static Object invokeAnyImpl(final ListeningExecutorService listeningExecutorService, final Collection collection, final boolean b, long n) {
        Preconditions.checkNotNull(listeningExecutorService);
        int size = collection.size();
        Preconditions.checkArgument(size > 0);
        final ArrayList arrayListWithCapacity = Lists.newArrayListWithCapacity(size);
        final LinkedBlockingQueue linkedBlockingQueue = Queues.newLinkedBlockingQueue();
        try {
            Object o = null;
            long n2 = b ? System.nanoTime() : 0L;
            final Iterator<Callable> iterator = collection.iterator();
            arrayListWithCapacity.add(submitAndAddQueueListener(listeningExecutorService, iterator.next(), linkedBlockingQueue));
            --size;
            int n3 = 1;
            while (true) {
                Future<Object> future = linkedBlockingQueue.poll();
                if (future == null) {
                    if (size > 0) {
                        --size;
                        arrayListWithCapacity.add(submitAndAddQueueListener(listeningExecutorService, iterator.next(), linkedBlockingQueue));
                        ++n3;
                    }
                    else {
                        if (n3 == 0) {
                            if (o == null) {
                                o = new ExecutionException((Throwable)null);
                            }
                            throw o;
                        }
                        if (b) {
                            future = linkedBlockingQueue.poll(n, TimeUnit.NANOSECONDS);
                            if (future == null) {
                                throw new TimeoutException();
                            }
                            final long nanoTime = System.nanoTime();
                            n -= nanoTime - n2;
                            n2 = nanoTime;
                        }
                        else {
                            future = linkedBlockingQueue.take();
                        }
                    }
                }
                if (future != null) {
                    --n3;
                    try {
                        return future.get();
                    }
                    catch (ExecutionException ex) {
                        o = ex;
                    }
                    catch (RuntimeException ex2) {
                        o = new ExecutionException(ex2);
                    }
                }
            }
        }
        finally {
            final Iterator<Future> iterator2 = (Iterator<Future>)arrayListWithCapacity.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().cancel(true);
            }
        }
    }
    
    @GwtIncompatible("TODO")
    private static ListenableFuture submitAndAddQueueListener(final ListeningExecutorService listeningExecutorService, final Callable callable, final BlockingQueue blockingQueue) {
        final ListenableFuture submit = listeningExecutorService.submit(callable);
        submit.addListener(new MoreExecutors$1(blockingQueue, submit), directExecutor());
        return submit;
    }
    
    @Beta
    @GwtIncompatible("concurrency")
    public static ThreadFactory platformThreadFactory() {
        if (!isAppEngine()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
        }
        catch (IllegalAccessException ex) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", ex);
        }
        catch (ClassNotFoundException ex2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", ex2);
        }
        catch (NoSuchMethodException ex3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", ex3);
        }
        catch (InvocationTargetException ex4) {
            throw Throwables.propagate(ex4.getCause());
        }
    }
    
    @GwtIncompatible("TODO")
    private static boolean isAppEngine() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", (Class<?>[])new Class[0]).invoke(null, new Object[0]) != null;
        }
        catch (ClassNotFoundException ex) {
            return false;
        }
        catch (InvocationTargetException ex2) {
            return false;
        }
        catch (IllegalAccessException ex3) {
            return false;
        }
        catch (NoSuchMethodException ex4) {
            return false;
        }
    }
    
    @GwtIncompatible("concurrency")
    static Thread newThread(final String name, final Runnable runnable) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(runnable);
        final Thread thread = platformThreadFactory().newThread(runnable);
        try {
            thread.setName(name);
        }
        catch (SecurityException ex) {}
        return thread;
    }
    
    @GwtIncompatible("concurrency")
    public static Executor renamingDecorator(final Executor executor, final Supplier supplier) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return executor;
        }
        return new MoreExecutors$2(executor, supplier);
    }
    
    @GwtIncompatible("concurrency")
    public static ExecutorService renamingDecorator(final ExecutorService executorService, final Supplier supplier) {
        Preconditions.checkNotNull(executorService);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return executorService;
        }
        return new MoreExecutors$3(executorService, supplier);
    }
    
    @GwtIncompatible("concurrency")
    public static ScheduledExecutorService renamingDecorator(final ScheduledExecutorService scheduledExecutorService, final Supplier supplier) {
        Preconditions.checkNotNull(scheduledExecutorService);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return scheduledExecutorService;
        }
        return new MoreExecutors$4(scheduledExecutorService, supplier);
    }
    
    @GoogleInternal
    @GwtIncompatible("TODO")
    public static ListeningExecutorService rateLimitingExecutorService(final RateLimiter rateLimiter, final ListeningScheduledExecutorService listeningScheduledExecutorService) {
        return new RateLimitingExecutorService(rateLimiter, listeningScheduledExecutorService, 1);
    }
    
    @GoogleInternal
    @GwtIncompatible("TODO")
    public static ListeningExecutorService rateLimitingExecutorService(final RateLimiter rateLimiter, final ListeningScheduledExecutorService listeningScheduledExecutorService, final int n) {
        return new RateLimitingExecutorService(rateLimiter, listeningScheduledExecutorService, n);
    }
    
    @Beta
    @GwtIncompatible("concurrency")
    public static boolean shutdownAndAwaitTermination(final ExecutorService executorService, final long n, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        executorService.shutdown();
        try {
            final long n2 = TimeUnit.NANOSECONDS.convert(n, timeUnit) / 2L;
            if (!executorService.awaitTermination(n2, TimeUnit.NANOSECONDS)) {
                executorService.shutdownNow();
                executorService.awaitTermination(n2, TimeUnit.NANOSECONDS);
            }
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }
}
