package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;
import com.google.common.collect.*;
import java.util.*;
import java.lang.reflect.*;

class SimpleTimeLimiter$1$1 implements Callable
{
    final /* synthetic */ Method val$method;
    final /* synthetic */ Object[] val$args;
    final /* synthetic */ SimpleTimeLimiter$1 this$1;
    
    SimpleTimeLimiter$1$1(final SimpleTimeLimiter$1 this$1, final Method val$method, final Object[] val$args) {
        this.this$1 = this$1;
        this.val$method = val$method;
        this.val$args = val$args;
    }
    
    @Override
    public Object call() {
        try {
            return this.val$method.invoke(this.this$1.val$target, this.val$args);
        }
        catch (InvocationTargetException ex) {
            throwCause(ex, false);
            throw new AssertionError((Object)"can't get here");
        }
    }
}
