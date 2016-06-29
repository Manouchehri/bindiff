package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.io.*;
import java.util.*;

public final class ImmutableSetMultimap$Builder extends ImmutableMultimap$Builder
{
    public ImmutableSetMultimap$Builder() {
        this.builderMultimap = new ImmutableSetMultimap$BuilderMultimap();
    }
    
    @Override
    public ImmutableSetMultimap$Builder put(final Object o, final Object o2) {
        this.builderMultimap.put(Preconditions.checkNotNull(o), Preconditions.checkNotNull(o2));
        return this;
    }
    
    @Override
    public ImmutableSetMultimap$Builder put(final Map.Entry entry) {
        this.builderMultimap.put(Preconditions.checkNotNull(entry.getKey()), Preconditions.checkNotNull(entry.getValue()));
        return this;
    }
    
    @Beta
    @Override
    public ImmutableSetMultimap$Builder putAll(final Iterable iterable) {
        super.putAll(iterable);
        return this;
    }
    
    @Override
    public ImmutableSetMultimap$Builder putAll(final Object o, final Iterable iterable) {
        final Collection value = this.builderMultimap.get(Preconditions.checkNotNull(o));
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            value.add(Preconditions.checkNotNull(iterator.next()));
        }
        return this;
    }
    
    @Override
    public ImmutableSetMultimap$Builder putAll(final Object o, final Object... array) {
        return this.putAll(o, Arrays.asList(array));
    }
    
    @Override
    public ImmutableSetMultimap$Builder putAll(final Multimap multimap) {
        for (final Map.Entry<Object, V> entry : multimap.asMap().entrySet()) {
            this.putAll(entry.getKey(), (Iterable)entry.getValue());
        }
        return this;
    }
    
    @Override
    public ImmutableSetMultimap$Builder orderKeysBy(final Comparator comparator) {
        this.keyComparator = (Comparator)Preconditions.checkNotNull(comparator);
        return this;
    }
    
    @Override
    public ImmutableSetMultimap$Builder orderValuesBy(final Comparator comparator) {
        super.orderValuesBy(comparator);
        return this;
    }
    
    @Override
    public ImmutableSetMultimap build() {
        if (this.keyComparator != null) {
            final ImmutableSetMultimap$BuilderMultimap builderMultimap = new ImmutableSetMultimap$BuilderMultimap();
            for (final Map.Entry<Object, V> entry : Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(this.builderMultimap.asMap().entrySet())) {
                builderMultimap.putAll(entry.getKey(), (Iterable)entry.getValue());
            }
            this.builderMultimap = builderMultimap;
        }
        return copyOf(this.builderMultimap, this.valueComparator);
    }
}
