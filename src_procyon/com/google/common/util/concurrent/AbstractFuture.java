package com.google.common.util.concurrent;

import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.concurrent.*;
import java.util.logging.*;

@GwtCompatible(emulated = true)
public abstract class AbstractFuture implements ListenableFuture
{
    private static final Logger log;
    private static final long SPIN_THRESHOLD_NANOS = 1000L;
    private static final AbstractFuture$AtomicHelper ATOMIC_HELPER;
    private static final AtomicReferenceFieldUpdater WAITER_THREAD_UPDATER;
    private static final AtomicReferenceFieldUpdater WAITER_NEXT_UPDATER;
    private static final AtomicReferenceFieldUpdater WAITERS_UPDATER;
    private static final AtomicReferenceFieldUpdater LISTENERS_UPDATER;
    private static final AtomicReferenceFieldUpdater VALUE_UPDATER;
    private static final Object NULL;
    private volatile Object value;
    private volatile AbstractFuture$Listener listeners;
    private volatile AbstractFuture$Waiter waiters;
    
    private void removeWaiter(final AbstractFuture$Waiter abstractFuture$Waiter) {
        abstractFuture$Waiter.thread = null;
    Label_0005:
        while (true) {
            AbstractFuture$Waiter abstractFuture$Waiter2 = null;
            AbstractFuture$Waiter waiters = this.waiters;
            if (waiters == AbstractFuture$Waiter.TOMBSTONE) {
                return;
            }
            while (waiters != null) {
                final AbstractFuture$Waiter next = waiters.next;
                if (waiters.thread != null) {
                    abstractFuture$Waiter2 = waiters;
                }
                else if (abstractFuture$Waiter2 != null) {
                    abstractFuture$Waiter2.next = next;
                    if (abstractFuture$Waiter2.thread == null) {
                        continue Label_0005;
                    }
                }
                else if (!AbstractFuture.ATOMIC_HELPER.casWaiters(this, waiters, next)) {
                    continue Label_0005;
                }
                waiters = next;
            }
        }
    }
    
