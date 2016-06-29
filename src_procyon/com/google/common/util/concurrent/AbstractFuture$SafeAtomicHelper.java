package com.google.common.util.concurrent;

import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.concurrent.*;
import java.util.logging.*;

final class AbstractFuture$SafeAtomicHelper extends AbstractFuture$AtomicHelper
{
    private AbstractFuture$SafeAtomicHelper() {
        super(null);
    }
    
    @Override
    void putThread(final AbstractFuture$Waiter abstractFuture$Waiter, final Thread thread) {
        AbstractFuture.WAITER_THREAD_UPDATER.lazySet(abstractFuture$Waiter, thread);
    }
    
    @Override
    void putNext(final AbstractFuture$Waiter abstractFuture$Waiter, final AbstractFuture$Waiter abstractFuture$Waiter2) {
        AbstractFuture.WAITER_NEXT_UPDATER.lazySet(abstractFuture$Waiter, abstractFuture$Waiter2);
    }
    
    @Override
    boolean casWaiters(final AbstractFuture abstractFuture, final AbstractFuture$Waiter abstractFuture$Waiter, final AbstractFuture$Waiter abstractFuture$Waiter2) {
        return AbstractFuture.WAITERS_UPDATER.compareAndSet(abstractFuture, abstractFuture$Waiter, abstractFuture$Waiter2);
    }
    
    @Override
    boolean casListeners(final AbstractFuture abstractFuture, final AbstractFuture$Listener abstractFuture$Listener, final AbstractFuture$Listener abstractFuture$Listener2) {
        return AbstractFuture.LISTENERS_UPDATER.compareAndSet(abstractFuture, abstractFuture$Listener, abstractFuture$Listener2);
    }
    
    @Override
    boolean casValue(final AbstractFuture abstractFuture, final Object o, final Object o2) {
        return AbstractFuture.VALUE_UPDATER.compareAndSet(abstractFuture, o, o2);
    }
}
