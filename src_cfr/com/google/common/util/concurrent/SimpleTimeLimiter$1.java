/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.SimpleTimeLimiter$1$1;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class SimpleTimeLimiter$1
implements InvocationHandler {
    final /* synthetic */ Object val$target;
    final /* synthetic */ long val$timeoutDuration;
    final /* synthetic */ TimeUnit val$timeoutUnit;
    final /* synthetic */ Set val$interruptibleMethods;
    final /* synthetic */ SimpleTimeLimiter this$0;

    SimpleTimeLimiter$1(SimpleTimeLimiter simpleTimeLimiter, Object object, long l2, TimeUnit timeUnit, Set set) {
        this.this$0 = simpleTimeLimiter;
        this.val$target = object;
        this.val$timeoutDuration = l2;
        this.val$timeoutUnit = timeUnit;
        this.val$interruptibleMethods = set;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] arrobject) {
        SimpleTimeLimiter$1$1 simpleTimeLimiter$1$1 = new SimpleTimeLimiter$1$1(this, method, arrobject);
        return this.this$0.callWithTimeout(simpleTimeLimiter$1$1, this.val$timeoutDuration, this.val$timeoutUnit, this.val$interruptibleMethods.contains(method));
    }
}

