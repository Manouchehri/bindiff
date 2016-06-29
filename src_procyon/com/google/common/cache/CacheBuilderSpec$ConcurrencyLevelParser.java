package com.google.common.cache;

import com.google.common.base.*;

class CacheBuilderSpec$ConcurrencyLevelParser extends CacheBuilderSpec$IntegerParser
{
    @Override
    protected void parseInteger(final CacheBuilderSpec cacheBuilderSpec, final int n) {
        Preconditions.checkArgument(cacheBuilderSpec.concurrencyLevel == null, "concurrency level was already set to ", cacheBuilderSpec.concurrencyLevel);
        cacheBuilderSpec.concurrencyLevel = n;
    }
}
