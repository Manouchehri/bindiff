/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class CycleDetectingLockFactory$CycleDetectingReentrantReadLock
extends ReentrantReadWriteLock.ReadLock {
    final CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock readWriteLock;
    final /* synthetic */ CycleDetectingLockFactory this$0;

    CycleDetectingLockFactory$CycleDetectingReentrantReadLock(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock) {
        this.this$0 = cycleDetectingLockFactory;
        super(cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock);
        this.readWriteLock = cycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock;
    }

    @Override
    public void lock() {
        CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
        try {
            super.lock();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.this$0, this.readWriteLock);
        }
    }

    @Override
    public void lockInterruptibly() {
        CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
        try {
            super.lockInterruptibly();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.this$0, this.readWriteLock);
        }
    }

    @Override
    public boolean tryLock() {
        CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
        try {
            boolean bl2 = super.tryLock();
            return bl2;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.this$0, this.readWriteLock);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean tryLock(long l2, TimeUnit timeUnit) {
        CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);
        try {
            boolean bl2 = super.tryLock(l2, timeUnit);
            return bl2;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.this$0, this.readWriteLock);
        }
    }

    @Override
    public void unlock() {
        try {
            super.unlock();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.this$0, this.readWriteLock);
        }
    }
}

