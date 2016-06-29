/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.cache.LocalCache$LoadingValueReference;

class LocalCache$LoadingValueReference$1
implements Function {
    final /* synthetic */ LocalCache$LoadingValueReference this$0;

    LocalCache$LoadingValueReference$1(LocalCache$LoadingValueReference loadingValueReference) {
        this.this$0 = loadingValueReference;
    }

    @Override
    public Object apply(Object object) {
        this.this$0.set(object);
        return object;
    }
}

