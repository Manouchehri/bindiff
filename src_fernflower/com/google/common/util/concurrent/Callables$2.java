package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

final class Callables$2 implements Callable {
   // $FF: synthetic field
   final Exception val$exception;

   Callables$2(Exception var1) {
      this.val$exception = var1;
   }

   public Object call() {
      throw this.val$exception;
   }
}
