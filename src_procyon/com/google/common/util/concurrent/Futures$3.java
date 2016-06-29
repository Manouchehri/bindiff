package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;

final class Futures$3 implements Future
{
    final /* synthetic */ Future val$input;
    final /* synthetic */ Function val$function;
    
    Futures$3(final Future val$input, final Function val$function) {
        this.val$input = val$input;
        this.val$function = val$function;
    }
    
    @Override
    public boolean cancel(final boolean b) {
        return this.val$input.cancel(b);
    }
    
    @Override
    public boolean isCancelled() {
        return this.val$input.isCancelled();
    }
    
    @Override
    public boolean isDone() {
        return this.val$input.isDone();
    }
    
    @Override
    public Object get() {
        return this.applyTransformation(this.val$input.get());
    }
    
    @Override
    public Object get(final long n, final TimeUnit timeUnit) {
        return this.applyTransformation(this.val$input.get(n, timeUnit));
    }
    
    private Object applyTransformation(final Object o) {
        try {
            return this.val$function.apply(o);
        }
        catch (Throwable t) {
            throw new ExecutionException(t);
        }
    }
}
