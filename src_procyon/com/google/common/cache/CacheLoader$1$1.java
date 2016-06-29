package com.google.common.cache;

import java.util.concurrent.*;

class CacheLoader$1$1 implements Callable
{
    final /* synthetic */ Object val$key;
    final /* synthetic */ Object val$oldValue;
    final /* synthetic */ CacheLoader$1 this$0;
    
    CacheLoader$1$1(final CacheLoader$1 this$0, final Object val$key, final Object val$oldValue) {
        this.this$0 = this$0;
        this.val$key = val$key;
        this.val$oldValue = val$oldValue;
    }
    
    @Override
    public Object call() {
        return this.this$0.val$loader.reload(this.val$key, this.val$oldValue).get();
    }
}
