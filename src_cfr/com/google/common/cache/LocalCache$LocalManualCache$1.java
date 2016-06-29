/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LocalCache$LocalManualCache;
import java.util.concurrent.Callable;

class LocalCache$LocalManualCache$1
extends CacheLoader {
    final /* synthetic */ Callable val$valueLoader;
    final /* synthetic */ LocalCache$LocalManualCache this$0;

    LocalCache$LocalManualCache$1(LocalCache$LocalManualCache localCache$LocalManualCache, Callable callable) {
        this.this$0 = localCache$LocalManualCache;
        this.val$valueLoader = callable;
    }

    @Override
    public Object load(Object object) {
        return this.val$valueLoader.call();
    }
}

