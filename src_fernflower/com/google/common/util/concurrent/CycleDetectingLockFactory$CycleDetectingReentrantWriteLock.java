package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory;
import com.google.common.util.concurrent.CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

class CycleDetectingLockFactory$CycleDetectingReentrantWriteLock extends WriteLock {
   final CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock readWriteLock;
   // $FF: synthetic field
   final CycleDetectingLockFactory this$0;

   CycleDetectingLockFactory$CycleDetectingReentrantWriteLock(CycleDetectingLockFactory var1, CycleDetectingLockFactory$CycleDetectingReentrantReadWriteLock var2) {
      super(var2);
      this.this$0 = var1;
      this.readWriteLock = var2;
   }

   public void lock() {
      CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);

      try {
         super.lock();
      } finally {
         CycleDetectingLockFactory.access$700(this.this$0, this.readWriteLock);
      }

   }

   public void lockInterruptibly() {
      CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);

      try {
         super.lockInterruptibly();
      } finally {
         CycleDetectingLockFactory.access$700(this.this$0, this.readWriteLock);
      }

   }

   public boolean tryLock() {
      CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);

      boolean var1;
      try {
         var1 = super.tryLock();
      } finally {
         CycleDetectingLockFactory.access$700(this.this$0, this.readWriteLock);
      }

      return var1;
   }

   public boolean tryLock(long var1, TimeUnit var3) {
      CycleDetectingLockFactory.access$600(this.this$0, this.readWriteLock);

      boolean var4;
      try {
         var4 = super.tryLock(var1, var3);
      } finally {
         CycleDetectingLockFactory.access$700(this.this$0, this.readWriteLock);
      }

      return var4;
   }

   public void unlock() {
      try {
         super.unlock();
      } finally {
         CycleDetectingLockFactory.access$700(this.this$0, this.readWriteLock);
      }

   }
}
