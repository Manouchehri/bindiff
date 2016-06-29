package com.google.common.util.concurrent;

abstract class AbstractFuture$AtomicHelper
{
    abstract void putThread(final AbstractFuture$Waiter p0, final Thread p1);
    
    abstract void putNext(final AbstractFuture$Waiter p0, final AbstractFuture$Waiter p1);
    
    abstract boolean casWaiters(final AbstractFuture p0, final AbstractFuture$Waiter p1, final AbstractFuture$Waiter p2);
    
    abstract boolean casListeners(final AbstractFuture p0, final AbstractFuture$Listener p1, final AbstractFuture$Listener p2);
    
    abstract boolean casValue(final AbstractFuture p0, final Object p1, final Object p2);
}
