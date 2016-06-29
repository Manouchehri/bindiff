/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Beta
public final class CycleDetectingLockFactory$WithExplicitOrdering
extends CycleDetectingLockFactory {
    private final Map lockGraphNodes;

    @VisibleForTesting
    CycleDetectingLockFactory$WithExplicitOrdering(CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy, Map map) {
        super(cycleDetectingLockFactory$Policy, null);
        this.lockGraphNodes = map;
    }

    public ReentrantLock newReentrantLock(Enum enum_) {
        return this.newReentrantLock(enum_, false);
    }

    public ReentrantLock newReentrantLock(Enum enum_, boolean bl2) {
        ReentrantLock reentrantLock;
        if (this.policy == CycleDetectingLockFactory$Policies.DISABLED) {
            reentrantLock = new ReentrantLock(bl2);
            return reentrantLock;
        }
        reentrantLock = new CycleDetectingLockFactory$CycleDetectingReentrantLock(this, (CycleDetectingLockFactory$LockGraphNode)this.lockGraphNodes.get(enum_), bl2, null);
        return reentrantLock;
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(Enum enum_) {
        return this.newReentrantReadWriteLock(enum_, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(Enum enum_, boolean bl2) {
        ReentrantReadWriteLock reentrantReadWriteLock;
        if (this.policy == CycleDetectingLockFactory$Policies.DISABLED) {
            reentrantReadWriteLock = new ReentrantReadWriteLock(bl2);
            return reentrantReadWriteLock;
        }
        reentrantReadWriteLock = new CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(this, (CycleDetectingLockFactory$LockGraphNode)this.lockGraphNodes.get(enum_), bl2, null);
        return reentrantReadWriteLock;
    }
}

