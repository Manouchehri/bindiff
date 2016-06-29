package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.locks.LockSupport;
import javax.annotation.Nullable;

final class AbstractFuture$Waiter {
   static final AbstractFuture$Waiter TOMBSTONE = new AbstractFuture$Waiter(false);
   @Nullable
   volatile Thread thread;
   @Nullable
   volatile AbstractFuture$Waiter next;

   AbstractFuture$Waiter(boolean var1) {
   }

   AbstractFuture$Waiter() {
      AbstractFuture.access$200().putThread(this, Thread.currentThread());
   }

   void setNext(AbstractFuture$Waiter var1) {
      AbstractFuture.access$200().putNext(this, var1);
   }

   void unpark() {
      Thread var1 = this.thread;
      if(var1 != null) {
         this.thread = null;
         LockSupport.unpark(var1);
      }

   }
}
