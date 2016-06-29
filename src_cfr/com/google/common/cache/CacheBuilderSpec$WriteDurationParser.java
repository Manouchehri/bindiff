/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$DurationParser;
import java.util.concurrent.TimeUnit;

class CacheBuilderSpec$WriteDurationParser
extends CacheBuilderSpec$DurationParser {
    CacheBuilderSpec$WriteDurationParser() {
    }

    @Override
    protected void parseDuration(CacheBuilderSpec cacheBuilderSpec, long l2, TimeUnit timeUnit) {
        Preconditions.checkArgument(cacheBuilderSpec.writeExpirationTimeUnit == null, "expireAfterWrite already set");
        cacheBuilderSpec.writeExpirationDuration = l2;
        cacheBuilderSpec.writeExpirationTimeUnit = timeUnit;
    }
}

