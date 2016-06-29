/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$IntegerParser;

class CacheBuilderSpec$InitialCapacityParser
extends CacheBuilderSpec$IntegerParser {
    CacheBuilderSpec$InitialCapacityParser() {
    }

    @Override
    protected void parseInteger(CacheBuilderSpec cacheBuilderSpec, int n2) {
        Preconditions.checkArgument(cacheBuilderSpec.initialCapacity == null, "initial capacity was already set to ", cacheBuilderSpec.initialCapacity);
        cacheBuilderSpec.initialCapacity = n2;
    }
}

