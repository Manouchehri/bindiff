package com.google.common.cache;

import java.util.concurrent.*;

class LocalCache$LocalManualCache$1 extends CacheLoader
{
    final /* synthetic */ Callable val$valueLoader;
    final /* synthetic */ LocalCache$LocalManualCache this$0;
    
    LocalCache$LocalManualCache$1(final LocalCache$LocalManualCache this$0, final Callable val$valueLoader) {
        this.this$0 = this$0;
        this.val$valueLoader = val$valueLoader;
    }
    
    @Override
    public Object load(final Object o) {
        return this.val$valueLoader.call();
    }
}
