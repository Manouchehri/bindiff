/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$1;
import com.google.common.collect.MapConstraints$2;
import com.google.common.collect.MapConstraints$ConstrainedAsMapEntries;
import com.google.common.collect.MapConstraints$ConstrainedBiMap;
import com.google.common.collect.MapConstraints$ConstrainedEntries;
import com.google.common.collect.MapConstraints$ConstrainedEntrySet;
import com.google.common.collect.MapConstraints$ConstrainedListMultimap;
import com.google.common.collect.MapConstraints$ConstrainedMap;
import com.google.common.collect.MapConstraints$ConstrainedMultimap;
import com.google.common.collect.MapConstraints$ConstrainedSetMultimap;
import com.google.common.collect.MapConstraints$ConstrainedSortedSetMultimap;
import com.google.common.collect.MapConstraints$NotNullMapConstraint;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Deprecated
@Beta
@GwtCompatible
public final class MapConstraints {
    private MapConstraints() {
    }

    public static MapConstraint notNull() {
        return MapConstraints$NotNullMapConstraint.INSTANCE;
    }

    public static Map constrainedMap(Map map, MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedMap(map, mapConstraint);
    }

    public static Multimap constrainedMultimap(Multimap multimap, MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedMultimap(multimap, mapConstraint);
    }

    public static ListMultimap constrainedListMultimap(ListMultimap listMultimap, MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedListMultimap(listMultimap, mapConstraint);
    }

    public static SetMultimap constrainedSetMultimap(SetMultimap setMultimap, MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedSetMultimap(setMultimap, mapConstraint);
    }

    public static SortedSetMultimap constrainedSortedSetMultimap(SortedSetMultimap sortedSetMultimap, MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedSortedSetMultimap(sortedSetMultimap, mapConstraint);
    }

    private static Map.Entry constrainedEntry(Map.Entry entry, MapConstraint mapConstraint) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkNotNull(mapConstraint);
        return new MapConstraints$1(entry, mapConstraint);
    }

    private static Map.Entry constrainedAsMapEntry(Map.Entry entry, MapConstraint mapConstraint) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkNotNull(mapConstraint);
        return new MapConstraints$2(entry, mapConstraint);
    }

    private static Set constrainedAsMapEntries(Set set, MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedAsMapEntries(set, mapConstraint);
    }

    private static Collection constrainedEntries(Collection collection, MapConstraint mapConstraint) {
        if (!(collection instanceof Set)) return new MapConstraints$ConstrainedEntries(collection, mapConstraint);
        return MapConstraints.constrainedEntrySet((Set)collection, mapConstraint);
    }

    private static Set constrainedEntrySet(Set set, MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedEntrySet(set, mapConstraint);
    }

    public static BiMap constrainedBiMap(BiMap biMap, MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedBiMap(biMap, null, mapConstraint);
    }

    private static Collection checkValues(Object object, Iterable iterable, MapConstraint mapConstraint) {
        ArrayList arrayList = Lists.newArrayList(iterable);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            mapConstraint.checkKeyValue(object, e2);
        }
        return arrayList;
    }

    private static Map checkMap(Map map, MapConstraint mapConstraint) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        Iterator iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            mapConstraint.checkKeyValue(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    static /* synthetic */ Set access$000(Set set, MapConstraint mapConstraint) {
        return MapConstraints.constrainedEntrySet(set, mapConstraint);
    }

    static /* synthetic */ Map access$100(Map map, MapConstraint mapConstraint) {
        return MapConstraints.checkMap(map, mapConstraint);
    }

    static /* synthetic */ Set access$200(Set set, MapConstraint mapConstraint) {
        return MapConstraints.constrainedAsMapEntries(set, mapConstraint);
    }

    static /* synthetic */ Collection access$300(Collection collection, MapConstraint mapConstraint) {
        return MapConstraints.constrainedEntries(collection, mapConstraint);
    }

    static /* synthetic */ Collection access$400(Object object, Iterable iterable, MapConstraint mapConstraint) {
        return MapConstraints.checkValues(object, iterable, mapConstraint);
    }

    static /* synthetic */ Map.Entry access$500(Map.Entry entry, MapConstraint mapConstraint) {
        return MapConstraints.constrainedEntry(entry, mapConstraint);
    }

    static /* synthetic */ Map.Entry access$700(Map.Entry entry, MapConstraint mapConstraint) {
        return MapConstraints.constrainedAsMapEntry(entry, mapConstraint);
    }
}

