package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

public class ImmutableMap$Builder
{
    Comparator valueComparator;
    ImmutableMapEntry[] entries;
    int size;
    boolean entriesUsed;
    
    public ImmutableMap$Builder() {
        this(4);
    }
    
    ImmutableMap$Builder(final int n) {
        this.entries = new ImmutableMapEntry[n];
        this.size = 0;
        this.entriesUsed = false;
    }
    
    private void ensureCapacity(final int n) {
        if (n > this.entries.length) {
            this.entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, ImmutableCollection$Builder.expandedCapacity(this.entries.length, n));
            this.entriesUsed = false;
        }
    }
    
    public ImmutableMap$Builder put(final Object o, final Object o2) {
        this.ensureCapacity(this.size + 1);
        this.entries[this.size++] = ImmutableMap.entryOf(o, o2);
        return this;
    }
    
    public ImmutableMap$Builder put(final Map.Entry entry) {
        return this.put(entry.getKey(), entry.getValue());
    }
    
    public ImmutableMap$Builder putAll(final Map map) {
        this.ensureCapacity(this.size + map.size());
        return this.putAll(map.entrySet());
    }
    
    @Beta
    public ImmutableMap$Builder putAll(final Iterable iterable) {
        final Iterator<Map.Entry> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.put((Map.Entry)iterator.next());
        }
        return this;
    }
    
    @Beta
    public ImmutableMap$Builder orderEntriesByValue(final Comparator comparator) {
        Preconditions.checkState(this.valueComparator == null, (Object)"valueComparator was already set");
        this.valueComparator = (Comparator)Preconditions.checkNotNull(comparator, (Object)"valueComparator");
        return this;
    }
    
    public ImmutableMap build() {
        switch (this.size) {
            case 0: {
                return ImmutableMap.of();
            }
            case 1: {
                return ImmutableMap.of(this.entries[0].getKey(), this.entries[0].getValue());
            }
            default: {
                if (this.valueComparator != null) {
                    if (this.entriesUsed) {
                        this.entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, this.size);
                    }
                    Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
                }
                this.entriesUsed = (this.size == this.entries.length);
                return RegularImmutableMap.fromEntryArray(this.size, this.entries);
            }
        }
    }
}
