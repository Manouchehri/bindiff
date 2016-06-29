/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$ExampleStackTrace;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;

@Beta
public final class CycleDetectingLockFactory$PotentialDeadlockException
extends CycleDetectingLockFactory$ExampleStackTrace {
    private final CycleDetectingLockFactory$ExampleStackTrace conflictingStackTrace;

    private CycleDetectingLockFactory$PotentialDeadlockException(CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode2, CycleDetectingLockFactory$ExampleStackTrace cycleDetectingLockFactory$ExampleStackTrace) {
        super(cycleDetectingLockFactory$LockGraphNode, cycleDetectingLockFactory$LockGraphNode2);
        this.conflictingStackTrace = cycleDetectingLockFactory$ExampleStackTrace;
        this.initCause(cycleDetectingLockFactory$ExampleStackTrace);
    }

    public CycleDetectingLockFactory$ExampleStackTrace getConflictingStackTrace() {
        return this.conflictingStackTrace;
    }

    @Override
    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder(super.getMessage());
        Throwable throwable = this.conflictingStackTrace;
        while (throwable != null) {
            stringBuilder.append(", ").append(throwable.getMessage());
            throwable = throwable.getCause();
        }
        return stringBuilder.toString();
    }

    /* synthetic */ CycleDetectingLockFactory$PotentialDeadlockException(CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode2, CycleDetectingLockFactory$ExampleStackTrace cycleDetectingLockFactory$ExampleStackTrace, CycleDetectingLockFactory$1 cycleDetectingLockFactory$1) {
        this(cycleDetectingLockFactory$LockGraphNode, cycleDetectingLockFactory$LockGraphNode2, cycleDetectingLockFactory$ExampleStackTrace);
    }
}

