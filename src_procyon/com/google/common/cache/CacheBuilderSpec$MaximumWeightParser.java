package com.google.common.cache;

import com.google.common.base.*;

class CacheBuilderSpec$MaximumWeightParser extends CacheBuilderSpec$LongParser
{
    @Override
    protected void parseLong(final CacheBuilderSpec cacheBuilderSpec, final long n) {
        Preconditions.checkArgument(cacheBuilderSpec.maximumWeight == null, "maximum weight was already set to ", cacheBuilderSpec.maximumWeight);
        Preconditions.checkArgument(cacheBuilderSpec.maximumSize == null, "maximum size was already set to ", cacheBuilderSpec.maximumSize);
        cacheBuilderSpec.maximumWeight = n;
    }
}
