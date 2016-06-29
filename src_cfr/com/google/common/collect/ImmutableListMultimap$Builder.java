/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$Builder;
import com.google.common.collect.Multimap;
import java.util.Comparator;
import java.util.Map;

public final class ImmutableListMultimap$Builder
extends ImmutableMultimap$Builder {
    @Override
    public ImmutableListMultimap$Builder put(Object object, Object object2) {
        super.put(object, object2);
        return this;
    }

    @Override
    public ImmutableListMultimap$Builder put(Map.Entry entry) {
        super.put(entry);
        return this;
    }

    @Beta
    @Override
    public ImmutableListMultimap$Builder putAll(Iterable iterable) {
        super.putAll(iterable);
        return this;
    }

    @Override
    public ImmutableListMultimap$Builder putAll(Object object, Iterable iterable) {
        super.putAll(object, iterable);
        return this;
    }

    @Override
    public /* varargs */ ImmutableListMultimap$Builder putAll(Object object, Object ... arrobject) {
        super.putAll(object, arrobject);
        return this;
    }

    @Override
    public ImmutableListMultimap$Builder putAll(Multimap multimap) {
        super.putAll(multimap);
        return this;
    }

    @Override
    public ImmutableListMultimap$Builder orderKeysBy(Comparator comparator) {
        super.orderKeysBy(comparator);
        return this;
    }

    @Override
    public ImmutableListMultimap$Builder orderValuesBy(Comparator comparator) {
        super.orderValuesBy(comparator);
        return this;
    }

    @Override
    public ImmutableListMultimap build() {
        return (ImmutableListMultimap)super.build();
    }
}

