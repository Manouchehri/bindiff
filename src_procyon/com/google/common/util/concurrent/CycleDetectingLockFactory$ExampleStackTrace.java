package com.google.common.util.concurrent;

import java.util.*;
import com.google.common.collect.*;

class CycleDetectingLockFactory$ExampleStackTrace extends IllegalStateException
{
    static final StackTraceElement[] EMPTY_STACK_TRACE;
    static final Set EXCLUDED_CLASS_NAMES;
    
    CycleDetectingLockFactory$ExampleStackTrace(final CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, final CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode2) {
        final String lockName = cycleDetectingLockFactory$LockGraphNode.getLockName();
        final String lockName2 = cycleDetectingLockFactory$LockGraphNode2.getLockName();
        super(new StringBuilder(4 + String.valueOf(lockName).length() + String.valueOf(lockName2).length()).append(lockName).append(" -> ").append(lockName2).toString());
        final StackTraceElement[] stackTrace = this.getStackTrace();
        for (int i = 0, length = stackTrace.length; i < length; ++i) {
            if (CycleDetectingLockFactory$WithExplicitOrdering.class.getName().equals(stackTrace[i].getClassName())) {
                this.setStackTrace(CycleDetectingLockFactory$ExampleStackTrace.EMPTY_STACK_TRACE);
                break;
            }
            if (!CycleDetectingLockFactory$ExampleStackTrace.EXCLUDED_CLASS_NAMES.contains(stackTrace[i].getClassName())) {
                this.setStackTrace(Arrays.copyOfRange(stackTrace, i, length));
                break;
            }
        }
    }
    
    static {
        EMPTY_STACK_TRACE = new StackTraceElement[0];
        EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), CycleDetectingLockFactory$ExampleStackTrace.class.getName(), CycleDetectingLockFactory$LockGraphNode.class.getName());
    }
}
