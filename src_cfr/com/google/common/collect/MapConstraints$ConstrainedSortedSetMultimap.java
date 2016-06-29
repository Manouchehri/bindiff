/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedSetMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

class MapConstraints$ConstrainedSortedSetMultimap
extends MapConstraints$ConstrainedSetMultimap
implements SortedSetMultimap {
    MapConstraints$ConstrainedSortedSetMultimap(SortedSetMultimap sortedSetMultimap, MapConstraint mapConstraint) {
        super(sortedSetMultimap, mapConstraint);
    }

    @Override
    public SortedSet get(Object object) {
        return (SortedSet)super.get(object);
    }

    @Override
    public SortedSet removeAll(Object object) {
        return (SortedSet)super.removeAll(object);
    }

    @Override
    public SortedSet replaceValues(Object object, Iterable iterable) {
        return (SortedSet)super.replaceValues(object, iterable);
    }

    @Override
    public Comparator valueComparator() {
        return ((SortedSetMultimap)this.delegate()).valueComparator();
    }
}

