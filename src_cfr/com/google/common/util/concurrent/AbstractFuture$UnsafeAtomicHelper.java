/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$1;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1;
import com.google.common.util.concurrent.AbstractFuture$Waiter;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

final class AbstractFuture$UnsafeAtomicHelper
extends AbstractFuture$AtomicHelper {
    static final Unsafe UNSAFE;
    static final long LISTENERS_OFFSET;
    static final long WAITERS_OFFSET;
    static final long VALUE_OFFSET;
    static final long WAITER_THREAD_OFFSET;
    static final long WAITER_NEXT_OFFSET;

    private AbstractFuture$UnsafeAtomicHelper() {
        super(null);
    }

    @Override
    void putThread(AbstractFuture$Waiter abstractFuture$Waiter, Thread thread) {
        UNSAFE.putObject((Object)abstractFuture$Waiter, WAITER_THREAD_OFFSET, (Object)thread);
    }

    @Override
    void putNext(AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        UNSAFE.putObject((Object)abstractFuture$Waiter, WAITER_NEXT_OFFSET, (Object)abstractFuture$Waiter2);
    }

    @Override
    boolean casWaiters(AbstractFuture abstractFuture, AbstractFuture$Waiter abstractFuture$Waiter, AbstractFuture$Waiter abstractFuture$Waiter2) {
        return UNSAFE.compareAndSwapObject(abstractFuture, WAITERS_OFFSET, abstractFuture$Waiter, abstractFuture$Waiter2);
    }

    @Override
    boolean casListeners(AbstractFuture abstractFuture, AbstractFuture$Listener abstractFuture$Listener, AbstractFuture$Listener abstractFuture$Listener2) {
        return UNSAFE.compareAndSwapObject(abstractFuture, LISTENERS_OFFSET, abstractFuture$Listener, abstractFuture$Listener2);
    }

    @Override
    boolean casValue(AbstractFuture abstractFuture, Object object, Object object2) {
        return UNSAFE.compareAndSwapObject(abstractFuture, VALUE_OFFSET, object, object2);
    }

    /* synthetic */ AbstractFuture$UnsafeAtomicHelper(AbstractFuture$1 abstractFuture$1) {
        this();
    }

    static {
        Unsafe unsafe = null;
        try {
            unsafe = Unsafe.getUnsafe();
        }
        catch (SecurityException var1_1) {
            try {
                unsafe = (Unsafe)AccessController.doPrivileged(new AbstractFuture$UnsafeAtomicHelper$1());
            }
            catch (PrivilegedActionException var2_4) {
                throw new RuntimeException("Could not initialize intrinsics", var2_4.getCause());
            }
        }
        try {
            reference var1_2 = AbstractFuture.class;
            WAITERS_OFFSET = unsafe.objectFieldOffset(var1_2.getDeclaredField("waiters"));
            LISTENERS_OFFSET = unsafe.objectFieldOffset(var1_2.getDeclaredField("listeners"));
            VALUE_OFFSET = unsafe.objectFieldOffset(var1_2.getDeclaredField("value"));
            WAITER_THREAD_OFFSET = unsafe.objectFieldOffset(AbstractFuture$Waiter.class.getDeclaredField("thread"));
            WAITER_NEXT_OFFSET = unsafe.objectFieldOffset(AbstractFuture$Waiter.class.getDeclaredField("next"));
            UNSAFE = unsafe;
            return;
        }
        catch (Exception var1_3) {
            throw Throwables.propagate(var1_3);
        }
    }
}

