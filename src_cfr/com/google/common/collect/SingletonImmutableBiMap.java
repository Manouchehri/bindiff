/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BiMap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
final class SingletonImmutableBiMap
extends ImmutableBiMap {
    final transient Object singleKey;
    final transient Object singleValue;
    @LazyInit
    transient ImmutableBiMap inverse;

    SingletonImmutableBiMap(Object object, Object object2) {
        CollectPreconditions.checkEntryNotNull(object, object2);
        this.singleKey = object;
        this.singleValue = object2;
    }

    private SingletonImmutableBiMap(Object object, Object object2, ImmutableBiMap immutableBiMap) {
        this.singleKey = object;
        this.singleValue = object2;
        this.inverse = immutableBiMap;
    }

    @Override
    public Object get(@Nullable Object object) {
        if (!this.singleKey.equals(object)) return null;
        Object object2 = this.singleValue;
        return object2;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.singleKey.equals(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.singleValue.equals(object);
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    ImmutableSet createEntrySet() {
        return ImmutableSet.of(Maps.immutableEntry(this.singleKey, this.singleValue));
    }

    @Override
    ImmutableSet createKeySet() {
        return ImmutableSet.of(this.singleKey);
    }

    @Override
    public ImmutableBiMap inverse() {
        ImmutableBiMap immutableBiMap = this.inverse;
        if (immutableBiMap != null) return immutableBiMap;
        this.inverse = new SingletonImmutableBiMap(this.singleValue, this.singleKey, this);
        return this.inverse;
    }
}

