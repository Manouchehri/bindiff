package com.google.common.cache;

import javax.annotation.*;
import com.google.common.base.*;

class CacheBuilderSpec$RecordStatsParser implements CacheBuilderSpec$ValueParser
{
    @Override
    public void parse(final CacheBuilderSpec cacheBuilderSpec, final String s, @Nullable final String s2) {
        Preconditions.checkArgument(s2 == null, (Object)"recordStats does not take values");
        Preconditions.checkArgument(cacheBuilderSpec.recordStats == null, (Object)"recordStats already set");
        cacheBuilderSpec.recordStats = true;
    }
}
