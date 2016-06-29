package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@ThreadSafe
public interface CycleDetectingLockFactory$Policy {
   void handlePotentialDeadlock(CycleDetectingLockFactory$PotentialDeadlockException var1);
}
