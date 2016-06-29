/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies;
import com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException;

final class CycleDetectingLockFactory$Policies$1
extends CycleDetectingLockFactory$Policies {
    CycleDetectingLockFactory$Policies$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    public void handlePotentialDeadlock(CycleDetectingLockFactory$PotentialDeadlockException cycleDetectingLockFactory$PotentialDeadlockException) {
        throw cycleDetectingLockFactory$PotentialDeadlockException;
    }
}

