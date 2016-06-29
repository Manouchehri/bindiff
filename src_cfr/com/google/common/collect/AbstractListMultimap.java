/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ListMultimap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractListMultimap
extends AbstractMapBasedMultimap
implements ListMultimap {
    private static final long serialVersionUID = 6588350623831699109L;

    protected AbstractListMultimap(Map map) {
        super(map);
    }

    @Override
    abstract List createCollection();

    @Override
    List createUnmodifiableEmptyCollection() {
        return ImmutableList.of();
    }

    @Override
    public List get(@Nullable Object object) {
        return (List)super.get(object);
    }

    @Override
    public List removeAll(@Nullable Object object) {
        return (List)super.removeAll(object);
    }

    @Override
    public List replaceValues(@Nullable Object object, Iterable iterable) {
        return (List)super.replaceValues(object, iterable);
    }

    @Override
    public boolean put(@Nullable Object object, @Nullable Object object2) {
        return super.put(object, object2);
    }

    @Override
    public Map asMap() {
        return super.asMap();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return super.equals(object);
    }
}

