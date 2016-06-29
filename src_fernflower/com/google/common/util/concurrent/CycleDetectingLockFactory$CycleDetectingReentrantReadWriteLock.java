package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantWriteLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

final class CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLockFactory$CycleDetectingLock {
   private final CycleDetectingLockFactory$CycleDetectingReentrantReadLock readLock;
   private final CycleDetectingLockFactory$CycleDetectingReentrantWriteLock writeLock;
   private final CycleDetectingLockFactory$LockGraphNode lockGraphNode;
   // $FF: synthetic field
   final CycleDetectingLockFactory this$0;

   private CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory var1, CycleDetectingLockFactory$LockGraphNode var2, boolean var3) {
      super(var3);
      this.this$0 = var1;
      this.readLock = new CycleDetectingLockFactory$CycleDetectingReentrantReadLock(var1, this);
      this.writeLock = new CycleDetectingLockFactory$CycleDetectingReentrantWriteLock(var1, this);
      this.lockGraphNode = (CycleDetectingLockFactory$LockGraphNode)Preconditions.checkNotNull(var2);
   }

   public ReadLock readLock() {
      return this.readLock;
   }

   public WriteLock writeLock() {
      return this.writeLock;
   }

   public CycleDetectingLockFactory$LockGraphNode getLockGraphNode() {
      return this.lockGraphNode;
   }

   public boolean isAcquiredByCurrentThread() {
      return this.isWriteLockedByCurrentThread() || this.getReadHoldCount() > 0;
   }

   // $FF: synthetic method
   CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory var1, CycleDetectingLockFactory$LockGraphNode var2, boolean var3, CycleDetectingLockFactory$1 var4) {
      this(var1, var2, var3);
   }
}
