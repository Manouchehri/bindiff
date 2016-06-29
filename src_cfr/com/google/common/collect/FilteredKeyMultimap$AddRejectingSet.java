/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

class FilteredKeyMultimap$AddRejectingSet
extends ForwardingSet {
    final Object key;

    FilteredKeyMultimap$AddRejectingSet(Object object) {
        this.key = object;
    }

    @Override
    public boolean add(Object object) {
        String string = String.valueOf(this.key);
        throw new IllegalArgumentException(new StringBuilder(32 + String.valueOf(string).length()).append("Key does not satisfy predicate: ").append(string).toString());
    }

    @Override
    public boolean addAll(Collection collection) {
        Preconditions.checkNotNull(collection);
        String string = String.valueOf(this.key);
        throw new IllegalArgumentException(new StringBuilder(32 + String.valueOf(string).length()).append("Key does not satisfy predicate: ").append(string).toString());
    }

    @Override
    protected Set delegate() {
        return Collections.emptySet();
    }
}

