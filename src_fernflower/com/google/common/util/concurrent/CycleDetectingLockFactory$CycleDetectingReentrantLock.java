package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingLock;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

final class CycleDetectingLockFactory$CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLockFactory$CycleDetectingLock {
   private final CycleDetectingLockFactory$LockGraphNode lockGraphNode;
   // $FF: synthetic field
   final CycleDetectingLockFactory this$0;

   private CycleDetectingLockFactory$CycleDetectingReentrantLock(CycleDetectingLockFactory var1, CycleDetectingLockFactory$LockGraphNode var2, boolean var3) {
      super(var3);
      this.this$0 = var1;
      this.lockGraphNode = (CycleDetectingLockFactory$LockGraphNode)Preconditions.checkNotNull(var2);
   }

   public CycleDetectingLockFactory$LockGraphNode getLockGraphNode() {
      return this.lockGraphNode;
   }

   public boolean isAcquiredByCurrentThread() {
      return this.isHeldByCurrentThread();
   }

   public void lock() {
      CycleDetectingLockFactory.access$600(this.this$0, this);

      try {
         super.lock();
      } finally {
         CycleDetectingLockFactory.access$700(this.this$0, this);
      }

   }

   public void lockInterruptibly() {
      CycleDetectingLockFactory.access$600(this.this$0, this);

      try {
         super.lockInterruptibly();
      } finally {
         CycleDetectingLockFactory.access$700(this.this$0, this);
      }

   }

   public boolean tryLock() {
      CycleDetectingLockFactory.access$600(this.this$0, this);

      boolean var1;
      try {
         var1 = super.tryLock();
      } finally {
         CycleDetectingLockFactory.access$700(this.this$0, this);
      }

      return var1;
   }

   public boolean tryLock(long var1, TimeUnit var3) {
      CycleDetectingLockFactory.access$600(this.this$0, this);

      boolean var4;
      try {
         var4 = super.tryLock(var1, var3);
      } finally {
         CycleDetectingLockFactory.access$700(this.this$0, this);
      }

      return var4;
   }

   public void unlock() {
      try {
         super.unlock();
      } finally {
         CycleDetectingLockFactory.access$700(this.this$0, this);
      }

   }

   // $FF: synthetic method
   CycleDetectingLockFactory$CycleDetectingReentrantLock(CycleDetectingLockFactory var1, CycleDetectingLockFactory$LockGraphNode var2, boolean var3, CycleDetectingLockFactory$1 var4) {
      this(var1, var2, var3);
   }
}
