package com.google.common.util.concurrent;

import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;
import javax.annotation.*;

class CycleDetectingLockFactory$LockGraphNode
{
    final Map allowedPriorLocks;
    final Map disallowedPriorLocks;
    final String lockName;
    
    CycleDetectingLockFactory$LockGraphNode(final String s) {
        this.allowedPriorLocks = new MapMaker().weakKeys().makeMap();
        this.disallowedPriorLocks = new MapMaker().weakKeys().makeMap();
        this.lockName = (String)Preconditions.checkNotNull(s);
    }
    
    String getLockName() {
        return this.lockName;
    }
    
    void checkAcquiredLocks(final CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy, final List list) {
        for (int i = 0; i < list.size(); ++i) {
            this.checkAcquiredLock(cycleDetectingLockFactory$Policy, list.get(i));
        }
    }
    
    void checkAcquiredLock(final CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy, final CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode) {
        Preconditions.checkState(this != cycleDetectingLockFactory$LockGraphNode, "Attempted to acquire multiple locks with the same rank %s", cycleDetectingLockFactory$LockGraphNode.getLockName());
        if (this.allowedPriorLocks.containsKey(cycleDetectingLockFactory$LockGraphNode)) {
            return;
        }
        final CycleDetectingLockFactory$PotentialDeadlockException ex = this.disallowedPriorLocks.get(cycleDetectingLockFactory$LockGraphNode);
        if (ex != null) {
            cycleDetectingLockFactory$Policy.handlePotentialDeadlock(new CycleDetectingLockFactory$PotentialDeadlockException(cycleDetectingLockFactory$LockGraphNode, this, ex.getConflictingStackTrace(), null));
            return;
        }
        final CycleDetectingLockFactory$ExampleStackTrace pathTo = cycleDetectingLockFactory$LockGraphNode.findPathTo(this, Sets.newIdentityHashSet());
        if (pathTo == null) {
            this.allowedPriorLocks.put(cycleDetectingLockFactory$LockGraphNode, new CycleDetectingLockFactory$ExampleStackTrace(cycleDetectingLockFactory$LockGraphNode, this));
        }
        else {
            final CycleDetectingLockFactory$PotentialDeadlockException ex2 = new CycleDetectingLockFactory$PotentialDeadlockException(cycleDetectingLockFactory$LockGraphNode, this, pathTo, null);
            this.disallowedPriorLocks.put(cycleDetectingLockFactory$LockGraphNode, ex2);
            cycleDetectingLockFactory$Policy.handlePotentialDeadlock(ex2);
        }
    }
    
    @Nullable
    private CycleDetectingLockFactory$ExampleStackTrace findPathTo(final CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, final Set set) {
        if (!set.add(this)) {
            return null;
        }
        final CycleDetectingLockFactory$ExampleStackTrace cycleDetectingLockFactory$ExampleStackTrace = this.allowedPriorLocks.get(cycleDetectingLockFactory$LockGraphNode);
        if (cycleDetectingLockFactory$ExampleStackTrace != null) {
            return cycleDetectingLockFactory$ExampleStackTrace;
        }
        for (final Map.Entry<CycleDetectingLockFactory$LockGraphNode, V> entry : this.allowedPriorLocks.entrySet()) {
            final CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode2 = entry.getKey();
            final CycleDetectingLockFactory$ExampleStackTrace pathTo = cycleDetectingLockFactory$LockGraphNode2.findPathTo(cycleDetectingLockFactory$LockGraphNode, set);
            if (pathTo != null) {
                final CycleDetectingLockFactory$ExampleStackTrace cycleDetectingLockFactory$ExampleStackTrace2 = new CycleDetectingLockFactory$ExampleStackTrace(cycleDetectingLockFactory$LockGraphNode2, this);
                cycleDetectingLockFactory$ExampleStackTrace2.setStackTrace(((CycleDetectingLockFactory$ExampleStackTrace)entry.getValue()).getStackTrace());
                cycleDetectingLockFactory$ExampleStackTrace2.initCause(pathTo);
                return cycleDetectingLockFactory$ExampleStackTrace2;
            }
        }
        return null;
    }
}
