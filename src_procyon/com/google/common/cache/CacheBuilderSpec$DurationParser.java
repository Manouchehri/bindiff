package com.google.common.cache;

import java.util.concurrent.*;
import com.google.common.annotations.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

abstract class CacheBuilderSpec$DurationParser implements CacheBuilderSpec$ValueParser
{
    protected abstract void parseDuration(final CacheBuilderSpec p0, final long p1, final TimeUnit p2);
    
    @Override
    public void parse(final CacheBuilderSpec cacheBuilderSpec, final String s, final String s2) {
        Preconditions.checkArgument(s2 != null && !s2.isEmpty(), "value of key %s omitted", s);
        try {
            TimeUnit timeUnit = null;
            switch (s2.charAt(s2.length() - 1)) {
                case 'd': {
                    timeUnit = TimeUnit.DAYS;
                    break;
                }
                case 'h': {
                    timeUnit = TimeUnit.HOURS;
                    break;
                }
                case 'm': {
                    timeUnit = TimeUnit.MINUTES;
                    break;
                }
                case 's': {
                    timeUnit = TimeUnit.SECONDS;
                    break;
                }
                default: {
                    throw new IllegalArgumentException(format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[] { s, s2 }));
                }
            }
            this.parseDuration(cacheBuilderSpec, Long.parseLong(s2.substring(0, s2.length() - 1)), timeUnit);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException(format("key %s value set to %s, must be integer", new Object[] { s, s2 }));
        }
    }
}
