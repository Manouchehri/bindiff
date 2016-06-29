/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$ValueParser;
import javax.annotation.Nullable;

class CacheBuilderSpec$RecordStatsParser
implements CacheBuilderSpec$ValueParser {
    CacheBuilderSpec$RecordStatsParser() {
    }

    @Override
    public void parse(CacheBuilderSpec cacheBuilderSpec, String string, @Nullable String string2) {
        Preconditions.checkArgument(string2 == null, "recordStats does not take values");
        Preconditions.checkArgument(cacheBuilderSpec.recordStats == null, "recordStats already set");
        cacheBuilderSpec.recordStats = true;
    }
}

