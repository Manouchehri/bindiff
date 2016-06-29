package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.*;
import java.util.concurrent.locks.*;

@Beta
public final class CycleDetectingLockFactory$WithExplicitOrdering extends CycleDetectingLockFactory
{
    private final Map lockGraphNodes;
    
    CycleDetectingLockFactory$WithExplicitOrdering(final CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy, final Map lockGraphNodes) {
        super(cycleDetectingLockFactory$Policy, null);
        this.lockGraphNodes = lockGraphNodes;
    }
    
    public ReentrantLock newReentrantLock(final Enum enum1) {
        return this.newReentrantLock(enum1, false);
    }
    
    public ReentrantLock newReentrantLock(final Enum enum1, final boolean b) {
        return (this.policy == CycleDetectingLockFactory$Policies.DISABLED) ? new ReentrantLock(b) : new CycleDetectingLockFactory$CycleDetectingReentrantLock(this, this.lockGraphNodes.get(enum1), b, null);
    }
    
    public ReentrantReadWriteLock newReentrantReadWriteLock(final Enum enum1) {
        return this.newReentrantReadWriteLock(enum1, false);
    }
    
    public ReentrantReadWriteLock newReentrantReadWriteLock(final Enum enum1, final boolean b) {
        return (this.policy == CycleDetectingLockFactory$Policies.DISABLED) ? new ReentrantReadWriteLock(b) : new CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(this, this.lockGraphNodes.get(enum1), b, null);
    }
}
