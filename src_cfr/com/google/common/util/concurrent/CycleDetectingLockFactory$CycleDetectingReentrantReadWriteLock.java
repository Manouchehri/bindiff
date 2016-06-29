/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantWriteLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

final class CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock
extends ReentrantReadWriteLock
implements CycleDetectingLockFactory$CycleDetectingLock {
    private final CycleDetectingLockFactory$CycleDetectingReentrantReadLock readLock;
    private final CycleDetectingLockFactory$CycleDetectingReentrantWriteLock writeLock;
    private final CycleDetectingLockFactory$LockGraphNode lockGraphNode;
    final /* synthetic */ CycleDetectingLockFactory this$0;

    private CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, boolean bl2) {
        this.this$0 = cycleDetectingLockFactory;
        super(bl2);
        this.readLock = new CycleDetectingLockFactory$CycleDetectingReentrantReadLock(cycleDetectingLockFactory, this);
        this.writeLock = new CycleDetectingLockFactory$CycleDetectingReentrantWriteLock(cycleDetectingLockFactory, this);
        this.lockGraphNode = (CycleDetectingLockFactory$LockGraphNode)Preconditions.checkNotNull(cycleDetectingLockFactory$LockGraphNode);
    }

    @Override
    public ReentrantReadWriteLock.ReadLock readLock() {
        return this.readLock;
    }

    @Override
    public ReentrantReadWriteLock.WriteLock writeLock() {
        return this.writeLock;
    }

    @Override
    public CycleDetectingLockFactory$LockGraphNode getLockGraphNode() {
        return this.lockGraphNode;
    }

    @Override
    public boolean isAcquiredByCurrentThread() {
        if (this.isWriteLockedByCurrentThread()) return true;
        if (this.getReadHoldCount() > 0) return true;
        return false;
    }

    /* synthetic */ CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, boolean bl2, CycleDetectingLockFactory$1 cycleDetectingLockFactory$1) {
        this(cycleDetectingLockFactory, cycleDetectingLockFactory$LockGraphNode, bl2);
    }
}

