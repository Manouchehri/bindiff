/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$IntegerParser;

class CacheBuilderSpec$ConcurrencyLevelParser
extends CacheBuilderSpec$IntegerParser {
    CacheBuilderSpec$ConcurrencyLevelParser() {
    }

    @Override
    protected void parseInteger(CacheBuilderSpec cacheBuilderSpec, int n2) {
        Preconditions.checkArgument(cacheBuilderSpec.concurrencyLevel == null, "concurrency level was already set to ", cacheBuilderSpec.concurrencyLevel);
        cacheBuilderSpec.concurrencyLevel = n2;
    }
}

