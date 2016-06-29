/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap$Builder;
import com.google.common.collect.ImmutableBiMap$SerializedForm;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.SingletonImmutableBiMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible(serializable=1, emulated=1)
public abstract class ImmutableBiMap
extends ImmutableMap
implements BiMap {
    public static ImmutableBiMap of() {
        return RegularImmutableBiMap.EMPTY;
    }

    public static ImmutableBiMap of(Object object, Object object2) {
        return new SingletonImmutableBiMap(object, object2);
    }

    public static ImmutableBiMap of(Object object, Object object2, Object object3, Object object4) {
        return RegularImmutableBiMap.fromEntries(ImmutableBiMap.entryOf(object, object2), ImmutableBiMap.entryOf(object3, object4));
    }

    public static ImmutableBiMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        return RegularImmutableBiMap.fromEntries(ImmutableBiMap.entryOf(object, object2), ImmutableBiMap.entryOf(object3, object4), ImmutableBiMap.entryOf(object5, object6));
    }

    public static ImmutableBiMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        return RegularImmutableBiMap.fromEntries(ImmutableBiMap.entryOf(object, object2), ImmutableBiMap.entryOf(object3, object4), ImmutableBiMap.entryOf(object5, object6), ImmutableBiMap.entryOf(object7, object8));
    }

    public static ImmutableBiMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        return RegularImmutableBiMap.fromEntries(ImmutableBiMap.entryOf(object, object2), ImmutableBiMap.entryOf(object3, object4), ImmutableBiMap.entryOf(object5, object6), ImmutableBiMap.entryOf(object7, object8), ImmutableBiMap.entryOf(object9, object10));
    }

    public static ImmutableBiMap$Builder builder() {
        return new ImmutableBiMap$Builder();
    }

    public static ImmutableBiMap copyOf(Map map) {
        if (!(map instanceof ImmutableBiMap)) return ImmutableBiMap.copyOf(map.entrySet());
        ImmutableBiMap immutableBiMap = (ImmutableBiMap)map;
        if (immutableBiMap.isPartialView()) return ImmutableBiMap.copyOf(map.entrySet());
        return immutableBiMap;
    }

    @Beta
    public static ImmutableBiMap copyOf(Iterable iterable) {
        Map.Entry[] arrentry = (Map.Entry[])Iterables.toArray(iterable, EMPTY_ENTRY_ARRAY);
        switch (arrentry.length) {
            case 0: {
                return ImmutableBiMap.of();
            }
            case 1: {
                Map.Entry entry = arrentry[0];
                return ImmutableBiMap.of(entry.getKey(), entry.getValue());
            }
        }
        return RegularImmutableBiMap.fromEntries(arrentry);
    }

    ImmutableBiMap() {
    }

    @Override
    public abstract ImmutableBiMap inverse();

    @Override
    public ImmutableSet values() {
        return this.inverse().keySet();
    }

    @Deprecated
    @Override
    public Object forcePut(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Override
    Object writeReplace() {
        return new ImmutableBiMap$SerializedForm(this);
    }
}

