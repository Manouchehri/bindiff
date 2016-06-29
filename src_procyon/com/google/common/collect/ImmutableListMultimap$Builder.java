package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

public final class ImmutableListMultimap$Builder extends ImmutableMultimap$Builder
{
    @Override
    public ImmutableListMultimap$Builder put(final Object o, final Object o2) {
        super.put(o, o2);
        return this;
    }
    
    @Override
    public ImmutableListMultimap$Builder put(final Map.Entry entry) {
        super.put(entry);
        return this;
    }
    
    @Beta
    @Override
    public ImmutableListMultimap$Builder putAll(final Iterable iterable) {
        super.putAll(iterable);
        return this;
    }
    
    @Override
    public ImmutableListMultimap$Builder putAll(final Object o, final Iterable iterable) {
        super.putAll(o, iterable);
        return this;
    }
    
    @Override
    public ImmutableListMultimap$Builder putAll(final Object o, final Object... array) {
        super.putAll(o, array);
        return this;
    }
    
    @Override
    public ImmutableListMultimap$Builder putAll(final Multimap multimap) {
        super.putAll(multimap);
        return this;
    }
    
    @Override
    public ImmutableListMultimap$Builder orderKeysBy(final Comparator comparator) {
        super.orderKeysBy(comparator);
        return this;
    }
    
    @Override
    public ImmutableListMultimap$Builder orderValuesBy(final Comparator comparator) {
        super.orderValuesBy(comparator);
        return this;
    }
    
    @Override
    public ImmutableListMultimap build() {
        return (ImmutableListMultimap)super.build();
    }
}
