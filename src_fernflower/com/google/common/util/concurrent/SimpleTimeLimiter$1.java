package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.SimpleTimeLimiter$1$1;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class SimpleTimeLimiter$1 implements InvocationHandler {
   // $FF: synthetic field
   final Object val$target;
   // $FF: synthetic field
   final long val$timeoutDuration;
   // $FF: synthetic field
   final TimeUnit val$timeoutUnit;
   // $FF: synthetic field
   final Set val$interruptibleMethods;
   // $FF: synthetic field
   final SimpleTimeLimiter this$0;

   SimpleTimeLimiter$1(SimpleTimeLimiter var1, Object var2, long var3, TimeUnit var5, Set var6) {
      this.this$0 = var1;
      this.val$target = var2;
      this.val$timeoutDuration = var3;
      this.val$timeoutUnit = var5;
      this.val$interruptibleMethods = var6;
   }

   public Object invoke(Object var1, Method var2, Object[] var3) {
      SimpleTimeLimiter$1$1 var4 = new SimpleTimeLimiter$1$1(this, var2, var3);
      return this.this$0.callWithTimeout(var4, this.val$timeoutDuration, this.val$timeoutUnit, this.val$interruptibleMethods.contains(var2));
   }
}
