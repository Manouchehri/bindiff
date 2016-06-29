/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$Builder;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSetMultimap$BuilderMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ImmutableSetMultimap$Builder
extends ImmutableMultimap$Builder {
    public ImmutableSetMultimap$Builder() {
        this.builderMultimap = new ImmutableSetMultimap$BuilderMultimap();
    }

    @Override
    public ImmutableSetMultimap$Builder put(Object object, Object object2) {
        this.builderMultimap.put(Preconditions.checkNotNull(object), Preconditions.checkNotNull(object2));
        return this;
    }

    @Override
    public ImmutableSetMultimap$Builder put(Map.Entry entry) {
        this.builderMultimap.put(Preconditions.checkNotNull(entry.getKey()), Preconditions.checkNotNull(entry.getValue()));
        return this;
    }

    @Beta
    @Override
    public ImmutableSetMultimap$Builder putAll(Iterable iterable) {
        super.putAll(iterable);
        return this;
    }

    @Override
    public ImmutableSetMultimap$Builder putAll(Object object, Iterable iterable) {
        Collection collection = this.builderMultimap.get(Preconditions.checkNotNull(object));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            collection.add(Preconditions.checkNotNull(t2));
        }
        return this;
    }

    @Override
    public /* varargs */ ImmutableSetMultimap$Builder putAll(Object object, Object ... arrobject) {
        return this.putAll(object, Arrays.asList(arrobject));
    }

    @Override
    public ImmutableSetMultimap$Builder putAll(Multimap multimap) {
        Iterator iterator = multimap.asMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            this.putAll(entry.getKey(), (Iterable)entry.getValue());
        }
        return this;
    }

    @Override
    public ImmutableSetMultimap$Builder orderKeysBy(Comparator comparator) {
        this.keyComparator = (Comparator)Preconditions.checkNotNull(comparator);
        return this;
    }

    @Override
    public ImmutableSetMultimap$Builder orderValuesBy(Comparator comparator) {
        super.orderValuesBy(comparator);
        return this;
    }

    @Override
    public ImmutableSetMultimap build() {
        if (this.keyComparator == null) return ImmutableSetMultimap.access$000(this.builderMultimap, this.valueComparator);
        ImmutableSetMultimap$BuilderMultimap immutableSetMultimap$BuilderMultimap = new ImmutableSetMultimap$BuilderMultimap();
        ImmutableList immutableList = Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(this.builderMultimap.asMap().entrySet());
        Iterator iterator = immutableList.iterator();
        do {
            if (!iterator.hasNext()) {
                this.builderMultimap = immutableSetMultimap$BuilderMultimap;
                return ImmutableSetMultimap.access$000(this.builderMultimap, this.valueComparator);
            }
            Map.Entry entry = (Map.Entry)iterator.next();
            immutableSetMultimap$BuilderMultimap.putAll(entry.getKey(), (Iterable)entry.getValue());
        } while (true);
    }
}

