package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

public final class ImmutableBiMap$Builder extends ImmutableMap$Builder
{
    public ImmutableBiMap$Builder() {
    }
    
    ImmutableBiMap$Builder(final int n) {
        super(n);
    }
    
    @Override
    public ImmutableBiMap$Builder put(final Object o, final Object o2) {
        super.put(o, o2);
        return this;
    }
    
    @Override
    public ImmutableBiMap$Builder put(final Map.Entry entry) {
        super.put(entry);
        return this;
    }
    
    @Override
    public ImmutableBiMap$Builder putAll(final Map map) {
        super.putAll(map);
        return this;
    }
    
    @Beta
    @Override
    public ImmutableBiMap$Builder putAll(final Iterable iterable) {
        super.putAll(iterable);
        return this;
    }
    
    @Beta
    @Override
    public ImmutableBiMap$Builder orderEntriesByValue(final Comparator comparator) {
        super.orderEntriesByValue(comparator);
        return this;
    }
    
    @Override
    public ImmutableBiMap build() {
        switch (this.size) {
            case 0: {
                return ImmutableBiMap.of();
            }
            case 1: {
                return ImmutableBiMap.of(this.entries[0].getKey(), this.entries[0].getValue());
            }
            default: {
                if (this.valueComparator != null) {
                    if (this.entriesUsed) {
                        this.entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, this.size);
                    }
                    Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
                }
                this.entriesUsed = (this.size == this.entries.length);
                return RegularImmutableBiMap.fromEntryArray(this.size, this.entries);
            }
        }
    }
}
