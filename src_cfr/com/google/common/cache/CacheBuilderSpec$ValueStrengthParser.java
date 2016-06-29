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
import com.google.common.cache.LocalCache$Strength;
import javax.annotation.Nullable;

class CacheBuilderSpec$ValueStrengthParser
implements CacheBuilderSpec$ValueParser {
    private final LocalCache$Strength strength;

    public CacheBuilderSpec$ValueStrengthParser(LocalCache$Strength localCache$Strength) {
        this.strength = localCache$Strength;
    }

    @Override
    public void parse(CacheBuilderSpec cacheBuilderSpec, String string, @Nullable String string2) {
        Preconditions.checkArgument(string2 == null, "key %s does not take values", string);
        Preconditions.checkArgument(cacheBuilderSpec.valueStrength == null, "%s was already set to %s", new Object[]{string, cacheBuilderSpec.valueStrength});
        cacheBuilderSpec.valueStrength = this.strength;
    }
}

