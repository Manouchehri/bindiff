package com.google.common.cache;

import com.google.common.base.*;

final class CacheBuilder$2 implements Supplier
{
    @Override
    public AbstractCache$StatsCounter get() {
        return new AbstractCache$SimpleStatsCounter();
    }
}
