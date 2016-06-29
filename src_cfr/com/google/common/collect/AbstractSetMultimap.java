/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractSetMultimap
extends AbstractMapBasedMultimap
implements SetMultimap {
    private static final long serialVersionUID = 7431625294878419160L;

    protected AbstractSetMultimap(Map map) {
        super(map);
    }

    @Override
    abstract Set createCollection();

    @Override
    Set createUnmodifiableEmptyCollection() {
        return ImmutableSet.of();
    }

    @Override
    public Set get(@Nullable Object object) {
        return (Set)super.get(object);
    }

    @Override
    public Set entries() {
        return (Set)super.entries();
    }

    @Override
    public Set removeAll(@Nullable Object object) {
        return (Set)super.removeAll(object);
    }

    @Override
    public Set replaceValues(@Nullable Object object, Iterable iterable) {
        return (Set)super.replaceValues(object, iterable);
    }

    @Override
    public Map asMap() {
        return super.asMap();
    }

    @Override
    public boolean put(@Nullable Object object, @Nullable Object object2) {
        return super.put(object, object2);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return super.equals(object);
    }
}

