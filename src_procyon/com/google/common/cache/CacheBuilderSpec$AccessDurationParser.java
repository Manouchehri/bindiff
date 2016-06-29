package com.google.common.cache;

import java.util.concurrent.*;
import com.google.common.base.*;

class CacheBuilderSpec$AccessDurationParser extends CacheBuilderSpec$DurationParser
{
    @Override
    protected void parseDuration(final CacheBuilderSpec cacheBuilderSpec, final long accessExpirationDuration, final TimeUnit accessExpirationTimeUnit) {
        Preconditions.checkArgument(cacheBuilderSpec.accessExpirationTimeUnit == null, (Object)"expireAfterAccess already set");
        cacheBuilderSpec.accessExpirationDuration = accessExpirationDuration;
        cacheBuilderSpec.accessExpirationTimeUnit = accessExpirationTimeUnit;
    }
}
