/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap$1;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import javax.annotation.Nullable;

abstract class DenseImmutableTable$ImmutableArrayMap
extends ImmutableMap$IteratorBasedImmutableMap {
    private final int size;

    DenseImmutableTable$ImmutableArrayMap(int n2) {
        this.size = n2;
    }

    abstract ImmutableMap keyToIndex();

    private boolean isFull() {
        if (this.size != this.keyToIndex().size()) return false;
        return true;
    }

    Object getKey(int n2) {
        return this.keyToIndex().keySet().asList().get(n2);
    }

    @Nullable
    abstract Object getValue(int var1);

    @Override
    ImmutableSet createKeySet() {
        ImmutableSet immutableSet;
        if (this.isFull()) {
            immutableSet = this.keyToIndex().keySet();
            return immutableSet;
        }
        immutableSet = super.createKeySet();
        return immutableSet;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object get(@Nullable Object object) {
        Integer n2 = (Integer)this.keyToIndex().get(object);
        if (n2 == null) {
            return null;
        }
        Object object2 = this.getValue(n2);
        return object2;
    }

    @Override
    UnmodifiableIterator entryIterator() {
        return new DenseImmutableTable$ImmutableArrayMap$1(this);
    }
}

