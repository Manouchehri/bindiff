/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.ThreadSafe
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@ThreadSafe
public interface CycleDetectingLockFactory$Policy {
    public void handlePotentialDeadlock(CycleDetectingLockFactory$PotentialDeadlockException var1);
}

