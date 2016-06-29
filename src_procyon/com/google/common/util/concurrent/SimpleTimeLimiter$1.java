package com.google.common.util.concurrent;

import java.util.*;
import java.lang.reflect.*;
import java.util.concurrent.*;

class SimpleTimeLimiter$1 implements InvocationHandler
{
    final /* synthetic */ Object val$target;
    final /* synthetic */ long val$timeoutDuration;
    final /* synthetic */ TimeUnit val$timeoutUnit;
    final /* synthetic */ Set val$interruptibleMethods;
    final /* synthetic */ SimpleTimeLimiter this$0;
    
    SimpleTimeLimiter$1(final SimpleTimeLimiter this$0, final Object val$target, final long val$timeoutDuration, final TimeUnit val$timeoutUnit, final Set val$interruptibleMethods) {
        this.this$0 = this$0;
        this.val$target = val$target;
        this.val$timeoutDuration = val$timeoutDuration;
        this.val$timeoutUnit = val$timeoutUnit;
        this.val$interruptibleMethods = val$interruptibleMethods;
    }
    
    @Override
    public Object invoke(final Object o, final Method method, final Object[] array) {
        return this.this$0.callWithTimeout(new SimpleTimeLimiter$1$1(this, method, array), this.val$timeoutDuration, this.val$timeoutUnit, this.val$interruptibleMethods.contains(method));
    }
}
