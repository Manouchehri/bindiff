/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.BiMap;
import com.google.common.collect.Maps$FilteredEntryBiMap$1;
import com.google.common.collect.Maps$FilteredEntryMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

final class Maps$FilteredEntryBiMap
extends Maps$FilteredEntryMap
implements BiMap {
    private final BiMap inverse;

    private static Predicate inversePredicate(Predicate predicate) {
        return new Maps$FilteredEntryBiMap$1(predicate);
    }

    Maps$FilteredEntryBiMap(BiMap biMap, Predicate predicate) {
        super(biMap, predicate);
        this.inverse = new Maps$FilteredEntryBiMap(biMap.inverse(), Maps$FilteredEntryBiMap.inversePredicate(predicate), this);
    }

    private Maps$FilteredEntryBiMap(BiMap biMap, Predicate predicate, BiMap biMap2) {
        super(biMap, predicate);
        this.inverse = biMap2;
    }

    BiMap unfiltered() {
        return (BiMap)this.unfiltered;
    }

    @Override
    public Object forcePut(@Nullable Object object, @Nullable Object object2) {
        Preconditions.checkArgument(this.apply(object, object2));
        return this.unfiltered().forcePut(object, object2);
    }

    @Override
    public BiMap inverse() {
        return this.inverse;
    }

    @Override
    public Set values() {
        return this.inverse.keySet();
    }
}

