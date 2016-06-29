/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$DurationParser;
import java.util.concurrent.TimeUnit;

class CacheBuilderSpec$RefreshDurationParser
extends CacheBuilderSpec$DurationParser {
    CacheBuilderSpec$RefreshDurationParser() {
    }

    @Override
    protected void parseDuration(CacheBuilderSpec cacheBuilderSpec, long l2, TimeUnit timeUnit) {
        Preconditions.checkArgument(cacheBuilderSpec.refreshTimeUnit == null, "refreshAfterWrite already set");
        cacheBuilderSpec.refreshDuration = l2;
        cacheBuilderSpec.refreshTimeUnit = timeUnit;
    }
}

