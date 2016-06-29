package com.google.common.util.concurrent;

import javax.annotation.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;
import java.util.logging.*;

final class AbstractFuture$Waiter
{
    static final AbstractFuture$Waiter TOMBSTONE;
    @Nullable
    volatile Thread thread;
    @Nullable
    volatile AbstractFuture$Waiter next;
    
    AbstractFuture$Waiter(final boolean b) {
    }
    
    AbstractFuture$Waiter() {
        AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
    }
    
    void setNext(final AbstractFuture$Waiter abstractFuture$Waiter) {
        AbstractFuture.ATOMIC_HELPER.putNext(this, abstractFuture$Waiter);
    }
    
    void unpark() {
        final Thread thread = this.thread;
        if (thread != null) {
            this.thread = null;
            LockSupport.unpark(thread);
        }
    }
    
    static {
        TOMBSTONE = new AbstractFuture$Waiter(false);
    }
}
