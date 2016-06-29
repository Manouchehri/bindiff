package com.google.common.cache;

import java.util.concurrent.*;
import com.google.common.base.*;

class CacheBuilderSpec$WriteDurationParser extends CacheBuilderSpec$DurationParser
{
    @Override
    protected void parseDuration(final CacheBuilderSpec cacheBuilderSpec, final long writeExpirationDuration, final TimeUnit writeExpirationTimeUnit) {
        Preconditions.checkArgument(cacheBuilderSpec.writeExpirationTimeUnit == null, (Object)"expireAfterWrite already set");
        cacheBuilderSpec.writeExpirationDuration = writeExpirationDuration;
        cacheBuilderSpec.writeExpirationTimeUnit = writeExpirationTimeUnit;
    }
}
