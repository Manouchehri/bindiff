package com.google.common.util.concurrent;

enum CycleDetectingLockFactory$Policies$1
{
    CycleDetectingLockFactory$Policies$1(final String s, final int n) {
    }
    
    @Override
    public void handlePotentialDeadlock(final CycleDetectingLockFactory$PotentialDeadlockException ex) {
        throw ex;
    }
}
