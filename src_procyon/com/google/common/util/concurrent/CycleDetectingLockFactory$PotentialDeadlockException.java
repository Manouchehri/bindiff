package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@Beta
public final class CycleDetectingLockFactory$PotentialDeadlockException extends CycleDetectingLockFactory$ExampleStackTrace
{
    private final CycleDetectingLockFactory$ExampleStackTrace conflictingStackTrace;
    
    private CycleDetectingLockFactory$PotentialDeadlockException(final CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, final CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode2, final CycleDetectingLockFactory$ExampleStackTrace conflictingStackTrace) {
        super(cycleDetectingLockFactory$LockGraphNode, cycleDetectingLockFactory$LockGraphNode2);
        this.initCause(this.conflictingStackTrace = conflictingStackTrace);
    }
    
    public CycleDetectingLockFactory$ExampleStackTrace getConflictingStackTrace() {
        return this.conflictingStackTrace;
    }
    
    @Override
    public String getMessage() {
        final StringBuilder sb = new StringBuilder(super.getMessage());
        for (Throwable t = this.conflictingStackTrace; t != null; t = t.getCause()) {
            sb.append(", ").append(t.getMessage());
        }
        return sb.toString();
    }
}
