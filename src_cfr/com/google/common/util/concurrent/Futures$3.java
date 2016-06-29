/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class Futures$3
implements Future {
    final /* synthetic */ Future val$input;
    final /* synthetic */ Function val$function;

    Futures$3(Future future, Function function) {
        this.val$input = future;
        this.val$function = function;
    }

    @Override
    public boolean cancel(boolean bl2) {
        return this.val$input.cancel(bl2);
    }

    @Override
    public boolean isCancelled() {
        return this.val$input.isCancelled();
    }

    @Override
    public boolean isDone() {
        return this.val$input.isDone();
    }

    public Object get() {
        return this.applyTransformation(this.val$input.get());
    }

    public Object get(long l2, TimeUnit timeUnit) {
        return this.applyTransformation(this.val$input.get(l2, timeUnit));
    }

    private Object applyTransformation(Object object) {
        try {
            return this.val$function.apply(object);
        }
        catch (Throwable var2_2) {
            throw new ExecutionException(var2_2);
        }
    }
}

