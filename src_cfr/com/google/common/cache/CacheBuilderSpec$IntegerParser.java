/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$ValueParser;

abstract class CacheBuilderSpec$IntegerParser
implements CacheBuilderSpec$ValueParser {
    CacheBuilderSpec$IntegerParser() {
    }

    protected abstract void parseInteger(CacheBuilderSpec var1, int var2);

    @Override
    public void parse(CacheBuilderSpec cacheBuilderSpec, String string, String string2) {
        Preconditions.checkArgument(string2 != null && !string2.isEmpty(), "value of key %s omitted", string);
        try {
            this.parseInteger(cacheBuilderSpec, Integer.parseInt(string2));
            return;
        }
        catch (NumberFormatException var4_4) {
            throw new IllegalArgumentException(CacheBuilderSpec.access$000("key %s value set to %s, must be integer", new Object[]{string, string2}), var4_4);
        }
    }
}

