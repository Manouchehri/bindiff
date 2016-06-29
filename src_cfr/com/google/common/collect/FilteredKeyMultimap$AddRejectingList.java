/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class FilteredKeyMultimap$AddRejectingList
extends ForwardingList {
    final Object key;

    FilteredKeyMultimap$AddRejectingList(Object object) {
        this.key = object;
    }

    @Override
    public boolean add(Object object) {
        this.add(0, object);
        return true;
    }

    @Override
    public boolean addAll(Collection collection) {
        this.addAll(0, collection);
        return true;
    }

    @Override
    public void add(int n2, Object object) {
        Preconditions.checkPositionIndex(n2, 0);
        String string = String.valueOf(this.key);
        throw new IllegalArgumentException(new StringBuilder(32 + String.valueOf(string).length()).append("Key does not satisfy predicate: ").append(string).toString());
    }

    @Override
    public boolean addAll(int n2, Collection collection) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkPositionIndex(n2, 0);
        String string = String.valueOf(this.key);
        throw new IllegalArgumentException(new StringBuilder(32 + String.valueOf(string).length()).append("Key does not satisfy predicate: ").append(string).toString());
    }

    @Override
    protected List delegate() {
        return Collections.emptyList();
    }
}