    @Override
    public Object get(final long n, final TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(n);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        final Object value = this.value;
        if (value != null & !(value instanceof AbstractFuture$SetFuture)) {
            return this.getDoneValue(value);
        }
        final long n2 = (nanos > 0L) ? (System.nanoTime() + nanos) : 0L;
        Label_0248: {
            if (nanos >= 1000L) {
                AbstractFuture$Waiter next = this.waiters;
                if (next != AbstractFuture$Waiter.TOMBSTONE) {
                    final AbstractFuture$Waiter abstractFuture$Waiter = new AbstractFuture$Waiter();
                    do {
                        abstractFuture$Waiter.setNext(next);
                        if (AbstractFuture.ATOMIC_HELPER.casWaiters(this, next, abstractFuture$Waiter)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (Thread.interrupted()) {
                                    this.removeWaiter(abstractFuture$Waiter);
                                    throw new InterruptedException();
                                }
                                final Object value2 = this.value;
                                if (value2 != null & !(value2 instanceof AbstractFuture$SetFuture)) {
                                    return this.getDoneValue(value2);
                                }
                                nanos = n2 - System.nanoTime();
                            } while (nanos >= 1000L);
                            this.removeWaiter(abstractFuture$Waiter);
                            break Label_0248;
                        }
                        next = this.waiters;
                    } while (next != AbstractFuture$Waiter.TOMBSTONE);
                }
                return this.getDoneValue(this.value);
            }
        }
        while (nanos > 0L) {
            final Object value3 = this.value;
            if (value3 != null & !(value3 instanceof AbstractFuture$SetFuture)) {
                return this.getDoneValue(value3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = n2 - System.nanoTime();
        }
        throw new TimeoutException();
    }
    
    @Override
    public Object get() {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        final Object value = this.value;
        if (value != null & !(value instanceof AbstractFuture$SetFuture)) {
            return this.getDoneValue(value);
        }
        AbstractFuture$Waiter next = this.waiters;
        if (next != AbstractFuture$Waiter.TOMBSTONE) {
            final AbstractFuture$Waiter abstractFuture$Waiter = new AbstractFuture$Waiter();
            do {
                abstractFuture$Waiter.setNext(next);
                if (AbstractFuture.ATOMIC_HELPER.casWaiters(this, next, abstractFuture$Waiter)) {
                    Object value2;
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            this.removeWaiter(abstractFuture$Waiter);
                            throw new InterruptedException();
                        }
                        value2 = this.value;
                    } while (!(value2 != null & !(value2 instanceof AbstractFuture$SetFuture)));
                    return this.getDoneValue(value2);
                }
                next = this.waiters;
            } while (next != AbstractFuture$Waiter.TOMBSTONE);
        }
        return this.getDoneValue(this.value);
    }
    
    private Object getDoneValue(final Object o) {
        if (o instanceof AbstractFuture$Cancellation) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((AbstractFuture$Cancellation)o).cause);
        }
        if (o instanceof AbstractFuture$Failure) {
            throw new ExecutionException(((AbstractFuture$Failure)o).exception);
        }
        if (o == AbstractFuture.NULL) {
            return null;
        }
        return o;
    }
    
    @Override
    public boolean isDone() {
        final Object value = this.value;
        return value != null & !(value instanceof AbstractFuture$SetFuture);
    }
    
    @Override
    public boolean isCancelled() {
        return this.value instanceof AbstractFuture$Cancellation;
    }
    
    @Override
    public boolean cancel(final boolean b) {
        Object o = this.value;
        if (o == null | o instanceof AbstractFuture$SetFuture) {
            while (!AbstractFuture.ATOMIC_HELPER.casValue(this, o, new AbstractFuture$Cancellation(b, this.newCancellationCause()))) {
                o = this.value;
                if (!(o instanceof AbstractFuture$SetFuture)) {
                    return false;
                }
            }
            if (b) {
                this.interruptTask();
            }
            this.complete();
            if (o instanceof AbstractFuture$SetFuture) {
                ((AbstractFuture$SetFuture)o).future.cancel(b);
            }
            return true;
        }
        return false;
    }
    
    @Beta
    @ForOverride
    protected Throwable newCancellationCause() {
        return new CancellationException("Future.cancel() was called.");
    }
    
    protected void interruptTask() {
    }
    
    protected final boolean wasInterrupted() {
        final Object value = this.value;
        return value instanceof AbstractFuture$Cancellation && ((AbstractFuture$Cancellation)value).wasInterrupted;
    }
    
    @Override
    public void addListener(final Runnable runnable, final Executor executor) {
        Preconditions.checkNotNull(runnable, (Object)"Runnable was null.");
        Preconditions.checkNotNull(executor, (Object)"Executor was null.");
        AbstractFuture$Listener next = this.listeners;
        if (next != AbstractFuture$Listener.TOMBSTONE) {
            final AbstractFuture$Listener abstractFuture$Listener = new AbstractFuture$Listener(runnable, executor);
            do {
                abstractFuture$Listener.next = next;
                if (AbstractFuture.ATOMIC_HELPER.casListeners(this, next, abstractFuture$Listener)) {
                    return;
                }
                next = this.listeners;
            } while (next != AbstractFuture$Listener.TOMBSTONE);
        }
        executeListener(runnable, executor);
    }
    
    protected boolean set(@Nullable final Object o) {
        if (AbstractFuture.ATOMIC_HELPER.casValue(this, null, (o == null) ? AbstractFuture.NULL : o)) {
            this.complete();
            return true;
        }
        return false;
    }
    
    protected boolean setException(final Throwable t) {
        if (AbstractFuture.ATOMIC_HELPER.casValue(this, null, new AbstractFuture$Failure((Throwable)Preconditions.checkNotNull(t)))) {
            this.complete();
            return true;
        }
        return false;
    }
    
    @Beta
    protected boolean setFuture(final ListenableFuture listenableFuture) {
        Preconditions.checkNotNull(listenableFuture);
        Object o = this.value;
        if (o == null) {
            if (listenableFuture.isDone()) {
                return this.completeWithFuture(listenableFuture, null);
            }
            final AbstractFuture$SetFuture abstractFuture$SetFuture = new AbstractFuture$SetFuture(this, listenableFuture);
            if (AbstractFuture.ATOMIC_HELPER.casValue(this, null, abstractFuture$SetFuture)) {
                try {
                    listenableFuture.addListener(abstractFuture$SetFuture, MoreExecutors.directExecutor());
                }
                catch (Throwable t) {
                    AbstractFuture$Failure fallback_INSTANCE;
                    try {
                        fallback_INSTANCE = new AbstractFuture$Failure(t);
                    }
                    catch (Throwable t2) {
                        fallback_INSTANCE = AbstractFuture$Failure.FALLBACK_INSTANCE;
                    }
                    AbstractFuture.ATOMIC_HELPER.casValue(this, abstractFuture$SetFuture, fallback_INSTANCE);
                }
                return true;
            }
            o = this.value;
        }
        if (o instanceof AbstractFuture$Cancellation) {
            listenableFuture.cancel(((AbstractFuture$Cancellation)o).wasInterrupted);
        }
        return false;
    }
    
    private boolean completeWithFuture(final ListenableFuture listenableFuture, final Object o) {
        Object value;
        if (listenableFuture instanceof AbstractFuture$TrustedFuture) {
            value = ((AbstractFuture)listenableFuture).value;
        }
        else {
            try {
                final Object uninterruptibly = Uninterruptibles.getUninterruptibly(listenableFuture);
                value = ((uninterruptibly == null) ? AbstractFuture.NULL : uninterruptibly);
            }
            catch (ExecutionException ex) {
                value = new AbstractFuture$Failure(ex.getCause());
            }
            catch (CancellationException ex2) {
                value = new AbstractFuture$Cancellation(false, ex2);
            }
            catch (Throwable t) {
                value = new AbstractFuture$Failure(t);
            }
        }
        if (AbstractFuture.ATOMIC_HELPER.casValue(this, o, value)) {
            this.complete();
            return true;
        }
        return false;
    }
    
    private void complete() {
        for (AbstractFuture$Waiter abstractFuture$Waiter = this.clearWaiters(); abstractFuture$Waiter != null; abstractFuture$Waiter = abstractFuture$Waiter.next) {
            abstractFuture$Waiter.unpark();
        }
        AbstractFuture$Listener abstractFuture$Listener;
        AbstractFuture$Listener next;
        AbstractFuture$Listener abstractFuture$Listener2;
        for (abstractFuture$Listener = this.clearListeners(), next = null; abstractFuture$Listener != null; abstractFuture$Listener = abstractFuture$Listener.next, abstractFuture$Listener2.next = next, next = abstractFuture$Listener2) {
            abstractFuture$Listener2 = abstractFuture$Listener;
        }
        while (next != null) {
            executeListener(next.task, next.executor);
            next = next.next;
        }
        this.done();
    }
    
    void done() {
    }
    
    final Throwable trustedGetException() {
        return ((AbstractFuture$Failure)this.value).exception;
    }
    
    final void maybePropagateCancellation(@Nullable final Future future) {
        if (future != null & this.isCancelled()) {
            future.cancel(this.wasInterrupted());
        }
    }
    
    private AbstractFuture$Waiter clearWaiters() {
        AbstractFuture$Waiter waiters;
        do {
            waiters = this.waiters;
        } while (!AbstractFuture.ATOMIC_HELPER.casWaiters(this, waiters, AbstractFuture$Waiter.TOMBSTONE));
        return waiters;
    }
    
    private AbstractFuture$Listener clearListeners() {
        AbstractFuture$Listener listeners;
        do {
            listeners = this.listeners;
        } while (!AbstractFuture.ATOMIC_HELPER.casListeners(this, listeners, AbstractFuture$Listener.TOMBSTONE));
        return listeners;
    }
    
    private static void executeListener(final Runnable runnable, final Executor executor) {
        try {
            executor.execute(runnable);
        }
        catch (RuntimeException ex) {
            final Logger log = AbstractFuture.log;
            final Level severe = Level.SEVERE;
            final String value = String.valueOf(runnable);
            final String value2 = String.valueOf(executor);
            log.log(severe, new StringBuilder(57 + String.valueOf(value).length() + String.valueOf(value2).length()).append("RuntimeException while executing runnable ").append(value).append(" with executor ").append(value2).toString(), ex);
        }
    }
    
    static final CancellationException cancellationExceptionWithCause(@Nullable final String s, @Nullable final Throwable t) {
        final CancellationException ex = new CancellationException(s);
        ex.initCause(t);
        return ex;
    }
    
    static {
        log = Logger.getLogger(AbstractFuture.class.getName());
        AbstractFuture$AtomicHelper atomic_HELPER = null;
        try {
            atomic_HELPER = new AbstractFuture$UnsafeAtomicHelper(null);
        }
        catch (Throwable t) {}
        if (atomic_HELPER == null) {
            WAITER_THREAD_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture$Waiter.class, Thread.class, "thread");
            WAITER_NEXT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture$Waiter.class, AbstractFuture$Waiter.class, "next");
            WAITERS_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, AbstractFuture$Waiter.class, "waiters");
            LISTENERS_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, AbstractFuture$Listener.class, "listeners");
            VALUE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value");
            atomic_HELPER = new AbstractFuture$SafeAtomicHelper(null);
        }
        else {
            WAITER_THREAD_UPDATER = null;
            WAITER_NEXT_UPDATER = null;
            WAITERS_UPDATER = null;
            LISTENERS_UPDATER = null;
            VALUE_UPDATER = null;
        }
        ATOMIC_HELPER = atomic_HELPER;
        NULL = new Object();
    }
}
