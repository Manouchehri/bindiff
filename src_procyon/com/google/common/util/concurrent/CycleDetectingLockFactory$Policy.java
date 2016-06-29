package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;

@Beta
@ThreadSafe
public interface CycleDetectingLockFactory$Policy
{
    void handlePotentialDeadlock(final CycleDetectingLockFactory$PotentialDeadlockException p0);
}
