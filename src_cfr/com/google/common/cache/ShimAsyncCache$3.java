/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

final class ShimAsyncCache$3
implements Function {
    ShimAsyncCache$3() {
    }

    @Override
    public Object apply(Object object) {
        return Preconditions.checkNotNull(object, "AsyncLoadingCache is null-hostile.");
    }
}

