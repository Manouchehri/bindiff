package com.google.common.util.concurrent;

import sun.misc.*;
import java.security.*;
import com.google.common.base.*;

final class AbstractFuture$UnsafeAtomicHelper extends AbstractFuture$AtomicHelper
{
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
    void putThread(final AbstractFuture$Waiter abstractFuture$Waiter, final Thread thread) {
        AbstractFuture$UnsafeAtomicHelper.UNSAFE.putObject(abstractFuture$Waiter, AbstractFuture$UnsafeAtomicHelper.WAITER_THREAD_OFFSET, thread);
    }
    
    @Override
    void putNext(final AbstractFuture$Waiter abstractFuture$Waiter, final AbstractFuture$Waiter abstractFuture$Waiter2) {
        AbstractFuture$UnsafeAtomicHelper.UNSAFE.putObject(abstractFuture$Waiter, AbstractFuture$UnsafeAtomicHelper.WAITER_NEXT_OFFSET, abstractFuture$Waiter2);
    }
    
    @Override
    boolean casWaiters(final AbstractFuture abstractFuture, final AbstractFuture$Waiter abstractFuture$Waiter, final AbstractFuture$Waiter abstractFuture$Waiter2) {
        return AbstractFuture$UnsafeAtomicHelper.UNSAFE.compareAndSwapObject(abstractFuture, AbstractFuture$UnsafeAtomicHelper.WAITERS_OFFSET, abstractFuture$Waiter, abstractFuture$Waiter2);
    }
    
    @Override
    boolean casListeners(final AbstractFuture abstractFuture, final AbstractFuture$Listener abstractFuture$Listener, final AbstractFuture$Listener abstractFuture$Listener2) {
        return AbstractFuture$UnsafeAtomicHelper.UNSAFE.compareAndSwapObject(abstractFuture, AbstractFuture$UnsafeAtomicHelper.LISTENERS_OFFSET, abstractFuture$Listener, abstractFuture$Listener2);
    }
    
    @Override
    boolean casValue(final AbstractFuture abstractFuture, final Object o, final Object o2) {
        return AbstractFuture$UnsafeAtomicHelper.UNSAFE.compareAndSwapObject(abstractFuture, AbstractFuture$UnsafeAtomicHelper.VALUE_OFFSET, o, o2);
    }
    
    static {
        Unsafe unsafe;
        try {
            unsafe = Unsafe.getUnsafe();
        }
        catch (SecurityException ex3) {
            try {
                unsafe = AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>)new AbstractFuture$UnsafeAtomicHelper$1());
            }
            catch (PrivilegedActionException ex) {
                throw new RuntimeException("Could not initialize intrinsics", ex.getCause());
            }
        }
        try {
            final Class<AbstractFuture> clazz = AbstractFuture.class;
            WAITERS_OFFSET = unsafe.objectFieldOffset(clazz.getDeclaredField("waiters"));
            LISTENERS_OFFSET = unsafe.objectFieldOffset(clazz.getDeclaredField("listeners"));
            VALUE_OFFSET = unsafe.objectFieldOffset(clazz.getDeclaredField("value"));
            WAITER_THREAD_OFFSET = unsafe.objectFieldOffset(AbstractFuture$Waiter.class.getDeclaredField("thread"));
            WAITER_NEXT_OFFSET = unsafe.objectFieldOffset(AbstractFuture$Waiter.class.getDeclaredField("next"));
            UNSAFE = unsafe;
        }
        catch (Exception ex2) {
            throw Throwables.propagate(ex2);
        }
    }
}
