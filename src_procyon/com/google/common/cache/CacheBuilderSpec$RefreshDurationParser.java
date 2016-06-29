package com.google.common.cache;

import java.util.concurrent.*;
import com.google.common.base.*;

class CacheBuilderSpec$RefreshDurationParser extends CacheBuilderSpec$DurationParser
{
    @Override
    protected void parseDuration(final CacheBuilderSpec cacheBuilderSpec, final long refreshDuration, final TimeUnit refreshTimeUnit) {
        Preconditions.checkArgument(cacheBuilderSpec.refreshTimeUnit == null, (Object)"refreshAfterWrite already set");
        cacheBuilderSpec.refreshDuration = refreshDuration;
        cacheBuilderSpec.refreshTimeUnit = refreshTimeUnit;
    }
}
