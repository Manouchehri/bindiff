package com.google.common.cache;

import com.google.common.base.*;

class CacheBuilderSpec$InitialCapacityParser extends CacheBuilderSpec$IntegerParser
{
    @Override
    protected void parseInteger(final CacheBuilderSpec cacheBuilderSpec, final int n) {
        Preconditions.checkArgument(cacheBuilderSpec.initialCapacity == null, "initial capacity was already set to ", cacheBuilderSpec.initialCapacity);
        cacheBuilderSpec.initialCapacity = n;
    }
}
