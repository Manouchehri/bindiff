/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableSortedMap;
import java.util.Comparator;
import java.util.Map;

public class ImmutableSortedMap$Builder
extends ImmutableMap$Builder {
    private final Comparator comparator;

    public ImmutableSortedMap$Builder(Comparator comparator) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }

    @Override
    public ImmutableSortedMap$Builder put(Object object, Object object2) {
        super.put(object, object2);
        return this;
    }

    @Override
    public ImmutableSortedMap$Builder put(Map.Entry entry) {
        super.put(entry);
        return this;
    }

    @Override
    public ImmutableSortedMap$Builder putAll(Map map) {
        super.putAll(map);
        return this;
    }

    @Beta
    @Override
    public ImmutableSortedMap$Builder putAll(Iterable iterable) {
        super.putAll(iterable);
        return this;
    }

    @Deprecated
    @Beta
    @Override
    public ImmutableSortedMap$Builder orderEntriesByValue(Comparator comparator) {
        throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
    }

    @Override
    public ImmutableSortedMap build() {
        switch (this.size) {
            case 0: {
                return ImmutableSortedMap.emptyMap(this.comparator);
            }
            case 1: {
                return ImmutableSortedMap.access$000(this.comparator, this.entries[0].getKey(), this.entries[0].getValue());
            }
        }
        return ImmutableSortedMap.access$100(this.comparator, false, this.entries, this.size);
    }
}

