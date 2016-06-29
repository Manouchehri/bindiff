/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Synchronized;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public final class Queues {
    private Queues() {
    }

    public static ArrayBlockingQueue newArrayBlockingQueue(int n2) {
        return new ArrayBlockingQueue(n2);
    }

    public static ArrayDeque newArrayDeque() {
        return new ArrayDeque();
    }

    public static ArrayDeque newArrayDeque(Iterable iterable) {
        if (iterable instanceof Collection) {
            return new ArrayDeque(Collections2.cast(iterable));
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        Iterables.addAll(arrayDeque, iterable);
        return arrayDeque;
    }

    public static ConcurrentLinkedQueue newConcurrentLinkedQueue() {
        return new ConcurrentLinkedQueue();
    }

    public static ConcurrentLinkedQueue newConcurrentLinkedQueue(Iterable iterable) {
        if (iterable instanceof Collection) {
            return new ConcurrentLinkedQueue(Collections2.cast(iterable));
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        Iterables.addAll(concurrentLinkedQueue, iterable);
        return concurrentLinkedQueue;
    }

    public static LinkedBlockingDeque newLinkedBlockingDeque() {
        return new LinkedBlockingDeque();
    }

    public static LinkedBlockingDeque newLinkedBlockingDeque(int n2) {
        return new LinkedBlockingDeque(n2);
    }

    public static LinkedBlockingDeque newLinkedBlockingDeque(Iterable iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingDeque(Collections2.cast(iterable));
        }
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        Iterables.addAll(linkedBlockingDeque, iterable);
        return linkedBlockingDeque;
    }

    public static LinkedBlockingQueue newLinkedBlockingQueue() {
        return new LinkedBlockingQueue();
    }

    public static LinkedBlockingQueue newLinkedBlockingQueue(int n2) {
        return new LinkedBlockingQueue(n2);
    }

    public static LinkedBlockingQueue newLinkedBlockingQueue(Iterable iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingQueue(Collections2.cast(iterable));
        }
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        Iterables.addAll(linkedBlockingQueue, iterable);
        return linkedBlockingQueue;
    }

    public static PriorityBlockingQueue newPriorityBlockingQueue() {
        return new PriorityBlockingQueue();
    }

    public static PriorityBlockingQueue newPriorityBlockingQueue(Iterable iterable) {
        if (iterable instanceof Collection) {
            return new PriorityBlockingQueue(Collections2.cast(iterable));
        }
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        Iterables.addAll(priorityBlockingQueue, iterable);
        return priorityBlockingQueue;
    }

    public static PriorityQueue newPriorityQueue() {
        return new PriorityQueue();
    }

    public static PriorityQueue newPriorityQueue(Iterable iterable) {
        if (iterable instanceof Collection) {
            return new PriorityQueue(Collections2.cast(iterable));
        }
        PriorityQueue priorityQueue = new PriorityQueue();
        Iterables.addAll(priorityQueue, iterable);
        return priorityQueue;
    }

    public static SynchronousQueue newSynchronousQueue() {
        return new SynchronousQueue();
    }

    @Beta
    public static int drain(BlockingQueue blockingQueue, Collection collection, int n2, long l2, TimeUnit timeUnit) {
        Preconditions.checkNotNull(collection);
        long l3 = System.nanoTime() + timeUnit.toNanos(l2);
        int n3 = 0;
        while (n3 < n2) {
            if ((n3 += blockingQueue.drainTo(collection, n2 - n3)) >= n2) continue;
            Object e2 = blockingQueue.poll(l3 - System.nanoTime(), TimeUnit.NANOSECONDS);
            if (e2 == null) {
                return n3;
            }
            collection.add(e2);
            ++n3;
        }
        return n3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Beta
    public static int drainUninterruptibly(BlockingQueue blockingQueue, Collection collection, int n2, long l2, TimeUnit timeUnit) {
        Preconditions.checkNotNull(collection);
        long l3 = System.nanoTime() + timeUnit.toNanos(l2);
        int n3 = 0;
        boolean bl2 = false;
        try {
            while (n3 < n2) {
                Object e2;
                if ((n3 += blockingQueue.drainTo(collection, n2 - n3)) >= n2) continue;
                do {
                    try {
                        e2 = blockingQueue.poll(l3 - System.nanoTime(), TimeUnit.NANOSECONDS);
                        break;
                    }
                    catch (InterruptedException var11_9) {
                        bl2 = true;
                        continue;
                    }
                    break;
                } while (true);
                if (e2 == null) {
                    return n3;
                }
                collection.add(e2);
                ++n3;
            }
            return n3;
        }
        finally {
            if (bl2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static Queue synchronizedQueue(Queue queue) {
        return Synchronized.queue(queue, null);
    }

    public static Deque synchronizedDeque(Deque deque) {
        return Synchronized.deque(deque, null);
    }
}

