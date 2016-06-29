/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$1;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class ImmutableMap$MapViewOfValuesAsSingletonSets
extends ImmutableMap$IteratorBasedImmutableMap {
    final /* synthetic */ ImmutableMap this$0;

    private ImmutableMap$MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap) {
        this.this$0 = immutableMap;
    }

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public ImmutableSet keySet() {
        return this.this$0.keySet();
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.this$0.containsKey(object);
    }

    @Override
    public ImmutableSet get(@Nullable Object object) {
        Object object2 = this.this$0.get(object);
        if (object2 == null) {
            return null;
        }
        ImmutableSet immutableSet = ImmutableSet.of(object2);
        return immutableSet;
    }

    @Override
    boolean isPartialView() {
        return this.this$0.isPartialView();
    }

    @Override
    public int hashCode() {
        return this.this$0.hashCode();
    }

    @Override
    boolean isHashCodeFast() {
        return this.this$0.isHashCodeFast();
    }

    @Override
    UnmodifiableIterator entryIterator() {
        UnmodifiableIterator unmodifiableIterator = this.this$0.entrySet().iterator();
        return new ImmutableMap$MapViewOfValuesAsSingletonSets$1(this, unmodifiableIterator);
    }

    /* synthetic */ ImmutableMap$MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, ImmutableMap$1 immutableMap$1) {
        this(immutableMap);
    }
}

