package com.google.common.util.concurrent;

import java.util.concurrent.*;

final class Callables$2 implements Callable
{
    final /* synthetic */ Exception val$exception;
    
    Callables$2(final Exception val$exception) {
        this.val$exception = val$exception;
    }
    
    @Override
    public Object call() {
        throw this.val$exception;
    }
}
