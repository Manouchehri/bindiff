package com.google.common.util.concurrent;

import java.util.concurrent.*;

final class Callables$1 implements Callable
{
    final /* synthetic */ Object val$value;
    
    Callables$1(final Object val$value) {
        this.val$value = val$value;
    }
    
    @Override
    public Object call() {
        return this.val$value;
    }
}
