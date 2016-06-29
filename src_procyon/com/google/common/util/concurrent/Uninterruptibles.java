package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;

@Beta
@GwtCompatible(emulated = true)
public final class Uninterruptibles
{
    @GwtIncompatible("concurrency")
    public static void awaitUninterruptibly(final CountDownLatch countDownLatch) {
        boolean b = false;
        while (true) {
            try {
                countDownLatch.await();
            }
            catch (InterruptedException ex) {
                b = true;
                continue;
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
            break;
        }
    }
    
    @GoogleInternal
    @GwtIncompatible("concurrency")
    public static void awaitUninterruptibly(final IncrementableCountDownLatch incrementableCountDownLatch) {
        boolean b = false;
        while (true) {
            try {
                incrementableCountDownLatch.await();
            }
            catch (InterruptedException ex) {
                b = true;
                continue;
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
            break;
        }
    }
    
    @GwtIncompatible("concurrency")
    public static boolean awaitUninterruptibly(final CountDownLatch countDownLatch, final long n, final TimeUnit timeUnit) {
        boolean b = false;
        try {
            long nanos = timeUnit.toNanos(n);
            final long n2 = System.nanoTime() + nanos;
            try {
                return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
            }
            catch (InterruptedException ex) {
                b = true;
                nanos = n2 - System.nanoTime();
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    @GoogleInternal
    @GwtIncompatible("concurrency")
    public static boolean awaitUninterruptibly(final IncrementableCountDownLatch incrementableCountDownLatch, final long n, final TimeUnit timeUnit) {
        boolean b = false;
        try {
            long nanos = timeUnit.toNanos(n);
            final long n2 = System.nanoTime() + nanos;
            try {
                return incrementableCountDownLatch.await(nanos, TimeUnit.NANOSECONDS);
            }
            catch (InterruptedException ex) {
                b = true;
                nanos = n2 - System.nanoTime();
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    @GwtIncompatible("concurrency")
    public static void joinUninterruptibly(final Thread thread) {
        boolean b = false;
        while (true) {
            try {
                thread.join();
            }
            catch (InterruptedException ex) {
                b = true;
                continue;
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
            break;
        }
    }
    
    public static Object getUninterruptibly(final Future future) {
        boolean b = false;
        try {
            return future.get();
        }
        catch (InterruptedException ex) {
            b = true;
            return future.get();
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    @GwtIncompatible("TODO")
    public static Object getUninterruptibly(final Future future, final long n, final TimeUnit timeUnit) {
        boolean b = false;
        try {
            long nanos = timeUnit.toNanos(n);
            final long n2 = System.nanoTime() + nanos;
            try {
                return future.get(nanos, TimeUnit.NANOSECONDS);
            }
            catch (InterruptedException ex) {
                b = true;
                nanos = n2 - System.nanoTime();
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    @GwtIncompatible("concurrency")
    public static void joinUninterruptibly(final Thread thread, final long n, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(thread);
        boolean b = false;
        try {
            long nanos = timeUnit.toNanos(n);
            final long n2 = System.nanoTime() + nanos;
            try {
                TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
            }
            catch (InterruptedException ex) {
                b = true;
                nanos = n2 - System.nanoTime();
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    @GwtIncompatible("concurrency")
    public static Object takeUninterruptibly(final BlockingQueue blockingQueue) {
        boolean b = false;
        try {
            return blockingQueue.take();
        }
        catch (InterruptedException ex) {
            b = true;
            return blockingQueue.take();
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    @GwtIncompatible("concurrency")
    public static void putUninterruptibly(final BlockingQueue blockingQueue, final Object o) {
        boolean b = false;
        while (true) {
            try {
                blockingQueue.put(o);
            }
            catch (InterruptedException ex) {
                b = true;
                continue;
            }
            finally {
                if (b) {
                    Thread.currentThread().interrupt();
                }
            }
            break;
        }
    }
    
    @GwtIncompatible("concurrency")
    public static void sleepUninterruptibly(final long n, final TimeUnit timeUnit) {
        boolean b = false;
        try {
            long nanos = timeUnit.toNanos(n);
            final long n2 = System.nanoTime() + nanos;
            try {
                TimeUnit.NANOSECONDS.sleep(nanos);
            }
            catch (InterruptedException ex) {
                b = true;
                nanos = n2 - System.nanoTime();
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    @GwtIncompatible("concurrency")
    public static boolean tryAcquireUninterruptibly(final Semaphore semaphore, final long n, final TimeUnit timeUnit) {
        return tryAcquireUninterruptibly(semaphore, 1, n, timeUnit);
    }
    
    @GwtIncompatible("concurrency")
    public static boolean tryAcquireUninterruptibly(final Semaphore semaphore, final int n, final long n2, final TimeUnit timeUnit) {
        boolean b = false;
        try {
            long nanos = timeUnit.toNanos(n2);
            final long n3 = System.nanoTime() + nanos;
            try {
                return semaphore.tryAcquire(n, nanos, TimeUnit.NANOSECONDS);
            }
            catch (InterruptedException ex) {
                b = true;
                nanos = n3 - System.nanoTime();
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
