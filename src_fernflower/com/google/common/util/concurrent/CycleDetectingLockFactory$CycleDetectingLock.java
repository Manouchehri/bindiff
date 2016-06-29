package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;

interface CycleDetectingLockFactory$CycleDetectingLock {
   CycleDetectingLockFactory$LockGraphNode getLockGraphNode();

   boolean isAcquiredByCurrentThread();
}
