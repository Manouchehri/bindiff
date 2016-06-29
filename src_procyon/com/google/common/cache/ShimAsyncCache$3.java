package com.google.common.cache;

import com.google.common.base.*;

final class ShimAsyncCache$3 implements Function
{
    @Override
    public Object apply(final Object o) {
        return Preconditions.checkNotNull(o, (Object)"AsyncLoadingCache is null-hostile.");
    }
}
