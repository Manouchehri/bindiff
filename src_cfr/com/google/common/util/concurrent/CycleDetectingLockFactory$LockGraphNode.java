/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$ExampleStackTrace;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;
import com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

class CycleDetectingLockFactory$LockGraphNode {
    final Map allowedPriorLocks = new MapMaker().weakKeys().makeMap();
    final Map disallowedPriorLocks = new MapMaker().weakKeys().makeMap();
    final String lockName;

    CycleDetectingLockFactory$LockGraphNode(String string) {
        this.lockName = (String)Preconditions.checkNotNull(string);
    }

    String getLockName() {
        return this.lockName;
    }

    void checkAcquiredLocks(CycleDetectingLockFactory$Policy policy, List list) {
        int n2 = 0;
        int n3 = list.size();
        while (n2 < n3) {
            this.checkAcquiredLock(policy, (CycleDetectingLockFactory$LockGraphNode)list.get(n2));
            ++n2;
        }
    }

    void checkAcquiredLock(CycleDetectingLockFactory$Policy cycleDetectingLockFactory$Policy, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode) {
        Preconditions.checkState(this != cycleDetectingLockFactory$LockGraphNode, "Attempted to acquire multiple locks with the same rank %s", cycleDetectingLockFactory$LockGraphNode.getLockName());
        if (this.allowedPriorLocks.containsKey(cycleDetectingLockFactory$LockGraphNode)) {
            return;
        }
        CycleDetectingLockFactory$PotentialDeadlockException cycleDetectingLockFactory$PotentialDeadlockException = (CycleDetectingLockFactory$PotentialDeadlockException)this.disallowedPriorLocks.get(cycleDetectingLockFactory$LockGraphNode);
        if (cycleDetectingLockFactory$PotentialDeadlockException != null) {
            CycleDetectingLockFactory$PotentialDeadlockException cycleDetectingLockFactory$PotentialDeadlockException2 = new CycleDetectingLockFactory$PotentialDeadlockException(cycleDetectingLockFactory$LockGraphNode, this, cycleDetectingLockFactory$PotentialDeadlockException.getConflictingStackTrace(), null);
            cycleDetectingLockFactory$Policy.handlePotentialDeadlock(cycleDetectingLockFactory$PotentialDeadlockException2);
            return;
        }
        Set set = Sets.newIdentityHashSet();
        CycleDetectingLockFactory$ExampleStackTrace cycleDetectingLockFactory$ExampleStackTrace = cycleDetectingLockFactory$LockGraphNode.findPathTo(this, set);
        if (cycleDetectingLockFactory$ExampleStackTrace == null) {
            this.allowedPriorLocks.put(cycleDetectingLockFactory$LockGraphNode, new CycleDetectingLockFactory$ExampleStackTrace(cycleDetectingLockFactory$LockGraphNode, this));
            return;
        }
        CycleDetectingLockFactory$PotentialDeadlockException cycleDetectingLockFactory$PotentialDeadlockException3 = new CycleDetectingLockFactory$PotentialDeadlockException(cycleDetectingLockFactory$LockGraphNode, this, cycleDetectingLockFactory$ExampleStackTrace, null);
        this.disallowedPriorLocks.put(cycleDetectingLockFactory$LockGraphNode, cycleDetectingLockFactory$PotentialDeadlockException3);
        cycleDetectingLockFactory$Policy.handlePotentialDeadlock(cycleDetectingLockFactory$PotentialDeadlockException3);
    }

    @Nullable
    private CycleDetectingLockFactory$ExampleStackTrace findPathTo(CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, Set set) {
        CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode2;
        Map.Entry entry;
        if (!set.add(this)) {
            return null;
        }
        CycleDetectingLockFactory$ExampleStackTrace cycleDetectingLockFactory$ExampleStackTrace = (CycleDetectingLockFactory$ExampleStackTrace)this.allowedPriorLocks.get(cycleDetectingLockFactory$LockGraphNode);
        if (cycleDetectingLockFactory$ExampleStackTrace != null) {
            return cycleDetectingLockFactory$ExampleStackTrace;
        }
        Iterator iterator = this.allowedPriorLocks.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((cycleDetectingLockFactory$ExampleStackTrace = (cycleDetectingLockFactory$LockGraphNode2 = (CycleDetectingLockFactory$LockGraphNode)(entry = iterator.next()).getKey()).findPathTo(cycleDetectingLockFactory$LockGraphNode, set)) == null);
        CycleDetectingLockFactory$ExampleStackTrace cycleDetectingLockFactory$ExampleStackTrace2 = new CycleDetectingLockFactory$ExampleStackTrace(cycleDetectingLockFactory$LockGraphNode2, this);
        cycleDetectingLockFactory$ExampleStackTrace2.setStackTrace(((CycleDetectingLockFactory$ExampleStackTrace)entry.getValue()).getStackTrace());
        cycleDetectingLockFactory$ExampleStackTrace2.initCause(cycleDetectingLockFactory$ExampleStackTrace);
        return cycleDetectingLockFactory$ExampleStackTrace2;
    }
}

