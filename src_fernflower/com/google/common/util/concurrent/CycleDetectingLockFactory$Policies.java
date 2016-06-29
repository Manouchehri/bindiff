package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;

@Beta
public enum CycleDetectingLockFactory$Policies implements CycleDetectingLockFactory$Policy {
   THROW,
   WARN,
   DISABLED;

   private CycleDetectingLockFactory$Policies() {
   }

   // $FF: synthetic method
   CycleDetectingLockFactory$Policies(CycleDetectingLockFactory$1 var3) {
      this();
   }
}
