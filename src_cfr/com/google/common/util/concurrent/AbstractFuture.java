/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture$1;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Cancellation;
import com.google.common.util.concurrent.AbstractFuture$Failure;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$SafeAtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$SetFuture;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Waiter;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public abstract class AbstractFuture
implements ListenableFuture {
    private static final Logger log = Logger.getLogger(AbstractFuture.class.getName());
    private static final long SPIN_THRESHOLD_NANOS = 1000;
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

    /*
     * Unable to fully structure code
     */
    private void removeWaiter(AbstractFuture$Waiter var1_1) {
        var1_1.thread = null;
        block0 : do {
            var2_2 = null;
            var3_3 = this.waiters;
            if (var3_3 == AbstractFuture$Waiter.TOMBSTONE) {
                return;
            }
            while (var3_3 != null) {
                var4_4 = var3_3.next;
                if (var3_3.thread != null) {
                    var2_2 = var3_3;
                } else if (var2_2 != null) {
                    var2_2.next = var4_4;
                    if (var2_2.thread == null) {
                        continue block0;
                    }
                } else {
                    if (AbstractFuture.ATOMIC_HELPER.casWaiters(this, var3_3, var4_4)) ** break;
                    continue block0;
                }
                var3_3 = var4_4;
            }
            return;
            break;
        } while (true);
    }

    protected AbstractFuture() {
    }

    public Object get(long l2, TimeUnit timeUnit) {
        long l3;
        long l4 = timeUnit.toNanos(l2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object object = this.value;
        if (object != null & !(object instanceof AbstractFuture$SetFuture)) {
            return this.getDoneValue(object);
        }
        long l5 = l3 = l4 > 0 ? System.nanoTime() + l4 : 0;
        if (l4 >= 1000) {
            AbstractFuture$Waiter abstractFuture$Waiter;
            block9 : {
                AbstractFuture$Waiter abstractFuture$Waiter2 = this.waiters;
                if (abstractFuture$Waiter2 == AbstractFuture$Waiter.TOMBSTONE) return this.getDoneValue(this.value);
                abstractFuture$Waiter = new AbstractFuture$Waiter();
                do {
                    abstractFuture$Waiter.setNext(abstractFuture$Waiter2);
                    if (ATOMIC_HELPER.casWaiters(this, abstractFuture$Waiter2, abstractFuture$Waiter)) break block9;
                } while ((abstractFuture$Waiter2 = this.waiters) != AbstractFuture$Waiter.TOMBSTONE);
                return this.getDoneValue(this.value);
            }
            do {
                LockSupport.parkNanos(this, l4);
                if (Thread.interrupted()) {
                    this.removeWaiter(abstractFuture$Waiter);
                    throw new InterruptedException();
                }
                object = this.value;
                if (!(object != null & !(object instanceof AbstractFuture$SetFuture))) continue;
                return this.getDoneValue(object);
            } while ((l4 = l3 - System.nanoTime()) >= 1000);
            this.removeWaiter(abstractFuture$Waiter);
        }
        while (l4 > 0) {
            object = this.value;
            if (object != null & !(object instanceof AbstractFuture$SetFuture)) {
                return this.getDoneValue(object);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            l4 = l3 - System.nanoTime();
        }
        throw new TimeoutException();
    }

    public Object get() {
        Object object;
        AbstractFuture$Waiter abstractFuture$Waiter;
        block4 : {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            object = this.value;
            if (object != null & !(object instanceof AbstractFuture$SetFuture)) {
                return this.getDoneValue(object);
            }
            AbstractFuture$Waiter abstractFuture$Waiter2 = this.waiters;
            if (abstractFuture$Waiter2 == AbstractFuture$Waiter.TOMBSTONE) return this.getDoneValue(this.value);
            abstractFuture$Waiter = new AbstractFuture$Waiter();
            do {
                abstractFuture$Waiter.setNext(abstractFuture$Waiter2);
                if (ATOMIC_HELPER.casWaiters(this, abstractFuture$Waiter2, abstractFuture$Waiter)) break block4;
            } while ((abstractFuture$Waiter2 = this.waiters) != AbstractFuture$Waiter.TOMBSTONE);
            return this.getDoneValue(this.value);
        }
        do {
            LockSupport.park(this);
            if (!Thread.interrupted()) continue;
            this.removeWaiter(abstractFuture$Waiter);
            throw new InterruptedException();
        } while (!((object = this.value) != null & !(object instanceof AbstractFuture$SetFuture)));
        return this.getDoneValue(object);
    }

    private Object getDoneValue(Object object) {
        if (object instanceof AbstractFuture$Cancellation) {
            throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", ((AbstractFuture$Cancellation)object).cause);
        }
        if (object instanceof AbstractFuture$Failure) {
            throw new ExecutionException(((AbstractFuture$Failure)object).exception);
        }
        if (object != NULL) return object;
        return null;
    }

    @Override
    public boolean isDone() {
        boolean bl2;
        Object object = this.value;
        boolean bl3 = object != null;
        if (!(object instanceof AbstractFuture$SetFuture)) {
            bl2 = true;
            return bl3 & bl2;
        }
        bl2 = false;
        return bl3 & bl2;
    }

    @Override
    public boolean isCancelled() {
        Object object = this.value;
        return object instanceof AbstractFuture$Cancellation;
    }

    @Override
    public boolean cancel(boolean bl2) {
        Object object = this.value;
        if (!(object == null | object instanceof AbstractFuture$SetFuture)) return false;
        AbstractFuture$Cancellation abstractFuture$Cancellation = new AbstractFuture$Cancellation(bl2, this.newCancellationCause());
        do {
            if (!ATOMIC_HELPER.casValue(this, object, abstractFuture$Cancellation)) continue;
            if (bl2) {
                this.interruptTask();
            }
            this.complete();
            if (!(object instanceof AbstractFuture$SetFuture)) return true;
            ((AbstractFuture$SetFuture)object).future.cancel(bl2);
            return true;
        } while ((object = this.value) instanceof AbstractFuture$SetFuture);
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
        Object object = this.value;
        if (!(object instanceof AbstractFuture$Cancellation)) return false;
        if (!((AbstractFuture$Cancellation)object).wasInterrupted) return false;
        return true;
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        AbstractFuture$Listener abstractFuture$Listener = this.listeners;
        if (abstractFuture$Listener != AbstractFuture$Listener.TOMBSTONE) {
            AbstractFuture$Listener abstractFuture$Listener2 = new AbstractFuture$Listener(runnable, executor);
            do {
                abstractFuture$Listener2.next = abstractFuture$Listener;
                if (!ATOMIC_HELPER.casListeners(this, abstractFuture$Listener, abstractFuture$Listener2)) continue;
                return;
            } while ((abstractFuture$Listener = this.listeners) != AbstractFuture$Listener.TOMBSTONE);
        }
        AbstractFuture.executeListener(runnable, executor);
    }

    protected boolean set(@Nullable Object object) {
        Object object2 = object == null ? NULL : object;
        if (!ATOMIC_HELPER.casValue(this, null, object2)) return false;
        this.complete();
        return true;
    }

    protected boolean setException(Throwable throwable) {
        AbstractFuture$Failure abstractFuture$Failure = new AbstractFuture$Failure((Throwable)Preconditions.checkNotNull(throwable));
        if (!ATOMIC_HELPER.casValue(this, null, abstractFuture$Failure)) return false;
        this.complete();
        return true;
    }

    @Beta
    protected boolean setFuture(ListenableFuture listenableFuture) {
        Preconditions.checkNotNull(listenableFuture);
        Object object = this.value;
        if (object == null) {
            if (listenableFuture.isDone()) {
                return this.completeWithFuture(listenableFuture, null);
            }
            AbstractFuture$SetFuture abstractFuture$SetFuture = new AbstractFuture$SetFuture(this, listenableFuture);
            if (ATOMIC_HELPER.casValue(this, null, abstractFuture$SetFuture)) {
                try {
                    listenableFuture.addListener(abstractFuture$SetFuture, MoreExecutors.directExecutor());
                    return true;
                }
                catch (Throwable var4_4) {
                    AbstractFuture$Failure abstractFuture$Failure;
                    try {
                        abstractFuture$Failure = new AbstractFuture$Failure(var4_4);
                    }
                    catch (Throwable var6_6) {
                        abstractFuture$Failure = AbstractFuture$Failure.FALLBACK_INSTANCE;
                    }
                    ATOMIC_HELPER.casValue(this, abstractFuture$SetFuture, abstractFuture$Failure);
                }
                return true;
            }
            object = this.value;
        }
        if (!(object instanceof AbstractFuture$Cancellation)) return false;
        listenableFuture.cancel(((AbstractFuture$Cancellation)object).wasInterrupted);
        return false;
    }

    private boolean completeWithFuture(ListenableFuture listenableFuture, Object object) {
        Object object2;
        if (listenableFuture instanceof AbstractFuture$TrustedFuture) {
            object2 = ((AbstractFuture)listenableFuture).value;
        } else {
            try {
                Object object3 = Uninterruptibles.getUninterruptibly(listenableFuture);
                object2 = object3 == null ? NULL : object3;
            }
            catch (ExecutionException var4_5) {
                object2 = new AbstractFuture$Failure(var4_5.getCause());
            }
            catch (CancellationException var4_6) {
                object2 = new AbstractFuture$Cancellation(false, var4_6);
            }
            catch (Throwable var4_7) {
                object2 = new AbstractFuture$Failure(var4_7);
            }
        }
        if (!ATOMIC_HELPER.casValue(this, object, object2)) return false;
        this.complete();
        return true;
    }

    private void complete() {
        Object object = this.clearWaiters();
        while (object != null) {
            object.unpark();
            object = object.next;
        }
        object = this.clearListeners();
        Object object2 = null;
        do {
            if (object == null) {
                this.done();
                return;
            }
            Object object3 = object;
            object = object.next;
            object3.next = object2;
            object2 = object3;
        } while (true);
    }

    void done() {
    }

    final Throwable trustedGetException() {
        return ((AbstractFuture$Failure)this.value).exception;
    }

    final void maybePropagateCancellation(@Nullable Future future) {
        if (!(future != null & this.isCancelled())) return;
        future.cancel(this.wasInterrupted());
    }

    private AbstractFuture$Waiter clearWaiters() {
        AbstractFuture$Waiter abstractFuture$Waiter;
        while (!ATOMIC_HELPER.casWaiters(this, abstractFuture$Waiter = this.waiters, AbstractFuture$Waiter.TOMBSTONE)) {
        }
        return abstractFuture$Waiter;
    }

    private AbstractFuture$Listener clearListeners() {
        AbstractFuture$Listener abstractFuture$Listener;
        while (!ATOMIC_HELPER.casListeners(this, abstractFuture$Listener = this.listeners, AbstractFuture$Listener.TOMBSTONE)) {
        }
        return abstractFuture$Listener;
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
            return;
        }
        catch (RuntimeException var2_2) {
            String string = String.valueOf(runnable);
            String string2 = String.valueOf(executor);
            log.log(Level.SEVERE, new StringBuilder(57 + String.valueOf(string).length() + String.valueOf(string2).length()).append("RuntimeException while executing runnable ").append(string).append(" with executor ").append(string2).toString(), var2_2);
        }
    }

    static final CancellationException cancellationExceptionWithCause(@Nullable String string, @Nullable Throwable throwable) {
        CancellationException cancellationException = new CancellationException(string);
        cancellationException.initCause(throwable);
        return cancellationException;
    }

    static /* synthetic */ AbstractFuture$AtomicHelper access$200() {
        return ATOMIC_HELPER;
    }

    static /* synthetic */ Object access$300(AbstractFuture abstractFuture) {
        return abstractFuture.value;
    }

    static /* synthetic */ boolean access$400(AbstractFuture abstractFuture, ListenableFuture listenableFuture, Object object) {
        return abstractFuture.completeWithFuture(listenableFuture, object);
    }

    static /* synthetic */ AtomicReferenceFieldUpdater access$600() {
        return WAITER_THREAD_UPDATER;
    }

    static /* synthetic */ AtomicReferenceFieldUpdater access$700() {
        return WAITER_NEXT_UPDATER;
    }

    static /* synthetic */ AtomicReferenceFieldUpdater access$800() {
        return WAITERS_UPDATER;
    }

    static /* synthetic */ AtomicReferenceFieldUpdater access$900() {
        return LISTENERS_UPDATER;
    }

    static /* synthetic */ AtomicReferenceFieldUpdater access$1000() {
        return VALUE_UPDATER;
    }

    static {
        AbstractFuture$AtomicHelper abstractFuture$AtomicHelper = null;
        try {
            abstractFuture$AtomicHelper = new AbstractFuture$UnsafeAtomicHelper(null);
        }
        catch (Throwable var1_1) {
            // empty catch block
        }
        if (abstractFuture$AtomicHelper == null) {
            WAITER_THREAD_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture$Waiter.class, Thread.class, "thread");
            WAITER_NEXT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture$Waiter.class, AbstractFuture$Waiter.class, "next");
            WAITERS_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, AbstractFuture$Waiter.class, "waiters");
            LISTENERS_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, AbstractFuture$Listener.class, "listeners");
            VALUE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value");
            abstractFuture$AtomicHelper = new AbstractFuture$SafeAtomicHelper(null);
        } else {
            WAITER_THREAD_UPDATER = null;
            WAITER_NEXT_UPDATER = null;
            WAITERS_UPDATER = null;
            LISTENERS_UPDATER = null;
            VALUE_UPDATER = null;
        }
        ATOMIC_HELPER = abstractFuture$AtomicHelper;
        reference var1_2 = LockSupport.class;
        NULL = new Object();
    }
}

