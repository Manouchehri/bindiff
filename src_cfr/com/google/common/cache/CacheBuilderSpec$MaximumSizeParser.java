/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$LongParser;

class CacheBuilderSpec$MaximumSizeParser
extends CacheBuilderSpec$LongParser {
    CacheBuilderSpec$MaximumSizeParser() {
    }

    @Override
    protected void parseLong(CacheBuilderSpec cacheBuilderSpec, long l2) {
        Preconditions.checkArgument(cacheBuilderSpec.maximumSize == null, "maximum size was already set to ", cacheBuilderSpec.maximumSize);
        Preconditions.checkArgument(cacheBuilderSpec.maximumWeight == null, "maximum weight was already set to ", cacheBuilderSpec.maximumWeight);
        cacheBuilderSpec.maximumSize = l2;
    }
}

