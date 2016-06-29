/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import com.google.common.util.concurrent.CycleDetectingLockFactory$WithExplicitOrdering;
import java.util.Arrays;
import java.util.Set;

class CycleDetectingLockFactory$ExampleStackTrace
extends IllegalStateException {
    static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
    static final Set EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), CycleDetectingLockFactory$ExampleStackTrace.class.getName(), CycleDetectingLockFactory$LockGraphNode.class.getName());

    CycleDetectingLockFactory$ExampleStackTrace(CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode, CycleDetectingLockFactory$LockGraphNode cycleDetectingLockFactory$LockGraphNode2) {
        StackTraceElement[] arrstackTraceElement = cycleDetectingLockFactory$LockGraphNode.getLockName();
        String string = cycleDetectingLockFactory$LockGraphNode2.getLockName();
        super(new StringBuilder(4 + String.valueOf(arrstackTraceElement).length() + String.valueOf(string).length()).append((String)arrstackTraceElement).append(" -> ").append(string).toString());
        arrstackTraceElement = this.getStackTrace();
        int n2 = 0;
        int n3 = arrstackTraceElement.length;
        while (n2 < n3) {
            if (CycleDetectingLockFactory.WithExplicitOrdering.class.getName().equals(arrstackTraceElement[n2].getClassName())) {
                this.setStackTrace(EMPTY_STACK_TRACE);
                return;
            }
            if (!EXCLUDED_CLASS_NAMES.contains(arrstackTraceElement[n2].getClassName())) {
                this.setStackTrace(Arrays.copyOfRange(arrstackTraceElement, n2, n3));
                return;
            }
            ++n2;
        }
    }
}

