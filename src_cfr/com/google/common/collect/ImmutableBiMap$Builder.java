/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public final class ImmutableBiMap$Builder
extends ImmutableMap$Builder {
    public ImmutableBiMap$Builder() {
    }

    ImmutableBiMap$Builder(int n2) {
        super(n2);
    }

    @Override
    public ImmutableBiMap$Builder put(Object object, Object object2) {
        super.put(object, object2);
        return this;
    }

    @Override
    public ImmutableBiMap$Builder put(Map.Entry entry) {
        super.put(entry);
        return this;
    }

    @Override
    public ImmutableBiMap$Builder putAll(Map map) {
        super.putAll(map);
        return this;
    }

    @Beta
    @Override
    public ImmutableBiMap$Builder putAll(Iterable iterable) {
        super.putAll(iterable);
        return this;
    }

    @Beta
    @Override
    public ImmutableBiMap$Builder orderEntriesByValue(Comparator comparator) {
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
        }
        if (this.valueComparator != null) {
            if (this.entriesUsed) {
                this.entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, this.size);
            }
            Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
        }
        this.entriesUsed = this.size == this.entries.length;
        return RegularImmutableBiMap.fromEntryArray(this.size, this.entries);
    }
}

