/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableCollection$ArrayBasedBuilder;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableSortedSet;
import java.util.Comparator;
import java.util.Iterator;

public final class ImmutableSortedSet$Builder
extends ImmutableSet$Builder {
    private final Comparator comparator;

    public ImmutableSortedSet$Builder(Comparator comparator) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }

    @Override
    public ImmutableSortedSet$Builder add(Object object) {
        super.add(object);
        return this;
    }

    @Override
    public /* varargs */ ImmutableSortedSet$Builder add(Object ... arrobject) {
        super.add(arrobject);
        return this;
    }

    @Override
    public ImmutableSortedSet$Builder addAll(Iterable iterable) {
        super.addAll(iterable);
        return this;
    }

    @Override
    public ImmutableSortedSet$Builder addAll(Iterator iterator) {
        super.addAll(iterator);
        return this;
    }

    @Override
    public ImmutableSortedSet build() {
        Object[] arrobject = this.contents;
        ImmutableSortedSet immutableSortedSet = ImmutableSortedSet.construct(this.comparator, this.size, arrobject);
        this.size = immutableSortedSet.size();
        return immutableSortedSet;
    }
}

