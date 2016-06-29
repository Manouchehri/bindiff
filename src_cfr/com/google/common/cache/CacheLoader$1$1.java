/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader$1;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

class CacheLoader$1$1
implements Callable {
    final /* synthetic */ Object val$key;
    final /* synthetic */ Object val$oldValue;
    final /* synthetic */ CacheLoader$1 this$0;

    CacheLoader$1$1(CacheLoader$1 var1_1, Object object, Object object2) {
        this.this$0 = var1_1;
        this.val$key = object;
        this.val$oldValue = object2;
    }

    public Object call() {
        return this.this$0.val$loader.reload(this.val$key, this.val$oldValue).get();
    }
}

