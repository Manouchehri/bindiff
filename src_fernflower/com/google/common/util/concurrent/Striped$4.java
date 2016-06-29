package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Semaphore;

final class Striped$4 implements Supplier {
   // $FF: synthetic field
   final int val$permits;

   Striped$4(int var1) {
      this.val$permits = var1;
   }

   public Semaphore get() {
      return new Semaphore(this.val$permits, false);
   }
}
