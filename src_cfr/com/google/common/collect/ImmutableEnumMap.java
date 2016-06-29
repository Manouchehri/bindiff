/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableEnumMap$1;
import com.google.common.collect.ImmutableEnumMap$EnumSerializedForm;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
final class ImmutableEnumMap
extends ImmutableMap$IteratorBasedImmutableMap {
    private final transient EnumMap delegate;

    static ImmutableMap asImmutable(EnumMap enumMap) {
        switch (enumMap.size()) {
            case 0: {
                return ImmutableMap.of();
            }
            case 1: {
                Map.Entry entry = (Map.Entry)Iterables.getOnlyElement(enumMap.entrySet());
                return ImmutableMap.of(entry.getKey(), entry.getValue());
            }
        }
        return new ImmutableEnumMap(enumMap);
    }

    private ImmutableEnumMap(EnumMap enumMap) {
        this.delegate = enumMap;
        Preconditions.checkArgument(!enumMap.isEmpty());
    }

    @Override
    UnmodifiableIterator keyIterator() {
        return Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
    }

    @Override
    public int size() {
        return this.delegate.size();
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.delegate.containsKey(object);
    }

    @Override
    public Object get(Object object) {
        return this.delegate.get(object);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ImmutableEnumMap)) return this.delegate.equals(object);
        object = ((ImmutableEnumMap)object).delegate;
        return this.delegate.equals(object);
    }

    @Override
    UnmodifiableIterator entryIterator() {
        return Maps.unmodifiableEntryIterator(this.delegate.entrySet().iterator());
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    Object writeReplace() {
        return new ImmutableEnumMap$EnumSerializedForm(this.delegate);
    }

    /* synthetic */ ImmutableEnumMap(EnumMap enumMap, ImmutableEnumMap$1 immutableEnumMap$1) {
        this(enumMap);
    }
}

