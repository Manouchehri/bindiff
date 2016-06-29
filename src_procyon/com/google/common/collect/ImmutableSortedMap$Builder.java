package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

public class ImmutableSortedMap$Builder extends ImmutableMap$Builder
{
    private final Comparator comparator;
    
    public ImmutableSortedMap$Builder(final Comparator comparator) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }
    
    @Override
    public ImmutableSortedMap$Builder put(final Object o, final Object o2) {
        super.put(o, o2);
        return this;
    }
    
    @Override
    public ImmutableSortedMap$Builder put(final Map.Entry entry) {
        super.put(entry);
        return this;
    }
    
    @Override
    public ImmutableSortedMap$Builder putAll(final Map map) {
        super.putAll(map);
        return this;
    }
    
    @Beta
    @Override
    public ImmutableSortedMap$Builder putAll(final Iterable iterable) {
        super.putAll(iterable);
        return this;
    }
    
    @Deprecated
    @Beta
    @Override
    public ImmutableSortedMap$Builder orderEntriesByValue(final Comparator comparator) {
        throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
    }
    
    @Override
    public ImmutableSortedMap build() {
        switch (this.size) {
            case 0: {
                return ImmutableSortedMap.emptyMap(this.comparator);
            }
            case 1: {
                return of(this.comparator, this.entries[0].getKey(), this.entries[0].getValue());
            }
            default: {
                return fromEntries(this.comparator, false, this.entries, this.size);
            }
        }
    }
}
