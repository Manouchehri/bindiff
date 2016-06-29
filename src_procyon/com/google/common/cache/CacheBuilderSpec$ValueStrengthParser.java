package com.google.common.cache;

import javax.annotation.*;
import com.google.common.base.*;

class CacheBuilderSpec$ValueStrengthParser implements CacheBuilderSpec$ValueParser
{
    private final LocalCache$Strength strength;
    
    public CacheBuilderSpec$ValueStrengthParser(final LocalCache$Strength strength) {
        this.strength = strength;
    }
    
    @Override
    public void parse(final CacheBuilderSpec cacheBuilderSpec, final String s, @Nullable final String s2) {
        Preconditions.checkArgument(s2 == null, "key %s does not take values", s);
        Preconditions.checkArgument(cacheBuilderSpec.valueStrength == null, "%s was already set to %s", s, cacheBuilderSpec.valueStrength);
        cacheBuilderSpec.valueStrength = this.strength;
    }
}
