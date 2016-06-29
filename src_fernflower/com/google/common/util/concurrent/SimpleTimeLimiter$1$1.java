package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.SimpleTimeLimiter$1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

class SimpleTimeLimiter$1$1 implements Callable {
   // $FF: synthetic field
   final Method val$method;
   // $FF: synthetic field
   final Object[] val$args;
   // $FF: synthetic field
   final SimpleTimeLimiter$1 this$1;

   SimpleTimeLimiter$1$1(SimpleTimeLimiter$1 var1, Method var2, Object[] var3) {
      this.this$1 = var1;
      this.val$method = var2;
      this.val$args = var3;
   }

   public Object call() {
      try {
         return this.val$method.invoke(this.this$1.val$target, this.val$args);
      } catch (InvocationTargetException var2) {
         SimpleTimeLimiter.access$000(var2, false);
         throw new AssertionError("can\'t get here");
      }
   }
}
