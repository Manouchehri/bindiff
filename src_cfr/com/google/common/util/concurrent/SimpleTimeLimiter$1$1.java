/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.SimpleTimeLimiter$1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

class SimpleTimeLimiter$1$1
implements Callable {
    final /* synthetic */ Method val$method;
    final /* synthetic */ Object[] val$args;
    final /* synthetic */ SimpleTimeLimiter$1 this$1;

    SimpleTimeLimiter$1$1(SimpleTimeLimiter$1 var1_1, Method method, Object[] arrobject) {
        this.this$1 = var1_1;
        this.val$method = method;
        this.val$args = arrobject;
    }

    public Object call() {
        try {
            return this.val$method.invoke(this.this$1.val$target, this.val$args);
        }
        catch (InvocationTargetException var1_1) {
            SimpleTimeLimiter.access$000(var1_1, false);
            throw new AssertionError((Object)"can't get here");
        }
    }
}

