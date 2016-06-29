package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@Deprecated
@Beta
@GwtCompatible
public final class MapConstraints
{
    public static MapConstraint notNull() {
        return MapConstraints$NotNullMapConstraint.INSTANCE;
    }
    
    public static Map constrainedMap(final Map map, final MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedMap(map, mapConstraint);
    }
    
    public static Multimap constrainedMultimap(final Multimap multimap, final MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedMultimap(multimap, mapConstraint);
    }
    
    public static ListMultimap constrainedListMultimap(final ListMultimap listMultimap, final MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedListMultimap(listMultimap, mapConstraint);
    }
    
    public static SetMultimap constrainedSetMultimap(final SetMultimap setMultimap, final MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedSetMultimap(setMultimap, mapConstraint);
    }
    
    public static SortedSetMultimap constrainedSortedSetMultimap(final SortedSetMultimap sortedSetMultimap, final MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedSortedSetMultimap(sortedSetMultimap, mapConstraint);
    }
    
    private static Map.Entry constrainedEntry(final Map.Entry entry, final MapConstraint mapConstraint) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkNotNull(mapConstraint);
        return new MapConstraints$1(entry, mapConstraint);
    }
    
    private static Map.Entry constrainedAsMapEntry(final Map.Entry entry, final MapConstraint mapConstraint) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkNotNull(mapConstraint);
        return new MapConstraints$2(entry, mapConstraint);
    }
    
    private static Set constrainedAsMapEntries(final Set set, final MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedAsMapEntries(set, mapConstraint);
    }
    
    private static Collection constrainedEntries(final Collection collection, final MapConstraint mapConstraint) {
        if (collection instanceof Set) {
            return constrainedEntrySet((Set)collection, mapConstraint);
        }
        return new MapConstraints$ConstrainedEntries(collection, mapConstraint);
    }
    
    private static Set constrainedEntrySet(final Set set, final MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedEntrySet(set, mapConstraint);
    }
    
    public static BiMap constrainedBiMap(final BiMap biMap, final MapConstraint mapConstraint) {
        return new MapConstraints$ConstrainedBiMap(biMap, null, mapConstraint);
    }
    
    private static Collection checkValues(final Object o, final Iterable iterable, final MapConstraint mapConstraint) {
        final ArrayList arrayList = Lists.newArrayList(iterable);
        final Iterator<Object> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            mapConstraint.checkKeyValue(o, iterator.next());
        }
        return arrayList;
    }
    
    private static Map checkMap(final Map map, final MapConstraint mapConstraint) {
        final LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(map);
        for (final Map.Entry<Object, V> entry : linkedHashMap.entrySet()) {
            mapConstraint.checkKeyValue(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
}
