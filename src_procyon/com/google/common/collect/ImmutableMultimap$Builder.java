package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

public class ImmutableMultimap$Builder
{
    Multimap builderMultimap;
    Comparator keyComparator;
    Comparator valueComparator;
    
    public ImmutableMultimap$Builder() {
        this.builderMultimap = new ImmutableMultimap$BuilderMultimap();
    }
    
    public ImmutableMultimap$Builder put(final Object o, final Object o2) {
        CollectPreconditions.checkEntryNotNull(o, o2);
        this.builderMultimap.put(o, o2);
        return this;
    }
    
    public ImmutableMultimap$Builder put(final Map.Entry entry) {
        return this.put(entry.getKey(), entry.getValue());
    }
    
    @Beta
    public ImmutableMultimap$Builder putAll(final Iterable iterable) {
        final Iterator<Map.Entry> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.put((Map.Entry)iterator.next());
        }
        return this;
    }
    
    public ImmutableMultimap$Builder putAll(final Object o, final Iterable iterable) {
        if (o == null) {
            final String s = "null key in entry: null=";
            final String value = String.valueOf(Iterables.toString(iterable));
            throw new NullPointerException((value.length() != 0) ? s.concat(value) : new String(s));
        }
        final Collection value2 = this.builderMultimap.get(o);
        for (final Object next : iterable) {
            CollectPreconditions.checkEntryNotNull(o, next);
            value2.add(next);
        }
        return this;
    }
    
    public ImmutableMultimap$Builder putAll(final Object o, final Object... array) {
        return this.putAll(o, Arrays.asList(array));
    }
    
    public ImmutableMultimap$Builder putAll(final Multimap multimap) {
        for (final Map.Entry<Object, V> entry : multimap.asMap().entrySet()) {
            this.putAll(entry.getKey(), (Iterable)entry.getValue());
        }
        return this;
    }
    
    public ImmutableMultimap$Builder orderKeysBy(final Comparator comparator) {
        this.keyComparator = (Comparator)Preconditions.checkNotNull(comparator);
        return this;
    }
    
    public ImmutableMultimap$Builder orderValuesBy(final Comparator comparator) {
        this.valueComparator = (Comparator)Preconditions.checkNotNull(comparator);
        return this;
    }
    
    public ImmutableMultimap build() {
        if (this.valueComparator != null) {
            final Iterator<Collection> iterator = this.builderMultimap.asMap().values().iterator();
            while (iterator.hasNext()) {
                Collections.sort((List<Object>)iterator.next(), this.valueComparator);
            }
        }
        if (this.keyComparator != null) {
            final ImmutableMultimap$BuilderMultimap builderMultimap = new ImmutableMultimap$BuilderMultimap();
            for (final Map.Entry<Object, V> entry : Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(this.builderMultimap.asMap().entrySet())) {
                builderMultimap.putAll(entry.getKey(), (Iterable)entry.getValue());
            }
            this.builderMultimap = builderMultimap;
        }
        return ImmutableMultimap.copyOf(this.builderMultimap);
    }
}
