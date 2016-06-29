package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$PaddedSemaphore;
import java.util.concurrent.Semaphore;

final class Striped$3 implements Supplier {
   // $FF: synthetic field
   final int val$permits;

   Striped$3(int var1) {
      this.val$permits = var1;
   }

   public Semaphore get() {
      return new Striped$PaddedSemaphore(this.val$permits);
   }
}
