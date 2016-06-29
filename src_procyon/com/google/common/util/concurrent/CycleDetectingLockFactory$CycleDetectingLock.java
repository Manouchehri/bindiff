package com.google.common.util.concurrent;

interface CycleDetectingLockFactory$CycleDetectingLock
{
    CycleDetectingLockFactory$LockGraphNode getLockGraphNode();
    
    boolean isAcquiredByCurrentThread();
}
