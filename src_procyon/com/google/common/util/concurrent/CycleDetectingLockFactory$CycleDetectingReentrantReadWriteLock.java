package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.locks.*;

final class CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLockFactory$CycleDetectingLock
{
    private final CycleDetectingLockFactory$CycleDetectingReentrantReadLock readLock;
    private final CycleDetectingLockFactory$CycleDetectingReentrantWriteLock writeLock;
    private final CycleDetectingLockFactory$LockGraphNode lockGraphNode;
    final /* synthetic */ CycleDetectingLockFactory this$0;
    
    private CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(final CycleDetectingLockFactory this$0, final CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, final boolean b) {
        this.this$0 = this$0;
        super(b);
        this.readLock = new CycleDetectingLockFactory$CycleDetectingReentrantReadLock(this$0, this);
        this.writeLock = new CycleDetectingLockFactory$CycleDetectingReentrantWriteLock(this$0, this);
        this.lockGraphNode = (CycleDetectingLockFactory$LockGraphNode)Preconditions.checkNotNull(cycleDetectingLockFactory$LockGraphNode);
    }
    
    @Override
    public ReadLock readLock() {
        return this.readLock;
    }
    
    @Override
    public WriteLock writeLock() {
        return this.writeLock;
    }
    
    @Override
    public CycleDetectingLockFactory$LockGraphNode getLockGraphNode() {
        return this.lockGraphNode;
    }
    
    @Override
    public boolean isAcquiredByCurrentThread() {
        return this.isWriteLockedByCurrentThread() || this.getReadHoldCount() > 0;
    }
}
