package com.google.common.util.concurrent;

final class AbstractFuture$Failure$1 extends Throwable {
   AbstractFuture$Failure$1(String var1) {
      super(var1);
   }

   public synchronized Throwable fillInStackTrace() {
      return this;
   }
}
