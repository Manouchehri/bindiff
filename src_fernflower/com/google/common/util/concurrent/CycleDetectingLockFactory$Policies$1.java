package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException;

enum CycleDetectingLockFactory$Policies$1 {
   public void handlePotentialDeadlock(CycleDetectingLockFactory$PotentialDeadlockException var1) {
      throw var1;
   }
}
