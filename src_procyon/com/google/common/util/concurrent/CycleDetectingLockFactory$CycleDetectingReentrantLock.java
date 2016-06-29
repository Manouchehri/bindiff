package com.google.common.util.concurrent;

import javax.annotation.concurrent.*;
import java.util.concurrent.*;
import java.util.logging.*;
import java.util.concurrent.locks.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.annotations.*;
import com.google.common.collect.*;

final class CycleDetectingLockFactory$CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLockFactory$CycleDetectingLock
{
    private final CycleDetectingLockFactory$LockGraphNode lockGraphNode;
    final /* synthetic */ CycleDetectingLockFactory this$0;
    
    private CycleDetectingLockFactory$CycleDetectingReentrantLock(final CycleDetectingLockFactory this$0, final CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, final boolean b) {
        this.this$0 = this$0;
        super(b);
        this.lockGraphNode = (CycleDetectingLockFactory$LockGraphNode)Preconditions.checkNotNull(cycleDetectingLockFactory$LockGraphNode);
    }
    
    @Override
    public CycleDetectingLockFactory$LockGraphNode getLockGraphNode() {
        return this.lockGraphNode;
    }
    
    @Override
    public boolean isAcquiredByCurrentThread() {
        return this.isHeldByCurrentThread();
    }
    
    @Override
    public void lock() {
        this.this$0.aboutToAcquire(this);
        try {
            super.lock();
        }
        finally {
            this.this$0.lockStateChanged(this);
        }
    }
    
    @Override
    public void lockInterruptibly() {
        this.this$0.aboutToAcquire(this);
        try {
            super.lockInterruptibly();
        }
        finally {
            this.this$0.lockStateChanged(this);
        }
    }
    
    @Override
    public boolean tryLock() {
        this.this$0.aboutToAcquire(this);
        try {
            return super.tryLock();
        }
        finally {
            this.this$0.lockStateChanged(this);
        }
    }
    
    @Override
    public boolean tryLock(final long n, final TimeUnit timeUnit) {
        this.this$0.aboutToAcquire(this);
        try {
            return super.tryLock(n, timeUnit);
        }
        finally {
            this.this$0.lockStateChanged(this);
        }
    }
    
    @Override
    public void unlock() {
        try {
            super.unlock();
        }
        finally {
            this.this$0.lockStateChanged(this);
        }
    }
}
