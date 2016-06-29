package com.google.common.cache;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

abstract class CacheBuilderSpec$LongParser implements CacheBuilderSpec$ValueParser
{
    protected abstract void parseLong(final CacheBuilderSpec p0, final long p1);
    
    @Override
    public void parse(final CacheBuilderSpec cacheBuilderSpec, final String s, final String s2) {
        Preconditions.checkArgument(s2 != null && !s2.isEmpty(), "value of key %s omitted", s);
        try {
            this.parseLong(cacheBuilderSpec, Long.parseLong(s2));
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException(format("key %s value set to %s, must be integer", new Object[] { s, s2 }), ex);
        }
    }
}
