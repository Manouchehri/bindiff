/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

final class CycleDetectingLockFactory$CycleDetectingReentrantLock
extends ReentrantLock
implements CycleDetectingLockFactory$CycleDetectingLock {
    private final CycleDetectingLockFactory$LockGraphNode lockGraphNode;
    final /* synthetic */ CycleDetectingLockFactory this$0;

    private CycleDetectingLockFactory$CycleDetectingReentrantLock(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, boolean bl2) {
        this.this$0 = cycleDetectingLockFactory;
        super(bl2);
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
        CycleDetectingLockFactory.access$600(this.this$0, this);
        try {
            super.lock();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.this$0, this);
        }
    }

    @Override
    public void lockInterruptibly() {
        CycleDetectingLockFactory.access$600(this.this$0, this);
        try {
            super.lockInterruptibly();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.this$0, this);
        }
    }

    @Override
    public boolean tryLock() {
        CycleDetectingLockFactory.access$600(this.this$0, this);
        try {
            boolean bl2 = super.tryLock();
            return bl2;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.this$0, this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean tryLock(long l2, TimeUnit timeUnit) {
        CycleDetectingLockFactory.access$600(this.this$0, this);
        try {
            boolean bl2 = super.tryLock(l2, timeUnit);
            return bl2;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.this$0, this);
        }
    }

    @Override
    public void unlock() {
        try {
            super.unlock();
            return;
        }
        finally {
            CycleDetectingLockFactory.access$700(this.this$0, this);
        }
    }

    /* synthetic */ CycleDetectingLockFactory$CycleDetectingReentrantLock(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, boolean bl2, CycleDetectingLockFactory$1 cycleDetectingLockFactory$1) {
        this(cycleDetectingLockFactory, cycleDetectingLockFactory$LockGraphNode, bl2);
    }
}

