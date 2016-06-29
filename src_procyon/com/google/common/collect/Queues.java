package com.google.common.collect;

import java.util.concurrent.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

public final class Queues
{
    public static ArrayBlockingQueue newArrayBlockingQueue(final int n) {
        return new ArrayBlockingQueue(n);
    }
    
    public static ArrayDeque newArrayDeque() {
        return new ArrayDeque();
    }
    
    public static ArrayDeque newArrayDeque(final Iterable iterable) {
        if (iterable instanceof Collection) {
            return new ArrayDeque(Collections2.cast(iterable));
        }
        final ArrayDeque arrayDeque = new ArrayDeque();
        Iterables.addAll(arrayDeque, iterable);
        return arrayDeque;
    }
    
    public static ConcurrentLinkedQueue newConcurrentLinkedQueue() {
        return new ConcurrentLinkedQueue();
    }
    
    public static ConcurrentLinkedQueue newConcurrentLinkedQueue(final Iterable iterable) {
        if (iterable instanceof Collection) {
            return new ConcurrentLinkedQueue(Collections2.cast(iterable));
        }
        final ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        Iterables.addAll(concurrentLinkedQueue, iterable);
        return concurrentLinkedQueue;
    }
    
    public static LinkedBlockingDeque newLinkedBlockingDeque() {
        return new LinkedBlockingDeque();
    }
    
    public static LinkedBlockingDeque newLinkedBlockingDeque(final int n) {
        return new LinkedBlockingDeque(n);
    }
    
    public static LinkedBlockingDeque newLinkedBlockingDeque(final Iterable iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingDeque(Collections2.cast(iterable));
        }
        final LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        Iterables.addAll(linkedBlockingDeque, iterable);
        return linkedBlockingDeque;
    }
    
    public static LinkedBlockingQueue newLinkedBlockingQueue() {
        return new LinkedBlockingQueue();
    }
    
    public static LinkedBlockingQueue newLinkedBlockingQueue(final int n) {
        return new LinkedBlockingQueue(n);
    }
    
    public static LinkedBlockingQueue newLinkedBlockingQueue(final Iterable iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingQueue(Collections2.cast(iterable));
        }
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        Iterables.addAll(linkedBlockingQueue, iterable);
        return linkedBlockingQueue;
    }
    
    public static PriorityBlockingQueue newPriorityBlockingQueue() {
        return new PriorityBlockingQueue();
    }
    
    public static PriorityBlockingQueue newPriorityBlockingQueue(final Iterable iterable) {
        if (iterable instanceof Collection) {
            return new PriorityBlockingQueue(Collections2.cast(iterable));
        }
        final PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        Iterables.addAll(priorityBlockingQueue, iterable);
        return priorityBlockingQueue;
    }
    
    public static PriorityQueue newPriorityQueue() {
        return new PriorityQueue();
    }
    
    public static PriorityQueue newPriorityQueue(final Iterable iterable) {
        if (iterable instanceof Collection) {
            return new PriorityQueue(Collections2.cast(iterable));
        }
        final PriorityQueue priorityQueue = new PriorityQueue();
        Iterables.addAll(priorityQueue, iterable);
        return priorityQueue;
    }
    
    public static SynchronousQueue newSynchronousQueue() {
        return new SynchronousQueue();
    }
    
    @Beta
    public static int drain(final BlockingQueue blockingQueue, final Collection collection, final int n, final long n2, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(collection);
        final long n3 = System.nanoTime() + timeUnit.toNanos(n2);
        int i;
        for (i = 0; i < n; ++i) {
            i += blockingQueue.drainTo(collection, n - i);
            if (i < n) {
                final Object poll = blockingQueue.poll(n3 - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (poll == null) {
                    break;
                }
                collection.add(poll);
            }
        }
        return i;
    }
    
    @Beta
    public static int drainUninterruptibly(final BlockingQueue blockingQueue, final Collection collection, final int n, final long n2, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(collection);
        final long n3 = System.nanoTime() + timeUnit.toNanos(n2);
        int i = 0;
        boolean b = false;
        try {
            while (i < n) {
                i += blockingQueue.drainTo(collection, n - i);
                if (i < n) {
                    Object poll;
                    while (true) {
                        try {
                            poll = blockingQueue.poll(n3 - System.nanoTime(), TimeUnit.NANOSECONDS);
                        }
                        catch (InterruptedException ex) {
                            b = true;
                            continue;
                        }
                        break;
                    }
                    if (poll == null) {
                        break;
                    }
                    collection.add(poll);
                    ++i;
                }
            }
        }
        finally {
            if (b) {
                Thread.currentThread().interrupt();
            }
        }
        return i;
    }
    
    public static Queue synchronizedQueue(final Queue queue) {
        return Synchronized.queue(queue, null);
    }
    
    public static Deque synchronizedDeque(final Deque deque) {
        return Synchronized.deque(deque, null);
    }
}
