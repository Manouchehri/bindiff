package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

final class TreeRangeMap$1 implements RangeMap
{
    @Nullable
    @Override
    public Object get(final Comparable comparable) {
        return null;
    }
    
    @Nullable
    @Override
    public Map.Entry getEntry(final Comparable comparable) {
        return null;
    }
    
    @Override
    public Range span() {
        throw new NoSuchElementException();
    }
    
    @Override
    public void put(final Range range, final Object o) {
        Preconditions.checkNotNull(range);
        final String value = String.valueOf(range);
        throw new IllegalArgumentException(new StringBuilder(46 + String.valueOf(value).length()).append("Cannot insert range ").append(value).append(" into an empty subRangeMap").toString());
    }
    
    @Override
    public void putAll(final RangeMap rangeMap) {
        if (!rangeMap.asMapOfRanges().isEmpty()) {
            throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
        }
    }
    
    @Override
    public void clear() {
    }
    
    @Override
    public void remove(final Range range) {
        Preconditions.checkNotNull(range);
    }
    
    @Override
    public Map asMapOfRanges() {
        return Collections.emptyMap();
    }
    
    @Override
    public Map asDescendingMapOfRanges() {
        return Collections.emptyMap();
    }
    
    @Override
    public RangeMap subRangeMap(final Range range) {
        Preconditions.checkNotNull(range);
        return this;
    }
}
