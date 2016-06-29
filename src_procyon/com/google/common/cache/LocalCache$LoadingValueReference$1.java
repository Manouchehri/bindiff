package com.google.common.cache;

import com.google.common.base.*;

class LocalCache$LoadingValueReference$1 implements Function
{
    final /* synthetic */ LocalCache$LoadingValueReference this$0;
    
    LocalCache$LoadingValueReference$1(final LocalCache$LoadingValueReference this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Object apply(final Object o) {
        this.this$0.set(o);
        return o;
    }
}
