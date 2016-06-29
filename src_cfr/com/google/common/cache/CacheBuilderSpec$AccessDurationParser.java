/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$DurationParser;
import java.util.concurrent.TimeUnit;

class CacheBuilderSpec$AccessDurationParser
extends CacheBuilderSpec$DurationParser {
    CacheBuilderSpec$AccessDurationParser() {
    }

    @Override
    protected void parseDuration(CacheBuilderSpec cacheBuilderSpec, long l2, TimeUnit timeUnit) {
        Preconditions.checkArgument(cacheBuilderSpec.accessExpirationTimeUnit == null, "expireAfterAccess already set");
        cacheBuilderSpec.accessExpirationDuration = l2;
        cacheBuilderSpec.accessExpirationTimeUnit = timeUnit;
    }
}

