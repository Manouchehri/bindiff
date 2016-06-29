/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Sets;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible(emulated=1)
final class Platform {
    static Object[] newArray(Object[] arrobject, int n2) {
        Class class_ = arrobject.getClass().getComponentType();
        return (Object[])Array.newInstance(class_, n2);
    }

    static Set newSetFromMap(Map map) {
        return Collections.newSetFromMap(map);
    }

    static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }

    static SortedMap mapsTransformEntriesSortedMap(SortedMap sortedMap, Maps$EntryTransformer maps$EntryTransformer) {
        SortedMap sortedMap2;
        if (sortedMap instanceof NavigableMap) {
            sortedMap2 = Maps.transformEntries((NavigableMap)sortedMap, maps$EntryTransformer);
            return sortedMap2;
        }
        sortedMap2 = Maps.transformEntriesIgnoreNavigable(sortedMap, maps$EntryTransformer);
        return sortedMap2;
    }

    static SortedMap mapsAsMapSortedSet(SortedSet sortedSet, Function function) {
        SortedMap sortedMap;
        if (sortedSet instanceof NavigableSet) {
            sortedMap = Maps.asMap((NavigableSet)sortedSet, function);
            return sortedMap;
        }
        sortedMap = Maps.asMapSortedIgnoreNavigable(sortedSet, function);
        return sortedMap;
    }

    static SortedSet setsFilterSortedSet(SortedSet sortedSet, Predicate predicate) {
        SortedSet sortedSet2;
        if (sortedSet instanceof NavigableSet) {
            sortedSet2 = Sets.filter((NavigableSet)sortedSet, predicate);
            return sortedSet2;
        }
        sortedSet2 = Sets.filterSortedIgnoreNavigable(sortedSet, predicate);
        return sortedSet2;
    }

    static SortedMap mapsFilterSortedMap(SortedMap sortedMap, Predicate predicate) {
        SortedMap sortedMap2;
        if (sortedMap instanceof NavigableMap) {
            sortedMap2 = Maps.filterEntries((NavigableMap)sortedMap, predicate);
            return sortedMap2;
        }
        sortedMap2 = Maps.filterSortedIgnoreNavigable(sortedMap, predicate);
        return sortedMap2;
    }

    private Platform() {
    }
}

