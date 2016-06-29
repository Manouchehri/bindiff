package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Beta
public final class CycleDetectingLockFactory$WithExplicitOrdering extends CycleDetectingLockFactory {
   private final Map lockGraphNodes;

   @VisibleForTesting
   CycleDetectingLockFactory$WithExplicitOrdering(CycleDetectingLockFactory$Policy var1, Map var2) {
      super(var1, (CycleDetectingLockFactory$1)null);
      this.lockGraphNodes = var2;
   }

   public ReentrantLock newReentrantLock(Enum var1) {
      return this.newReentrantLock(var1, false);
   }

   public ReentrantLock newReentrantLock(Enum var1, boolean var2) {
      return (ReentrantLock)(this.policy == CycleDetectingLockFactory$Policies.DISABLED?new ReentrantLock(var2):new CycleDetectingLockFactory$CycleDetectingReentrantLock(this, (CycleDetectingLockFactory$LockGraphNode)this.lockGraphNodes.get(var1), var2, (CycleDetectingLockFactory$1)null));
   }

   public ReentrantReadWriteLock newReentrantReadWriteLock(Enum var1) {
      return this.newReentrantReadWriteLock(var1, false);
   }

   public ReentrantReadWriteLock newReentrantReadWriteLock(Enum var1, boolean var2) {
      return (ReentrantReadWriteLock)(this.policy == CycleDetectingLockFactory$Policies.DISABLED?new ReentrantReadWriteLock(var2):new CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(this, (CycleDetectingLockFactory$LockGraphNode)this.lockGraphNodes.get(var1), var2, (CycleDetectingLockFactory$1)null));
   }
}
