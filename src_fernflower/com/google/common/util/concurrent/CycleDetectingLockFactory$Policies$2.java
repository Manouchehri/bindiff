package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$PotentialDeadlockException;
import java.util.logging.Level;

enum CycleDetectingLockFactory$Policies$2 {
   public void handlePotentialDeadlock(CycleDetectingLockFactory$PotentialDeadlockException var1) {
      CycleDetectingLockFactory.access$100().log(Level.SEVERE, "Detected potential deadlock", var1);
   }
}
