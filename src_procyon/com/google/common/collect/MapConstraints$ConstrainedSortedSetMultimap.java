package com.google.common.collect;

import java.util.*;

class MapConstraints$ConstrainedSortedSetMultimap extends MapConstraints$ConstrainedSetMultimap implements SortedSetMultimap
{
    MapConstraints$ConstrainedSortedSetMultimap(final SortedSetMultimap sortedSetMultimap, final MapConstraint mapConstraint) {
        super(sortedSetMultimap, mapConstraint);
    }
    
    @Override
    public SortedSet get(final Object o) {
        return (SortedSet)super.get(o);
    }
    
    @Override
    public SortedSet removeAll(final Object o) {
        return (SortedSet)super.removeAll(o);
    }
    
    @Override
    public SortedSet replaceValues(final Object o, final Iterable iterable) {
        return (SortedSet)super.replaceValues(o, iterable);
    }
    
    @Override
    public Comparator valueComparator() {
        return ((SortedSetMultimap)this.delegate()).valueComparator();
    }
}
