/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ImmutableMap$Builder {
    Comparator valueComparator;
    ImmutableMapEntry[] entries;
    int size;
    boolean entriesUsed;

    public ImmutableMap$Builder() {
        this(4);
    }

    ImmutableMap$Builder(int n2) {
        this.entries = new ImmutableMapEntry[n2];
        this.size = 0;
        this.entriesUsed = false;
    }

    private void ensureCapacity(int n2) {
        if (n2 <= this.entries.length) return;
        this.entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, ImmutableCollection$Builder.expandedCapacity(this.entries.length, n2));
        this.entriesUsed = false;
    }

    public ImmutableMap$Builder put(Object object, Object object2) {
        this.ensureCapacity(this.size + 1);
        ImmutableMapEntry immutableMapEntry = ImmutableMap.entryOf(object, object2);
        this.entries[this.size++] = immutableMapEntry;
        return this;
    }

    public ImmutableMap$Builder put(Map.Entry entry) {
        return this.put(entry.getKey(), entry.getValue());
    }

    public ImmutableMap$Builder putAll(Map map) {
        this.ensureCapacity(this.size + map.size());
        return this.putAll(map.entrySet());
    }

    @Beta
    public ImmutableMap$Builder putAll(Iterable iterable) {
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            this.put(entry);
        }
        return this;
    }

    @Beta
    public ImmutableMap$Builder orderEntriesByValue(Comparator comparator) {
        Preconditions.checkState(this.valueComparator == null, "valueComparator was already set");
        this.valueComparator = (Comparator)Preconditions.checkNotNull(comparator, "valueComparator");
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
        }
        if (this.valueComparator != null) {
            if (this.entriesUsed) {
                this.entries = (ImmutableMapEntry[])ObjectArrays.arraysCopyOf(this.entries, this.size);
            }
            Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
        }
        this.entriesUsed = this.size == this.entries.length;
        return RegularImmutableMap.fromEntryArray(this.size, this.entries);
    }
}

